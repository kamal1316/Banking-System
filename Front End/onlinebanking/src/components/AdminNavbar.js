import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import { useNavigate } from 'react-router-dom';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
import { Button, Form } from 'react-bootstrap';


function AdminNavbar() {

  const usenaviagte = useNavigate();
  
  const handleLogout = (e) => {
    sessionStorage.clear();
    usenaviagte('/');
  }

  return (
    <>
      <Navbar  bg="ffae00" data-bs-theme="dark" >
        <Container>
          <Navbar.Brand href="/adminDashboard">Admin</Navbar.Brand>
          <Nav className="mr-auto">
            {/* <Link to="/home">Home</Link> */}
            {/* <Link className='btn' style ={{padding: '10px', margin: '10px'}} to="/admin/accountRequests">Account Requests</Link>
            <Link className='btn' style ={{padding: '10px', margin: '10px'}} to="/admin/listUsers">All Users</Link> */}
            <Form className="d-flex">
              <Form.Control type="search" placeholder="Search User" style ={{padding: '10px', margin: '10px',width: '300px', height: '50px'}} aria-label="Search" />
              <Button className='btn' style ={{padding: '10px',margin: '10px' ,width: '80px', height: '50px'} } >Search</Button>
            </Form>
            <Button className='btn' style ={{margin: '10px', height: '50px'} }onClick={handleLogout}> Logout </Button>
          </Nav>
        </Container>
      </Navbar>
    </>
  )
}

export default AdminNavbar;