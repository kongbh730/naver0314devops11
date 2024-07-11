import React, { useState } from 'react';
import TwoApp from './TwoApp';
import OneApp from './OneApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';

const MainApp = () => {
    // 인덱스 변수 생성 : 기본값은 1
    const [idx, setidx] = useState(1);//기본 선택값

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
                        ThreeApp-데이터 추가, 삭제, 출력(부모,자식 컴포넌트 사용)
                </label>
                <br></br>
                <label>
                    <input type='radio' name='app' defaultValue={4} onClick={changeApp}/>
                        FourApp-문제
                </label>

            </div>
            <hr></hr>
            {
                idx === 1 ? <OneApp></OneApp> : 
                idx === 2 ? <TwoApp></TwoApp> :
                idx === 3 ? <ThreeApp></ThreeApp> : <FourApp></FourApp>
            }
        </div>
    );
};

export default MainApp;