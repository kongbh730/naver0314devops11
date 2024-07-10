import React, { useState } from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';

const MainApp = () => {
    // 인덱스 변수 생성 : 기본값은 ?
    const [idx, setidx] = useState(6);//기본 선택값

    // 인덱스 값 변경 이벤트
    const changeApp=(e)=>{
        setidx(Number(e.target.value));
    }

    return (
        <div>
            <h2>2024-07-10 리액트 수업</h2>
            <div style={{fontSize:'16px'}}>
                <label>
                    {/* 라디오 버튼은 name을 같게 줘야 하나의 라디오 버튼으로 작동한다. */}
                    <input type='radio' name='app' defaultValue={1} onClick={changeApp}/>
                        OneApp-배열 추가, 삭제
                </label>
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={2} onClick={changeApp}/>
                        TwoApp-배열 추가, 삭제 문제
                </label>
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={3} onClick={changeApp}/>
                        ThreeApp-useRef 공부
                </label>
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={4} onClick={changeApp}/>
                        FourApp-useRef 응용예제
                </label>
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={5} onClick={changeApp}/>
                        FiveApp - 부모 자식 components 간의 통신 #1
                </label>
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={6} onClick={changeApp}/>
                        SixApp - 부모 자식 components 간의 통신 #2
                </label>


            </div>
            <hr></hr>
            {
                idx === 1 ? <OneApp></OneApp> : 
                idx === 2 ? <TwoApp></TwoApp> :
                idx === 3 ? <ThreeApp></ThreeApp> :
                idx === 4 ? <FourApp></FourApp> :
                idx === 5 ? <FiveApp></FiveApp> : <SixApp></SixApp>
            }



        </div>
    );
};

export default MainApp;