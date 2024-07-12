import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';
import { Button } from '@mui/material';

const Footer = () => {
    const {isDark, setIsDark}=useContext(ThemeContext);
    
    return (
        <footer className='footer' style={{backgroundColor:isDArk? 'pink' : 'cyan'}}>
            <Button variant='contained' color='error'>
                Dark Mode
            </Button>
        </footer>
    );
};

export default Footer;