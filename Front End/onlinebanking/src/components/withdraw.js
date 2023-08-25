//import React from 'react';
import { useEffect } from "react";
import { Link, useNavigate } from 'react-router-dom';
import Navbar from './navbar'; 
import Footer from './footer'; 
import React,{useState} from 'react';
import { toast } from "react-toastify";

const Withdraw = () => {
  const usenavigate = useNavigate();
  const [amount, amountChange] = useState("");
  const [timestamp, timestampChange] = useState("");
 

  useEffect(() => {

    if(timestamp !== "") {

        let balance = sessionStorage.getItem('balance');
      

       
        if(amount < 0) {
            toast.error("Amount cannot be negative!!");
            timestampChange("");
        }
        else if(amount < 10) {
            toast.error("Minimum amount should be atleast ₹10");
            timestampChange("");
        }
        else if(parseInt(amount) > parseInt(balance)) {
            toast.error("Insufficient balance!! Your balance is " + balance + ".");
            timestampChange("");
        }
        else {
            
           

            let token = sessionStorage.getItem('JwtToken');
            let userId=sessionStorage.getItem('userId');
            let withdrawObject  = {userId,amount,timestamp};

            fetch("http://localhost:8080/transaction/executeWithdraw", {
                method: "POST",
                headers: { "Authorization" : `User ${token}`,
                "Content-Type": "application/json" },
                body: JSON.stringify(withdrawObject)
            }).then((res) => {

                if(!res.ok) {
                    return res.json().then(data => {console.log('at if'); throw new Error(data.message)});
                }
                return res.text();

            }).then((data) => {
                console.log('at success');
                toast.success(data);
                usenavigate('/dashboard');
            }).catch((err) => {
                console.log('catch');
                toast.error(err.message);
            });
        }
    }

  }, [timestamp]);

  const handlesubmit = (e) => {
    e.preventDefault();

    timestampChange(new Date());
  }

  useEffect(()=>{
    let token = sessionStorage.getItem('JwtToken');
    if(token===''||token===null){
        usenavigate('/home');
    }
  },[usenavigate]);


  return (
    <div>
        <Navbar> </Navbar>
        <div className="offset-lg-3 col-lg-6">
                <form className="container" onSubmit={handlesubmit} style = {{padding: "20px"}}>
                    <div className="card">
                        <div className="card-header">
                            <h1>Withdraw Money</h1>
                        </div>


                        <div className="card-body">
                            <div className="row">
                                
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label style = {{padding: "5px"}}>Amount <span className="errmsg">*</span></label>
                                        <input pattern = "^[0-9]+$" title = "Enter a valid amount(in ₹)" required value={amount} onChange={e => amountChange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>                              
                            </div>
                        </div>
                        <div className="card-footer">
                            <button type="submit" className="btn btn-primary">Submit</button>
                            <span style = {{padding : "10px"}}></span>
                            <Link to={'/dashboard'} className="btn btn-danger">Back To Dashboard</Link>
                        </div>
                    </div>
                </form>
            </div>
            <Footer> </Footer>
    </div>
  );
};

export default Withdraw;
