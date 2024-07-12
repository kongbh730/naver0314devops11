import { Alert } from '@mui/material';
import React, { useRef } from 'react';
import cate from '../data/CateData.json';
import './MyStyle.css';
import errorImg from '../image/noimage2.png';

const ThreeApp = () => {
    //json 데이터 가져오기
    const navData=cate.navData; //배열 형태
    const categoryData=cate.categoryData; //배열 형태

    //이미지 ref
    const mainPhotoRef=useRef(null);

    return (
        <div>
            <Alert color='success'>ThreeApp-json 데이터 출력</Alert>
            <div className='nav_container'>
                <ul className='nav_category'>
                {
                    navData.map((item, idx)=> 
                        <li key={idx}>
                            <div>
                                <img alt='' src={item.img} className='imgcategory' 
                                onClick={(e)=>mainPhotoRef.current.src = e.target.src}/>
                            </div>
                            <div>
                                {item.title}
                            </div>
                        </li>)
                }
                </ul>
            </div>

            <div className='nav_container'>
                <ul className='nav_category'>
                {
                    categoryData.map((item, idx)=> 
                        <li key={idx}>
                            <div>
                                <img alt='' src={item.img} className='imgcategory' 
                                onMouseOver={(e)=> mainPhotoRef.current.src = e.target.src}
                                />
                            </div>
                            <div>
                                {item.title}
                            </div>
                        </li>)
                }
                </ul>
            </div>
            {/* 아이콘 클릭시 작은 이미지를 가져와서 출력할 메인 이미지 - ref를 이용 */}
            <div>
                <img alt='' src={errorImg} 
                style={{width:'300px', height:'300px', border:'5px inset gray', margin:'10px 200px'}}  
                onError={(e)=>e.target.src=errorImg}
                ref={mainPhotoRef}
                />
            </div>




        </div>
    );
};

export default ThreeApp;