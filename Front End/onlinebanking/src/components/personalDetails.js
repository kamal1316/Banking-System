import './personalDetails.css'; // Import the CSS file for styling
import React, { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import {Link } from 'react-router-dom';
import { toast } from "react-toastify";
import Footer from './footer';
import DashboardNavbar from './dashboardNavbar';

function PersonalDetails() {

  const [details, setDetails] = useState('');

  useEffect(() => {
    let token = sessionStorage.getItem('JwtToken');
    let userId = sessionStorage.getItem('userId');

    fetch(" http://localhost:8080/personalDetails/" + userId, {
      method: "GET",
      headers: { "Authorization" : `User ${token}`,
      "Content-Type": "application/json" }
    }).then((res) => {
      if(!res.ok) {
        throw new Error("Couldn't fetch personal details!!");
      }
      else {
        return res.json();
      }
    }).then ((resp) => {
        setDetails(resp);
    }).catch((err) => {
      toast.error(err.message);
    })

  }, []);

  return (
    <>
    <DashboardNavbar/>
    <div className="personal-details-container">
      <h2>Personal Details</h2>
      <div className="details">
        <div className="detail-item">
          <label>Name:</label>
          <span>{details.name}</span>
        </div>
        <div className="detail-item">

          <label>userId:</label>
          <span>{details.userId}</span>

        </div>
        <div className="detail-item">
          <label>Father's Name:</label>
          <span>{details.fatherName}</span>
        </div>
        <div className="detail-item">
          <label>Address:</label>
          <span>{details.address}</span>
        </div>
        <div className="detail-item">
          <label>Email ID:</label>
          <span>{details.email}</span>
        </div>
        <div className="detail-item">
          <label>Phone Number:</label>
          <span>{details.mobile}</span>
        </div>
        <div className="detail-item">
          <label>Aadhar Number:</label>
          <span>{details.aadhaarNumber}</span>
        </div>
        <div className="detail-item">
          <label>PAN Number:</label>
          <span>{details.pan}</span>
        </div>
        <div className="detail-item">
          <label>Gender:</label>
          <span>{details.gender}</span>
        </div>
        <div className="detail-item">
          <label>Country:</label>
          <span>{details.country}</span>
        </div>
      </div>

      <div style = {{padding: "10px"}}>
        <Button variant="primary" >
        <Link to="/dashboard" className="btn btn-default">Back To Dashboard</Link>
        </Button>
      </div>
      
    </div>
    <Footer/>
    </>
  );
}

export default PersonalDetails;
