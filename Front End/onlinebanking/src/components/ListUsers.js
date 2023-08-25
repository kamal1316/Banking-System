import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import { toast } from "react-toastify";
import React, { useState, useEffect } from 'react';
import AdminNavbar from './AdminNavbar';
import Footer from './footer'; 

function ListUsers() {

    const [users, setUsers] = useState([]);

    useEffect(() => {
        let token = sessionStorage.getItem('JwtToken');

        fetch(" http://localhost:8080/admin/listUsers", {
            method: "GET",
            headers: {
                "Authorization": `Bearer ${token}`,
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

    }, []);

    return (
        <>
            <AdminNavbar />

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
                            {console.log(user)}
                            <td>
                                {user.userId}
                            </td>
                            <td>{user.accountNumber}</td>
                            <td><Button variant="primary"> {user.activeStatus ? "Active": "Inactive" }</Button> </td>                          
      

                        </tr>
                    ))}
                </tbody>
            </Table>
            <Footer/> 
        </>
    );
}

export default ListUsers;