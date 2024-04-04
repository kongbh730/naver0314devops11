-- 2024-04-04 mysql 공부

-- 현재날짜 구하는 함수들
select now() from dual; -- now()만 사용할 것
select sysdate() from dual;
select current_timestamp() from dual;

-- 날짜함수들
select year(now()) from dual;
select month(now()) from dual;
select monthname(now()) from dual; -- april
select dayname(now()) from dual; -- thursday
select dayofmonth(now()) from dual; -- 4일
select date_format(now(), '%Y-%m-%d') from dual;
select date_format(now(), '%Y-%m-%d %H:%i') from dual;
select str_to_date('20240404', '%Y%m%d') from dual;

-- 오라클은 시퀀스가 없다. 시퀀스가 필요하다면  auto_increment;

-- 테이블 생성 test01
create table test01 (num tinyint auto_increment primary key,
      name varchar(20), age smallint,
     height decimal(5,1),birthday datetime, ipsaday date);

-- insert : 일부만 추가할 경우 컬럼명기재, 전부 다 줄 경우 컬럼명 생략 가능
insert into test01(name, age, height) values ('lee', 23, 178.9);
insert into test01(name, birthday, ipsaday) values ('LeeMJ', '2021-12-25 12:30', '2018-05-10');

-- 컬럼 생략시 num도 값을 넣어야 하는데 num은 auto이므로 그냥 null로 넣으면 됨
insert into test01 values(null, 'kim', 29, 156.9, now(), now());
insert into test01 values(null, 'son', 31, 168.888, now(), now());
insert into test01 values(null, 'sonnaa', 26, 177.9, now(), now());
insert into test01 values(null, 'kimbap', 45, 189.3, now(), now());
insert into test01 values(null, 'ParkNamJung', 12, 123.6, now(), now());

select * from test01;
select * from test01 where name = 'son';
select * from test01 where name like 's%'; -- 이름이 s로 시작하는 사람
select * from test01 where name like '_i%'; -- 이름 두번째 글자가 i인 사람
select upper(name), height from test01; -- 이름을 대문자로
select ucase(name), height from test01; -- 이름을 대문자로 : upper()와 ucase() 동일

select lower(name), height from test01; -- 소문자로
select lcase(name), height from test01; -- 소문자로

-- 오라클의 NVL은 mysql에서는 ifnull:null일때 대체값 지정
select name, ifnull(age, 10), ifnull(height, 150.5) from test01;

-- 컬럼명을 변경해보자
select name "이름", ifnull(age, 10) "나이", ifnull(height, 150.5) "키" from test01;
select name , ifnull(age, 10) age, ifnull(height, 150.5) height from test01;

-- 테이블 구조 수정
-- 컬럼추가
alter table test01 add hp varchar(20);

-- 컬럼 추가하는데 기본값 지정
alter table test01 add blood varchar(3) default 'b';

-- 컬럼 타입 변경
desc test01; -- rnwhghkrdls
-- name의 길이를 20에서 30으로 변경해보자
alter table test01 modify name varchar(30);
-- age 컬럼 제거
alter table test01 drop column age;

-- 컬럼명 변경
-- hp -> phone 으로 변경해보자
alter table test01 rename column hp to phone;

-- 삭제
delete from test01 where num = 5;
-- 수정 
update test01 set birthday = '1990-12-12', ipsaday=now(),phone='010-2222-3333' where num = 1;

-- 조회
select * from test01 order by num;
select * from test01 order by 2; -- 컬럼번호는 1부터 시작 : name 기준으로 정렬해서 출력

-- 부분 조회
select * from test01 limit 0, 3; -- 첫데이터가 0번 : 0번부터 3개 조회
select * from test01 limit 3, 2; -- 3번부터 2개 조회


-- -----------------------------sawon 테이블 새로 생성----------------------------------
 create table sawon (
              num smallint auto_increment,
              name varchar(20),
              score smallint,
              gender varchar(10),
              buseo varchar(10),
              constraint pk_sawon_num primary key(num),
  		constraint ck_sawon_score check (score between 0 and 100),
 		constraint ck_sawon_gender check (gender in ('여자','남자'))
        );

-- 제약조건 확인
select * from information_schema.table_constraints where table_name='sawon';

select * from sawon;

-- check에 안맞는 값을 insert 할 경우 오류메세지 확인
insert into sawon values (null, '이민정', 110, '여자', '홍보부'); -- 에러 발생 score에서 오류 발생
insert into sawon values (null, '이민정', 90, '여자', '홍보부'); -- 성공
insert into sawon values (null, '홍길동', 87, '남', '교육부'); -- 에러발생 : 성별에서 문제생김
insert into sawon values (null, '홍길동', 87, '남자', '교육부');

-- group by 연습을 위해 데이터 10개 추가
insert into sawon values (null, '이진', 60, '여자', '인사부');
insert into sawon values (null, '유재석', 67, '남자', '홍보부');
insert into sawon values (null, '이제동', 39, '남자', '인사부');
insert into sawon values (null, '박재정', 38, '여자', '홍보부');
insert into sawon values (null, '강호동', 74, '남자', '교육부');
insert into sawon values (null, '이수근', 80, '남자', '행정부');
insert into sawon values (null, '이영애', 93, '여자', '인사부');
insert into sawon values (null, '이재권', 100, '남자', '행정부');

-- group 함수
select count(*) from sawon; -- 총 인원수 
select sum(score), avg(score) from sawon; -- 총점, 평균
select sum(score), round(avg(score), 1) from sawon; -- 총점, 평균

-- 성별 : 인원수 최고점수 최저점수 평균점수 구해보자
select
	gender 성별 , count(*) 인원수, max(score) 최고점수, min(score) 최저점수, round(avg(score), 1) 평균
from sawon
group by gender; -- 성별 기준으로 그룹화

-- 부서별 인원수와 최고점수
select
	buseo 부서 , count(*) 인원수, max(score) 최고점수, min(score) 최저점수, round(avg(score), 1) 평균
from sawon
group by buseo; -- 부서 기준으로 그룹화

-- 오라클의 decode와 비슷한 if문
select name, score, if(score>=90, '통과', '재시험') 평가
from sawon;

-- test01은 연습용이므로 삭제
drop table test01;


