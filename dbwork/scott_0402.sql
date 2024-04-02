--카페에서 scott_table을 다운받아 naver0314에 넣은 후 
--cmd 창에서 naver0314 폴더로 이동 후 (cd naver0314)
--sqlplus로 scott계정으로 접속 후
--@scott_table 엔터
--자동으로 안에 있는 sql명령어가 실행
select *from tab; -- 생성된 테이블 확인
select *from emp; --emp테이블의 연습용 데이터 확인
commit; --추가된 데이터 커밋, 커밋 안할 시 추가된 데이타가 취소됨

--emp테이블의 구조 확인
desc emp;

--전체 컬럼으로 emp 테이블 조회
select * from emp;
--ename, job 컬럼만 조회
select ename,job from emp;

--ename, job 컬럼만 조회, ename은 오름차순 또는 내림차순으로 조회
select ename,job from emp order by ename asc; -- asc는 생략가능
select ename,job from emp order by ename desc; --ename의 내림차순

select ename,job from emp order by job asc; 
select ename,job from emp order by job desc; 










