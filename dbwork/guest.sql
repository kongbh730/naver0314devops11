create table guest (
	num smallint auto_increment primary key,
    nickname varchar(20),
    avata varchar(50),
    content varchar(1000),
    writeday datetime
);
select * from guest;
drop table guest;