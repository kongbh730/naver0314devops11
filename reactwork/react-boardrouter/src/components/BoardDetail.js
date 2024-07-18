import { Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, TextField } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const BoardDetail = () => {
    const { boardnum } = useParams();
    const [selectData, setSelectData] = useState({});
    const storage = process.env.REACT_APP_STORAGE;
    const navi = useNavigate();

    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const [pass, setPass] = useState('');

    const getData = () => {
        let url = "/boot/board/detail?boardnum=" + boardnum;
        axios.get(url)
            .then(res => {
                setSelectData(res.data);
            })
    };

    //댓글 불러오기
    const

    useEffect(() => {
        getData();
    },[]);

    return (
        <div style={{ width: '500px', marginLeft: '30px' }}>
            {
                selectData &&
                <table className='table'>
                    <caption align='top'><h3><b>게시글 상세보기</b></h3></caption>
                    <tbody>
                        <tr>
                            <td>
                                <h3><b>{selectData.subject}</b></h3>
                                <b>{selectData.writer}</b>
                                <span style={{ float: 'right', color: 'gray', fontSize: '14px' }}>
                                    조회&nbsp;{selectData.readcount}
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    {selectData.writeday}
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                {
                                    selectData.photo !== 'no' ?
                                        <div>
                                            <h3><b>대표 사진</b></h3>
                                            <img alt='' src={`${storage}/${selectData.photo}`}
                                                style={{ width: '200px' }} />
                                            <hr />
                                        </div> : ""

                                }
                                {/* dangerouslySetInnerHTML은 DOM에서 innerHTML을 사용하기 위한 리액트의 대체 방법이다.
                        innerHTML을 사용하면 DOM의 변경을 인식하지 못한다. 
                        대신 dangerouslySetInnerHTML를 사용하게 되면 가상 DOM과 실제 DOM을 비교해 변경된 곳을 리렌더링 해준다. */}
                                <pre dangerouslySetInnerHTML={{ __html: selectData.content }}></pre>

                            </td>
                        </tr>
                        <tr>
                            <td align='right'>
                                <Button variant='outlined' color='success'
                                    size="small" style={{ width: '80px' }}
                                    onClick={() => navi("/board/list")}>목록</Button>
                                &nbsp;
                                <Button variant='outlined' color='success'
                                    size="small" style={{ width: '80px' }}
                                    onClick={() => navi("/board/form")}>글쓰기</Button>
                                &nbsp;
                                <Button variant='outlined' color='success'
                                    size="small" style={{ width: '80px' }}
                                    onClick={() => navi(`/board/updatepass/${boardnum}`)}>
                                    수정
                                </Button>

                                &nbsp;
                                <Button variant='outlined' color='success'
                                    size="small" style={{ width: '80px' }}
                                    onClick={handleClickOpen}>삭제</Button>

                                {/* 삭제 비번 입력 다이얼로그 */}
                                <Dialog
                                    open={open}
                                    onClose={handleClose}
                                    PaperProps={{
                                        component: 'form',
                                        onSubmit: (event) => {
                                            event.preventDefault();
                                            //alert(pass);
                                            let url = `/boot/board/deletecheckpass?boardnum=${boardnum}&pass=${pass}`;
                                            axios.get(url)
                                                .then(res => {
                                                    // alert(res.data.result);
                                                    if (res.data.result === 'success') {
                                                        window.alert("삭제되었습니다.");
                                                        navi("/board/list");
                                                    }
                                                    else {
                                                        window.alert("비밀번호가 맞지 않습니다");
                                                    }
                                                });
                                            handleClose();
                                        },
                                    }}
                                >
                                    <DialogTitle>삭제확인</DialogTitle>
                                    <DialogContent>
                                        <DialogContentText>
                                            비밀번호를 입력해주세요
                                        </DialogContentText>
                                        <TextField
                                            autoFocus
                                            required
                                            margin="dense"
                                            id="standard-password-input"
                                            label="Password"
                                            type="password"
                                            autoComplete="current-password"
                                            variant="standard"
                                            onChange={(e) => setPass(e.target.value)}
                                        />
                                    </DialogContent>
                                    <DialogActions>
                                        <Button onClick={handleClose}>취소</Button>
                                        <Button type="submit">글삭제</Button>
                                    </DialogActions>
                                </Dialog>
                            </td>
                        </tr>
                    </tbody>
                    
                    {/* 댓글 */}
                    <tfoot>
                        {/* 댓글 목록 */}
                        {/* 닉네임 / 코멘트 / 날짜 / 삭제아이콘 / 수정아이콘 */}
                        <tr>

                        </tr>

                        {/* 댓글 입력 */}
                        <tr>

                        </tr>

                    </tfoot>
                </table>
            }
        </div>
    );
};

export default BoardDetail;