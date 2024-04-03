--복습문제
-- enamedl 'A'나 'S'로 시작하는 사람의 ENAME, SAL, COMM 조회
select ename,sal,comm from emp where ename like 'A%' or ename like 'S%';

--COMM이 NULL이 아닌 사람만 조회
select * from emp where COMM is not null;

--MGR이 7698,7566, 7782인 사람 조회(IN사용)
select * from emp where MGR IN('7698','7566','7782');

--SAL이 2500부터 3000까지 조회(AND연산)
select * from emp where sal >= 2500 and sal <= 3000;

--SAL이 2500부터 3000까지 조회(BETWEEN사용)
select * from emp where sal between 2500 and 3000;

--JOB을 중복처리해서 한번씩만 출력
select distinct job from emp;

--서브쿼리 문제
--ALLEN의 직업과 같은 직업을 가진 사람들을 조회하시오
select * from emp where job=(select job from emp where ename='ALLEN');

--SCOTT의 MGR과 같은 값을 가진 사람의 정보를 조회
--MGR = 직속상사의 사원번호
select * from emp where mgr=(select mgr from emp where ename='SCOTT');