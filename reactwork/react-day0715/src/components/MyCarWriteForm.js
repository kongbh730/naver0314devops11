import { Alert, Button } from '@mui/material';
import axios from 'axios'; // 중괄호가 들어가면 안됨// Axios로 임포트 하면 자동완성으로 중괄호가 생성됨
import React, { useState } from 'react';

const MyCarWriteForm = ({onSave}) => {
    const [carname, setCarname]=useState('');
    const [carprice, setCarprice]=useState('');
    const [carcolor, setCarcolor]=useState('#ccffaa');
    const [carguip, setCarguip]=useState('');
    const [carphoto, setCarphoto]=useState('');

    // const photopath1 = "https://oaucs8mz3715.edge.naverncp.com/Fx9RP95Kaa/mycar";
    // const photopath2 = "?type=f&w=40&h=40&faceopt=true&ttype=jpg";

    const photopath = "https://kr.object.ncloudstorage.com/bitcamp-kbh-37/mycar";//스토리지 주소
    
    //파일 업로드 이벤트
    const photoUploadEvent=(e)=>{
        const uploadFilename=e.target.files[0];
        const uploadForm = new FormData();
        uploadForm.append("upload", uploadFilename);

        //이미지가 아니라 데이터만 보낼 때는 axios.post()
        axios({
            method:'post', //이미지를 보낼 때는 안에서 post
            url:'/mycar/upload',
            data:uploadForm,
            headers:{'Content-Type':'multipart/form-data'}
        }).then(res=>{
            setCarphoto(res.data.carphoto);
        })
    }

    //등록버튼 이벤트....
    const addDataEvent=()=>{
        //부모컴포넌트의 onSave에 데이터 보내기
        onSave({carname, carphoto, carprice, carguip, carcolor});

        setCarcolor("#ccffaa");
        setCarguip('');
        setCarname('');
        setCarphoto('');
        setCarprice('');
    }

    return (
        <div>
            <Alert color='error' style={{width:'500px'}}>자동차 등록하기</Alert>
            <table className='table table-bordered' style={{width:'500px'}}>
                <tbody>
                    {/* 자동차명 */}
                    <tr>
                        <td className='table-success' style={{width:'100px'}}>
                            자동차명
                        </td>
                        <td>
                            <input type='text' className='form-control' style={{width:'200px'}} value={carname} onChange={(e)=>setCarname(e.target.value)}></input>
                        </td>
                        {/* 업로드된 사진 보기 */}
                        <td style={{width:'200px'}} rowSpan={5} valign='middle'>
                            <img alt='' src={`${photopath}/${carphoto}`} style={{maxWidth:'200px'}}/>
                        </td>
                    </tr>

                    {/* 사진 */}
                    <tr>
                        <td className='table-success' style={{width:'100px'}}>
                            사진
                        </td>
                        <td>
                            <input type='file' className='form-control' style={{width:'200px'}} onChange={photoUploadEvent}></input>
                        </td>
                    </tr>

                    {/* 가격 */}
                    <tr>
                        <td className='table-success' style={{width:'100px'}}>
                            가격
                        </td>
                        <td>
                            <input type='number' className='form-control' style={{width:'200px'}} value={carprice} onChange={(e)=>setCarprice(e.target.value)}></input>
                        </td>
                    </tr>

                    {/* 색상 */}
                    <tr>
                        <td className='table-success' style={{width:'100px'}}>
                            색상
                        </td>
                        <td>
                            <input type='color' className='form-control' style={{width:'200px'}} value={carcolor} onChange={(e)=>setCarcolor(e.target.value)}></input>
                        </td>
                    </tr>

                    {/* 구입일 */}
                    <tr>
                        <td className='table-success' style={{width:'100px'}}>
                            구입일
                        </td>
                        <td>
                            <input type='date' className='form-control' style={{width:'200px'}} value={carguip} onChange={(e)=>setCarguip(e.target.value)}></input>
                        </td>
                    </tr>

                    {/* 등록버튼 */}
                    <tr>
                        <td colSpan={3} align='center'>
                            <Button variant='contained' color='success' onClick={addDataEvent}>등록</Button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default MyCarWriteForm;