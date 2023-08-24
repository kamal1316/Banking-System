import Table from 'react-bootstrap/Table';

import { Link } from 'react-router-dom';
import { toast } from "react-toastify";
import React, { useState, useEffect } from 'react';
import AdminNavbar from './AdminNavbar';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function ListUsers() {

const usenavigate = useNavigate();

  const [users, setUsers] = useState([]);
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
            headers: { "Authorization" : `Admin ${token}`,
          "Content-Type": "application/json" }
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
    <AdminNavbar/>

            <Table Registered Users>
                <thead>
                    <tr>
                        <th>  
                            User ID
                          </th>
                          <th>  
                            Account Number
                          </th>
                          <th>  
                            Status
                          </th>
                        
                    </tr>
                </thead>
                <tbody>
                    {users.map((user) => (
                        <tr key={user.userId}>
                            <td>
                                {user.userId}
                                </td>
                                <td>{user.accountNumber}</td>
                                <td> <Button onClick={(e) => handleActiveStatus(e, user.userId)} >{user.activeStatus ? "Active" : "Inactive"}</Button> </td>
                            
                        </tr>
                    ))}
                </tbody>
                </Table>
            </>
  );
}

export default ListUsers;