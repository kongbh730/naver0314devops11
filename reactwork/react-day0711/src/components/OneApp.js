import { Alert, Button } from '@mui/material';
import React, { useState } from 'react';
import OneSubApp from './OneSubApp';

const OneApp = () => {
    // const[inputArray, setInputArray]=useState([]);
    
    const[inputArray, setInputArray]=useState([
        {sname: '신상슈즈', sphoto: '15.jpg', sprice: 23000, scolor: 'orange'}
    ]);

    const [inputs, setInputs] = useState({
        sname: '', sphoto: '', sprice: 0, scolor: '#ffccff'
    });

    const changeDataEvent=(e)=>{
        let {name, value} = e.target;
        setInputs(
            {
                ...inputs,//나머지 값들은 유지
                [name] : value//같은 name을 찾아서 value값 넣기
            }
        )
    }

    const addSangpumEvent=()=>{
        setInputArray(inputArray.concat(inputs));
    }

    //입력값 초기화
    const initDataEvent=()=>{
        setInputs({
            sname: '', sphoto: '', sprice: 0, scolor: '#ffccff'
        })
    }

    return (
        <div>
            <Alert color='success'>OneApp-모든 입력값 하나의 변수에 넣기</Alert>
            <table className='table table-bordered' style={{width: '300px'}}>
                <tbody>
                    <tr>
                        <th style={{backgroundColor:'#ccf', width: '100px'}}>상품명</th>
                        <td>
                            <input type='text' className='form-control' value={inputs.sname} name="sname" onChange={changeDataEvent}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{backgroundColor:'#ccf', width: '100px'}}>색상</th>
                        <td>
                            <input type='color' className='form-control' value={inputs.scolor} name="scolor" onChange={changeDataEvent}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{backgroundColor:'#ccf', width: '100px'}}>상품가격</th>
                        <td>
                            <input type='text' className='form-control' value={inputs.sprice} name="sprice" onChange={changeDataEvent} />
                        </td>
                    </tr>
                    <tr>
                        <th style={{backgroundColor:'#ccf', width:'100px'}}>
                            사진
                        </th>   
                        <td>
                            <select className='form-select' name="sphoto" onChange={changeDataEvent}>
                                <option value={'14.jpg'}>플렛슈즈</option>
                                <option value={'23.jpg'}>여름용모자</option>
                                <option value={'30.jpg'}>보석머리띠</option>
                                <option value={'32.jpg'}>투피스</option>
                                <option value={'31.jpg'}>자켓</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <Button variant='contained' color='success' size="small" onClick={addSangpumEvent}>상품 추가</Button>
                            &nbsp;
                            <Button variant='contained' color='info' size="small" onClick={initDataEvent}>입력값 초기화</Button>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <h4>
                                상품명 : {inputs.sname}<br></br>
                                색  상 : {inputs.scolor}<br></br>
                                가  격 : {inputs.sprice}<br></br>
                                사  진 : {inputs.sphoto}
                            </h4>
                        </td>
                    </tr>
                </tbody>
            </table>
            <h4>총 {inputArray.length}개의 배열 데이터가 있습니다.</h4>

            <table className='table table-bordered' style={{width:'400px'}}>
                <tbody>
                    {
                        inputArray.map((item, idx) =>
                        <OneSubApp key={idx} idx={idx} item={item}></OneSubApp>)
                    }
                </tbody>

            </table>
        </div>
    );
};

export default OneApp;