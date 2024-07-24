import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { NavLink } from 'react-router-dom';
import noimage from '../image/noimage2.png';

const BoardList = () => {

    const [boardList, setBoardList] = useState([]);
    const getDataList = () => {
        axios.get("/boot/board/list")
            .then(res => {
                setBoardList(res.data);
            });
    }

    const storage = process.env.REACT_APP_STORAGE;

    //처음 딱 한번만 목록 가져오기
    useEffect(() => {
        getDataList();
    }, []);

    return (
        <div style={{ width: '600px' }}>
            {
                sessionStorage.token == null ?
                    <div>
                        <h1>게시판 목록을 보려면 로그인을 해주세요</h1>
                    </div>
                    :
                    <div>
                        <Alert>
                            <b>총 {boardList.length}개의 게시글이 있습니다.</b>
                        </Alert>
                        <table className='table table-striped'>
                            <thead>
                                <tr className='table-danger'>
                                    <th style={{ width: '50px' }}>번호</th>
                                    <th style={{ width: '350px' }}>제목</th>
                                    <th style={{ width: '70px' }}>작성자</th>
                                    <th style={{ width: '100px' }}>작성일</th>
                                    <th style={{ width: '50px' }}>조회</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    //DB에서 리스트 가져와서 출력할 때 데이터가 아직 불러들어오지 않아 null인경우 잠깐 기다렸다 출력할 수 있게 추가
                                    boardList &&
                                    boardList.map((row, idx) =>
                                        <tr key={idx}>
                                            <td align='center'>
                                                {boardList.length - idx}
                                            </td>
                                            <td>
                                                <NavLink to={`/board/detail/${row.boardnum}`}
                                                    style={{ textDecoration: 'none', color: 'black' }}>
                                                    {/* 사진이 없을 경우 기본 이미지로 출력하기 추가!!!!! */}
                                                    {/* <img alt='' src={`${storage}/${row.photo}`} style={{width:'40px', height:'40px'}} /> */}
                                                    <img alt=''
                                                        src={row.photo !== 'no' ? `${storage}/${row.photo}` : noimage}
                                                        style={{ width: '40px', height: '40px' }} />
                                                    &nbsp;{row.subject}
                                                    &nbsp;
                                                    {
                                                        row.answercount > 0 ?
                                                            <span style={{ color: 'red' }}>
                                                                [{row.answercount}]
                                                            </span> : ""
                                                    }

                                                </NavLink>
                                            </td>
                                            <td align='center'>
                                                {row.writer}
                                            </td>
                                            <td align='center'>
                                                {/* 기본은 시,분까지 출력 */}
                                                {/* {row.writeday} */}
                                                <span style={{ fontSize: '14px' }}>
                                                    {row.writeday.substring(0, 10)}
                                                    {/* 년월일까지만 출력 */}
                                                </span>
                                            </td>
                                            <td align='center'>
                                                {row.readcount}
                                            </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                    </div>
            }
        </div>
    );
};

export default BoardList;