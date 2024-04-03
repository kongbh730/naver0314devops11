--카페에서 scott_table을 다운받아 naver0314에 넣은 후 
--cmd 창에서 naver0314 폴더로 이동 후 (cd naver0314)
--sqlplus로 scott계정으로 접속 후
--@scott_table 엔터
--자동으로 안에 있는 sql명령어가 실행
select * from tab; -- 생성된 테이블 확인
select * from emp; --emp테이블의 연습용 데이터 확인
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

--job을 조회
select job from emp; --job을 전부 출력 : 중복 발생

--job을 조회하는데 같은 직업은 한번만 나오게
select distinct job from emp;
select distinct job from emp order by job asc;
SELECT distinct job from emp order by 1; --컬럼번호는 1번부터, 위와 같다

--ename 이 smith인 사람 조회
select * from emp where ename='SMITH';--원소값은 대소문자 구분
select * from emp where ename='ward'; --sql명령어는 대소문자 상관없지만 데이터는 정확히 써야한다.
select * from emp where ename = 'SMITH' or ename = 'WARD'; -- 데이터 원소지정은 무조건 작은 따옴표 ' '
select ename, sal from emp;

--컬럼제목을 변경
select ename "사원명", sal "급여" from emp; --제목 변경시 공백이 포한되어 있을 경우 반드시 "" 로 묶어준다.
select ename 사원명,sal 급여 from emp;

--여러 컬럼을 합해서 하나의 컬럼으로 출력할 경우
select '내 이름은 '||ename||'이고 직업은 '||job||'입니다' from emp;
select '내 이름은 '||ename||'이고 직업은 '||job||'입니다' "사원" from emp;

--내가 만들기
--smith 님의 연봉은 800만원입니다
select ename||'님의 연봉은 '||sal||'만원입니다.' 연봉 from emp; 

--연봉이 2000~3000사이 조회
select ename,sal from emp where sal >= 2000 and sal <= 3000;

--between을 이용해서 조회가능
select ename,sal from emp where sal between 1000 and 2000;

-- 직업이 salesmen, manager, clerk 조회
select ename,job from emp where job='SALESMAN' or job='MANAGER' or job='CLERK';

--IN을 이용해서 여러 직업으로 출력해보자
select ename,job from emp where job in ('SALESMAN', 'MANAGER', 'CLERK');

--MGR이 7902, 7839, 7788 조회(컬럼은 ename, job, mgr) - in 사용해서
select ename,job,mgr from emp where mgr in(7902,7839,7788);

--MGR이 null인 경우만 출력
select * from emp where mgr is null;

--comm이 null인 경우
select * from emp where comm is null;

--comm이 null이 아닌 경우
select * from emp where comm is not null;

--문자조회시 %, _를 이용해서 조회
--ename이 A로 시작하는 사람 조회
select ename,sal from emp where ename like 'A%';

--ename이 n으로 끝나는 사람 조회
select ename,sal from emp where ename like '%N';

--이름의 두번째 글자가 A인 사람 조회
select ename,sal from emp where ename like '_A%'; --무조건 두번째 글자가 A인 사람, 뒤에 글자는 상관 없음

--이름의 세번째 글자가 A인 사람 조회
select ename,sal from emp where ename like '__A%';

--이름이 S나 M으로 시작하는 사람 조회
select ename,sal from emp where ename like 'S%' or ename like 'M%'; 
--이름이 S로 시작하는 사람 중에 sal이 2000 이상인 사람 조회
select ename,sal from emp where ename like 'S%' and sal >= 2000;

--MGR이 7902,7788,7566이 아닌 사람을 조회
select ename,sal,mgr from emp where mgr not in ('7902','7788','7566');

--comm, comm+1000의 결과 출력
select comm, comm+1000 from emp; --null인 경우는 더해도 결과는 null

--함수 중 NVL(컬럼명, 널일 경우 초기값), MYSQL은 ifnull이다.
select NVL(comm, 0), NVL(comm, 0)+1000 from emp; --null일 경우 0으로 출력 또는 계싼

--위의 sql문을 컬럼제목을 추가하여 완성하시오 "comm", "comm2"
select NVL(comm, 0) COMM, NVL(comm, 0)+1000 COMM2 from emp; --속성명 원하는 대로 수정

--SAL이 2000~3000이 아닌 경우 조회, 두가지 방법으로 해보기
select ename,sal from emp where sal < 2000 or sal > 3000;
select ename,sal from emp where sal not between 2000 and 3000;

--GROUP함수 (count, max, min, avg, sum)
select count(*) from emp;--전체 인원수
select max(sal) from emp;--최고연봉
select min(sal) from emp;--최소연봉
select sum(sal) from emp;--sal의 합계
select avg(sal) from emp;--sal의 평균

--avg는 소숫점 이하가 많이 나오는 경우가 많아서 round,cell,floor등과 같이 많이 사용
--평균은 소숫점 이하 두자리까지만 나오게 하기
select round(avg(sal),2) from emp;--2073.21 반올림
select ceil(avg(sal)) from emp; --무조건 올림 ceil : 천장
select floor(avg(sal)) from emp;--무조건 내림

--PPT 57page group by 절
--job을 그룹으로 각 직업별 인원수 구해보기
select job 직업,count(*) 인원수 from emp group by job;--job을 기준으로 group by 하겠다.

--위의 결과에 직업의 오름차순으로 출력
select job 직업,count(*) 인원수 from emp group by job order by 직업;--컬럼명으로 순서정하기
select job 직업,count(*) 인원수 from emp group by job order by 1;--컬럼번호로 순서정하기

--위의 결과에 인원수의 오름차순 출력
select job 직업,count(*) 인원수 from emp group by job order by 인원수;--인원수로 순서정하기
select job 직업,count(*) 인원수 from emp group by job order by 2; --2번 속성 기준으로 순서정하겠다
select job 직업,count(*) 인원수 from emp group by job order by 인원수 desc;--인원수로 순서정하기 내림차순

--직업별 인원수와 최고연봉, 최저연봉, 평균연봉(무조건 올림)을 구해보시오.
select job 직업,count(*) 인원수,max(sal) 최고연봉,min(sal) 최저연봉, ceil(avg(sal)) 평균연봉 from emp group by job;

--having은 group절에서 그룹함수를 이용해서 조건을 나타낼 경우
--직업별 인원수과 최고 연봉을 구하는데 직업별 인원수가 3명 이상인 경우만 조회를 하시오
select job, count(*), max(sal) from emp group by job having count(job) >= 3;

--오라클에서는 현재 날짜를 구할 때 SYSDATE, MYSQL은 NOW()
select sysdate from dual;--현재 콘솔에 현재 날짜 출력
--3일뒤
select sysdate+3 from dual;--현재 날짜 더하기 3일
--30dlfenl
select sysdate+30 from dual;--현재 날짜 더하기 30일

--날짜 타입을 문자열로 변환 to_char : 기호 y,m,d,hh, hh24, mi, ss,am,pm등
select to_char(sysdate, 'yyyy') from dual;
select to_char(sysdate, 'year') from dual; --영문자로 표기
select to_char(sysdate, 'mm') from dual;
select to_char(sysdate, 'month') from dual; --지역언어로 월이 나옴

--기호를 많이 쓰는데 다양한 기호로 날짜를 출력해보자
select to_char(sysdate, 'yyyy-mm-dd') from dual;
select to_char(sysdate, 'yyyy-mm-dd hh:mi')from dual;
select to_char(sysdate, 'yyyy-mm-dd am hh:mi')from dual;--am 또는 pm쓰면 자동으로 정해짐
select to_char(sysdate, 'yyyy-mm-dd hh24:mi')from dual;

--emp에서 hiredate(날짜타입)를 이용해서 출력해보자
select ename,to_char(hiredate, 'yyyy-mm-dd') HIREDATE from emp;

--고용년도가 1987년인 사람 출력 
select * from emp where to_char(hiredate,'yyyy')='1987';
select * from emp where to_char(hiredate,'yyyy')=1987;
select ename,to_char(hiredate,'yyyy')HIREYEAR from emp where to_char(hiredate,'yyyy')=1987;

--고용월이 5월인 사람 출력
select * from emp where to_char(hiredate,'mm')='05';
select * from emp where to_char(hiredate,'mm')=05;
select * from emp where to_char(hiredate,'mm')=5;

--SUBQUERY(select 문 안에 또 select 문이 있는 경우)
--SCOTT의 연봉과 같은 연봉을 가진 사람을 구하시오
select * from emp where sal=(select sal from emp where ename='SCOTT') and not ename='SCOTT';

--평균연봉보다 많이 받는 사람의 정보 출력
select * from emp where sal>(select avg(sal) from emp);








