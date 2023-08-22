import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';
import { useNavigate, useLocation } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { toast } from "react-toastify";

const ResetStep = () => {

    const [newPassword, setNewPassword] = useState('');
    const usenavigate = useNavigate();

    const location = useLocation();
  const email = location.state?.email || '';

    const handleResetPassword = (e) => {
       
        e.preventDefault();

        let obj = {email, newPassword};

        fetch('http://localhost:8080/forgotPassword/resetPassword', {
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
            usenavigate('/login');

        }).catch((err) => {
            toast.error('Failed : ' + err.message);
        });


    };
    return (
        <div className="row">
            <div className="offset-lg-3 col-lg-6" style={{ marginTop: '100px' }}>
                <form className="container" onSubmit = {handleResetPassword}>
                    <div className="card">
                        <div className="card-header">
                            <h2>Reset Password</h2>
                        </div>
                        <div className="card-body">

                            <div className="form-group">
                                <label>New Password <span className="errmsg">*</span></label>
                                <input type="password" value={newPassword} onChange={e => setNewPassword(e.target.value)} className="form-control"></input>
                            </div>

                        </div>
                        <div className="card-footer">
                            <button className="btn btn-primary" >Reset Password</button>
                            <span style={{"paddingRight": "20px"}}></span>
                        <Link className="btn btn-success" to={'/login'}>Back to login</Link>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    )
}
export default ResetStep;