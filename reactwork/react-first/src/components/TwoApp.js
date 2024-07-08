import './MyStyle.css';

const TwoApp=()=>{
    let message="Have a Good Day!!!";

    return(
        <div>
            <h1 className="alert alert-info">TwoApp - function 형태</h1>
            {/* 
            3개의 div 에 class msg를 적용하시오
            첫번째 div는 배경색을 'orange,', border를 '10px solid gray' 
            두번째 div는 배경색을 pink, 글자색을 blue, box-shadow넣기
            세번째 div는 border를 '10px groove gold' border-radius값을 30px
            */}
            <div className='msg' style={{backgroundColor: 'orange', border: '10px solid gray'}}>{message}</div>
            <div className='msg' style={{backgroundColor: 'pink', color: 'blue', boxShadow: '5px 5px 5px black'}}>{message}</div>
            <div className='msg' style={{border: '10px groove gold', borderRadius: '30px'}}>{message}</div>
        </div>
    )
 }

 export default TwoApp;