import { Alert, Button } from '@mui/material';
import React, { useState } from 'react';

const TwoApp = () => {

    const [names, setNames] = useState(["한가인", "캔디", "테리우스"]);

    // 입력 추가 함수
    const addNameEvent=(e)=>{
        setNames(names.concat(e.target.value)); //배열에 데이터 추가시 반드시 concat으로 추가
        e.target.value=""; // value값 초기화
    }

    //삭제 버튼
    const deleteName=(index)=>{

        //2. filter를 이용해서 i번지만 제회하고 담기
        setNames(names.filter((name, currentIndex) => currentIndex !== index));
    }

    //=======================================================================

    const [irum, setIrum]=useState('');

    const addNameEvent2=()=>{
        if(irum.length === 0)
        {
            alert("추가할 이름을 입력해주세요");
            return;
        }

        //입력한 이름을 배열변수에 추가
        setNames(names.concat(irum));
        setIrum('');
    }

    const deleteName2=(deleteidx)=>{
        //2. filter를 이용해서 i번지만 제회하고 담기
        let conf = window.confirm(`${deleteidx + 1}번째 이름을 삭제하시겠습니까?`);

        // if(!conf)
        // {
        //     return;
        // }
        // setNames(names.filter((name, currentidx) => currentidx !== deleteidx));
        if(conf)
        {
            setNames(names.filter((name, currentidx) => currentidx !== deleteidx));
        }
    }

    //=======================================================================

    return (
        <div>
            <Alert>TwoApp - 배열 추가, 삭제 복습 문제</Alert>

            {/* 입력란 */}
            <div>
                이름입력
                <input type='text' className='form-control' name='addName' placeholder='이름 입력' style={{width:'200px'}}></input>
                <button className='btn btn-sm btn-outline-danger' onClick={()=>addNameEvent()}>추가</button>
            </div>

            {/* 출력위치 */}
            <hr></hr>
            <div>
            {
                names && // null 값인지 아닌지 판단(null값이면 실행 안됨)
                names.map((name, index)=>
                <h4 key={index}>
                    <span>
                        {name}
                    </span>
                    &nbsp;&nbsp;
                    <button className='btn btn-sm btn-success' onClick={()=>deleteName(index)}>삭제</button>
                </h4>
                )
            }
            </div>

            <hr></hr>
            {/* //======================================================================= */}

            <div className='input-group' style={{width:'300px'}}>
                <h5>이름 : </h5>
                <input type='text' className='form-control' style={{width:'130px'}} value={irum} onChange={(e)=>setIrum(e.target.value)}/>
                <Button variant='contained' color='success' onClick={addNameEvent2}>추가</Button>
            </div>
            <hr></hr>
            {
                names.map((myname, idx)=>
                    <div className='input-group'>
                        <h4 style={{width:'200px'}}>{myname}</h4>
                        <Button variant='outlined' color='info' onClick={()=>deleteName2(idx)}>삭제</Button>
                    </div>
                )
            }

        </div>
    );
};

export default TwoApp;