import { DeleteForeverOutlined } from '@mui/icons-material';
import React from 'react';

const MyCarRowItem = ({ idx, row, onDelete }) => {
    const photopath1 = "https://oaucs8mz3715.edge.naverncp.com/Fx9RP95Kaa/mycar";
    const photopath2 = "?type=f&w=40&h=40&faceopt=true&ttype=jpg";

    const deleteMycar=(num)=>{
        let a = window.confirm("해당 상품을 삭제할까요?");
        if(a)
        {
            onDelete(num);
        }
    }
    return (
        <tr style={{ fontSize: '14px' }}>
            <td>
                <img alt='' src={`${photopath1}/${row.carphoto}${photopath2}`} border='1' />
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
                    <DeleteForeverOutlined style={{ cursor: 'pointer' }} onClick={()=>deleteMycar(row.num)} ></DeleteForeverOutlined>
                </span>
            </td>
        </tr>
    );
};

export default MyCarRowItem;