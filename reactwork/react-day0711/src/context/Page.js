import React from 'react';
import './context.css';
import Header from './Header';
import Content from './Content';
import Footer from './Footer';


const Page = () => {
    return (
        <div className='page'>
            <Header></Header>
            <Content></Content>
            <Footer></Footer>
        </div>
    );
};

export default Page;