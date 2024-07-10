import { Alert } from '@mui/material';
import React from 'react';
import FiveChildApp from './FiveChildApp';
import FiveChild2App from './FiveChild2App';

const FiveApp = () => {


    
    return (
        <div>
            <Alert>FiveApp - 부모 자식 components 간의 통신 #1</Alert>
            <h5>FiveChildApp 컴포넌트 호출</h5>
            <FiveChildApp irum={'이영자'} age={23} addr={'서울시'}></FiveChildApp>
            <FiveChildApp irum={'강호동'} age={41} addr={'부산시'}></FiveChildApp>
            <FiveChildApp irum={'손흥민'} age={33} addr={'경기도'}></FiveChildApp>

            <h5>FiveChild2App 컴포넌트 호출</h5>
            <FiveChild2App irum="이미자" photo={"mycar11.png"} msg="노랑이차"></FiveChild2App>
            <FiveChild2App irum="강호동" photo={"mycar13.png"} msg="분홍이차"></FiveChild2App>



        </div>
    );
};

export default FiveApp;