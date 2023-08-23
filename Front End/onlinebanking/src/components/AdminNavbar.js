import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
import { Button, Form } from 'react-bootstrap';


function AdminNavbar() {
  return (
    <>
      <Navbar bg="danger" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#home">Admin</Navbar.Brand>
          <Nav className="me-auto">
            {/* <Link to="/home">Home</Link> */}
            <Link className='btn' to="/admin/accountRequests">Account Requests</Link>
            <Link className='btn' to="/admin/listUsers">All Users</Link>
            <Form className="d-flex">
              <Form.Control
                type="search"
                placeholder="Search User"
                className="me-2"
                aria-label="Search"
              />
              <Button variant="primary">Search</Button>
            </Form>
          </Nav>
        </Container>
      </Navbar>
    </>
  )
}

export default AdminNavbar;