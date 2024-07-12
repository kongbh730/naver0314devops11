import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';
import { UserContext } from './UserContext';

const Content = () => {
    const {isDark}=useContext(ThemeContext);
    const myname=useContext(UserContext);
    
    return (
        <div className='content' style={{backgroundColor: ''}}>
            
        </div>
    );
};

export default Content;