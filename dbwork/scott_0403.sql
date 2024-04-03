--��������
-- enamedl 'A'�� 'S'�� �����ϴ� ����� ENAME, SAL, COMM ��ȸ
select ename,sal,comm from emp where ename like 'A%' or ename like 'S%';

--COMM�� NULL�� �ƴ� ����� ��ȸ
select * from emp where COMM is not null;

--MGR�� 7698,7566, 7782�� ��� ��ȸ(IN���)
select * from emp where MGR IN('7698','7566','7782');

--SAL�� 2500���� 3000���� ��ȸ(AND����)
select * from emp where sal >= 2500 and sal <= 3000;

--SAL�� 2500���� 3000���� ��ȸ(BETWEEN���)
select * from emp where sal between 2500 and 3000;

--JOB�� �ߺ�ó���ؼ� �ѹ����� ���
select distinct job from emp;

--�������� ����
--ALLEN�� ������ ���� ������ ���� ������� ��ȸ�Ͻÿ�
select * from emp where job=(select job from emp where ename='ALLEN');

--SCOTT�� MGR�� ���� ���� ���� ����� ������ ��ȸ
--MGR = ���ӻ���� �����ȣ
select * from emp where mgr=(select mgr from emp where ename='SCOTT');

--�����Լ�, �����Լ� ����
--dual : �ӽ� ���̺�
select abs(-5), abs(5) from dual; --ABS: ���밪
select ceil(3.0),ceil(3.1),ceil(3.9) from dual;--ceil : ������ �ø�
select floor(3.0),floor(3.1),floor(3.9),floor(4.0) from dual;--floor : ������ ����
select mod(7,3),mod(9,5) from dual; --mod:������
select power(2,3),power(3,4) from dual;--power:������
select round(23.456, 2),round(8923, -1),round(4567890, -4) from dual; --round : �ݿø�
--�Ҽ��� ���� �����̸� ����, �������̸� ���

--�����Լ�
select concat('HAPPY', 'DAY') from dual;  --concat
select 'HAPPY'||'DAY' from dual;--���� ����� ����
select initcap('HAPPY'),initcap('hello') from dual;
select lower('heLLOdAy'), upper('heLLOdAy') from dual;
select lower(ename), initcap(ename) from emp;
select lpad(sal,10,'*') from emp; --�������� * ä���, ���������� ����
select rpad(sal,10,'^') from emp; --���������� ^ ä���,, �������� ����
select substr('happy day', 2, 3) from dual;--2�� �ε������� 3���� : ù �ε����� 1 : app
select substr('happy day', -5, 3) from dual;--�ڿ��� 5��° �ε������� 3���� : y d
select ename,length(ename) ���ڼ� from emp; --length : ����, ���ڼ�
select replace('Good Day', 'o', '*') from dual; --o�� *�� �����ؼ� ���
select instr('happy', 'a') from dual; --happy�� a�� ��ġ : 2
select instr('happy', 'x') from dual; --x�� ������� 0
select instr('have a nice day', 'nice') from dual;--8��°�� nice�� ����
select trim('    hello     ') from dual; --�յ� ���� ����

--��Ÿ�Լ�
--nvl�� �ΰ��� ��� ��ü������ ���
select nvl(comm, 1000) from emp;--null�� ��� 1000���� ���

--decode :���� ���� �ٸ� ���� ����� ��
select ename �����, deptno �μ��ڵ�,
decode(deptno, 10, 'ȫ����', 20, '������', 30, '�λ��') �μ��� from emp;

--join
--inner join
--���1
select
    emp.empno, emp.ename, emp.job, dept.dname, dept.loc
from emp, dept
where emp.deptno=dept.deptno;

--���2. �� ���̺� ���������� �ִ� �÷��� ��쿡�� �տ� ���̺���� ���̰� �������� ��������
select
    empno, ename, job, dname, loc
from emp, dept
where emp.deptno=dept.deptno;

--���3. ���̺���� �ʹ� �� ��� ��Ī ��� ����
select
    e.empno, ename, job, dname, loc --���⵵ ��Ī ����
from emp e, dept d
where e.deptno=d.deptno; --���⼭ ��Ī���� ��� ����