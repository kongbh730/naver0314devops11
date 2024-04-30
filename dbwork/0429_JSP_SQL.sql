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