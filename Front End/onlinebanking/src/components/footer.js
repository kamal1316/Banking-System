import React from 'react';
import './footer.css';

const Footer = () => {
  return (
    <footer className="footer">
      &copy; {new Date().getFullYear()} Wells Fargo Bank App. All rights reserved.
    </footer>
  );
};

export default Footer;
