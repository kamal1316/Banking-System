import './personalDetails.css'; // Import the CSS file for styling
import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import { Link, useLocation } from 'react-router-dom';
import { toast } from "react-toastify";
import AdminNavbar from './AdminNavbar';

function RequestDetails() {

  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const details = JSON.parse(decodeURIComponent(queryParams.get('data')));
  console.log(details);

  let usenavigate = useNavigate();

  const handleApprove = (e) => {
    e.preventDefault();

    // sessionStorage.setItem('reqId',details.id);
    const reqId = details.id;
    const token = sessionStorage.getItem('JwtToken');
    console.log(reqId);


    fetch(" http://localhost:8080/admin/accountRequests/approveRequest/" + reqId, {
      method: "GET",
      headers: { "Authorization" : `Admin ${token}`,
      "Content-Type": "application/json" }
      }).then(res => {

        if (!res.ok) {
          return res.json().then(data => { throw new Error(data.message) });
        }

        return res.text();
      }).then(data => {

        toast.success('Approved successfully.')
        usenavigate('/admin/accountRequests');
      }).catch((err) => {
        toast.error('Failed : ' + err.message);
      });
    
  }

  const handleReject = (e) => {
    e.preventDefault();

    const reqId = details.id;
    
    const token = sessionStorage.getItem('JwtToken');
    


      fetch("http://localhost:8080/admin/accountRequests/rejectRequest/" + reqId, {
        method: "DELETE",
        headers: { "Authorization" : `Admin ${token}`,
      "Content-Type": "application/json" }
      }).then(res => {

        if (!res.ok) {
          return res.json().then(data => { throw new Error(data.message) });
        }

        return res.text();
      }).then(data => {

        toast.success('Rejected successfully.')
        usenavigate('/admin/accountRequests');
      }).catch((err) => {
        toast.error('Failed : ' + err.message);
      });
    
  }



  return (
    <>
    <AdminNavbar/>
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
        <Button className='m-3' variant="primary" onClick={handleApprove} >
          Approve
        </Button>

        <Button className='m-3' variant="danger" onClick={handleReject}>
          Reject
        </Button>
      </div>

    </div>
    </>
  );
}

export default RequestDetails;
