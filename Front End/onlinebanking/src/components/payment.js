//import React from 'react';
import { useEffect } from "react";
import { Link, useNavigate } from 'react-router-dom';
import React,{useState} from 'react';
import { toast } from "react-toastify";

const Payment = () => {
  const usenavigate = useNavigate();
  
  const [toAccount, toAccountChange] = useState("");
  const [amount, amountChange] = useState("");
  const [mode, modeChange] = useState("");
  const [timestamp, timestampChange] = useState("");
  const [remark, remarkChange] = useState("");

  const handlesubmit = (e) => {
    e.preventDefault();
    timestampChange(new Date());
    console.log(new Date());

    let fromAccount = sessionStorage.getItem('accountNumber');

    let transObject  = {fromAccount, toAccount, amount, mode, timestamp, remark};

    console.log(transObject);

    let token = sessionStorage.getItem('JwtToken');

    fetch("http://localhost:8080/transaction/executeTransaction", {
        method: "POST",
        headers: { "Authorization" : `Bearer ${token}`,
        "Content-Type": "application/json" },
        body: JSON.stringify(transObject)
    }).then((res) => {
        return res.text();
    }).then((resp) => {
      toast.success(resp);
      // usenavigate('/success');
    }).catch((err) => {
        toast.error('Failed :' + err.message);
    });

  }

  useEffect(()=>{
    let token = sessionStorage.getItem('JwtToken');
    if(token===''||token===null){
        usenavigate('/home');
    }
  },[usenavigate]);


  return (
    <div>
        <div className="offset-lg-3 col-lg-6">
                <form className="container" onSubmit={handlesubmit} style = {{padding: "20px"}}>
                    <div className="card">
                        <div className="card-header">
                            <h1>Payment Page</h1>
                        </div>


                        <div className="card-body">
                            <div className="row">
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label style = {{padding: "5px"}}>To Account Number <span className="errmsg">*</span></label>
                                        <input value={toAccount} onChange={e => toAccountChange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label style = {{padding: "5px"}}>Amount <span className="errmsg">*</span></label>
                                        <input value={amount} onChange={e => amountChange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label style = {{padding: "5px"}}>Mode <span className="errmsg">*</span></label>
                                        <br></br>
                                        <input type="radio" checked={mode === 'ntfs'} onChange={e => modeChange(e.target.value)} name="mode" value="ntfs" className="app-check"></input>
                                        <label> ntfs</label>
                                        <span style = {{padding : "5px"}}></span>
                                        <input type="radio" checked={mode === 'imps'} onChange={e => modeChange(e.target.value)} name="mode" value="imps" className="app-check"></input>
                                        <label> imps</label>
                                        <span style = {{padding : "5px"}}></span>
                                        <input type="radio" checked={mode === 'rtgs'} onChange={e => modeChange(e.target.value)} name="mode" value="rtgs" className="app-check"></input>
                                        <label> rtgs</label>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label style = {{padding: "5px"}}>Remark <span className="errmsg"></span></label>
                                        <input value={remark} onChange={e => remarkChange(e.target.value)} className="form-control"></input>
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
    </div>
  );
};

export default Payment;
