import React, { useState, useEffect } from 'react';
import './transactions.css';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import { toast } from "react-toastify";

function Transactions() {

  const [transactionData, setTransactionData] = useState([]);

  useEffect(() => {
    let token = sessionStorage.getItem('JwtToken');

    fetch(" http://localhost:8080/transaction/" + sessionStorage.getItem('accountNumber') + "/transactions", {
      method: "GET",
      headers: {
        "Authorization": `User ${token}`,
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
          {transactionData.map((transaction) => (
            <tr key={transaction.refId} >
              <td>{transaction.refId}</td>
              <td>{transaction.mode}</td>

             { ((transaction.mode) == ("withdraw") ?

                (<><td>{transaction.fromAccount}</td><td>- ₹{transaction.amount}</td></>)

                :

                (<>
                  {transaction.toAccount === sessionStorage.getItem('accountNumber') ?
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

      <div style={{ padding: "10px" }}>
        <Button variant="primary" >
          <Link to="/dashboard" className="btn btn-default">Back To Dashboard</Link>
        </Button>
      </div>
    </div>
  );
}


export default Transactions;
