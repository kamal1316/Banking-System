import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';

function AdminNavbar() {
    return (
        <>
        <Navbar bg="danger" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#home">Admin</Navbar.Brand>
          <Nav className="me-auto">
            {/* <Link to="/home">Home</Link> */}
            <Link className='btn' to="/admin/accountRequests">Account Requests</Link>
            <Link className='btn' to="/admin/allUsers">All Users</Link>
          </Nav>
        </Container>
      </Navbar>
      </>
    )
}

export default AdminNavbar;