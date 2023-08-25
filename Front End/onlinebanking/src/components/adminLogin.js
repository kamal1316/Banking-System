import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import Navbar from './navbar'; 
import Footer from './footer'; 
import './login.css';

const AdminLogin = () => {
  const [adminId, adminIdUpdate] = useState('');
  const [password, passwordUpdate] = useState('');

  const usenavigate = useNavigate();

  useEffect(() => {
    let token = sessionStorage.getItem('AdminJwtToken');
    if (!(token === '' || token === null)) {
      usenavigate('/adminDashboard');
    }
  }, [usenavigate]);

  const ProceedAdminLogin = (e) => {
    e.preventDefault();
    if (validate()) {
      let userId = adminId;
      let adminObj = { userId, password };
      sessionStorage.setItem('adminId', adminId);

      console.log(adminObj);

      fetch("http://localhost:8080/authenticateAdmin", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(adminObj)
      }).then((response) => {
        if (!response.ok) {
          toast.error('Please Enter valid credentials');
          throw new Error('Response was not ok');
        } else {
          return response.text();
        }
      }).then((data) => {
        sessionStorage.setItem('JwtToken', data);
        console.log(data);
        toast.success('Success');
        usenavigate('/adminDashboard');
      }).catch((err) => {
        toast.error('Login Failed due to :' + err.message);
      });
    }
  }

  const validate = () => {
    let result = true;
    if (adminId === '' || adminId === null) {
      result = false;
      toast.warning('Please Enter Admin ID');
    }
    if (password === '' || password === null) {
      result = false;
      toast.warning('Please Enter Password');
    }
    return result;
  }

  return (
    <> 
    <Navbar > </Navbar>
    <div className="login-container">
        <div className="offset-lg-3 col-lg-6" style={{ marginTop: '10px' }}>
            <form onSubmit={ProceedAdminLogin} className="container">
                <div className="card">
                    <div className="card-header">
                        <h2>Admin Login</h2>
                    </div>
                    <div className="card-body">
                        <div className="form-group">
                            <label>Admin ID <span className="errmsg">*</span></label>
                            <input value={adminId} onChange={e => adminIdUpdate(e.target.value)} className="form-control"></input>
                        </div>
                        <div className="form-group">
                            <label>Password <span className="errmsg">*</span></label>
                            <input type="password" value={password} onChange={e => passwordUpdate(e.target.value)} className="form-control"></input>
                        </div>
                    </div>
                    <div className="card-footer">
                        <button type="submit" className="btn btn-primary">Login</button>
                        <span style={{"paddingRight": "20px"}}></span>
                        <Link className="btn btn-success" to={'/login'}>Sign in to your User Account</Link>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <Footer> </Footer>
    </>
  );
};

export default AdminLogin;
