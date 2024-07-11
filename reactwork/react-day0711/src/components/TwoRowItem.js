import { Button } from '@mui/material';
import React from 'react';

const TwoRowItem = (props) => {
    let {idx, row, onDelete} = props;

    return (
        <tr>
            <td>{idx + 1}</td>
            <td>{row.irum}</td>
            <td>{row.age}</td>
            <td>{row.blood}</td>
            <td>{row.today.toLocaleDateString('ko-Kr')}</td>
            <td><Button variant='outlined' size='small' color='error' onClick={()=>onDelete(idx)}>삭제</Button></td>
            {/* <td>{row.today.toLocaleString('ko-Kr')}</td> */}
            {/* 시간까지 */}
        </tr>
    );
};

export default TwoRowItem;