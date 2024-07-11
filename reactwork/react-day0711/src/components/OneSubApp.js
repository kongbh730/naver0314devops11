import { CloseSharp } from '@mui/icons-material';
import React from 'react';

const OneSubApp = ({idx, item, deleteSangpum}) => {
    return (
        <>
            <tr>
                <td style={{width:'200px', backgroundColor:'#ccf'}} rowSpan={4} align='center'>
                    <img alt="" src={require(`../shop/${item.sphoto}`)}
                    style={{width:'120px', height:'130px', border:'1px solid gray'}} />
                    <br></br>
                    <CloseSharp style={{cursor:'pointer'}} onClick={()=>deleteSangpum(idx)}/>
                </td>
                <td>
                    상품번호 : {idx + 1}번
                </td>
            </tr>
            <tr>
                <td>상품명 : {item.sname}</td>
            </tr>
            <tr>
                <td>상품가격 : {item.sprice}</td>
            </tr>
            <tr>
                <td>상품색상 : <b style={{backgroundColor:item.scolor}}>{item.scolor}</b></td>
            </tr>
        </>
    );
};

export default OneSubApp;