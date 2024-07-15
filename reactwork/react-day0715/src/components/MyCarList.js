import React, { useEffect, useState } from 'react';
import Axios from 'axios';
import { Alert, Button } from '@mui/material';
import MyCarRowItem from './MyCarRowItem';
import MyCarWriteForm from './MyCarWriteForm';

const MyCarList = () => {
    const [list, setList]=useState([]);
    const [show, setShow]=useState(true);

    const MyCarList=()=>{
        Axios.get("/mycar/list")
        .then(res=>setList(res.data));
    }

    //처음 시작시 목록 가져오기
    //처음 한번만 호출
    useEffect(()=>{
        MyCarList();
    },[]);

    //자동차 등록 이벤트 : 왜? -> 하위컴포넌트에서 호출해서 부모의 list를 다시 호출해야 하니까!
    const addMycarEvent=(data)=>{
        console.log(data);
        Axios.post("/mycar/insert", data)
        .then(res=>{
            //목록 다시 출력
            MyCarList();
        });
    }

    //자동차 삭제 이벤트 
    const deleteMycarEvent=(num)=>{
        console.log(num);
        
        Axios.delete("/mycar/delete?num="+num)
        .then(res=>{
            //삭제 성공 후 목록 다시 출력
            MyCarList();
        })
    }

    //수정이벤트
    const updateMycar=(data)=>{
        Axios.post("/mycar/update", data)
        .then(res=>{
            //수정 성공 후 목록 다시 출력
            MyCarList();
        })
    }

    return (
        <div>
            <Button variant='contained' color='info' onClick={()=>setShow(!show)}>자동차 등록 show/hide</Button>
            {
                show && 
                <MyCarWriteForm onSave={addMycarEvent}></MyCarWriteForm>//onSave라는 이름으로 addMycarEvent 보냄
            }

            <Alert severity='success' style={{fontSize:'15px', width:'500px'}}>
                <b>총 {list.length}개의 자동차 정보가 있습니다.</b>
            </Alert>
            <table className='table table-bordered' style={{width:'500px'}}>
                <thead>
                    <tr className='table-danger'>
                        <th style={{width:'150px'}}>자동차명</th>
                        <th style={{width:'100px'}}>가격</th>
                        <th style={{width:'60px'}}>색상</th>
                        <th style={{width:'120px'}}>구입일</th>
                        <th style={{width:'120px'}}>등록일</th>
                    </tr>
                </thead>
                <tbody>
                {
                    list.map((row, idx) => 
                        <MyCarRowItem key={idx} idx={idx} row={row} onDelete={deleteMycarEvent} onUpdate={updateMycar}></MyCarRowItem> //onDelete라는 이름으로 삭제 이벤트 보냄 
                    )
                }    
                </tbody>
            </table>
        </div>
    );
};

export default MyCarList;

/*
import React from 'react';
const MyCarList=()=>{
    return (
        <div></div>
    );
};
export default MyCarList;
*/