import { Alert, Switch } from '@mui/material';
import React, { useState } from 'react';
import img1 from '../image/17.jpg';
import img2 from '../image/12.jpg';

const ThreeApp = () => {
    const [show, setShow]=useState(true);
    const [visible, setVisible]=useState('visible');
    
    const photoStyle={
        width:'200px',
        height:'200px',
        border:'1px solid gray',
        borderRadius: '100px'
    }

    const photocheckEvent=(e)=>setShow(e.target.checked);

    const photoSwitchEvent=(e)=>{
        setVisible(e.target.checked ? "visible" : "hidden");
    }

    return (
        <div>
            {/* <h3 className='alert alert-danger'>ThreeApp</h3> */}

            <Alert>ThreeApp</Alert>
            <Alert severity='info'>이미지 show/hide 하는 여러방법</Alert>
            <Alert severity='warning'>이미지 show/hide 하는 여러방법</Alert>
            <Alert severity='error'>이미지 show/hide 하는 여러방법</Alert>
            <Alert severity='success'>이미지 show/hide 하는 여러방법</Alert>

            <label>
                <input type='checkbox' defaultChecked onClick={photocheckEvent}/>사진1 보이기
            </label>
            <br></br>
            {
                show &&
                <img alt="photo" src={img1} style={photoStyle}/>
            }
            <hr></hr>

            <Switch color="primary" defaultChecked onChange={photoSwitchEvent}></Switch>
            <br></br>
            <img alt="photo" src={img2} style={{width:'200px', visibility:visible}}/>
            

        </div>
    );
};

export default ThreeApp;