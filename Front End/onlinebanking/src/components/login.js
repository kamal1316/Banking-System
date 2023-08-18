import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import Navbar from './navbar'; 
import Footer from './footer'; 
import './login.css';

const Login = () => {
  const [userId, userIdUpdate] = useState('');
  const [password, passwordUpdate] = useState('');
//   const [token, setToken] = useState('');

  const usenavigate = useNavigate();

//   useEffect(()=>{
//     sessionStorage.clear();
//         },[]);

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

            if(!response.ok) {
                toast.error('Please Enter valid credentials');
                throw new Error('Response was not ok');
            }
            else {
                return response.text();
            }
        }).then((data)=>{
            sessionStorage.setItem('JwtToken',data);
            console.log(data);
            // setToken(data);
            toast.success('Success');
            usenavigate('/dashboard');
        }).catch((err) => {
            toast.error('Login Failed due to :' + err.message);
        });

        // fetch("http://localhost:8080/users/" + userid).then((res) => {
        //     return res.json();
        // }).then((resp) => {
        //     if (Object.keys(resp).length === 0) {
        //         toast.error('Please Enter valid userid');
        //     } else {
        //         if (resp.password === password) {
        //             toast.success('Success');
        //             sessionStorage.setItem('userid',userid);
        //             sessionStorage.setItem('userrole',resp.role);
        //             usenavigate('/dashboard')
        //         }else{
        //             toast.error('Please Enter valid credentials');
        //         }
        //     }
        // }).catch((err) => {
        //     toast.error('Login Failed due to :' + err.message);
        // });
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
    <Navbar > </Navbar>
    <div className="row">
        <div className="offset-lg-3 col-lg-6" style={{ marginTop: '100px' }}>
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
                    </div>
                    <div className="card-footer">
                        <button type="submit" className="btn btn-primary">Login</button>
                        <span style={{"paddingRight": "20px"}}></span>

                        <Link className="btn btn-success" to={'/openAccount'}>New User? Apply for account</Link>

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
