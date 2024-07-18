import { Alert } from '@mui/material';
import React from 'react';
import mainphoto1 from '../image/K-036.png';
import mainphoto2 from '../image/K-039.png';

const Home = () => {
    return (
        <div>
            <Alert>Home 메인입니다</Alert>  
            <div style={{marginTop:'30px'}}>
                <img alt='' src={mainphoto1} style={{width:'200px', height:'200px'}} />
                <img alt='' src={mainphoto2} style={{width:'200px', height:'200px'}} />
            </div>
        </div>
    );
};

export default Home; 