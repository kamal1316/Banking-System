import React, {useState} from 'react';
import {Button,Form} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import axios from 'axios';

const VerifyStep = ({generatedOtp}) => {
  
  const [otp,setOtp] = useState('');
  
  const usenavigate = useNavigate();
  
    const handleBackToLogin = () => {
        usenavigate('/login');
    };

  const handleVerifyOtp =({generatedOtp})=>{

    // send otp to backend for verficiation.

   console.log(otp,generatedOtp);
//    if(otp.length!==4 || isNaN(otp)){
//     alert('Invalid OTP format');
//     return;
//    }
//    if(otp !== props.generatedOtp){
//     alert('Invalid OTP');
//     return;
//    }
//  axios.post('/verify-otp', {otp}).then(response => {
//     if(response.data.valid){
//         console.log('verified successfully');
//         //useNavigate(/ResetStep);
//     }
//     else{
//         alert('Invalid OTP');
//     }
//  })

 
  
    
  };
 

return(

    <div className="row">
    <div className="offset-lg-3 col-lg-6" style={{ marginTop: '100px' }}>
        <form className="container">
            <div className="card">
                <div className="card-header">
                    <h2>Verify Otp</h2>
                </div>
                <div className="card-body">
                   
                    <div className="form-group">
                        <label>Otp: <span className="errmsg">*</span></label>
                        <input type="text" value={otp} onChange={e => setOtp(e.target.value)} className="form-control"></input>
                    </div>
                    
                </div>
                <div className="card-footer">
                    <button className="btn btn-primary" onClick={handleVerifyOtp({generatedOtp})}>Verify Otp</button>
                    <span style={{"paddingRight": "20px"}}></span>
                    <button className="btn btn-primary" onClick={handleBackToLogin}>Back to login</button>
                </div>
            </div>
        </form>
    </div>
</div>

);
}

export default VerifyStep;