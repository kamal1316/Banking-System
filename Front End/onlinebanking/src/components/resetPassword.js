import React, {useState} from 'react';
import {Button,Form} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { toast } from "react-toastify";
import Navbar from './navbar'; 
import Footer from './footer';

const ResetPassword = () => {
  const [email,setEmail] = useState('');
  const usenavigate = useNavigate();

    const handleSendResetLink =  (e) =>{
        e.preventDefault();

            let obj = [email];
            
            fetch('http://localhost:8080/forgotPassword/generateOTP', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
              },
              body: email
            }).then(res => {

                if(!res.ok) {
                    return res.json().then(data => {throw new Error(data.message)});
                }

                return res.text();
            }).then(data => {

                toast.success(data);
                usenavigate('/verifyStep', { state: { email } });

            }).catch((err) => {
                toast.error('Failed : ' + err.message);
            });
        }
  

return(
    <>
    
<div className="row" style={{"overflow": "hidden"}}>
<Navbar />
        <div className="offset-lg-3 col-lg-6" style={{ marginTop: '100px' }}>
            <form className="container" onSubmit={handleSendResetLink}>
                <div className="card">
                    <div className="card-header">
                        <h2>Reset Password</h2>
                    </div>
                    <div className="card-body">
                       
                        <div className="form-group">
                            <label>Email <span className="errmsg">*</span></label>
                            <input type="email" value={email} onChange={e => setEmail(e.target.value)} className="form-control"></input>
                        </div>
                        
                    </div>
                    <div className="card-footer">
                        <button className="btn btn-primary" >Send OTP</button>
                        <span style={{"paddingRight": "20px"}}></span>
                        <Link className="btn btn-success" to={'/login'}>Back to login</Link>
                    </div>
                </div>
            </form>
        </div>
        <Footer/> 
    </div>
    
        </>
);
}

export default ResetPassword;