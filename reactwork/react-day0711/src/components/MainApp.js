import React, { useState } from 'react';
import TwoApp from './TwoApp';
import OneApp from './OneApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import RootApp from '../context/Root';

const MainApp = () => {
    // 인덱스 변수 생성 : 기본값은 1
    const [idx, setidx] = useState(5);//기본 선택값

    // 인덱스 값 변경 이벤트
    const changeApp=(e)=>{
        setidx(Number(e.target.value));
    }

    return (
        <div>
            <h2>2024-07-11~12 리액트 수업</h2>
            <div style={{fontSize:'16px'}}>
                <label>
                    {/* 라디오 버튼은 name을 같게 줘야 하나의 라디오 버튼으로 작동한다. */}
                    <input type='radio' name='app' defaultValue={1} onClick={changeApp}/>
                        OneApp-모든 입력값 하나의 변수에 넣기
                </label>
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={2} onClick={changeApp}/>
                        TwoApp-객체 배열 출력-tr의 rowSpan
                </label>
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={3} onClick={changeApp}/>
                        ThreeApp-json 데이터 출력
                </label>
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={4} onClick={changeApp}/>
                        FourApp-json
                </label>
                {/* ================================================ */}
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={5} onClick={changeApp}/>
                        Root-useContext 공부
                </label>

            </div>
            <hr></hr>
            {
                idx === 1 ? <OneApp></OneApp> : 
                idx === 2 ? <TwoApp></TwoApp> :
                idx === 3 ? <ThreeApp></ThreeApp> :
                idx === 4 ? <FourApp></FourApp> : <RootApp></RootApp>
            }
        </div>
    );
};

export default MainApp;