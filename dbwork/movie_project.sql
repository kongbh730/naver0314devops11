create table movie(
	num smallint auto_increment primary key,
    title varchar(30),
	poster varchar(50),
    announcementyoutube varchar(100),
    genre varchar(30),
    introduce varchar(400),
    director varchar(30),
    actors varchar(100)
    -- releaseday datetime --
);
select * from movie;
drop table movie;

create table user(
	num smallint auto_increment primary key,
    userID varchar(30),
	userpassword varchar(30),
    username varchar(30),
    useremail varchar(30),
    userPosition varchar(30)
);
select * from user;
drop table user;