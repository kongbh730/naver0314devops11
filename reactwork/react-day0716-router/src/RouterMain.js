import React from 'react';
import Menu from './components/Menu';
import { Route, Routes } from 'react-router-dom';

// import Home from './pages/Home';
// import Food from './pages/Food';
// import About from './pages/About';
import {Home, Food, About} from './pages';

import photo1 from './image/s5.JPG';
import photo2 from './image/s2.JPG'

import './components/MyStyle.css';

import Member from './pages/Member';
import Mycar from './pages/Mycar';

const RouterMain = () => {
    return (
        <div>
            <Menu></Menu>
            <hr style={{clear:'both'}}></hr>
            <Routes>
                <Route path='/' element={<Home></Home>}></Route>
                
                {/* <Route path='/food' element={<Food></Food>}></Route> */}
                <Route path='/food' element={<Food></Food>}>
                    <Route path=':food1' element={<Food></Food>}></Route> 
                    <Route path=':food1/:food2' element={<Food></Food>}></Route>             
                </Route>

                {/* about */}
                <Route path='/about' element={<About></About>}>
                    <Route path=':emp' element={<About></About>}></Route>
                </Route>

                {/* Member */}
                <Route path='/member/*' element={<Member></Member>}></Route>

                {/* Mycar */}
                <Route path='/Mycar/*' element={<Mycar></Mycar>}></Route>

                {/* 직접 태그를 이용한 페이지 구현 */}
                <Route path='/login/*' element={
                    <div>
                        <h2>로그인 메뉴입니다.</h2>
                        <img alt='' src={photo1}/>
                        <About></About>
                    </div>
                }></Route>

                {/* 이외의 모든 매핑주소에 대한 처리 */}
                <Route path='*' element={
                    <div>
                        <h2>잘못된 페이지입니다.</h2>
                        <img alt='' src={photo2}></img>
                    </div>
                }></Route>

            </Routes>
        </div>
    );
};

export default RouterMain;