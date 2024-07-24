import { Alert, Button } from '@mui/material';
import React, { useReducer, useState } from 'react';

/*
useReducer : state관리가 용이하며 유지, 보수가 편리함
호출 : dispatch(type, action)로 호출시 -> reducer(state, action)함수가 호출됨
reducer : state를 업데이트 하는 역할
dispatch-state 업데이트를 요구
action : 요구의 내용
*/

const ACTION_TYPES={
    add:'addmoney',
    sub:'submoney'
}

//간단한 입출금 예제
const reducer=(state, action)=>
{
    console.log("reducer(은행)가 일을 합니다.", state, action);

    switch(action.type){
        //case ACTION_TYPES.add:
        case 'addmoney':
            return state+Number(action.payload);
        case ACTION_TYPES.sub:
            return state-Number(action.payload);
        default:
            return state;
    }
}

const ReducerComp1 = () => {
    const[number, setNumber]=useState(0);
    const[money, dispatch]=useReducer(reducer, 0);   

    return (
        <div>
            <Alert>ReducerComp #1</Alert>
            <h3>useReducer 은행</h3>
            <h3>잔고 : <b>{money}</b></h3>
            <hr></hr>
            <input type='number' value={number}
                step={1000} onChange={(e)=>setNumber(e.target.value)}
                className='form-control' style={{width:'200px'}}/>
            <Button variant='contained' size="small" color="success"

            onClick={()=>dispatch({'type':ACTION_TYPES.add,payload:number})}
            
            >
                입금
            </Button>

            &nbsp;&nbsp;

            <Button variant='contained' size="small" color="error"

            onClick={()=>dispatch({'type':ACTION_TYPES.sub,payload:number})}
            
            >
                출금
            </Button>
        </div>
    );
};

export default ReducerComp1;