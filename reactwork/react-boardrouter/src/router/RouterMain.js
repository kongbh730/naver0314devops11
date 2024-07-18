import React from 'react';
import Menu from '../components/Menu';
import '../components/MyStyle.css';
import { Route, Routes } from 'react-router-dom';
import Home from '../components/Home';
import BoardForm from '../components/BoardForm';
import BoardList from '../components/BoardList';
import BoardDetail from '../components/BoardDetail';

const RouterMain = () => {
    return (
        <div>
            <Menu></Menu>
            <br></br>
            <br style={{clear:'both'}}></br>
            <Routes>
                <Route path='/' element={<Home></Home>}></Route>
                <Route path='/board'>
                    <Route path='form' element={<BoardForm></BoardForm>}></Route>
                    <Route path='list' element={<BoardList></BoardList>}></Route>
                    <Route path='detail/:boardnum' element={<BoardDetail></BoardDetail>}></Route>
                </Route>
            </Routes>
        </div>
    );
};

export default RouterMain;


