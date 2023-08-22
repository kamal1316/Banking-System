import React, {useState} from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { toast } from "react-toastify";
import { Link } from 'react-router-dom';


const VerifyStep = ({generatedOtp}) => {
  
  const [otp,setOtp] = useState('');
  
  const usenavigate = useNavigate();
  const location = useLocation();
  const email = location.state?.email || '';

  const handleVerifyOtp =(e)=>{

    e.preventDefault();

    let obj = {email, otp};
    console.log(email, otp);
        
        fetch('http://localhost:8080/forgotPassword/verifyOTP', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(obj)
        }).then(res => {

            if(!res.ok) {
                return res.json().then(data => {throw new Error(data.message)});
            }

            return res.text();
        }).then(data => {

            toast.success(data);
            usenavigate('/resetStep', { state: { email } });

        }).catch((err) => {
            toast.error('Failed : ' + err.message);
        });
    
  };
 

return(

    <div className="row">
    <div className="offset-lg-3 col-lg-6" style={{ marginTop: '100px' }}>
        <form className="container" onSubmit={handleVerifyOtp}>
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
                    <button className="btn btn-primary" >Verify Otp</button>
                    <span style={{"paddingRight": "20px"}}></span>
                        <Link className="btn btn-success" to={'/login'}>Back to login</Link>
                </div>
            </div>
        </form>
    </div>
</div>

);
}

export default VerifyStep;