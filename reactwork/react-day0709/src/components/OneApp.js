import { AccessAlarm, BookmarkAdd } from '@mui/icons-material';
import { Button } from '@mui/material';
import React from 'react';
import styled from 'styled-components';

const OneApp = () => {
    //styled-components태그가 지정된 템플릿 백틱을 활용하여 구성 요소의 스타일 지정.
    //h1 태그에 스타일 추가
    const Title = styled.h1`
        font-size:1.5em;
        text-align:center;
        color:orange;
        background-color:pink;
    `;

    //버튼에 스타일 적용
    const MyButton = styled.button`
        color:orange;
        width:200px;
        height:60px;
        border:1px solid red;
        border-radius:30px;
        margin-top:10px;
    `;

    //기존 스타일 확장
    const MyButton2=styled(MyButton)`
        color:blue;
        background-color:yellow;
        border:2px solid gray;
    `;

    //Title을 확장한 Title2를 직접 생성
    const Title2=styled(Title)`
        color:blue;
        background-color: red;
        line-height:200px;
        width:200px;
        height:200px;
        border: 5px dashed green;
    `

    return (
        <div>
            <h3 className='alert alert-danger'><AccessAlarm></AccessAlarm>
            <BookmarkAdd></BookmarkAdd>
            &nbsp;OneApp-styled-components</h3>
            
            <h1>Hello H1</h1>
            <Title>Hello Title</Title>
            <Title2>Hello Title2</Title2>
            <hr></hr>
            <Button variant='outlined' color='success'>Hello Button</Button>
            <Button variant='contained' color='success'>Hello Button</Button>
            <br></br>
            <MyButton>MyButton Style</MyButton>
            <MyButton2>MyButton2 Style</MyButton2>

        </div>
    );
};

export default OneApp;