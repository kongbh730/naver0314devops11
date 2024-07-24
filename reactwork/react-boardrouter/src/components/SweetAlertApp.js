import { Alert, Button } from '@mui/material';
import React, { useState } from 'react';
import Swal from 'sweetalert2';

import xmas1 from '../image/santa.gif';
import tree1 from '../image/tree1.gif';
import tree2 from '../image/tree2.gif';
import tree3 from '../image/tree3.gif';
import bell1 from '../image/bell1.gif';

const SweetAlertApp = () => {

    const [sangpum, setSangpum]=useState("애플워치");
    const buttonEvent1=()=>{
        Swal.fire('안녕하세요');
    }
    const buttonEvent2=()=>{
        Swal.fire({
            title:"Swal Test #2",
            //text:"줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>"
            html:"줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>",
            icon:"info"/*warning,success,info,error*/ ,
            confirmButtonColor:"#abcabc",
            confirmButtonText:"확인",
            showCancelButton:true,
            cancelButtonColor:'orange',
            cancelButtonText:"취소"
        }).then(result=>{
            if(result.isConfirmed){
                Swal.fire("처리했습니다");
            }else{
                Swal.fire("취소했습니다");
            }
        });
    }
    const buttonEvent3=()=>{
        Swal.fire({
            title:'사진넣기',
            html:`<h5>사진을 넣어보세요</h5> 
            <img alt='' src=${tree1}   />`,
            imageUrl:xmas1,
            //imageHeight:60,
            //imageWidth:50,
            icon:'success'
        });
    }
    const buttonEvent4=()=>{
        Swal.fire({
            title:"input Email Addreee",
            input:'email',
            inputLable:"your Email Address",
            inputPlaceholder:'Enter your Email address',
            showCancelButton:true,
            cancelButtonText:'cancel',
            cancelButtonColor:'red'
        });
    }
    const buttonEvent5=()=>{
        Swal.fire({
            title:"상품구매",
            imageUrl:'../house1.gif',/*public의 사진은 경로로 넣기 */
            text:`[${sangpum}] 상품을 구매하시겠습니까?`,
            showCancelButton:'true',
            cancelButtonText:'Cancel'
        }).then(result=>{
            if(result.isConfirmed)
            {
                Swal.fire(`[${sangpum}] 상품을 결재했습니다.`);
            }
        });
    }
    const buttonEvent6=()=>{
        let arr=[
            {photo:tree1, msg:'캔디1'},
            {photo:tree2, msg:'마이클2'},
            {photo:tree3, msg:'영자3'},
            {photo:bell1, msg:'철수4'}
        ]
        let s = "";
        for(let a of arr)
        {
            s += `<img alt="" src=${a.photo} width=30 /> &nbsp;&nbsp;<b>${a.msg}</b><br/>`;
        }

        Swal.fire({
            //icon:'success',
            title:'좋아요 누른 사람',
            imageUrl:xmas1,
            html:s
        });
    }

    return (
        <div>
            <Alert>SweetAlert 공부하기</Alert>

            <Button variant='contained' color='error' onClick={buttonEvent1}>SWEETALERT1</Button>
            <br></br><br></br>
            <Button variant='contained' color='error' onClick={buttonEvent2}>SWEETALERT2</Button>
            <br></br><br></br>
            <Button variant='contained' color='error' onClick={buttonEvent3}>SWEETALERT3</Button>
            <br></br><br></br>
            <Button variant='contained' color='error' onClick={buttonEvent4}>SWEETALERT4</Button>
            <br></br><br></br>
            <Button variant='contained' color='error' onClick={buttonEvent5}>SWEETALERT5</Button>
            <br></br><br></br>
            <Button variant='contained' color='error' onClick={buttonEvent6}>SWEETALERT6</Button>
            <br></br><br></br>
        </div>
    );
};

export default SweetAlertApp;