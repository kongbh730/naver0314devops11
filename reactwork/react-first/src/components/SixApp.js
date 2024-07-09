import React, { useState } from 'react';
import talent1 from '../9.jpg';
import talent2 from '../15.jpg';
import talent3 from '../17.jpg';
import talent4 from '../19.jpg';

const SixApp = () => {
    const [show, setShow]=useState(false);
    //const [imageSize, setImageSize]=useState(true);
    const [text, setText]=useState('텍스트 입력');
    const [imageWidth, setImageWidth]=useState(200);
    //const [imageHeight, setImageHeight]=useState(200);
    const [image, setImage]=useState(talent1);
    const [border, setBorder]=useState('solid');

    //const [show,setShow]=useState(false);
    const [width,setWidth]=useState(200);
    const [msg,setMsg]=useState('리액트 문제 다풀면 복습 100% 보장');
    const [photo,setPhoto]=useState(talent1);
    //const [border,setBorder]=useState('inset');

    return (
        <div>
            <h1 className='alert alert-success'>2024-07-08 문제</h1>
            <hr></hr>
            <table className='table table-bordered' style={{width: "500px"}}>
                <tbody>
                    <tr>
                        <td>
                            <div>
                                <label>
                                    <input type="checkbox" onClick={(e)=>setShow(e.target.checked)}/> 사진 숨김
                                </label>
                            </div>
                        </td>
                        <td>
                            {/* 점점작게 / 점점크게 버튼 */}
                            <button type="button" className='btn btn-outline-danger' onClick={(e)=>setImageWidth(imageWidth - 10)}>점점 작게</button>
                            &nbsp;
                            <button type="button" className='btn btn-outline-danger' onClick={(e)=>setImageWidth(imageWidth + 10)}>점점 크게</button>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2}>
                            {/* 텍스트 입력 */}
                            <div>
                                <input type="text" className='form-control' onChange={(e)=>setText(e.target.value)} placeholder='입력'></input>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {/* 이미지 셀렉트 박스 */}
                            <select className='form-select' onChange={(e)=>setImage(e.target.value)}>
                                <option value={talent1}>1</option>
                                <option value={talent2}>2</option>
                                <option value={talent3}>3</option>
                                <option value={talent4}>4</option>
                            </select>
                        </td>

                        <td rowSpan={4}>
                            {/* 이미지 출력 */}
                            <div>
                            {
                                !show &&
                                <img alt='사진' src={image} 
                                style={{border:`10px ${border} pink`, width:`${imageWidth}px`, marginLeft:'20px'}}></img>
                            }
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>
                            {/* 선 모양 셀렉트 박스 */}
                            <select className='form-select' onChange={(e)=>setBorder(e.target.value)}>
                                <option>dashed</option>
                                <option selected>solid</option>
                                <option>groove</option>
                                <option>dotted</option>
                                <option>inset</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td colSpan={2}>
                            {/* 입력된 텍스트 출력 */}
                            <div className='alert alert-info'>
                                {text}
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>



            <b style={{fontFamily:'Single Day',fontSize:'3em',color:'deeppink'}}>
                    오늘의 문제</b>
            <hr/>
            <div className='input-group'>
                <label><input type={'checkbox'} 
                onClick={(e)=>setShow(e.target.checked)}/> 사진 숨김</label>

                <button type='button' className='btn btn-outline-danger'
                style={{marginLeft:'60px'}} onClick={(e)=>setWidth(width-10)}>점점작게</button>
                <button type='button' className='btn btn-outline-danger'
                style={{marginLeft:'10px'}} onClick={(e)=>setWidth(width+10)}>점점크게</button>                
            </div>
            <br/>
            <input type={'text'} className='form-control' style={{width:'400px'}}
                placeholder='메세지를 입력하세요'
                defaultValue={msg}
                onChange={(e)=>setMsg(e.target.value)}/>
            <br/><br/>
            <div style={{float:'left'}}>             

                <select className='form-select' style={{width:'200px'}}
                    onChange={(e)=>setPhoto(e.target.value)}>
                    <option value={talent1}>박보영</option>
                    <option value={talent2}>신민아</option>
                    <option value={talent3}>신세경</option>
                    <option value={talent4}>수지</option>                    
                </select>
                <br/><br/>
                <select className='form-select' style={{width:'200px'}}
                    onChange={
                        (e)=>{
                            setBorder(e.target.value);
                        }
                    }>
                    <option>solid</option>
                    <option selected>inset</option>
                    <option>double</option>
                    <option>groove</option> 
                    <option>dotted</option> 
                    <option>dashed</option>                    
                </select>
            </div>
            {
                !show &&                
                <img alt="" src={photo}
                style={{border:`10px ${border} pink`,width:`${width}px`,marginLeft:'20px'}}/>
            }

             <h1 style={{clear:'both',width:'500px',marginTop:'10px'}}
             className='alert alert-info'>{msg}</h1>     
            


        </div>
    )
};

export default SixApp;