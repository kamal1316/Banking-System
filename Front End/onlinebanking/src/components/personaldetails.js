import React from 'react';
import './personaldetails.css'; // Import the CSS file for styling

function PersonalDetails() {
  return (
    <div className="personal-details-container">
      <h2>Personal Details</h2>
      <div className="details">
        <div className="detail-item">
          <label>Name:</label>
          <span>Sangram Ray</span>
        </div>
        <div className="detail-item">
          <label>Account No:</label>
          <span>123459876</span>
        </div>
        <div className="detail-item">
          <label>Father's Name:</label>
          <span>Samir Ray</span>
        </div>
        <div className="detail-item">
          <label>Address:</label>
          <span>Madhapur, Hyderabad, Telangana.</span>
        </div>
        <div className="detail-item">
          <label>Email ID:</label>
          <span>sangram.ray@example.com</span>
        </div>
        <div className="detail-item">
          <label>Phone Number:</label>
          <span>(+91) 456-7890</span>
        </div>
        <div className="detail-item">
          <label>Aadhar Number:</label>
          <span>1234-5678-9012</span>
        </div>
        <div className="detail-item">
          <label>PAN Number:</label>
          <span>ABCDE1234F</span>
        </div>
      </div>
    </div>
  );
}

export default PersonalDetails;
