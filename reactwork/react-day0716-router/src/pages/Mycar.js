import { Alert } from '@mui/material';
import React from 'react';
import { NavLink, Route, Routes } from 'react-router-dom';

import MycarList from './MycarList';
import MycarPhoto from './MycarPhoto';

const Mycar = () => {
    return (
        <div>
            <Alert severity='error' style={{fontSize:'20px'}}>Mycar</Alert>
            <ul className='menu'>
                <li>
                    <NavLink to={'/mycar/mycarlist'}>목록</NavLink>
                </li>
                <li>
                    <NavLink to={'/mycar/mycarphoto'}>사진</NavLink>
                </li>
            </ul>

            <div style={{clear:'both', marginTop:'20px'}}>
                <Routes>
                    <Route path='mycarlist' element={<MycarList></MycarList>}></Route>
                    <Route path='mycarphoto' element={<MycarPhoto></MycarPhoto>}></Route>
                </Routes>

            </div>

            <h2 className='alert alert-danger'>MyCarDB자료 : 강사님 해설</h2>
            <ul className='menu'>
                <li>
                    <NavLink to={'/mycar/list'}>목록 #1</NavLink>
                </li>
                <li>
                    <NavLink to={'/mycar/photo'}>목록 #2</NavLink>
                </li>
                <div style={{marginTop:'20px', width:'400px', clear:'both'}}>
                    <Routes>
                        <Route path='list' element={<MycarList></MycarList>}></Route>
                        <Route path='photo' element={<MycarPhoto></MycarPhoto>}></Route>
                    </Routes>
                </div>
            </ul>

        </div>
    );
};

export default Mycar;