import React from 'react';
import './MyStyle.css';

// const FiveChild2App = ({irum, photo, msg}) => {
const FiveChild2App = (props) => {

    let {irum, photo, msg} = props; //여러 통신 방법

    return (
        <div className='box1'>
            <img art="" src={require(`../mycar/${photo}`)} className='small'/>
            <b>{irum}의 차는 {msg}</b>
                
        </div>
    );
};

export default FiveChild2App;