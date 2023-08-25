import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import Navbar from './navbar'; 
import Footer from './footer'; 
import './login.css';
import { Form } from "react-bootstrap";

const Login = () => {
  const [userId, userIdUpdate] = useState('');
  const [password, passwordUpdate] = useState('');

  const usenavigate = useNavigate();


    useEffect(()=>{
        let token = sessionStorage.getItem('JwtToken');
        if(!(token===''||token===null)){
            usenavigate('/dashboard');
        }
    },[usenavigate]);

  const ProceedLogin = (e) => {
    e.preventDefault();
    if (validate()) {

        let userobj = {userId, password};

        sessionStorage.setItem('userId', userId);

        fetch("http://localhost:8080/authenticate", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(userobj)
        }).then((response) => {
            console.log(response);
            if(!response.ok) {
                // throw new Error('Please Enter valid credentials');
                return response.json().then(data => {throw new Error(data.message)});
            }
            else {
                return response.text();
            }
        }).then((data)=>{
            sessionStorage.setItem('JwtToken',data);
            console.log(data);
            toast.success('Success');
            usenavigate('/dashboard');
        }).catch((err) => {
            toast.error('Login Failed.' + err.message);
        });
    }
  }

  const validate = () => {
    let result = true;
    if (userId === '' || userId === null) {
      result = false;
      toast.warning('Please Enter userid');
    }
    if (password === '' || password === null) {
      result = false;
      toast.warning('Please Enter Password');
    }
    return result;
  }

  return (
    <> 
   <Navbar />
    <div className="login-container">
        <div className="offset-lg-3 col-lg-6" >
            <form onSubmit={ProceedLogin} className="container">
                <div className="card">
                    <div className="card-header">
                        <h2>User Login</h2>
                    </div>
                    <div className="card-body">
                        <div className="form-group">
                            <label>User Name <span className="errmsg">*</span></label>
                            <input value={userId} onChange={e => userIdUpdate(e.target.value)} className="form-control"></input>
                        </div>
                        <div className="form-group">
                            <label>Password <span className="errmsg">*</span></label>
                            <input type="password" value={password} onChange={e => passwordUpdate(e.target.value)} className="form-control"></input>
                        </div>
                        <Form.Group className="mb-3" controlId="formBasicCheckbox">
                        <p className="small">
                          <a className="text-primary" href="/resetPassword">
                            Forgot password?
                          </a>
                        </p>
                        </Form.Group>
                    </div>
                    <div className="card-footer">
                        <button type="submit" className="btn btn-primary">Login</button>
                        <span style={{"paddingRight": "20px"}}></span>

                        {/* Admin Login Link */}
                        <Link className="btn btn-info" to={'/adminLogin'}>Admin Login</Link>

                        <Link className="btn btn-success" to={'/openAccount'}>New User? Apply for an account</Link>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <Footer> </Footer>
    </>
  );
};

export default Login;
