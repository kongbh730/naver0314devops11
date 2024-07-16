import { Alert } from '@mui/material';
import Axios from 'axios';
import React, { useEffect, useState } from 'react';

const MycarList = () => {
    const [list, setList]=useState([]);

    //======================================
    const CarList=()=>{
        Axios.get("/mycar/list")
        .then(res=>setList(res.data));
    }
    useEffect(()=>{
        CarList();
    },[]);

    //=======================================
    const dataList=()=>{
        Axios.get("/mycar/list")
        .then(res=>setList(res.data));
    }
    useEffect(()=>{
        dataList();
    },[]);

    return (
        <div>
            <Alert severity='info' >목록</Alert>
            <div>
                <table>
                    <thead>
                    <tr className=''>
                        <th style={{width:'150px'}}>자동차명</th>
                        <th style={{width:'200px'}}>가격</th>
                        <th style={{width:'200px'}}>색상</th>
                        <th style={{width:'200px'}}>구입일</th>
                        <th style={{width:'200px'}}>등록일</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        list.map((item, idx) =>
                            <tr>
                                <td>
                                    {item.carname}
                                </td>
                                <td>
                                    {item.carprice}만원
                                </td>
                                <td>
                                    <div style={{backgroundColor: item.carcolor, border:'1px solid black'}}>
                                        {item.carcolor}
                                    </div>
                                </td>
                                <td>
                                    {item.carguip}
                                </td>
                                <td>
                                    {item.writeday}
                                </td>
                            </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>

            {/* 강사님 풀이 */}
            <table>
                <thead>
                    <tr className='table table-bordered'>
                        <th style={{width:'120px'}}>자동차명</th>
                        <th style={{width:'120px'}}>가격</th>
                        <th style={{width:'120px'}}>색상</th>
                        <th style={{width:'120px'}}>구입일</th>
                    </tr>
                </thead>
                <tbody>
                {
                    list.map((item, idx)=>
                    <tr key={idx}>
                        <td>{item.carname}</td>
                        <td>{item.carprice}</td>
                        <td style={{backgroundColor:item.carcolor, clear:'both'}}>{item.carcolor}</td>
                        <td>{item.carguip}</td>
                    </tr>
                    )
                }    
                </tbody>
            </table>

        </div>
    );
};

export default MycarList;