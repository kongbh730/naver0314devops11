import React from 'react';
import Menu from '../components/Menu';
import '../components/MyStyle.css';
import { Route, Routes } from 'react-router-dom';
import Home from '../components/Home';
import BoardForm from '../components/BoardForm';
import BoardList from '../components/BoardList';
import BoardDetail from '../components/BoardDetail';
import UpdatePassForm from '../components/UpdatePassForm';
import UpdateForm from '../components/UpdateForm';
import DaumPostApp from '../components/DaumPostApp';
import SweetAlertApp from '../components/SweetAlertApp';
import ReducerComp1 from '../components/ReducerComp1';
import ReducerComp2 from '../components/ReducerComp2';
import MemoTest from '../components2/MemoTest';
import CallBackTest from '../components2/CallBackTest';
import LoginForm from '../member/LoginForm';
import MemberList from '../member/MemberList';
import MemberForm from '../member/MemberForm';

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
                    <Route path='updatepass/:boardnum' element={<UpdatePassForm></UpdatePassForm>}></Route>
                    <Route path='updateform/:boardnum' element={<UpdateForm></UpdateForm>}></Route>
                </Route>

                <Route path='/post' element={<DaumPostApp/>}/>
                <Route path='/sweet' element={<SweetAlertApp/>}/>
                <Route path='/reducercomp1' element={<ReducerComp1></ReducerComp1>}></Route>
                <Route path='/reducercomp2' element={<ReducerComp2></ReducerComp2>}></Route>
                
                <Route path='/memo' element={<MemoTest></MemoTest>}></Route>
                <Route path='/callback' element={<CallBackTest></CallBackTest>}></Route>

                <Route path='/login' element={<LoginForm/>}/>
                <Route path='/member'>
                    <Route path='list' element={<MemberList/>}/>
                    <Route path='form' element={<MemberForm/>}/>
                </Route>

            </Routes>
        </div>
    );
};

export default RouterMain;
