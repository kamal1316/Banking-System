import { useEffect, useState } from "react";
import { CardGroup } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import React from 'react'; 
import {Link } from 'react-router-dom';
import { toast } from "react-toastify";

const MyCard = () => {

  const [name, setName] = useState('unknown');
  const [balance, setBalance] = useState('xxxx');
  const [accountNumber, setAccountNumber] = useState('xxxx');
  const [accountType, setAccountType] = useState('xxxx');
  const [branch, setBranch] = useState('xxxx');
  
  useEffect(() => {
    let token = sessionStorage.getItem('JwtToken');

    fetch(" http://localhost:8080/accounts/" + sessionStorage.getItem('userId'), {
      method: "GET",
      headers: { "Authorization" : `User ${token}`,
      "Content-Type": "application/json" }
    }).then((res) => {
        if(!res.ok) {
          throw new Error("Couldn't fetch account details!!");
        }
        else {
            return res.json();
        }
    }).then ((resp) => {
      setBalance(resp.balance);
      setName(resp.name);
      setAccountNumber(resp.accountNumber);
      sessionStorage.setItem('balance', resp.balance);
      sessionStorage.setItem('accountNumber', resp.accountNumber);
      setAccountType(resp.accountType);
      setBranch(resp.branch);
    }).catch((err) => {
        toast.error(err.message);
    })  
}, [])

  return (
    <div>
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
        <Link to="/personalDetails" className="btn btn-default">Show Personal Details</Link>
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
          Balance: ₹{balance}
        </Card.Text>
        
        <Button variant="primary">
        <Link to="/transactions" className="btn btn-default">Show All Transactions</Link>
        </Button>
      </Card.Body>
    </Card>
    </CardGroup>
    
    </div>
  );
}

export default MyCard;