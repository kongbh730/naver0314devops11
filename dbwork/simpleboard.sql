create table simpleboard
(
	num smallint auto_increment primary key,
    writer varchar(20),
    avata varchar(10),
    subject varchar(200),
    content varchar(3000),
    readcount smallint default 0,
    chu smallint default 0,
    writeday datetime
);

delete from simpleboard where num = 18;

select * from simpleboard;
drop table simpleboard;