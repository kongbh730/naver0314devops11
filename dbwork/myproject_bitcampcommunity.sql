create table BitcampUser(
	num smallint auto_increment primary key,
    id varchar(30),
    password varchar(20),
	name varchar(30),
    email varchar(30)
);
select * from BitcampUser;
drop table BitcampUser;

create table communitytext(
	title varchar(100),
    writer varchar(30)
);