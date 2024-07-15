import { Alert } from "@mui/material";
import React from "react";

const EightApp=()=>{

    const personArray=[
        {pname:"전지현", photo:"8.jpg", addr:"제주도 애월읍", age: 45},
        {pname:"이재권", photo:"9.jpg", addr:"서울시 강남구", age: 29},
        {pname:"차민규", photo:"10.jpg", addr:"전라남도 진도군", age: 29},
        {pname:"채지원", photo:"11.jpg", addr:"서울시 낙성대", age: 29},
        {pname:"홍창경", photo:"12.jpg", addr:"경기도 광주시", age: 2000000000}
    ]
    return (
        <div>
            <Alert>EightApp-table을 이용해서 출력</Alert>

            <table className="table table-bordered">
                <tbody>
                    <tr className="alert alert-danger">
                        <td width={'100px'}>사진</td>
                        <td>정보</td>
                    </tr>
                {
                    personArray.map((item, idx)=>
                    <tr>
                        <td>
                            <img alt="" src={require(`../image/${item.photo}`)} className="smallphoto"></img>
                        </td>
                        <td>
                            <h6>번호 : {idx + 1} </h6>
                            <h6>이름 : {item.pname} </h6>
                            <h6>주소 : {item.addr} </h6>
                            <h6>나이 : {item.age}세 </h6>
                        </td>
                    </tr>
                    )
                }
                </tbody>
            </table>

            <hr></hr>

            <table className="table table-bordered" style={{width:'400px'}}>
                <thead>
                    <tr className="table-danger">
                        <td style={{width:'50px'}}>번호</td>
                        <td style={{width:'60px'}}>사진</td>
                        <td style={{width:'70px'}}>이름</td>
                        <td style={{width:'130px'}}>주소</td>
                        <td style={{width:'40px'}}>나이</td>
                    </tr>
                </thead>
                <tbody>
                {
                    personArray.map((item, idx)=>
                    <tr>
                        <td>{idx+1}</td>
                        <td>
                            <img alt="" src={require(`../image/${item.photo}`)} className="smallphoto"></img>
                        </td>
                        <td>{item.pname}</td>
                        <td>{item.addr}</td>
                        <td>{item.age}</td>
                    </tr>
                    )
                }
                </tbody>
            </table>


        </div>
    );
};

export default EightApp;
