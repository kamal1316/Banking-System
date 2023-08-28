import React, { useState, useEffect } from 'react';
import './transactions.css';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import { toast } from "react-toastify";
import Footer from './footer';
import { useLocation } from 'react-router-dom/dist';
import AdminNavbar from './AdminNavbar';
import ReactPaginate from 'react-paginate';
function AdminTransactions() {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const accountNumber = JSON.parse(decodeURIComponent(queryParams.get('data')));
  console.log(accountNumber);
  const [transactionData, setTransactionData] = useState([]);

  const itemsPerPage =5;

  const pageCount=Math.ceil(transactionData.length/itemsPerPage);

  const [currentPage, setCurrentPage]=useState(0);

  const offset =currentPage * itemsPerPage;
  
  const currentTransactions=transactionData.slice(offset,offset + itemsPerPage);

  const handlePageChange =({selected}) => {
    setCurrentPage(selected);
  }

  useEffect(() => {
    let token = sessionStorage.getItem('JwtToken');

    fetch(" http://localhost:8080/transaction/" + accountNumber + "/transactions", {
      method: "GET",
      headers: {
        "Authorization": `Admin ${token}`,
        "Content-Type": "application/json"
      }
    }).then((res) => {

      if (!res.ok) {
        throw new Error("Couldn't fetch transaction history!!");
      }
      else {
        return res.json();
      }
    }).then((resp) => {
      console.log(resp);
      setTransactionData(resp);
    }).catch((err) => {
      toast.error(err.message);
    })

  }, []);

  return (
    <>
    <AdminNavbar/>
    <div style={{ padding: "30px" }}>
      <h2>Transaction History</h2>
      <table className="transaction-table">
        <thead>
          <tr>
            <th>Reference Id</th>
            <th>Payment Mode</th>
            <th>Other's Account Number</th>
            <th>Amount</th>
            <th>Timestamp</th>
            <th>Remark</th>
          </tr>
        </thead>
        <tbody>
          {currentTransactions.map((transaction) => (
            <tr key={transaction.refId}  style={transaction.mode === 'withdraw' ?  {backgroundColor:'#87CEEBAA'}:
            transaction.toAccount === accountNumber ?  {backgroundColor:'#00FF00AA'} : 
            {backgroundColor:'#FF0000AA'}}>
              <td>{transaction.refId}</td>
              <td>{transaction.mode}</td>

             { ((transaction.mode) === ("withdraw") ?

                (<><td>{transaction.fromAccount}</td><td>- ₹{transaction.amount}</td></>)

                :

                (<>
                  {transaction.toAccount === accountNumber ?
                    (<><td>{transaction.fromAccount}</td><td>₹{transaction.amount}</td></>) :
                    (<><td>{transaction.toAccount}</td><td> - ₹{transaction.amount}</td></>)}
                </>)
              )
                }

              <td>{transaction.timestamp}</td>
              <td>{transaction.remark}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <ReactPaginate
      
      pageCount={pageCount}
      onPageChange={handlePageChange}
      containerClassName={'pagination'}
      subContainerClassName={'pages pagination'}
      activeClassName={'active'}
      pageLinkClassName={'page-link'}
      disableInitialCallback={true}
      />

      <div style={{ padding: "10px" }}>
        <Button className='btn-sm' variant="primary" >
          <Link to="/admin/listUsers" className="btn btn-default">Back</Link>
        </Button>
      </div>
    </div>
    <Footer/>
    </>
  );
}


export default AdminTransactions;