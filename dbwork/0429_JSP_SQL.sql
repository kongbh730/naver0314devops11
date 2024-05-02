create table myshop(
	shopidx smallint auto_increment primary key, 
    sname varchar(30),
    sprice int, 
    scount int,
    scolor varchar(20),
    sphoto varchar(100),
    writeday datetime
);

drop table myshop;

select * from myshop;

create table mysawon(
	num smallint auto_increment primary key,
    name varchar(20),
    buseo varchar(20),
    age smallint,
    addr varchar(100),
    photo varchar(100),
    gender varchar(10),
    birthday varchar(20)
);

select * from mysawon;
    
drop table mysawon;

create table mystudent(
	num smallint auto_increment primary key,
    java smallint,
    spring smallint,
    html smallint,
    name varchar(20),
    blood varchar(10),
    license char(1),
    writeday datetime
);
select * from mystudent;

drop table mystudent;

create table mymemo(
	num smallint auto_increment primary key,
    uploadphoto varchar(30),
    title varchar(100), 
    content varchar(1000),
    writeday datetime
);
select * from mymemo;

drop table mymemo;