import { DeleteForeverOutlined } from '@mui/icons-material';
import { Alert } from '@mui/material';
import React, { useState } from 'react';

const OneApp = () => {
    const[msg, setMsg] = useState(["Happy", "안녕", "Bitcamp"]); //배열 생성
    
    //메세지 입력 후 엔터시 이벤트
    const addMessageEvent=(e)=>{
        if(e.key==='Enter')
        {
            //setMsg(msg.push(e.target.value)); //에러 발생
            setMsg(msg.concat(e.target.value)); //배열에 데이터 추가시 반드시 concat으로 추가
            e.target.value=""; // value값 초기화
        }
    }

    //i번지 메세지 삭제 함수 != 이벤트 함수
    const deleteMessage=(i)=>{
        //alert(i);

        // //1. slice를 이용해서 i번지만 빼고 다시 배열에 담기
        // setMsg(
        //     [
        //         ...msg.slice(0, i), //0번부터 i-1번까지
        //         ...msg.slice(i+1, msg.length)//i+1번부터 끝까지
        //         // i번지만 빼고 다시 배열에 담기
        //     ]
        // )

        //2. filter를 이용해서 i번지만 제회하고 담기
        setMsg(msg.filter((m,n)=>n!== i));
    }
    
    return (
        <div>
            <Alert>OneApp-배열에 데이터 추가, 삭제하기</Alert>
            <hr></hr>

            <input type='text' className='form-control' style={{width:'300px'}} 
            placeholder='메세지 입력 후 엔터' onKeyUp={addMessageEvent}/>
            
            <hr></hr>
            <h3 style={{color:'red'}}>배열 데이터 출력</h3>
            <Alert severity='info'>총 {msg.length}개의 메세지가 있어요</Alert>
            {
                msg && // null 값인지 아닌지 판단(null값이면 실행 안됨)
                msg.map((m, i)=>
                <h4 key={i}>{m}
                    &nbsp;&nbsp;
                    {/* <span onClick={()=>deleteMessage(i)}>
                        <DeleteForeverOutlined style={{cursor:'pointer'}}/>
                    </span> */}
                    <DeleteForeverOutlined style={{cursor:'pointer'}} onClick={()=>deleteMessage(i)}/>
                </h4>
                )
            }

        </div>
    );
};

export default OneApp;