import { Alert, Button } from '@mui/material';
import React, { useReducer, useState } from 'react';
import Student from './Student';


const initialState={
    count:2,
    students:[
        {
            id:new Date(),
            name:'이영자',
            isHere:false
        },
        {
            id:new Date(),
            name:'캔디',
            isHere:true
        }
    ]
}

const reducer=(state, action)=>{
    switch(action.type){
        case 'add-student':
            //payload를 통해서 name을 전달받을 예정
            const name=action.payload.name;
            
            //추가할 학생정보 구성
            const addStudent={
                id: new Date(),
                name,//key, value가 같을 경우 한번만
                isHere:false
            }

            const data={
                count:state.count + 1,
                students:[
                    ...state.students,
                    addStudent
                ]
            }
            return data;

        case 'delete-student':
            return {
                count:state.count-1,
                students:state.students.filter(s=> s.id !== action.payload.id)
            };
        
        case 'mark-student':
            return {
                count:state.count,
                students: state.students.map(s=>{
                    if(s.id === action.payload.id)
                    {
                        return {
                            ...s,
                            isHere: !s.isHere
                        }
                    }
                    return s;
                })
            }

        default:
            return state;
    }
}
const ReducerComp2 = () => {

    const [name, setName]=useState('');
    const [studentInfo, dispatch] = useReducer(reducer, initialState);

    return (
        <div>
            <Alert>ReducerComp #2</Alert>  
            <h4>총 학생수 : {studentInfo.count}명</h4>
            <div className='input-group' style={{width:'230px'}}>
                <input type='text' className='form-control' value={name} 
                
                    onChange={(e)=>setName(e.target.value)}
                
                ></input>
                <Button variant='outlined' color="error"

                onClick={()=>{
                    dispatch({'type':'add-student', payload:{name}});
                    setName('');
                }

                }>
                    추가
                </Button>
            </div>

            <div className='input-group' style={{width:'300px', marginTop:'20px'}}>
                <h5>학생 목록 출력</h5>
                {
                    studentInfo.students.map((stu,idx)=>
                    <Student key={idx} stu={stu} dispatch={dispatch}></Student>
                    )
                }

            </div>

        </div>
    );
};

export default ReducerComp2;