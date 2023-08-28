//import React from 'react';
import { useEffect } from "react";
import { Link, useNavigate } from 'react-router-dom';
import Navbar from './navbar';
import Footer from './footer';
import React, { useState } from 'react';
import { toast } from "react-toastify";
import { Card } from "react-bootstrap";

const Payment = () => {
    const usenavigate = useNavigate();

    const [toAccount, toAccountChange] = useState("");
    const [amount, amountChange] = useState("");
    const [mode, modeChange] = useState("imps");
    const [timestamp, timestampChange] = useState("");
    const [remark, remarkChange] = useState("");

    let balance = sessionStorage.getItem('balance');
    let fromAccount = sessionStorage.getItem('accountNumber');

    useEffect(() => {

        if (timestamp !== "") {

            let balance = sessionStorage.getItem('balance');
            let fromAccount = sessionStorage.getItem('accountNumber');

            if (fromAccount === toAccount) {
                toast.error("To Account Number cannot be same as your Account Number.");
                timestampChange("");
            }
            else if (amount < 0) {
                toast.error("Amount cannot be negative!!");
                timestampChange("");
            }
            else if (amount < 10) {
                toast.error("Minimum amount should be atleast ₹10");
                timestampChange("");
            }
            else if (parseInt(amount) > parseInt(balance)) {
                toast.error("Insufficient balance!! Your balance is " + balance + ".");
                timestampChange("");
            }
            else {

                let transObject = { fromAccount, toAccount, amount, mode, timestamp, remark };

                let token = sessionStorage.getItem('JwtToken');

                fetch("http://localhost:8080/transaction/executeTransaction", {
                    method: "POST",
                    headers: {
                        "Authorization": `User ${token}`,
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(transObject)
                }).then((res) => {

                    if (!res.ok) {
                        return res.json().then(data => { throw new Error(data.message) });
                    }

                    return res.text();

                }).then((data) => {
                    toast.success(data);
                    usenavigate('/dashboard');
                }).catch((err) => {
                    toast.error(err.message);
                });
            }
        }

    }, [timestamp]);

    const handlesubmit = (e) => {
        e.preventDefault();

        timestampChange(new Date());
    }

    useEffect(() => {
        let token = sessionStorage.getItem('JwtToken');
        if (token === '' || token === null) {
            usenavigate('/home');
        }
    }, [usenavigate]);


    return (
        <div>
            <Navbar> </Navbar>
            <div className="d-flex flex-row">
            <div className=" offset-lg-3 col-lg-6">
                <form className="container" onSubmit={handlesubmit} style={{ padding: "20px" }}>
                    <div className="card">
                        <div className="card-header">
                            <h1>Payment Page</h1>
                        </div>


                        <div className="card-body">
                            <div className="row">
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label style={{ padding: "5px" }}>To Account Number <span className="errmsg">*</span></label>
                                        <input pattern="^[0-9]{5}$" title="Enter valid 5 digit account number" required value={toAccount} onChange={e => toAccountChange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label style={{ padding: "5px" }}>Amount <span className="errmsg">*</span></label>
                                        <input pattern="^[0-9]+$" title="Enter a valid amount(in ₹)" required value={amount} onChange={e => amountChange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label style={{ padding: "5px" }}>Mode <span className="errmsg">*</span></label>
                                        <br></br>
                                        <input required type="radio" checked={mode === 'imps'} onChange={e => modeChange(e.target.value)} name="mode" value="imps" className="app-check"></input>
                                        <label> imps</label>
                                        <span style={{ padding: "5px" }}></span>
                                        <input type="radio" checked={mode === 'ntfs'} onChange={e => modeChange(e.target.value)} name="mode" value="ntfs" className="app-check"></input>
                                        <label> ntfs</label>
                                        <span style={{ padding: "5px" }}></span>
                                        <input type="radio" checked={mode === 'rtgs'} onChange={e => modeChange(e.target.value)} name="mode" value="rtgs" className="app-check"></input>
                                        <label> rtgs</label>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label style={{ padding: "5px" }}>Remark <span className="errmsg"></span></label>
                                        <input value={remark} onChange={e => remarkChange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                            </div>

                        </div>


                        <div className="card-footer">
                            <button type="submit" className="btn btn-primary">Pay</button>
                            <span style={{ padding: "10px" }}></span>
                            <Link to={'/dashboard'} className="btn btn-danger">Back To Dashboard</Link>
                        </div>
                    </div>
                </form>
            </div>
            <div className="my-4">
                <Card style={{ width: '18rem' }}>
                    
                    <Card.Body>
                        {/* <Card.Title>Card Title</Card.Title> */}
                        <Card.Text>
                        Your Account Number : {fromAccount}
                        </Card.Text>
                        <Card.Text>
                        Available Balance : {balance}
                        </Card.Text>
                        
                    </Card.Body>
                </Card>
                
            </div>
            </div>
            <Footer> </Footer>
        </div>
    );
};

export default Payment;
