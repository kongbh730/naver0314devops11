import React, { useState } from 'react';
import talent1 from '../9.jpg';
import talent2 from '../15.jpg';
import talent3 from '../17.jpg';
import talent4 from '../19.jpg';

const SixApp = () => {
    const [show, setShow]=useState(true);
    //const [imageSize, setImageSize]=useState(true);
    const [text, setText]=useState('텍스트 입력');
    const [imageWidth, setImageWidth]=useState(200);
    //const [imageHeight, setImageHeight]=useState(200);
    const [image, setImage]=useState(talent1);
    const [border, setBorder]=useState('solid');

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
                                    <input type={"checkbox"} onClick={(e)=>setShow(e.target.checked)}/> 사진 숨김
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
                                style={{border:'10px ${border} pink', width:'${imageWidth}px', marginLeft:'20px'}}></img>
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
        </div>
    )
};

export default SixApp;