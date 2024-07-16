import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';

const About = () => {
    const {emp}=useParams();
    return (
        <div>
            <Alert severity='info'>About</Alert>

            <div style={{marginTop: '20px'}}>
            {
                emp == null ?
                <div>
                    <h3>취업 준비 중 입니다.</h3>
                    <img alt='' src={require('../image/s8.JPG')}  />
                </div>
                :
                <div>
                    <h3>현재 {emp} 에 재직 중 입니다.</h3>
                    <img alt='' src={require(`../image/${emp}.jpg`)}  />
                </div>    
            }    
            </div>
        </div>
    );
};

export default About;