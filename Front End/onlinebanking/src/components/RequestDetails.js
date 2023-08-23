import './personalDetails.css'; // Import the CSS file for styling
// import React, { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import {Link, useParams } from 'react-router-dom';
// import { toast } from "react-toastify";

function RequestDetails() {

  const {details} = useParams();

 

  return (
    <div className="personal-details-container" >
      <h2>Request Details</h2>
      <div className="details">
        <div className="detail-item">
          <label>Name:</label>
          <span>{details.name}</span>
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

      <div className='requestDetails'>
      <Button variant="primary" >
        <Link to="/admin/accountRequest/approve" className="btn btn-default">Approve</Link>
        </Button>
        
        <Button variant="danger">
        <Link to="admin/accountRequest/reject" className="btn btn-default">Reject</Link>
        </Button>
      </div>
      
    </div>
  );
}

export default RequestDetails;
