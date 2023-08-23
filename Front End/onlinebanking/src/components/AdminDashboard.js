import React from 'react';
import { useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import AdminNavbar from './AdminNavbar';

const AdminDashboard = () => {

    const usenavigate = useNavigate();

    useEffect(()=>{
        let token = sessionStorage.getItem('JwtToken');
        if(token===''||token===null){
            usenavigate('/');
        }
    },[usenavigate]);

  return (
    <div>
      <AdminNavbar />
  
    </div>
  );
};

export default AdminDashboard;

