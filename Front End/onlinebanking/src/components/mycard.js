import { useEffect, useState } from "react";
import { CardGroup } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import React from 'react';
import { useEffect } from "react";
import {Link, useNavigate } from 'react-router-dom';

const MyCard = () => {

  const [name, setName] = useState('unknown');
  const [balance, setBalance] = useState('xxx');
  const [accountNumber, setAccountNumber] = useState('yyyy');
  const [accountType, setAccountType] = useState('');
  const [branch, setBranch] = useState('');
  
  useEffect(() => {
    let token = sessionStorage.getItem('JwtToken');
    fetch(" http://localhost:8080/accounts/" + sessionStorage.getItem('userId'), {
      method: "GET",
      headers: { "Authorization" : `Bearer ${token}`,
      "Content-Type": "application/json" }
    }).then((res) => {
        return res.json();
    }).then ((resp) => {
      setBalance(resp.balance);
      setName(resp.name);
      setAccountNumber(resp.accountNumber);
      setAccountType(resp.accountType);
      setBranch(resp.branch);
    }).catch((err) => {
        console.log(err.message);
    })  
}, [])

  return (
    <CardGroup style={{padding: '50px'}}>
    <Card border='primary' style={{ width: '15rem', padding: '10px'}} bg='light' text = 'dark'>
      <Card.Body>
        <Card.Title>Account Summary</Card.Title>
        <Card.Text></Card.Text>
        <Card.Text></Card.Text>
        <Card.Text></Card.Text>
        <Card.Text></Card.Text>
        <Card.Text>
          Name: {name}
        </Card.Text>
        <Card.Text>
          Account Number: {accountNumber}
        </Card.Text>
        <Card.Text>
          Account Type: {accountType}
        </Card.Text>
        <Card.Text>
          Branch: {branch}
        </Card.Text>
        <Button variant="primary">
        <Link to="/personaldetails" className="btn btn-default">Show Personal Details</Link>
        </Button>
      </Card.Body>
    </Card>

    <Card border='primary' style={{ width: '15rem', padding: '10px'}} bg='light' text = 'dark'>
      <Card.Body>
        <Card.Title>Balance Summary</Card.Title>
        <Card.Text></Card.Text>
        <Card.Text></Card.Text>
        <Card.Text></Card.Text>
        <Card.Text></Card.Text>
        <Card.Text>
          Balance: {balance}
        </Card.Text>
        <Card.Text>
          Last Transaction: +1000
        </Card.Text>
        
        <Button variant="primary">
        <Link to="/transactions" className="btn btn-default">Show All Transactions</Link>
        </Button>
      </Card.Body>
    </Card>
    </CardGroup>
  );
}

export default MyCard;