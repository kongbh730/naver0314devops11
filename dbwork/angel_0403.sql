--������ ����
--�⺻ 1���� 1�� �����ϴ� �������� �����ϰ� �⺻ ��ɾ �ָ� ��
create sequence seq1;

--��ü ������ ��ȸ
select * from seq;

--���� ������ �� �߻� : nextval
select seq1.nextval from dual;

--10���� 5�� �����ϴ� �������� �����غ���, ĳ���� �⺻ 20�ε� ���ֺ���
create sequence seq2 start with 10 increment by 5 nocache;

--seq2���� �߻����Ѻ���.
select seq2.nextval from dual;

--1���� 3�� ����, ĳ��0, �ƽ� 100
create sequence seq3 start with 1 increment by 3 nocache maxvalue 100;

--seq3 �� �߻�
select seq3.nextval from dual;

--�������� ����
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

--���� ���̺��� ����� ������ ����(1���� 1�� ����(����), cache 0)
create sequence seq_test nocache;

--������ ���̺�
create table hello(
    idx number(3) primary key,
    irum varchar2(20),
    age number(3)
);

--���̺� ���� ���� : alter table
--irum�� ���̸� 20���� 30���� �����غ���
alter table hello modify irum varchar2(30);

--addr�̶�� �÷� �߰� : �Ӽ�, ��...(���ڿ� ���̴� 100)
alter table hello add addr varchar2(100);

--age��� �÷��� �����غ���
alter table hello drop column age;

--�÷��� ���� addr -> address
alter table hello rename column addr to address;

--�÷� �ΰ� �߰��غ���
alter table hello add blood varchar2(3);
alter table hello add age number(3);

--�����͸� �߰��غ���
insert into hello (irum) values ('lee'); --�����߻�, idx�� pk�̹Ƿ� �ݵ�� ���� �־�� �Ѵ�.

insert into hello (idx,irum) values (seq_test.nextval, 'lee');
insert into hello (idx,blood,address) values (seq_test.nextval, 'ab', '���� ����');
--�÷��� ������ ���̺��� �÷� ������� ��� ���� ��� �Ѵ�.
insert into hello values (seq_test.nextval, '����', '���ֵ� �ֿ���', 'O', 23);

--����
--�̸��� '����'�� ����� �������� b������ �����غ���
update hello set blood='b' where irum='����';
--idx�� 2�� ����� irum�� age�� �����غ���
update hello set irum='��ȣ��',age=35 where idx=2;
--idx�� 1�� ����� addres, blood, age�� ���� �����ϼ���
update hello set address='���� ����',blood='A',age=35 where idx=1;

--����
--idx�� 1�� ��� ����
delete from hello where idx=1;
--age�� 30 �̻��� ������ ��� ����
delete from hello where age >= 30;

select * from hello;

--���̺��� ����
drop table hello;

-----------------------------------------------------
--���ο� ���̺� ����, �̹����� ���� ���������� �߰��ؼ� �����غ���
create table student (
    num number(3) constraint pk_num primary key,
    stuname varchar2(20) constraint nn_name not null,
    score number(3) constraint ck_score check(score >= 1 and score <= 100),
    birthday date
);

--insert�� ������ �߰��� �ϴµ� ���� ������ �߻����Ѻ���,
insert into student (num, stuname) values(1, '��̸�'); -- �����߻�

--ORA-01400 NULL�� ("ANGEL", "STUDENT" "NUM")�ȿ� ���� �Ұ�
insert into student (num, socre) values('�̹���', 45); -- �����߻�

--num�� pk(�⺻Ű)
insert into sudent(num, stuname) values(1, 'ȫ����'); -- ����

--ORA-02290: üũ ���������� ����Ǿ����ϴ�.
--score�� ������ 1~100�̾�� �Ѵ�.
insert into student(num, stuname, score) values (2, '����ȣ', 110); --����

--�������� �������ͷ� �߰�
insert into student values(3, '�̹���', 89, sysdate);--��¥�� ���糯¥��
insert into student values(4, '�����', 100, '2010-12-20');

--commit�� �ϴ� �ϸ� rollback�� �ȵ�
commit;

insert into student values(5, '��̳�', 56, '2019-05-10');--��¥�� ���糯¥��
insert into student values(6, '������', 98, sysdate);
insert into student values(7, '������', 67, '2015-09-12');
insert into student values(8, '��ȣ��', 66, '2019-05-03');

commit;--Ŀ�����ĺ��ʹ� �ѹ��� �ȵ�
--Ʈ����� : Ŀ��, �ѹ�
rollback;--developer�� ���� Ŀ���� �ȵ�, mysql�� ����Ŀ�� ����

--num�� 5���� �������� �̸��� '�չ̶�', score�� 80���� ����
update student set stuname='�չ̶�',score=80 where num=5;

--birthday�� ���� 5�� ����� ������ �ϰ������� 85�� ����
update student set score=85 where to_char(birthday,'mm') = 5;
commit;

--num�� 7�� ������ ����
delete from student where num=7;
--�ѹ�� ������ Ȯ��
rollback;
--�ٽ� ������ ����
delete from student where num=7;
--Ŀ��
commit;
--�ٽ� �ѹ� �� ������ Ȯ��
rollback;--�̹� Ŀ�Ե� �����ʹ� ��ҵ��� �ʴ´�.

--���ʿ��� �������� ����
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;

alter table student add constraint uq_name unique(stuname);

insert into student (num,stuname) values(10, '��ȣ��');

--������ ���� �� �������� ���̺� ����
drop sequence seq_test;
drop table student;

------------------------------------------------------------
/*
join ������ ���̺� 2�� �����ϱ�
���̺� #1 : food - foodnum ����(3)
            foodname ���ڿ�(20)
            foodsptce ����(7)
            foodsize ���� (20)
            
        booking - bnum pk ����(3)
                bname ���ڿ�(20) nn
                bhp ���ڿ�(20)uq
                foodnum ����(3)- fj(food�� foodnum)
                bookingday date
    
    �ܺ�Ű�� ����� ��� booking �� �����Ͱ� �߰��� ���� �߰��� foodnum�� ������ �� ����.
    ���� ��� �Խ����� ��� ���� ��� �ܺ�Ű�� ����Ǿ� �ִµ� �̶��� ��۸� �޸� ��� 
    �ش���� ������ �� ���� �����ǵ��� �ִ�.
    �׷��� ���� food�� �����͸� �����ϸ� �� �޴��� �߰��� ���� �����͵� �ڵ����� ������Ű���� �� ��� 
    booking�� �ܺ�Ű�� ������ �� on delete cascade�� �ָ� �ȴ�.
*/

create table food(
    foodnum number(3) constraint pk_foodnum primary key,
    foodname varchar2(20),
    foodprice number(7),
    foodsize varchar2(20)
);

--�޴��� ����غ���
insert into food values (100, '¥���', 9000, '����');
insert into food values (101, '¥���', 11000, '�����');
insert into food values (200, '������', 15000, '����');
insert into food values (201, '������', 20000, '�����');
insert into food values (300, 'ĥ������', 15000, '��');
insert into food values (301, 'ĥ������', 30000, '��');
insert into food values (400, '�ع�«��', 11000, '����');
commit;

select * from food;
drop table food;

--������ �߰�
create sequence seq_food nocache;
drop sequence seq_food;

--booking ���̺� ����
create table booking(
    bnum number(3) constraint pk_bnum primary key,
    bname varchar2(20) constraint nn_bname not null,
    bhp varchar2(20) constraint uq_bhp unique,
    foodnum number(3),
    bookingday date,
    constraint fk_foodnum foreign key(foodnum) references food(foodnum)--food���̺��� foodnum�� �����ϴ� foodnum�� �����.
);

--���� ���̺� ������ �߰�
select * from booking;

insert into booking values (seq_food.nextval, 'ȫ����', '010-2222-3333', 101, sysdate); --����

--�ڵ����� ������ �ȵ�
insert into booking values (seq_food.nextval, '��ȣ��', '010-2222-3333', 101, sysdate); --�����߻�

insert into booking values (seq_food.nextval, '�̿���', '010-3434-8899', 101, sysdate + 7); -- ����

--���� �޴� �ֹ�, �θ�Ű�� �����ϴ�.
insert into booking values (seq_food.nextval, '������', '010-3434-9999', 500, sysdate + 3); 

insert into booking values (seq_food.nextval, '�̼���', '010-7777-7777', 201, sysdate + 3); -- ����
insert into booking values (seq_food.nextval, '������', '010-2222-2222', 300, sysdate + 3); -- ����
insert into booking values (seq_food.nextval, '�չ̳�', '010-5555-5555', 101, sysdate + 10); -- ����
insert into booking values (seq_food.nextval, '��ȿ��', '010-3333-3333', 400, sysdate + 1); -- ����
commit;

select * from booking;
drop table food;
--join���� �� ���̺��� �����ؼ� ����Ͻÿ�
--bnum, bname, bhp, foodnum, foodname, foodprice, foodsize, bookingday(yyyy-mm-dd)

--�� ���̺��� �ִ°�� ��Ī �Ⱥٿ��� ��.
select bnum �����ȣ, 
    bname ������, 
    bhp �ڵ�����ȣ, 
    b.foodnum ���Ĺ�ȣ, 
    foodname �����̸�, 
    foodprice ���İ���, 
    foodsize ����ũ��, 
    to_char(bookingday, 'yyyy-mm-dd') ���೯¥ 
from food f, booking b
where f.foodnum = b.foodnum;

/*
select b.bnum �����ȣ, 
    b.bname ������, 
    b.bhp �ڵ�����ȣ, 
    b.foodnum ���Ĺ�ȣ, 
    f.foodname �����̸�, 
    f.foodprice ���İ���, 
    f.foodsize ����ũ��, 
    b.bookingday ���೯¥ 
from food f, booking b
where f.foodnum = b.foodnum;
*/
select
    bnum, f.foodnum, foodname, foodprice, foodsize
from food f, booking b
where f.foodnum=b.foodnum(+) and bnum is null;

--200,301,100�� �ƹ��� �ֹ� ����
--�׷� food�� 200�� �޴��� ���� ����? 
delete from food where foodnum=200; --����
--�׷� food�� 300�� �޴��� ���� ����?
delete from food where foodnum=300; --������ �ֹ��� �����Ƿ� ���� �Ұ�

--�θ����̺��� food�� �����غ���
drop table food;--������ ���� �Ұ� : �ܺ�Ű�� ������ֱ� ������ �ڽ����̺��� ���� �����Ŀ� �θ����̺��� �����ؾ���

-- ���� ���� �� �� ���̺� ����
drop table booking; --�ڽ����̺� ���� ����
drop table food;--�ڽ����̺� ���� �� �θ����̺� ����
--�������� ����
drop sequence seq_food;
--------------------------------------------------------------------------------
--�̹����� �θ����̺��� ������ ������ �������̺��� �����͵� �ڵ����� �����ǵ���
--�ܺ�Ű�� �����غ���
--������ ����
create sequence seq_shop;
drop sequence seq_shop;

create table shop(
    sang_no number(3) constraint shop_pk_no primary key,
    sang_name varchar2(30),
    sang_price number(10)
);
drop table shop;

--�ܺ�Ű ������ on delete cascade�� ���̸� �θ����̺� ������ �ڽ����̺� �߰��� ����Ÿ�� ���� ������
create table cart(
    cart_no number(3) constraint cart_pk_no primary key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);
drop table cart;

--5���� ��ǰ ���
insert into shop values (seq_shop.nextval, '���콺', 12000);
insert into shop values (seq_shop.nextval, '����', 19000);
insert into shop values (seq_shop.nextval, 'û����', 25000);
insert into shop values (seq_shop.nextval, 'üũ��Ʈ', 99000);
insert into shop values (seq_shop.nextval, 'Ƽ����', 11000);
commit;
select * from shop;

--cart�� ���ϴ� ��ǰ�� ��ƺ���
insert into cart values (seq_shop.nextval, 2, 3, sysdate);
insert into cart values (seq_shop.nextval, 1, 2, sysdate);
insert into cart values (seq_shop.nextval, 5, 1, sysdate);
commit;
select * from cart;

--join���� ��ȸ�ϱ�
--cart_no, sang_no, sang_name, sang_price, cnt, cartday(yyyy-mm-dd)
select
    cart_no īƮ��ȣ, c.sang_no ��ǰ��ȣ, sang_name ��ǰ�̸�, 
    sang_price ��ǰ����, cnt ����, to_char(cartday, 'yyyy-mm-dd') "īƮ�� �ø� ��¥"
from shop s, cart c
where s.sang_no = c.sang_no;

--�ƹ��� īƮ�� ���� ���� ��ǰ��?
/*
select
    cart_no, sang_name, sang_price
from shop s, cart c
where s.sang_no=c.sang_no(+) and cart_no is null;
*/

select
    cart_no īƮ��ȣ, s.sang_no ��ǰ��ȣ, sang_name ��ǰ�̸�, 
    sang_price ��ǰ����
from shop s, cart c
where s.sang_no = c.sang_no(+) and cart_no is null;

--on delete cascade�� �� ��� cart�� �߰��� ��ǰ�� ������ �����ϴ�
--2�� ���� ��ǰ �����غ���
delete from shop where sang_no = 2;

--cart�� Ȯ���غ��� cart�� �ִ� 2�� ��ǰ�� ������� Ȯ���� �� �ִ�.
select
    cart_no īƮ��ȣ, c.sang_no ��ǰ��ȣ, sang_name ��ǰ�̸�, 
    sang_price ��ǰ����, cnt ����, to_char(cartday, 'yyyy-mm-dd') "īƮ�� �ø� ��¥"
from shop s, cart c
where s.sang_no = c.sang_no;

--table ���Ŵ� �������̺���� �輼
drop table cart;
drop table shop;
drop sequence seq_shop;

