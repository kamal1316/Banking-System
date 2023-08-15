import React from 'react';
import { useEffect } from "react";
import { useNavigate } from 'react-router-dom';

import DashboardNavbar from './dashboardNavbar';
import MyCard from './mycard';

const Dashboard = () => {

    const usenavigate = useNavigate();

    useEffect(()=>{
        let token = sessionStorage.getItem('JwtToken');
        if(token===''||token===null){
            usenavigate('/login');
        }
    },[usenavigate]);

  return (
    <div>
      <DashboardNavbar />
      <MyCard/>
    </div>
  );
};

export default Dashboard;
