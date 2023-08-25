import { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import Navbar from './navbar'; 
import Footer from './footer'; 
import './signup.css'; 

const Signup = () => {

    //const [userId, idchange] = useState("");
    const [name, namechange] = useState("");
    const [fatherName, fathernamechange] = useState("");
    //const [password, passwordchange] = useState("");
    const [email, emailchange] = useState("");
    const [mobile, phonechange] = useState("");
    const [aadhaar, aadhaarchange] = useState("");
    const [pan, panchange] = useState("");
    const [country, countrychange] = useState("india");
    const [address, addresschange] = useState("");
    const [gender, genderchange] = useState("female");

    const usenavigate = useNavigate();

    useEffect(() => {
        let token = sessionStorage.getItem('JwtToken');
        if (!(token === '' || token === null)) {
            usenavigate('/dashboard');
        }
    }, [usenavigate]);

    const IsValidate = () => {
        let isproceed = true;
        let errormessage = 'Please enter the value in ';
        
        if (name === null || name === '') {
            isproceed = false;
            errormessage += ' Fullname';
        }
        if (fatherName === null || fatherName === '') {
            isproceed = false;
            errormessage += ' Father\'s name';
        }
        if (email === null || email === '') {
            isproceed = false;
            errormessage += ' Email';
        }

        if (!isproceed) {
            toast.warning(errormessage);
        } else {
            if (/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/.test(email)) {

            } else {
                isproceed = false;
                toast.warning('Please enter the valid email')
            }
        }
        return isproceed;
    }

    const handlesubmit = (e) => {
        e.preventDefault();

        let regobj = { name, fatherName, email, mobile, aadhaar, pan, country, address, gender };

        if (IsValidate()) {

            fetch("http://localhost:8080/admin/createRequest", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(regobj)
            }).then(res => {

                if(!res.ok) {
                    return res.json().then(data => {throw new Error(data.message)});
                }

                return res.text();
            }).then(data => {

                toast.success('Applied successfully.')
                usenavigate('/successpage');
            }).catch((err) => {
                toast.error('Failed : ' + err.message);
            });
        }
    }


    return (
        <>
        <Navbar />
        <div className="signup-container">
            <div className="offset-lg-3 col-lg-6">
                <form className="container" onSubmit={handlesubmit} style = {{padding: "20px"}}>
                    <div className="card">
                        <div className="card-header">
                            <h1>Apply for Account</h1>
                        </div>
                        <div className="card-body">

                            <div className="row">
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label>Full Name <span className="errmsg">*</span></label>
                                        <input required value={name} onChange={e => namechange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label>Father's Name <span className="errmsg">*</span></label>
                                        <input required value={fatherName} onChange={e => fathernamechange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label>Email <span className="errmsg">*</span></label>
                                        <input type = "email" required value={email} onChange={e => emailchange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label>Mobile <span className="errmsg">*</span></label>
                                        <input pattern="[0-9]{10}" title="Enter 10 digit valid mobile number" required value={mobile} onChange={e => phonechange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label>Aadhaar <span className="errmsg"></span></label>
                                        <input pattern="^$|^[0-9]{12}$" title="Enter valid 12 digit aadhaar number" value={aadhaar} onChange={e => aadhaarchange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label>PAN <span className="errmsg"></span></label>
                                        <input pattern="^$|^[A-Z]{5}[0-9]{4}[A-Z]{1}$" title="Enter valid PAN. Format:ABCDE1234F" value={pan} onChange={e => panchange(e.target.value)} className="form-control"></input>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label>Country <span className="errmsg">*</span></label>
                                        <select required value={country} onChange={e => countrychange(e.target.value)} className="form-control">
                                            <option value="india">India</option>
                                            <option value="usa">USA</option>
                                            <option value="singapore">Singapore</option>
                                        </select>
                                    </div>
                                </div>
                                <div className="col-lg-12">
                                    <div className="form-group">
                                        <label>Address</label>
                                        <textarea value={address} onChange={e => addresschange(e.target.value)} className="form-control"></textarea>
                                    </div>
                                </div>
                                <div className="col-lg-6">
                                    <div className="form-group">
                                        <label required >Gender <span className="errmsg">*</span></label>
                                        <br></br>
                                        <input type="radio" checked={gender === 'male'} onChange={e => genderchange(e.target.value)} name="gender" value="male" className="app-check"></input>
                                        <label> Male</label>
                                        <span style = {{padding : "5px"}}></span>
                                        <input type="radio" checked={gender === 'female'} onChange={e => genderchange(e.target.value)} name="gender" value="female" className="app-check"></input>
                                        <label> Female</label>
                                        <span style = {{padding : "5px"}}></span>
                                        <input type="radio" checked={gender === 'other'} onChange={e => genderchange(e.target.value)} name="gender" value="other" className="app-check"></input>
                                        <label>Other</label>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div className="card-footer">
                            <button type="submit" className="btn btn-primary">Submit</button>
                            <span style = {{padding : "10px"}}></span>
                            <Link to={'/login'} className="btn btn-danger">Close</Link>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <Footer> </Footer>
        </>
    );
};

export default Signup;
