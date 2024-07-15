import { Alert, Button } from '@mui/material';
import React, { useRef, useState } from 'react';

const FourApp = () => {
    const [result, setResult] = useState('');
    const nameRef = useRef('');
    const korRef = useRef(0);
    const engRef = useRef(0);

    //버튼 이벤트
    const resultButtonEvent=()=>{
        //입력값 읽기
        let name = nameRef.current.value;
        let kor = korRef.current.value;
        let eng = engRef.current.value;

        //총점 //평균
        let tot = Number(kor) + Number(eng);
        let avg = tot/2;

        let s = `이름 : ${name}
            국어점수 : ${kor}점
            영어점수 : ${eng}점
            총점 : ${tot}점
            평균 : ${avg}점`;

        setResult(s);
        //입력값 초기화
        nameRef.current.value = '';
        korRef.current.value = '';
        engRef.current.value = '';

        //이름으로 포커스
        nameRef.current.focus();
    }

    return (
        <div>
            <Alert>FourApp-useRef 응용예제</Alert>
            <table className='table table-bordered' style={{width:'300px'}}>
                <tbody>
                    <tr>
                        <th style={{width:'100px'}} className='table-info'>이름</th>
                        <td>
                            <input type='text' className='form-control' ref={nameRef}></input>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width:'100px'}} className='table-info'>국어점수</th>
                        <td>
                            <input type='text' className='form-control' ref={korRef}></input>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width:'100px'}} className='table-info'>영어점수</th>
                        <td>
                            <input type='text' className='form-control' ref={engRef}></input>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <Button variant='contained' color='error' onClick={resultButtonEvent}>
                                결과 출력하기
                            </Button>
                        </td>
                    </tr>
                    <tr style={{height:'100px'}}>
                        <td colSpan={2} style={{ fontSize:'16px', whiteSpace:'pre-line', backgroundColor:'#ffc'}}>
                            {result}
                        </td>
                    </tr>

                </tbody>
            </table>
            
        </div>
    );
};

export default FourApp;