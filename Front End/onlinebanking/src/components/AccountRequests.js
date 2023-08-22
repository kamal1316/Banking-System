import ListGroup from 'react-bootstrap/ListGroup';
import { Link } from 'react-router-dom';

function AccountRequests() {
    return (
        <>
        <br />
        <ListGroup>
            <ListGroup.Item>
                <Link to="details" >Req #100</Link>
            </ListGroup.Item>
            <ListGroup.Item>
                <Link>Req #101</Link></ListGroup.Item>
            <ListGroup.Item>
                <Link>Req #102</Link></ListGroup.Item>
            <ListGroup.Item>
                <Link>Req #103</Link></ListGroup.Item>
            <ListGroup.Item>
                <Link>Req #104</Link></ListGroup.Item>
        </ListGroup>
        </>
    );
}

export default AccountRequests;