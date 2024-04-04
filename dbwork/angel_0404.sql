-- 자바연동 연습용 시퀀스 및 테이블 생성
create sequence seq_test nocache;

create table person(
    pnum number(3) constraint pk_pnum primary key,
    pname varchar2(20),
    pblood varchar2(5) default 'B',
    page number(3),
    ipsaday date
);

-- 5개 정도 데이터 추가
insert into person values(seq_test.nextval, '이상순','a',34,'2010-12-20');
insert into person values(seq_test.nextval, '강호동','O',21,'2008-03-20');
insert into person values(seq_test.nextval, '유재석','A',29,sysdate);
insert into person values(seq_test.nextval, '손미나','a',34,'2019-09-13');
insert into person values(seq_test.nextval, '손지영','a',34,sysdate);
select * from person;
commit;

select * from person;
select pnum, pname, upper(pblood) pblood, page, to_char(ipsaday, 'yyyy-mm-dd') ipsaday from person; 
-- 함수를 사용한 경우 컬럼명이 함수명으로 바뀌므로, 컬럼명을 지정해야함


drop sequence seq_test;