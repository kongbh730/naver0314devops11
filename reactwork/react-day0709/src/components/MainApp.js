import React, { useState } from "react";
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import SixApp from "./SixApp";
import SevenApp from "./SevenApp";
import EightApp from "./EightApp";

const MainApp =()=> {
    const [idx, setIdx]=useState(8);// 변수 선언 : idx라는 변수 초기값은 1!!!

    return(
        <div>
            <h3 className='alert alert-danger'>2024-07-09 리액트 수업</h3>
            <br></br>
            <select className="form-select" style={{width:'300px'}}
            onChange={(e)=>setIdx(Number(e.target.value))}>
                <option value={1}>OneApp-styled-components</option>
                <option value={2}>TwoApp-image-recall</option>
                <option value={3}>ThreeApp:show/hide</option>
                <option value={4}>FourApp-mui의 card</option>
                <option value={5}>FiveApp-useeffect</option>
                <option value={6}>SixApp-map 반복문</option>
                <option value={7}>SevenApp-Map반복문2</option>
                <option value={8} selected>EightApp-오늘의 문제-배열</option>
            </select>
            <br></br>
            {
                idx === 1 ? <OneApp></OneApp> :
                idx === 2 ? <TwoApp></TwoApp> :
                idx === 3 ? <ThreeApp></ThreeApp> :
                idx === 4 ? <FourApp></FourApp> :
                idx === 5 ? <FiveApp></FiveApp> :
                idx === 6 ? <SixApp></SixApp> :
                idx === 7 ? <SevenApp></SevenApp> : <EightApp></EightApp>
            }

            
        </div>
    );
};

export default MainApp;