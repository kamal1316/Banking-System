import { CardGroup } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

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
          Peter Parry
        </Card.Text>
        <Card.Text>
          Account Number: 12345
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
          Balance: 15000
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