import { Button } from '@mui/material';
import React, { useEffect, useState } from 'react';
import food1 from '../food/1.jpg';
import photo1 from '../image/12.jpg';

const FiveApp = () => {
    const[number, setNumber]=useState(1);
    const[count, setCount]=useState(100);
    const[show, setShow]=useState(false);
    const[show2, setShow2]=useState(false);

    //처음 + 값 변경시 마다 호출
    // useEffect(()=>{
    //     console.log("1.처음 또는 값 변경시 항상 호출");
    // });

    //처음 한번만 호출
    useEffect(()=>{
        console.log("2. 처음 한번만 호출");
    },[]);

    //number변경때만 호출
    useEffect(()=>{
        console.log("3. number가 변경 될 때만 호출");
        if(number % 3 === 0)
        {
            setShow(true);
        }
        else
        {
            setShow(false);
        }
    },[number]);

    //count변경때만 호출
    useEffect(()=>{
        console.log("4. count가 변경 될 때만 호출");
        if(count % 10 === 0)
        {
            setShow2(true);
        }
        else
        {
            setShow2(false);
        }
    },[count]);

    return (
        <div>
            <h3 className='alert alert-danger'>FiveApp</h3>

            <b style={{fontSize:'30px', color:'red'}}>Number : {number}</b>
            &nbsp;&nbsp;&nbsp;
            <Button variant='contained' color="success" onClick={()=>setNumber(number - 1)}>Number 감소</Button>&nbsp;
            <Button variant='contained' color="success" onClick={()=>setNumber(number + 1)}>Number 증가</Button>&nbsp;
            <hr/>

            <b style={{fontSize:'30px', color:'red'}}>Count : {count}</b>
            &nbsp;&nbsp;&nbsp;
            <Button variant='contained' color="primary" onClick={()=>setCount(count - 1)}>Count 감소</Button>&nbsp;
            <Button variant='contained' color="primary" onClick={()=>setCount(count + 1)}>Count 증가</Button>&nbsp;
            <hr/>

            <Button variant='contained' color="secondary" 
            onClick={()=>{
                setNumber(number - 1);
                setCount(count - 1);
            }}>모두 감소</Button>&nbsp;
            <Button variant='contained' color="secondary"
            onClick={()=>{
                setNumber(number + 1);
                setCount(count + 1);
            }}>모두 증가</Button>&nbsp;
            <hr/>

            <b>number가 3의 배수일때만 보이는 이미지</b>
            {
                show &&
                <img alt="이미지" src={food1} style={{width:'150px'}} />
            }
            <br></br>
            <b>count가 10의 배수일때만 보이는 이미지</b>
            {
                show2 &&
                <img alt="이미지" src={photo1} style={{width:'150px'}} />
            }
        </div>
    );
};

export default FiveApp;