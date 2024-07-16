import { Alert } from '@mui/material';
import Axios from 'axios';
import React, { useEffect, useState } from 'react';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import ImageListItemBar from '@mui/material/ImageListItemBar';

const MycarPhoto = () => {
    const storagepath = "https://kr.object.ncloudstorage.com/bitcamp-kbh-37/mycar";//원본사진 주소
    const [list, setList] = useState([]);

    //=======================================
    const CarList = () => {
        Axios.get("/mycar/list")
            .then(res => setList(res.data));
    }
    useEffect(() => {
        CarList();
    }, []);

    //=======================================
    const dataList = () => {
        Axios.get("/mycar/list")
            .then(res => setList(res.data));
    }
    useEffect(() => {
        dataList();
    }, []);

    return (
        <div>
            <Alert severity='info'>사진</Alert>

            <div>
                <table>
                    <thead>
                        <tr>
                            <th>자동차명</th>
                            <th>사진</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            list.map((item, idx) =>
                                <tr>
                                    <td>
                                        {item.carname}
                                    </td>
                                    <td>
                                        <img alt='' src={`${storagepath}/${item.carphoto}`} style={{ width: '200px' }} />
                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>

            <div>
            <ImageList sx={{ width: 450, height: 700 }}>
            {
                list.map((item, idx) => (
                    <ImageListItem key={idx}>
                        <img
                            srcSet={`${storagepath}/${item.carphoto}?w=248&fit=crop&auto=format&dpr=2 2x`}
                            src={`${storagepath}/${item.carphoto}?w=248&fit=crop&auto=format`}
                            alt={item.carname}
                            loading="lazy"
                        />
                        <ImageListItemBar
                            title={item.carname}
                            subtitle={<span>Price: {item.carprice}만원</span>}
                            position="below"
                        />
                    </ImageListItem>
                ))
            }
            </ImageList>
            </div>
           

        </div>
    );
};

export default MycarPhoto;