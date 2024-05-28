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
select * from reboard;

insert into reboard (writer, myid, subject, uploadphoto, content, regroup, restep, relevel, writeday) 
	values ('HHH', 'hhh', '안녕', 'no', '반가워요',1, 0, 0, now());
        
insert into reboard (writer, myid, subject, uploadphoto, content, regroup, restep, relevel, writeday) 
	values ('CCC', 'CCC', 'CCC', 'no', 'CCC반가워요',2, 0, 0, now());
    
insert into reboard (writer, myid, subject, uploadphoto, content, regroup, restep, relevel, writeday) 
	values ('DDD', 'DDD', '안녕', 'no', 'DDD입니다.',1, 1, 1, now());
    
insert into reboard (writer, myid, subject, uploadphoto, content, regroup, restep, relevel, writeday) 
	values ('EEE', 'EEE', '안녕하세요', 'no', 'EEE입니다', 1, 2, 2, now());
    
    
create table boardanswer (
	aidx smallint auto_increment primary key,
    num smallint,
    writer varchar(20),
    myid varchar(20),
    content varchar(1000),
    writeday datetime,
    foreign key(num) references reboard(num) on delete cascade
);

select * from boardanswer;
drop table boardanswer;