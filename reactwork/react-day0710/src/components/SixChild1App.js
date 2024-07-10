import React from 'react';
import "./MyStyle.css";
import { Button } from '@mui/material';

const SixChild1App = (props) => {
    let {carname, carphoto, carprice, onIncre, bgcolor} = props;

    return (
        <div className='box2' style={{backgroundColor: bgcolor}}>
            자동차명 : {carname}<br></br>
            가격 : {carprice}만원<br></br>
            사진<br></br>
            <img alt="" src={require(`../mycar/${carphoto}`)} className='small2' />
            <br></br>
            <Button variant="outlined" color='error' size="small" onClick={onIncre}>방문</Button>
        </div>
    );
};

export default SixChild1App;