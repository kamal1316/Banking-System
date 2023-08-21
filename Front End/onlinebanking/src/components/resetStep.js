import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';

const ResetStep = () => {

    const [newPassword, setNewPassword] = useState('');
    const usenavigate = useNavigate();
    const [auth, setAuth] = useState(false);
    if (auth) {
        usenavigate('/login');
    }

    const handleResetPassword = () => {
        alert('password reset successful');
        //reset logic


    };
    return (
        <div className="row">
            <div className="offset-lg-3 col-lg-6" style={{ marginTop: '100px' }}>
                <form className="container">
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
                            <button className="btn btn-primary" onClick={handleResetPassword}>Reset Password</button>
                            <span style={{ "paddingRight": "20px" }}></span>
                            <Link to={"/login"}>
                                <button className="btn btn-primary" onClick={() => setAuth(true)}>Back to login</button>
                            </Link>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    )
}
export default ResetStep;