import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/home';
import Login from './components/login';
import Signup from './components/signup';
import Dashboard from './components/dashboard';
import { ToastContainer } from 'react-toastify';

const App = () => {
  return (
    <><ToastContainer theme='colored' position='top-center'></ToastContainer>
     <BrowserRouter>
    
      <div>
        <Routes>
          <Route path="/"  element={<Home/>}></Route> 
          <Route path="/login"  element={<Login/>}></Route> 
          <Route path="/signup"  element={<Signup/>}></Route> 
          <Route path="/dashboard"  element={<Dashboard/>}></Route> 
        </Routes>
      </div>
    </BrowserRouter></>
  );
};

export default App;