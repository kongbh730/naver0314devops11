//첫 컴포넌트는 클래스 형태로 만들어 보자
//Hooks 문법이 추가된 이후는 class보다는 function 형태로 많이 만듦

import { Component } from "react";
import car1 from '../mycar11.png';
import car2 from '../mycar12.png';
import car3 from '../mycar13.png';
import './MyStyle.css';

class OneApp extends Component
{
    render(){
        return (
            <div>
                <h1 className="alert alert-danger">OneApp - class 형태</h1>
                <h5>public의 사진 가져오기</h5>
                {/* public의 사진은 매핑 주소에 따라 안나올 수 있음 - 권장 안함 */}
                <img src="./3.jpg" alt="사진1" width={200}></img>
                <img src="./12.jpg" alt="사진2"
                style={{width:'200px', border:'5px solid green', borderRadius: '50px 20px 100px 10px'}}></img>

                <h5>src 폴더의 사진 가져오기</h5>
                <img alt="자동차1" src={car1} className="photo line1"></img>
                <img alt="자동차2" src={car2} className="photo line2"></img>
                <img alt="자동차3" src={car3} className="photo line3"></img>
            </div>
        )
    }
}

//export default OneApp; //default는 한번만 사용가능, import 시에 마음대로 이름 지정 가능
export {OneApp} //이 경우에는 import 시에 정확한 이름으로 import 해야 한다.