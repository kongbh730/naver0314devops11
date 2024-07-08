//Main에 각종 컴포넌트를 배치해보자
//이번에는 함수형으로 만들어보자

import { OneApp } from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import SixApp from "./SixApp";
import { useState } from "react";

const Main=()=>{
    const [idx, setIdx] = useState(6);

    return (
        <div>
            {/* 
            <SixApp></SixApp>
            <hr></hr>
            <FiveApp></FiveApp>
            <hr></hr>
            <FourApp></FourApp>
            <hr></hr>
            <ThreeApp></ThreeApp>
            <hr></hr>
            <TwoApp></TwoApp>
            <hr></hr>
            <OneApp></OneApp>
            <hr></hr> 
            */}

            <h1>2024-07-08 리액트 첫 수업</h1>
            <select className="form-select" style={{width:'200px'}} onChange={(e)=>setIdx(Number(e.target.value))}>
                <option value={1}>1번 컴포넌트</option>
                <option value={2}>2번 컴포넌트</option>
                <option value={3}>3번 컴포넌트</option>
                <option value={4}>4번 컴포넌트</option>
                <option value={5}>5번 컴포넌트</option>
                <option value={6} selected>오늘의 문제</option>
            </select>
            <br></br><br></br>
            {
                idx === 1 ? <OneApp></OneApp> : 
                idx === 2 ? <TwoApp></TwoApp> :
                idx === 3 ? <ThreeApp></ThreeApp> :
                idx === 4 ? <FourApp></FourApp> :
                idx === 5 ? <FiveApp></FiveApp> : <SixApp></SixApp>
            }
        </div>
    )
}

export default Main;