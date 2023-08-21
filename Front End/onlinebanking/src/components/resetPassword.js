import React, {useState} from 'react';
import {Button,Form} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';

const ResetPassword = () => {
  const [email,setEmail] = useState('');
  const usenavigate = useNavigate();

    const handleSendResetLink = () =>{
        const generatedOtp=(Math.floor(1000+Math.random()*9000)).toString();
        console.log('Generated Otp:',generatedOtp);

        // call backend to generate otp.
    

        usenavigate('/verifyStep' , {generatedOtp});
    };

    const handleBackToLogin = () => {
        usenavigate('/login');
    };
  

return(
<div className="row">
        <div className="offset-lg-3 col-lg-6" style={{ marginTop: '100px' }}>
            <form className="container">
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
                        <button className="btn btn-primary" onClick={handleSendResetLink}>Send Reset Link</button>
                        <span style={{"paddingRight": "20px"}}></span>
                        <button className="btn btn-primary" onClick = {handleBackToLogin}>Back to login</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
);
}



export default ResetPassword;