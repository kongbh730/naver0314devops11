import { CameraAltRounded } from '@mui/icons-material';
import { Alert, Button } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';
//import InputEmojiWithRef from 'react-input-emoji';
import { useNavigate } from 'react-router-dom';

import { Editor, Viewer } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';

const BoardForm = () => {
    const [writer, setWriter] = useState('');
    const [pass, setPass] = useState('');
    const [subject, setSubject] = useState('');
    const [photo, setPhoto] = useState('no');

    const navi = useNavigate();

    const fileRef = useRef(null);
    const contentRef = useRef('');

    //.env의 변수를 불러오는 방법
    const storage = process.env.REACT_APP_STORAGE;
    console.log(storage);

    //파일업로드 이벤트
    const uploadPhoto = (e) => {
        const uploadFile = e.target.files[0];
        const uploadForm = new FormData();
        uploadForm.append("upload", uploadFile);

        axios({
            method: 'post',
            url: '/boot/board/upload',
            data: uploadForm,
            headers: { 'Content-Type': 'multipart/form-data' },
        }).then(res => {
            //스토리지에 저장된 파일명 photo에 넣기
            setPhoto(res.data);
        })
    }

    useEffect(() => {
        contentRef.current?.getInstance().setHTML('');
    }, []);

    //저장 버튼 이벤트
    let content = ''
    const dataSaveEvent = () => {
        //const content = contentRef.current.value;
        content = contentRef.current?.getInstance().getHTML();
        if (writer === '') {
            alert("작성자를 입력해주세요.");
            return;
        }

        if (pass === '') {
            alert("비밀번호를 입력해주세요.");
            return;
        }

        if (subject === '') {
            alert("제목을 입력해주세요.");
            return;
        }

        if (content === '') {
            alert("내용을 입력해주세요");
            return;
        }

        axios.post("/boot/board/insert", { writer, pass, photo, subject, content }).then(res => {
            //추가 성공 후 값 초기화 후 목록으로 이동
            setPhoto('no');
            setWriter('');
            setSubject('');
            setPass('');
            contentRef.current.value = '';

            //목록으로 이동
            navi("/board/list");
        })
    }

    return (
        <div>
            <Alert>게시판 글쓰기</Alert>
            <table className='table table-bordered' style={{ width: '400px' }}>
                <tbody>
                    {/* 작성자 writer */}
                    <tr>
                        <th className='table-info' style={{ width: '100px' }}>
                            작성자
                        </th>
                        <td>
                            <input type='text' className='form-control'
                                value={writer} onChange={(e) => setWriter(e.target.value)}></input>
                        </td>
                    </tr>

                    {/* 비밀번호 pass */}
                    <tr>
                        <th className='table-info' style={{ width: '100px' }}>
                            비밀번호
                        </th>
                        <td>
                            <input type='password' className='form-control'
                                value={pass} onChange={(e) => setPass(e.target.value)}></input>
                        </td>
                    </tr>

                    {/* 제목 subject */}
                    <tr>
                        {/* <td colSpan={2}>
                            <InputEmojiWithRef 
                            placeholder='제목을 입력 후 엔터를 눌러주세요'
                            cleanOnEnter//엔터 후 입력란 정리

                            onEnter={(text)=>{
                                console.log(text);
                                setSubject(text);
                            }}></InputEmojiWithRef> 
                        </td> */}
                        <td colSpan={2}>
                            <input type='text' className='form-control'
                                value={subject} onChange={(e) => setSubject(e.target.value)}></input>
                        </td>
                    </tr>

                    {/* 이미지 */}
                    <tr>
                        <td colSpan={2}>
                            <input type='file' style={{ display: 'none' }}
                                ref={fileRef} onChange={uploadPhoto} />
                            <CameraAltRounded onClick={() => fileRef.current.click()}
                                style={{ cursor: 'pointer', fontSize: '30px' }}></CameraAltRounded>

                            {/* 스토리지에 저장된 이미지를 보여준다. */}
                            <img alt='' src={`${storage}/${photo}`} style={{ width: '60px', marginLeft: '30px' }} />
                            <br></br>
                            {/* <textarea style={{width:'100%', height:'150px'}} 
                            placeholder='내용을 입력해주세요.' ref={contentRef} ></textarea> */}

                            {/* --------------------------------- toast editor --------------------------------- */}

                            <Editor
                                placeholder="내용을 입력해주세요."
                                previewStyle="vertical" // 미리보기 스타일 지정
                                height="500px" // 에디터 창 높이
                                initialEditType="wysiwyg" // 초기 입력모드 설정(디폴트 markdown)      
                                toolbarItems={[
                                    // 툴바 옵션 설정
                                    ['heading', 'bold', 'italic', 'strike'],
                                    ['hr', 'quote'],
                                    ['ul', 'ol', 'task', 'indent', 'outdent'],
                                    //['table', 'image', 'link'],
                                    ['image'],
                                    ['code', 'codeblock']
                                ]}

                                hooks={{
                                    addImageBlobHook: async (blob, callback) => {
                                        console.log(blob);
                                        const formData = new FormData()
                                        formData.append('upload', blob)

                                        let url = "/boot/board/upload" //백엔드에서 스토리지에 사진 저장하기

                                        axios.post(url, formData, {
                                            header: { "content-type": "multipart/formdata" }
                                        }).then(res => {
                                            callback(storage + "/" + res.data)//스토리지 파일명을 img태그에 넣어준
                                        })

                                        //callback(blob.name);//사진명만 일단 확인-사진 안나옴
                                    }
                                }}
                                ref={contentRef}
                            ></Editor>
                            <Viewer initialValue={content} />

                            {/* --------------------------------- toast editor --------------------------------- */}

                        </td>
                    </tr>

                    <tr>
                        <td colSpan={2} align='center'>
                            <Button variant='contained' color='success' style={{ width: '100px' }}
                                onClick={dataSaveEvent}>
                                DB저장
                            </Button>
                        </td>
                    </tr>

                </tbody>
            </table>
        </div>
    );
};

export default BoardForm;