import { Alert } from '@mui/material';
import React, { useState } from 'react';
import SixChild1App from './SixChild1App';
import SixChild2App from './SixChild2App';

const SixApp = () => {
    const [count, setCount]=useState(0);
    const [array, setArray]=useState([
        {cname : "아우디", cphoto:"mycar15.png", cprice:'2300', color:"#afeeee"},
        {cname : "벤츠", cphoto:"mycar14.png", cprice:'4300', color:"#eeafee"},
        {cname : "포르쉐", cphoto:"mycar13.png", cprice:'5400', color:"#eeeeaf"},
        {cname : "현대", cphoto:"mycar12.png", cprice:'2600', color:"#aefeee"}
    ]);

    //삭제하는 함수
    const deleteCar=(idx)=>{
        //alert(idx);
        setArray(array.filter((car, currentidx) => currentidx !== idx));
    };

    //count 변경 이벤트
    const countIncre=()=>setCount(count + 1);

    return (
        <div>
            <Alert>SixApp - 부모 자식 components 간의 통신 #2</Alert>
            <Alert severity='error' style={{fontSize:'20px'}}>회원 방문 횟수 : {count} 회</Alert>
            <SixChild1App carname="아반떼" carphoto="mycar8.png" bgcolor="#ffc0cb" carprice="3500" onIncre={countIncre}></SixChild1App>
            <SixChild1App carname="그랜저" carphoto="mycar5.png" bgcolor="#7fffd4" carprice="4700" onIncre={countIncre}></SixChild1App>

            <hr style={{clear:'both'}}></hr>

            <table className='tbstyle'>
                <thead>
                    <tr style={{backgroundColor: '#f5f5dc'}}>
                        <th style={{width: '140px'}}>
                            자동차명
                        </th>
                        <th style={{width: '100px'}}>
                            사진
                        </th>
                        <th style={{width: '100px'}}>
                            가격
                        </th>
                        <th style={{width: '100px'}}>
                            삭제
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        array.map((item, idx)=><SixChild2App row={item} key={idx} idx={idx} onDelete={deleteCar}></SixChild2App>)
                    }
                </tbody>
            </table>
        </div>
    );
};

export default SixApp;