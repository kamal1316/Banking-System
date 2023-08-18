import React from 'react';
import { Link } from 'react-router-dom';
import './successpage.css'; 

function Successpage() {
  return (
    <div className="success-container">
      <h2>Congratulations!</h2>
      <p>You have successfully opened an account in our bank!</p>
      <p>You can go back to our <Link to="/login">login page</Link> and explore the different banking features that are provided by us.</p>
    </div>
  );
}

export default Successpage;