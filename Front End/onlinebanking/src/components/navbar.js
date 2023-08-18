import React from 'react';
import { Link } from 'react-router-dom';
import './navbar.css';

const Navbar = () => {
  return (
    <nav className="navbar">
      <Link to="/" className="navbar-brand">
        Wells Fargo Banking App
      </Link>
      <Link to="/" className="navbar-brand">
        email : admin@wellsfargo.com
      </Link>
      <Link to="/" className="navbar-brand">
        Contact : 1800696969
      </Link>
      <ul className="navbar-links">
        <li>
          <Link to="/login" className="navbar-link">
            Login
          </Link>
        </li>
        <li>
          <Link to="/openAccount" className="navbar-link">
            Open a new account
          </Link>
        </li>
        {/* Add more navigation links as needed */}
      </ul>
    </nav>
  );
};

export default Navbar;
