import React from 'react';
import { useEffect } from "react";
import { Link, useNavigate } from 'react-router-dom';
import AdminNavbar from './AdminNavbar';
import Footer from './footer'; 
import './AdminDashboard.css';

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
      <AdminNavbar/>
      <div className="admin-container">
        <h1 className="admin-heading">Welcome Back Admin</h1>
        {/* <button className="home-button">
          <Link to="/admin/listUsers">All Users</Link>
        </button>
        <button className="admin-button">
          <Link to="/admin/accountRequests">Account Requests</Link>
        </button> */}
        
      </div>
      <Footer> </Footer>
  
    </div>
  );
};

export default AdminDashboard;

