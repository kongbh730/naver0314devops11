--시퀀스 생성
--기본 1부터 1씩 증가하는 시퀀스는 생략하고 기본 명령어만 주면 됨
create sequence seq1;

--전체 시퀀스 조회
select * from seq;

--다음 시퀀스 값 발생 : nextval
select seq1.nextval from dual;

--10부터 5씩 증가하는 시퀀스를 생성해보자, 캐쉬가 기본 20인데 없애보자
create sequence seq2 start with 10 increment by 5 nocache;

--seq2값을 발생시켜본다.
select seq2.nextval from dual;

--1부터 3씩 증가, 캐쉬0, 맥스 100
create sequence seq3 start with 1 increment by 3 nocache maxvalue 100;

--seq3 값 발생
select seq3.nextval from dual;

--시퀀스도 제거
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

--최종 테이블에서 사용할 시퀀스 생성(1부터 1씩 증가(생략), cache 0)
create sequence seq_test nocache;

--연습용 테이블
create table hello(
    idx number(3) primary key,
    irum varchar2(20),
    age number(3)
);

--테이블 구조 수정 : alter table
--irum의 길이를 20에서 30으로 수정해보자
alter table hello modify irum varchar2(30);

--addr이라는 컬럼 추가 : 속성, 열...(문자열 길이는 100)
alter table hello add addr varchar2(100);

--age라는 컬럼을 제거해보자
alter table hello drop column age;

--컬럼명 변경 addr -> address
alter table hello rename column addr to address;

--컬럼 두개 추가해보자
alter table hello add blood varchar2(3);
alter table hello add age number(3);

--데이터를 추가해보자
insert into hello (irum) values ('lee'); --에러발생, idx는 pk이므로 반드시 값을 넣어야 한다.

insert into hello (idx,irum) values (seq_test.nextval, 'lee');
insert into hello (idx,blood,address) values (seq_test.nextval, 'ab', '서울 역삼');
--컬럼명 생략시 테이블의 컬럼 순서대로 모든 값을 줘야 한다.
insert into hello values (seq_test.nextval, '이진', '제주도 애월읍', 'O', 23);

--수정
--이름이 '이진'인 사람의 혈액형을 b형으로 변경해보자
update hello set blood='b' where irum='이진';
--idx가 2인 사람의 irum과 age를 수정해보자
update hello set irum='강호동',age=35 where idx=2;
--idx가 1인 사람의 addres, blood, age의 값을 수정하세요
update hello set address='서울 강남',blood='A',age=35 where idx=1;

--삭제
--idx가 1인 사람 삭제
delete from hello where idx=1;
--age가 30 이상인 데이터 모두 삭제
delete from hello where age >= 30;

select * from hello;

--테이블을 제거
drop table hello;

-----------------------------------------------------
--새로운 테이블 생성, 이번에는 각종 제약조건을 추가해서 생성해보자
create table student (
    num number(3) constraint pk_num primary key,
    stuname varchar2(20) constraint nn_name not null,
    score number(3) constraint ck_score check(score >= 1 and score <= 100),
    birthday date
);

--insert로 데이터 추가를 하는데 각종 에러를 발생시켜본다,
insert into student (num, stuname) values(1, '김미리'); -- 오류발생

--ORA-01400 NULL을 ("ANGEL", "STUDENT" "NUM")안에 삽입 불가
insert into student (num, socre) values('이미자', 45); -- 오류발생

--num은 pk(기본키)
insert into sudent(num, stuname) values(1, '홍진주'); -- 오류

--ORA-02290: 체크 제약조건이 위배되었습니다.
--score의 범위는 1~100이어야 한다.
insert into student(num, stuname, score) values (2, '강동호', 110); --오류

--오류없는 정상데이터로 추가
insert into student values(3, '이미자', 89, sysdate);--날짜는 현재날짜로
insert into student values(4, '김민종', 100, '2010-12-20');

--commit을 일단 하면 rollback이 안됨
commit;

insert into student values(5, '곤미나', 56, '2019-05-10');--날짜는 현재날짜로
insert into student values(6, '강수지', 98, sysdate);
insert into student values(7, '김진우', 67, '2015-09-12');
insert into student values(8, '강호동', 66, '2019-05-03');

commit;--커밋이후부터는 롤백이 안됨
--트랜잭션 : 커밋, 롤백
rollback;--developer는 오토 커밋이 안됨, mysql은 오토커밋 지원

--num이 5번인 데이터의 이름을 '손미라', score를 80으로 수정
update student set stuname='손미라',score=80 where num=5;

--birthday의 월이 5인 사람의 점수를 일괄적으로 85로 수정
update student set score=85 where to_char(birthday,'mm') = 5;
commit;

--num이 7인 데이터 삭제
delete from student where num=7;
--롤백수 데이터 확인
rollback;
--다시 삭제문 실행
delete from student where num=7;
--커밋
commit;
--다시 롤백 후 데이터 확인
rollback;--이미 커밋된 데이터는 취소되지 않는다.

--불필요한 제약조건 제거
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;

alter table student add constraint uq_name unique(stuname);

insert into student (num,stuname) values(10, '강호동');

--연습이 끝난 후 시퀀스랑 테이블 삭제
drop sequence seq_test;
drop table student;

------------------------------------------------------------
/*
join 연습용 테이블 2개 생성하기
테이블 #1 : food - foodnum 숫자(3)
            foodname 문자열(20)
            foodsptce 숫자(7)
            foodsize 문제 (20)
            
        booking - bnum pk 숫자(3)
                bname 문자열(20) nn
                bhp 문자열(20)uq
                foodnum 숫자(3)- fj(food의 foodnum)
                bookingday date
    
    외부키로 연결된 경우 booking 에 데이터가 추가된 이후 추가된 foodnum은 삭제할 수 없다.
    예르 들어 게시판의 댓글 같은 경우 외부키로 연결되어 있는데 이때도 댓글리 달린 경우 
    해당글을 삭제할 수 없는 게이판들이 있다.
    그런데 만약 food의 데이터를 삭제하면 그 메뉴를 추가한 고객의 데이터도 자동으로 삭제시키고자 할 경우 
    booking에 외부키를 설정할 때 on delete cascade를 주면 된다.
*/

create table food(
    foodnum number(3) constraint pk_foodnum primary key,
    foodname varchar2(20),
    foodprice number(7),
    foodsize varchar2(20)
);

--메뉴를 등록해보자
insert into food values (100, '짜장면', 9000, '보통');
insert into food values (101, '짜장면', 11000, '곱배기');
insert into food values (200, '탕수육', 15000, '보통');
insert into food values (201, '탕수육', 20000, '곱배기');
insert into food values (300, '칠리새우', 15000, '소');
insert into food values (301, '칠리새우', 30000, '대');
insert into food values (400, '해물짬뽕', 11000, '보통');
commit;

select * from food;
drop table food;

--시퀀스 추가
create sequence seq_food nocache;
drop sequence seq_food;

--booking 테이블 생성
create table booking(
    bnum number(3) constraint pk_bnum primary key,
    bname varchar2(20) constraint nn_bname not null,
    bhp varchar2(20) constraint uq_bhp unique,
    foodnum number(3),
    bookingday date,
    constraint fk_foodnum foreign key(foodnum) references food(foodnum)--food테이블의 foodnum을 참조하는 foodnum을 만든다.
);

--예약 테이블에 데이터 추가
select * from booking;

insert into booking values (seq_food.nextval, '홍범자', '010-2222-3333', 101, sysdate); --성공

--핸드폰이 같으면 안됨
insert into booking values (seq_food.nextval, '강호동', '010-2222-3333', 101, sysdate); --오류발생

insert into booking values (seq_food.nextval, '이영자', '010-3434-8899', 101, sysdate + 7); -- 성공

--없는 메뉴 주문, 부모키가 없습니다.
insert into booking values (seq_food.nextval, '박지민', '010-3434-9999', 500, sysdate + 3); 

insert into booking values (seq_food.nextval, '이수근', '010-7777-7777', 201, sysdate + 3); -- 성공
insert into booking values (seq_food.nextval, '박지민', '010-2222-2222', 300, sysdate + 3); -- 성공
insert into booking values (seq_food.nextval, '손미나', '010-5555-5555', 101, sysdate + 10); -- 성공
insert into booking values (seq_food.nextval, '이효리', '010-3333-3333', 400, sysdate + 1); -- 성공
commit;

select * from booking;
drop table food;
--join으로 두 테이블을 조인해서 출력하시오
--bnum, bname, bhp, foodnum, foodname, foodprice, foodsize, bookingday(yyyy-mm-dd)

--한 테이블에만 있는경우 별칭 안붙여도 됨.
select bnum 예약번호, 
    bname 예약자, 
    bhp 핸드폰번호, 
    b.foodnum 음식번호, 
    foodname 음식이름, 
    foodprice 음식가격, 
    foodsize 음식크기, 
    to_char(bookingday, 'yyyy-mm-dd') 예약날짜 
from food f, booking b
where f.foodnum = b.foodnum;

/*
select b.bnum 예약번호, 
    b.bname 예약자, 
    b.bhp 핸드폰번호, 
    b.foodnum 음식번호, 
    f.foodname 음식이름, 
    f.foodprice 음식가격, 
    f.foodsize 음식크기, 
    b.bookingday 예약날짜 
from food f, booking b
where f.foodnum = b.foodnum;
*/
select
    bnum, f.foodnum, foodname, foodprice, foodsize
from food f, booking b
where f.foodnum=b.foodnum(+) and bnum is null;

--200,301,100은 아무도 주문 안함
--그럼 food의 200번 메뉴는 삭제 가능? 
delete from food where foodnum=200; --가능
--그럼 food의 300번 메뉴는 삭제 가능?
delete from food where foodnum=300; --누군가 주문을 했으므로 삭제 불가

--부모테이블인 food를 삭제해보자
drop table food;--지금은 삭제 불가 : 외부키로 연결되있기 때문에 자식테이블을 먼저 삭제후에 부모테이블을 삭제해야함

-- 연습 끝난 후 두 테이블 제거
drop table booking; --자식테이블 먼저 제거
drop table food;--자식테이블 제거 후 부모테이블 제거
--시퀀스도 제거
drop sequence seq_food;
--------------------------------------------------------------------------------
--이번에는 부모테이블의 데이터 삭제시 서브테이블의 데이터도 자동으로 삭제되도록
--외부키를 설정해보자
--시퀀스 생성
create sequence seq_shop;
drop sequence seq_shop;

create table shop(
    sang_no number(3) constraint shop_pk_no primary key,
    sang_name varchar2(30),
    sang_price number(10)
);
drop table shop;

--외부키 설정시 on delete cascade를 붙이면 부모테이블 삭제시 자식테이블에 추가된 데이타도 같이 삭제됨
create table cart(
    cart_no number(3) constraint cart_pk_no primary key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);
drop table cart;

--5개의 상품 등록
insert into shop values (seq_shop.nextval, '블라우스', 12000);
insert into shop values (seq_shop.nextval, '조끼', 19000);
insert into shop values (seq_shop.nextval, '청바지', 25000);
insert into shop values (seq_shop.nextval, '체크코트', 99000);
insert into shop values (seq_shop.nextval, '티셔츠', 11000);
commit;
select * from shop;

--cart에 원하는 상품을 담아보자
insert into cart values (seq_shop.nextval, 2, 3, sysdate);
insert into cart values (seq_shop.nextval, 1, 2, sysdate);
insert into cart values (seq_shop.nextval, 5, 1, sysdate);
commit;
select * from cart;

--join으로 조회하기
--cart_no, sang_no, sang_name, sang_price, cnt, cartday(yyyy-mm-dd)
select
    cart_no 카트번호, c.sang_no 상품번호, sang_name 상품이름, 
    sang_price 상품가격, cnt 개수, to_char(cartday, 'yyyy-mm-dd') "카트에 올린 날짜"
from shop s, cart c
where s.sang_no = c.sang_no;

--아무도 카트에 담지 않은 상품은?
/*
select
    cart_no, sang_name, sang_price
from shop s, cart c
where s.sang_no=c.sang_no(+) and cart_no is null;
*/

select
    cart_no 카트번호, s.sang_no 상품번호, sang_name 상품이름, 
    sang_price 상품가격
from shop s, cart c
where s.sang_no = c.sang_no(+) and cart_no is null;

--on delete cascade를 한 경우 cart에 추가된 상품도 삭제가 가능하다
--2번 조끼 상품 삭제해본다
delete from shop where sang_no = 2;

--cart를 확인해보면 cart에 있던 2번 상품도 사라진걸 확인할 수 있다.
select
    cart_no 카트번호, c.sang_no 상품번호, sang_name 상품이름, 
    sang_price 상품가격, cnt 개수, to_char(cartday, 'yyyy-mm-dd') "카트에 올린 날짜"
from shop s, cart c
where s.sang_no = c.sang_no;

--table 제거는 서브테이블부터 삭세
drop table cart;
drop table shop;
drop sequence seq_shop;

