import React from 'react';
import { useEffect, useState } from "react";
import { useNavigate,Link } from 'react-router-dom';

const Dashboard = () => {

    const usenavigate = useNavigate();

    useEffect(()=>{
        let username = sessionStorage.getItem('username');
        if(username===''||username===null){
            usenavigate('/login');
        }
    },[]);


  return (
    <div>
      <h2>Welcome User</h2>
    </div>
  );
};

export default Dashboard;
