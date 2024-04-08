create table student
(
	num smallint auto_increment primary key,
    name varchar(20),
    java smallint,
    html smallint,
    spring smallint,
    testday datetime
);

select * from student;
drop table student;

insert into student values (null, '이효리', 90, 80, 97, now());

select 
	num, name, java, html, spring, 
    java + html + spring tot, round((java + html + spring)/3,1) avg,
    date_format(testday, '%Y-%m-%d %H:%i') testday
from student;

