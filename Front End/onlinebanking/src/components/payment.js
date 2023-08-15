import React from 'react';
import { useEffect } from "react";
import { useNavigate } from 'react-router-dom';

const Payment = () => {

    const usenavigate = useNavigate();

    useEffect(()=>{
      let token = sessionStorage.getItem('JwtToken');
      if(token===''||token===null){
          usenavigate('/login');
      }
  },[usenavigate]);


  return (
    <div>
        <h1>Payment Page</h1>
    </div>
  );
};

export default Payment;
