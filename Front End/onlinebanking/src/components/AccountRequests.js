import ListGroup from 'react-bootstrap/ListGroup';
import { Link } from 'react-router-dom';
import { toast } from "react-toastify";
import React, { useState, useEffect } from 'react';
import AdminNavbar from './AdminNavbar';
import { Button} from 'react-bootstrap';
import Table from 'react-bootstrap/Table';

function AccountRequests() {

    const [requests, setRequests] = useState([]);

    useEffect(() => {
        let token = sessionStorage.getItem('JwtToken');

        fetch(" http://localhost:8080/admin/accountRequests", {
            method: "GET",
            headers: {
                "Authorization": `Admin ${token}`,
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
            <AdminNavbar />
            <div className='m-5'>
                <h2 className='text-center p-3'>Pending Request</h2>
                <Table>
                    <thead>
                        <tr>
                            <th>#Req Id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {requests.map((req) => (
                            <tr key={req.id}>
                                <td>
                                    {/* <Link to={{pathname: "/admin/accountRequests/details", state:"hello" }} >#{req.id}</Link> */}
                                    {/* <Link to={`/admin/accountRequests/details?data=${encodeURIComponent(JSON.stringify(req))}`}>#{req.id}</Link> */}
                                    {req.id}
                                </td>
                                <td>{req.name}</td>
                                <td>{req.email}</td>
                                <td>
                                    <Button>
                                         <Link className='btn btn-sm' to={`/admin/accountRequests/details?data=${encodeURIComponent(JSON.stringify(req))}`}>More Details</Link>
                                    </Button>
                                </td>

                            </tr>
                        ))}
                        
        

                    </tbody>
                </Table>
            </div>
            
        </>


    );
}

export default AccountRequests;