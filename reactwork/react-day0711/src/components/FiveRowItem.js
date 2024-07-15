import React from 'react';

const FiveRowItem = ({mycar}) => {
const storage1="https://kr.object.ncloudstorage.com/bitcamp-kbh-37/mycar/";
   //180x180 썸네일
   const storage2="https://q9h1r9bh3709.edge.naverncp.com/s2TlqaXAZo/mycar/";
   const ext="?type=f&w=180&h=180&faceopt=true&ttype=jpg";

    return (
        <>
            <tr>
                <td style={{width:'200px'}} align='center' rowSpan={5}>
                    <img alt='' style={{width:'180px',height:'180px'}}
                      src={`${storage1}${mycar.carphoto}`}/>
                    {/* 180x180 썸네일 사진 경로 */}
                    {/* <img alt='' src={`${storage2}${mycar.carphoto}${ext}`}/> */}
                </td>
                <td>자동차명 : {mycar.carname}</td>
            </tr>
            <tr>
                <td>가 격 : {mycar.carprice}만원</td>
            </tr>
            <tr>
                <td style={{backgroundColor:mycar.carcolor}}>
                    색 상 : {mycar.carcolor}
                </td>
            </tr>
            <tr>
                <td>
                     구입일 : {mycar.carguip}
                </td>
            </tr>
            <tr>
                <td style={{fontSize:'13px'}}>
                    등록일 : {mycar.writeday}                    
                </td>
            </tr>
        </>
    );
};

export default FiveRowItem;