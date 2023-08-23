import ListGroup from 'react-bootstrap/ListGroup';
import { Link } from 'react-router-dom';
import { toast } from "react-toastify";
import React, { useState, useEffect } from 'react';
import AdminNavbar from './AdminNavbar';

function AccountRequests() {

    const [requests, setRequests] = useState([]);

    useEffect(() => {
        let token = sessionStorage.getItem('JwtToken');

        fetch(" http://localhost:8080/admin/accountRequests", {
            method: "GET",
            headers: {
                "Authorization": `Bearer ${token}`,
                "Content-Type": "application/json"
            }
        }).then((res) => {

            if (!res.ok) {
                throw new Error("Couldn't fetch requests!!");
            }
            else {
                return res.json();
            }
        }).then((resp) => {
            console.log(resp);
            setRequests(resp);
        }).catch((err) => {
            toast.error(err.message);
        })

    }, []);


    return (
        <>
        <AdminNavbar/>
            <h2>Pending Requests</h2>
            <table className="req-table">
                <thead>
                    <tr>
                        <th>
                            
                            Request Id
                            </th>
                        
                    </tr>
                </thead>
                <tbody>
                    {requests.map((req) => (
                        <tr key={req.id}>
                            <td>
                                {/* <Link to={{pathname: "/admin/accountRequests/details", state:"hello" }} >#{req.id}</Link> */}
                                <Link to = {`/admin/accountRequests/details?data=${encodeURIComponent(JSON.stringify(req))}`}>#{req.id}</Link>
                                
                                </td>
                            
                        </tr>
                    ))}
                </tbody>
            </table>
        </>


    );
}

export default AccountRequests;