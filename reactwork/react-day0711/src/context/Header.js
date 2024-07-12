import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';
import { UserContext } from './UserContext';

const Header = () => {
    // 현재 폴더 내에 있는 ThemeContext
    const {isDark} = useContext(ThemeContext);
    const username = useContext(UserContext);
    console.log(isDark);
    console.log(username);

    return (
        <div>
            
        </div>
    );
};

export default Header;