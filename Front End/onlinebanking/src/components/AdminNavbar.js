import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import { useNavigate } from 'react-router-dom';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
import { Button, Form } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';


function AdminNavbar() {

  const usenaviagte = useNavigate();
  
  const handleLogout = (e) => {
    sessionStorage.clear();
    usenaviagte('/');
  }

  return (
    // <>
      <Navbar expand="lg" className="navbar-body"  >
        <Container>
          <Navbar.Brand href="/adminDashboard">Admin Dashboard</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            {/* <Link to="/home">Home</Link> */}

             {/* <Link className='btn text-dark w-auto

'   to="/admin/accountRequests">Account Requests</Link> */}
            <LinkContainer to ="/admin/listUsers">
              <Nav.Link className='text-dark'>All Users</Nav.Link>
            </LinkContainer>
            <LinkContainer to="/admin/accountRequests">
              <Nav.Link className='text-dark'>Account Requests</Nav.Link>
              </LinkContainer> 
            {/* <Nav.Link  to="/admin/listUsers">All Users</Nav.Link>  */}
          </Nav>
            
          <Nav>
          <Nav.Link className='float-right text-danger' to ={"/login"} onClick={handleLogout}>Logout</Nav.Link>
          </Nav>
          
          </Navbar.Collapse>
        </Container>
      </Navbar>
    // </>
  )
}

export default AdminNavbar;