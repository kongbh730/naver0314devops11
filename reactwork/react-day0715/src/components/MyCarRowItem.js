import { DeleteForeverOutlined, EditNote } from '@mui/icons-material';
import { Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, Slide } from '@mui/material';
import React, { useEffect, useState } from 'react';

const Transition = React.forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />;
});//다이얼로그 슬라이드 이벤트

const MyCarRowItem = ({ idx, row, onDelete, onUpdate }) => {
    const photopath1 = "https://oaucs8mz3715.edge.naverncp.com/Fx9RP95Kaa/mycar";
    const photopath2 = "?type=f&w=40&h=40&faceopt=true&ttype=jpg";
    const storagepath = "https://kr.object.ncloudstorage.com/bitcamp-kbh-37/mycar";//원본사진 주소

    // const [carname, setCarname] = useState(row.carname);
    // const [carprice, setCarprice] = useState(row.carprice);
    // const [carcolor, setCarcolor] = useState(row.carcolor);

    const [carname, setCarname] = useState(row.carname);
    const [carprice, setCarprice] = useState(row.carprice);
    const [carcolor, setCarcolor] = useState(row.carcolor);

    useEffect(()=>{
        setCarcolor(row.carcolor);
        setCarname(row.carname);
        setCarprice(row.carprice);
    },[]);

    //다이얼로그 이벤트
    const [open, setOpen] = React.useState(false);
    const handleClickOpen = () => {
        setOpen(true);
    };
    const handleClose = () => {
        setOpen(false);
    };

    //수정다이얼로그 이벤트
    const [open2, setOpen2] = React.useState(false);
    const handleClickOpen2 = () => {
        setOpen2(true);
    };
    const handleClose2 = () => {
        setOpen2(false);
    };

    //삭제 이벤트
    const deleteMycar = (num) => {
        let a = window.confirm("해당 상품을 삭제할까요?");
        if (a) {
            onDelete(num);
        }
    }

    //수정 이벤트
    const updateMycarEvent=()=>{
        onUpdate({num:row.num, carname, carprice, carcolor});
        //row.num에서 오류가 발생하는 이유? : dto와 row.num의 값이 다르기 때문에 생략 불가
        //다 수정되면 다이얼로그 창닫기
        setOpen2(false);
    }

    return (
        <tr style={{ fontSize: '14px' }}>

            {/* ========================= 원본사진확인 다이얼로그 추가 ========================= */}
            <Dialog
                open={open}
                TransitionComponent={Transition}
                keepMounted
                onClose={handleClose}
                aria-describedby="alert-dialog-slide-description"
            >
                <DialogTitle>{row.carname}</DialogTitle>
                <DialogContent>
                    <DialogContentText id="alert-dialog-slide-description">
                        <img alt='' src={`${storagepath}/${row.carphoto}`} style={{ width: '400px' }} />
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Close</Button>
                </DialogActions>
            </Dialog>
            {/* ============================================================================ */}

            {/* ========================= 수정 다이얼로그 추가 ========================= */}
            <Dialog
                open={open2}
                TransitionComponent={Transition}
                keepMounted
                onClose={handleClose2}
                aria-describedby="alert-dialog-slide-description"
            >
                <DialogTitle><b>{row.carname}</b> 자동차 정보 수정</DialogTitle>
                <DialogContent>
                    <DialogContentText id="alert-dialog-slide-description">
                        <table className='table table-bordered' style={{ width: '300px' }}>
                            <tbody>
                                {/* 자동차명 */}
                                <tr>
                                    <td className='table-success' style={{ width: '100px' }}>
                                        자동차명
                                    </td>
                                    <td>
                                        <input type='text' className='form-control' style={{ width: '200px' }} value={carname} onChange={(e) => setCarname(e.target.value)}></input>
                                    </td>
                                </tr>

                                {/* 가격 */}
                                <tr>
                                    <td className='table-success' style={{ width: '100px' }}>
                                        가격
                                    </td>
                                    <td>
                                        <input type='number' className='form-control' style={{ width: '200px' }} value={carprice} onChange={(e) => setCarprice(e.target.value)}></input>
                                    </td>
                                </tr>

                                {/* 색상 */}
                                <tr>
                                    <td className='table-success' style={{ width: '100px' }}>
                                        색상
                                    </td>
                                    <td>
                                        <input type='color' className='form-control' style={{ width: '200px' }} value={carcolor} onChange={(e) => setCarcolor(e.target.value)}></input>
                                    </td>
                                </tr>

                                {/* 등록버튼 */}
                                <tr>
                                    <td colSpan={2} align='center'>
                                        <Button variant='contained' color='success' onClick={updateMycarEvent}>수정하기</Button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose2}>Close</Button>
                </DialogActions>
            </Dialog>

            {/* ======================================================================== */}

            <td>
                {/* 다이얼로그 클릭 이벤트 추가 */}
                <img alt='' src={`${photopath1}/${row.carphoto}${photopath2}`} style={{ cursor: 'pointer' }} border='1' onClick={handleClickOpen} />
                <span style={{ marginLeft: '5px' }}>
                    {row.carname}
                </span>
            </td>
            <td align='right'>
                {row.carprice}만원
            </td>
            <td>
                {/* {row.carcolor} */}
                <div style={{ width: '30px', height: '30px', backgroundColor: row.carcolor, border: '1px solid black' }}></div>

                <div style={{
                    border: '1px solid black',
                    backgroundColor: row.carcolor, // 기본 텍스트 색상 설정
                }}>
                    <span style={{
                        color: row.carcolor, // 기본 텍스트 색상 설정
                        filter: 'invert(100%)' // 필터 적용
                    }}>
                        {row.carcolor}
                    </span>
                </div>
            </td>
            <td>
                {row.carguip}
            </td>
            <td>
                <span style={{ color: 'gray', fontSize: '13px' }}>
                    {row.writeday}
                    &nbsp;
                    {/* row가 가진 num을 deleteMycar의 이벤트 함수로 보냄 */}
                    <DeleteForeverOutlined style={{ cursor: 'pointer' }} onClick={() => deleteMycar(row.num)} ></DeleteForeverOutlined>
                    &nbsp;
                    <EditNote style={{ cursor: 'pointer' }} onClick={handleClickOpen2}></EditNote>
                </span>
            </td>
        </tr>
    );
};

export default MyCarRowItem;