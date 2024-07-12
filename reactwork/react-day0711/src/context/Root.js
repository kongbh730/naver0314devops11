import React, { useState } from "react";
import './context.css';
import { UserContext } from "./UserContext";
import { ThemeContext } from "./ThemeContext";
import Page from './Page';

const Root=()=>{
    const [isDark, setIsDark]=useState(false);

    return (
        <UserContext.Provider value={'비트캠프'}>
            {/* themecontext로 선택 */}
            <ThemeContext.Provider value={{isDark, setIsDark}}>
                <Page/>
            </ThemeContext.Provider>
        </UserContext.Provider>
    );
};


export default Root;