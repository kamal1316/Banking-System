import { useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import React,{useState} from 'react';
import {Button, Form} from 'react-bootstrap';

const ChangePassword = () => {
  const usenavigate = useNavigate();
  
  const[auth,setAuth] = useState(false);
  if(auth){
    usenavigate('/chanegedPassword');
  }
  const [data,setData] =useState({
    CurrentPassword: '',
    NewPassword : '',
  })
  const changeHandler = e => {
    setData({...data,[e.target.name]:[e.target.value]})
  }
  const submithandler = e => {
    e.preventDefault()
    console.log(data);
  }
  

    useEffect(()=>{
      let token = sessionStorage.getItem('JwtToken');
      if(token===''||token===null){
          usenavigate('/home');
      }
  },[usenavigate]);


  return (
    <div>
        <h1>Change Password</h1>
        <Form>
      <Form.Group className="mb-3" controlId="FormBasicPassword">
        <Form.Label>Current Password </Form.Label>
        <Form.Control type="password" label="Enter current Password" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="FormBasicPassword">
        <Form.Label>New Password</Form.Label>
        <Form.Control type="password" label="Enter new Password" />
      </Form.Group>

      <Button variant="primary" type="submit" OnClick={()=> setAuth(true)}>
        Submit
      </Button>
    
    </Form>
    </div>
  );
};

export default ChangePassword;
