import React from 'react';
import './dashboardNavbar.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link, useNavigate } from 'react-router-dom';

const DashboardNavbar = () => {

  const usenaviagte = useNavigate();

  const handleLogout = (e) => {
    sessionStorage.clear();
    usenaviagte('/');
  }

  return (
    <Navbar expand="lg" className="navbar-body">
      <Container>
        <Navbar.Brand href="#home">Wells Fargo Banking App</Navbar.Brand>

        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            
            <NavDropdown title="Fund Transfer" id="basic-nav-dropdown">
              <NavDropdown.Item >To Beneficiary</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item >
                <Link to ={"/payment"} >Quick Transfer</Link>
              </NavDropdown.Item>
            </NavDropdown>

            <Nav.Link href="/changepassword">Change Password</Nav.Link>
            <Nav.Link href="/contact">Contact Us</Nav.Link>

            <Nav.Link href="/login" onClick={handleLogout}>Logout</Nav.Link>

          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default DashboardNavbar;
