import { DeleteForeverOutlined } from '@mui/icons-material';
import { Button } from '@mui/material';
import React from 'react';

const SixChild2App = ({row, idx, onDelete}) => {
    return (
        <tr style={{backgroundColor : row.color}}>
            <td>
                {row.cname}
            </td>
            <td>
                <img alt="" src={require(`../mycar/${row.cphoto}`)} className='small'  />
            </td>
            <td align='right'>
                {row.cprice}만원
            </td>
            <td align='center'>
                <Button size='small' variant='outlined' color='error' onClick={()=>onDelete(idx)} 
                startIcon={<DeleteForeverOutlined/>}>DEL</Button>
            </td>
        </tr>
    );
};

export default SixChild2App;