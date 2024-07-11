import { Alert } from '@mui/material';
import React, { useState } from 'react';
import TwoWriteForm from './TwoWriteForm';
import TwoRowItem from './TwoRowItem';

const TwoApp = () => {
    const [dataArray, setDataArray]=useState([
        {irum:'이영자', blood:'AB', age:34, today:new Date()},
        {irum:'강호동', blood:'B', age:23, today:new Date()},
        {irum:'유재석', blood:'A', age:45, today:new Date()}
    ]);

    const deleteData=(idx)=>{
        setDataArray(dataArray.filter((d,i)=> i !== idx));
    }

    return (
        <div>
            <Alert color='success'>TwoApp-데이터 추가, 삭제, 출력(부모, 자식 컴포넌트)</Alert>

            <TwoWriteForm></TwoWriteForm>
            <hr></hr>
            <table className='table table-striped' style={{width:'400px'}}>
                <thead>
                    <tr className='table-danger'>
                        <th style={{width: '50px'}}>번호</th>
                        <th style={{width: '60px'}}>이름</th>
                        <th style={{width: '50px'}}>나이</th>
                        <th style={{width: '60px'}}>혈액형</th>
                        <th style={{width: '120px'}}>등록일</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                {
                    dataArray.map((row, idx)=> <TwoRowItem key={idx} idx={idx} row={row} onDelete={deleteData}></TwoRowItem>)
                }
                </tbody>
            </table>

        </div>
    );
};

export default TwoApp;