import React from 'react';
import { useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import Footer from './footer';
import DashboardNavbar from './dashboardNavbar';
import MyCard from './mycard';
import Payment from './payment';
import ChangePassword from './changepassword';

const Dashboard = () => {

    const usenavigate = useNavigate();

    useEffect(()=>{
        let token = sessionStorage.getItem('JwtToken');
        if(token===''||token===null){
            usenavigate('/');
        }
    },[usenavigate]);

  return (
    <div>
      <DashboardNavbar/>
      <MyCard/>
      <Footer> </Footer>
    </div>
  );
};

export default Dashboard;

