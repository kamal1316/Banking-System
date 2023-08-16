import { CardGroup } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import React from 'react';
import { useEffect } from "react";
import {Link, useNavigate } from 'react-router-dom';

const MyCard = () => {
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
          Sangram Ray
        </Card.Text>
        <Card.Text>
          Account Number: 123459876
        </Card.Text>
        <Card.Text>
          Account Type: Savings
        </Card.Text>
        <Card.Text>
          Branch: Hyderabad
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
          Balance: 15000
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