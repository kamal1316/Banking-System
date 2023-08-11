import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <div>
      <h2>Welcome to Our App</h2>
      <button>
        <Link to="/login">Login</Link>
      </button>
      <button>
        <Link to="/signup">Sign up</Link>
      </button>
    </div>
  );
};

export default Home;
