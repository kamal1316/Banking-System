import { useEffect, useState } from "react";
import { CardGroup } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

const MyCard = () => {

  const [name, setName] = useState('unknown');
  const [balance, setBalance] = useState('xxx');
  const [accountNumber, setAccountNumber] = useState('yyyy');

  useEffect(() => {
    let token = sessionStorage.getItem('JwtToken');
    fetch(" http://localhost:8080/accounts/" + sessionStorage.getItem('userId'), {
      method: "GET",
      headers: { "Authorization" : `Bearer ${token}`,
      "Content-Type": "application/json" }
    }).then((res) => {
        return res.json();
    }).then ((resp) => {
      // console.log(resp);
      // console.log(resp.balance);
      setBalance(resp.balance);
      setName(resp.name);
      setAccountNumber(resp.accountNumber);
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
          {name}
        </Card.Text>
        <Card.Text>
          Account Number: {accountNumber}
        </Card.Text>
        <Card.Text>
          Account Type: Savings
        </Card.Text>
        <Card.Text>
          Branch: Hyderabad
        </Card.Text>
        <Button variant="primary">Show Full Details</Button>
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
          Last Transaction: +500
        </Card.Text>
        <Button variant="primary">Show All Transactions</Button>
      </Card.Body>
    </Card>
    </CardGroup>
  );
}

export default MyCard;