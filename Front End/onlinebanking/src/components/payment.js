//import React from 'react';
import { useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import React,{useState} from 'react';
import {Button, Form} from 'react-bootstrap';

const Payment = () => {
  const usenavigate = useNavigate();
  
  const[auth,setAuth] = useState(false);
  if(auth){
    usenavigate('/success');
  }
  const [data,setData] =useState({
    UseraccountNumber : '',
    ToAccountNumber : '',
    Amount : '',
    password : ''
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
        <h1>Payment Page</h1>
        <Form>
      <Form.Group className="mb-3" controlId="FormBasicText">
        <Form.Label>User Account Number </Form.Label>
        <Form.Control type="number" placeholder="Enter your account number" onChange={changeHandler}/>
      </Form.Group>

      <Form.Group className="mb-3" controlId="FormBasicText">
        <Form.Label>To Account Number</Form.Label>
        <Form.Control type="number" placeholder="Enter receiver's account number"  onChange={changeHandler}/>
      </Form.Group>

      <Form.Group className="mb-3" controlId="FormBasicText"  onChange={changeHandler}>
        <Form.Label>Amount</Form.Label>
        <Form.Control type = "number" placeholder="Enter the amount to be send" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword"  onChange={changeHandler}>
       <Form.Label>Password</Form.Label>
        {<Form.Control type = "password" placeholder="Enter your password" />}
      </Form.Group>
    
      <Button variant="primary" type="submit" OnClick={()=> setAuth(true)}>
        Submit
      </Button>

    </Form>
    </div>
  );
};

export default Payment;
