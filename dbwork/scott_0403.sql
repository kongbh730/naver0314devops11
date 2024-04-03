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

--숫자함수, 문자함수 연습
--dual : 임시 테이블
select abs(-5), abs(5) from dual; --ABS: 절대값
select ceil(3.0),ceil(3.1),ceil(3.9) from dual;--ceil : 무조건 올림
select floor(3.0),floor(3.1),floor(3.9),floor(4.0) from dual;--floor : 무조건 내림
select mod(7,3),mod(9,5) from dual; --mod:나머지
select power(2,3),power(3,4) from dual;--power:지수승
select round(23.456, 2),round(8923, -1),round(4567890, -4) from dual; --round : 반올림
--소숫점 기준 왼쪽이면 음수, 오른쪽이면 양수

--문자함수
select concat('HAPPY', 'DAY') from dual;  --concat
select 'HAPPY'||'DAY' from dual;--위와 결과가 같다
select initcap('HAPPY'),initcap('hello') from dual;
select lower('heLLOdAy'), upper('heLLOdAy') from dual;
select lower(ename), initcap(ename) from emp;
select lpad(sal,10,'*') from emp; --왼쪽으로 * 채우기, 오른쪽으로 정렬
select rpad(sal,10,'^') from emp; --오른쪽으로 ^ 채우기,, 왼쪽으로 정렬
select substr('happy day', 2, 3) from dual;--2번 인덱스부터 3글자 : 첫 인덱스가 1 : app
select substr('happy day', -5, 3) from dual;--뒤에서 5번째 인덱스부터 3글자 : y d
select ename,length(ename) 글자수 from emp; --length : 길이, 글자수
select replace('Good Day', 'o', '*') from dual; --o을 *로 변경해서 출력
select instr('happy', 'a') from dual; --happy에 a의 위치 : 2
select instr('happy', 'x') from dual; --x가 없을경우 0
select instr('have a nice day', 'nice') from dual;--8번째에 nice가 있음
select trim('    hello     ') from dual; --앞뒤 공백 제거

--기타함수
--nvl은 널값일 경우 대체값으로 출력
select nvl(comm, 1000) from emp;--null일 경우 1000으로 출력

--decode :값에 따라 다른 값을 출력할 때
select ename 사원명, deptno 부서코드,
decode(deptno, 10, '홍보부', 20, '교육부', 30, '인사부') 부서명 from emp;

--join
--inner join
--방법1
select
    emp.empno, emp.ename, emp.job, dept.dname, dept.loc
from emp, dept
where emp.deptno=dept.deptno;

--방법2. 두 테이블에 공통적으로 있는 컬럼일 경우에만 앞에 테이블명을 붙이고 나머지는 생략가능
select
    empno, ename, job, dname, loc
from emp, dept
where emp.deptno=dept.deptno;

--방법3. 테이블명이 너무 길 경우 별칭 사용 가능
select
    e.empno, ename, job, dname, loc --여기도 별칭 가능
from emp e, dept d
where e.deptno=d.deptno; --여기서 별칭으로 사용 가능