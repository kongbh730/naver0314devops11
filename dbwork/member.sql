create table memberdb (
	num smallint auto_increment primary key,
    name varchar(20),
    myid varchar(20),
    passwd varchar(20),
    addr varchar(200),
    hp varchar(20),
    email varchar(30),
    photo varchar(20),
    birthday varchar(20),
    gaipday datetime
);

select * from memberdb;
drop table memberdb;

select count(*) from memberdb where myid = '';
alter table memberdb modify photo varchar(100);
desc memberdb;
select count(*) from memberdb where num = 3 and passwd='1234';
delete from memberdb where myid = 'aaa';

create table reboard (
	num smallint auto_increment primary key,
    writer varchar(20),
    myid varchar(20),
    subject varchar(300),
    uploadphoto varchar(100),
    content varchar(2000),
    readcount smallint default 0,
    regroup smallint,
    restep smallint,
    relevel smallint,
    writeday datetime
);

drop table reboard;