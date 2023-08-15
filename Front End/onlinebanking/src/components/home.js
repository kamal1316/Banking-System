import {React, useEffect} from 'react';
import { Link, useNavigate } from 'react-router-dom';

const Home = () => {

  const usenavigate = useNavigate();

  useEffect(()=>{
    let token = sessionStorage.getItem('JwtToken');
    if(!(token===''||token===null)){
        usenavigate('/dashboard');
    }
  },[usenavigate]);

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
