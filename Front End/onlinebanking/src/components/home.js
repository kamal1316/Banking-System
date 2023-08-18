import React, { useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Navbar from './navbar'; 
import Footer from './footer'; 
import './home.css';

const Home = () => {
  const navigate = useNavigate();

  useEffect(() => {
    let token = sessionStorage.getItem('JwtToken');
    if (!(token === '' || token === null)) {
      navigate('/dashboard');
    }
  }, [navigate]);

  return (
    <div>
      <Navbar />
      <div className="home-container">
        <h1 className="home-heading">Welcome to our Banking App</h1>
        <button className="home-button">
          <Link to="/login">Login</Link>
        </button>
        <button className="home-button">
          <Link to="/openAccount">New User? Apply for an account</Link>
        </button>
      </div>
      <Footer />
    </div>
  );
};

export default Home;
