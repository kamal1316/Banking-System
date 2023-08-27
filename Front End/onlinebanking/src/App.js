import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/home';
import Login from './components/login';
import AdminLogin from './components/adminLogin';
import Signup from './components/signup';
import Dashboard from './components/dashboard';
import Payment from './components/payment';
import Withdraw from './components/withdraw';
import Transactions from './components/transactions';
import PersonalDetails from './components/personalDetails';
import Success from './components/success';
import SuccessPage from './components/successpage';
import { ToastContainer } from 'react-toastify';

import ChangePassword from './components/changepassword';
import ResetPassword from './components/resetPassword';
import VerifyStep from './components/verifyStep';
import ResetStep from './components/resetStep';
import AdminDashboard from './components/AdminDashboard';
import RequestDetails from './components/RequestDetails';
import AccountRequests from './components/AccountRequests';
import ListUsers from './components/ListUsers';
import AdminTransactions from './components/adminTransactions';

const App = () => {

  return (
    <><ToastContainer theme='colored' position='top-center'></ToastContainer>
     <BrowserRouter>
    
      <div>
        <Routes>
          <Route path="/"  element={<Home/>}></Route> 
          <Route path="/login"  element={<Login/>}></Route> 
          <Route path="/adminLogin"  element={<AdminLogin/>}></Route> 
          <Route path="/openAccount"  element={<Signup/>}></Route> 
          <Route path="/dashboard"  element={<Dashboard/>}></Route> 
          <Route path="/payment"  element={<Payment/>}></Route> 
          <Route path="/withdraw"  element={<Withdraw/>}></Route> 
          <Route path="/changePassword" element={<ChangePassword/>}></Route>
          <Route path="/transactions"  element={<Transactions/>}></Route> 
          <Route path="/personalDetails"  element={<PersonalDetails/>}></Route>
          <Route path="/success" element ={<Success/>}></Route>
          <Route path="/successpage" element ={<SuccessPage/>}></Route>
          <Route path="/resetPassword" element ={<ResetPassword/>}></Route>
          <Route path="/adminDashboard" element ={<AdminDashboard/>}></Route>
          <Route path='/admin/accountRequests' element = {<AccountRequests/>}></Route>
          <Route path='/admin/accountRequests/details' element = {<RequestDetails/>}></Route>
          <Route path='/admin/listUsers' element = {<ListUsers/>}></Route>
          <Route path="/verifyStep" element ={<VerifyStep/>}></Route>
          <Route path="/resetStep" element ={<ResetStep/>}></Route>
          <Route path = "/userTransaction" element = {<AdminTransactions/>}></Route>
        </Routes>
      </div>
    </BrowserRouter></>
  );
};


export default App;
