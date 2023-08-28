import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import { toast } from "react-toastify";
import React, { useState, useEffect } from 'react';
import AdminNavbar from './AdminNavbar';
import Footer from './footer';
import { useNavigate } from 'react-router-dom';

function ListUsers() {

  const [users, setUsers] = useState([]);

  const usenavigate = useNavigate();


  const [query, setQuery] = useState("");


  const search_parameters = Object.keys(Object.assign({}, ...users));

  function search(users) {

    return users.filter((users) =>

      search_parameters.some((parameter) =>

        users[parameter].toString().toLowerCase().includes(query)

      )

    );
  }

  const [clickCount, setClickCount] = useState(0);


  useEffect(() => {
    let token = sessionStorage.getItem('JwtToken');

    fetch(" http://localhost:8080/admin/listUsers", {
      method: "GET",
      headers: {
        "Authorization": `Admin ${token}`,
        "Content-Type": "application/json"
      }
    }).then((res) => {

      if (!res.ok) {
        throw new Error("Couldn't fetch users!!");
      }
      else {
        return res.json();
      }
    }).then((resp) => {
      console.log(resp);
      setUsers(resp);
    }).catch((err) => {
      toast.error(err.message);
    })

  }, [clickCount]);

  const handleActiveStatus = (e, userId) => {
    e.preventDefault();

    const token = sessionStorage.getItem('JwtToken');

    fetch("http://localhost:8080/admin/changeActiveStatus/" + userId, {
      method: "PUT",
      headers: {
        "Authorization": `Admin ${token}`,
        "Content-Type": "application/json"
      }
    }).then(res => {

      if (!res.ok) {
        return res.json().then(data => { throw new Error(data.message) });
      }

      return res.text();
    }).then(data => {

      toast.success('changed status successfully.');
      setClickCount(clickCount + 1);
      // usenavigate('/admin/listUsers');
    }).catch((err) => {
      toast.error('Failed : ' + err.message);
    });


  }

  return (
    <>
      <AdminNavbar />

      <div className="input-box m-3">

        <input

          type="search"

          name="search-form"

          id="search-form"

          className="search-input"
          style={{ padding: '10px', margin: '10px', width: '300px', height: '50px' }}

          onChange={(e) => setQuery(e.target.value)}

          placeholder="Search user"

        />

      </div>

          <h2 className='text-center p-3'>Registered Users</h2>
            <Table  className='m-3'>
                <thead>
                    <tr>
                        <th>
                            User ID
                        </th>
                        <th>
                            Account Number
                        </th>
                        <th>
                            Active Status
                        </th>
                        <th>
                          
                        </th>

                    </tr>
                </thead>
                <tbody>
                    {search(users).map((user) => (
                      
                        <tr key={user.userId}>
                            <td>
                                {user.userId}
                                </td>
                                <td>{user.accountNumber}</td>
                                <td> <Button onClick={(e) => handleActiveStatus(e, user.userId)} >{user.activeStatus ? "Active" : "Inactive"}</Button> </td>
                                <td> <Button> <Link className='btn btn-sm' to={`/userTransaction?data=${encodeURIComponent(JSON.stringify(user.accountNumber))}`}>Show All Transactions</Link></Button></td>

                                
                        </tr>
                    ))}
                </tbody>
            </Table>
            <Footer/> 
        </>
    );
}

export default ListUsers;