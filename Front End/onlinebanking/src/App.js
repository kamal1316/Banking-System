import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/home';
import Login from './components/login';
import Signup from './components/signup';
import Dashboard from './components/dashboard';
import Payment from './components/payment';
import Transactions from './components/transactions';
import PersonalDetails from './components/personalDetails';
import Success from './components/success';
import SuccessPage from './components/successpage';
import { ToastContainer } from 'react-toastify';

import ChangePassword from './components/changepassword';

const App = () => {


  return (
    <><ToastContainer theme='colored' position='top-center'></ToastContainer>
     <BrowserRouter>
    
      <div>
        <Routes>
          <Route path="/"  element={<Home/>}></Route> 
          <Route path="/login"  element={<Login/>}></Route> 
          <Route path="/openAccount"  element={<Signup/>}></Route> 
          <Route path="/dashboard"  element={<Dashboard/>}></Route> 
          <Route path="/payment"  element={<Payment/>}></Route> 
          <Route path="/changePassword" element={<ChangePassword/>}></Route>
          <Route path="/transactions"  element={<Transactions/>}></Route> 
          <Route path="/personalDetails"  element={<PersonalDetails/>}></Route>
          <Route path="/success" element ={<Success/>}></Route>
          <Route path="/successpage" element ={<SuccessPage/>}></Route>
        </Routes>
      </div>
    </BrowserRouter></>
  );
};

export default App;
