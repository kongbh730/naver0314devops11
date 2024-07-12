import { Alert } from "@mui/material";
import React, { useRef } from "react";
import posting from "../data/PostingData.json";

const FourApp=()=>
{
    //json 데이터 가져오기
    const positingData=posting.deal; //배열 형태

    //이미지 ref
    const mainPhotoRef=useRef(null);

    return(
        <div>
            <Alert color='success'>FourApp-json데이터 활용</Alert>






        </div>
    );
};

export default FourApp; 