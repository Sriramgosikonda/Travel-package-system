import React from 'react';

const Footer = () => {
  return (
    <footer className="bg-primary text-white text-center py-3 mt-4">
      &copy; {new Date().getFullYear()} Travel Package System. All rights reserved.
    </footer>
  );
};

export default Footer;
