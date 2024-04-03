--ī�信�� scott_table�� �ٿ�޾� naver0314�� ���� �� 
--cmd â���� naver0314 ������ �̵� �� (cd naver0314)
--sqlplus�� scott�������� ���� ��
--@scott_table ����
--�ڵ����� �ȿ� �ִ� sql��ɾ ����
select * from tab; -- ������ ���̺� Ȯ��
select * from emp; --emp���̺��� ������ ������ Ȯ��
commit; --�߰��� ������ Ŀ��, Ŀ�� ���� �� �߰��� ����Ÿ�� ��ҵ�

--emp���̺��� ���� Ȯ��
desc emp;

--��ü �÷����� emp ���̺� ��ȸ
select * from emp;
--ename, job �÷��� ��ȸ
select ename,job from emp;

--ename, job �÷��� ��ȸ, ename�� �������� �Ǵ� ������������ ��ȸ
select ename,job from emp order by ename asc; -- asc�� ��������
select ename,job from emp order by ename desc; --ename�� ��������

select ename,job from emp order by job asc; 
select ename,job from emp order by job desc; 

--job�� ��ȸ
select job from emp; --job�� ���� ��� : �ߺ� �߻�

--job�� ��ȸ�ϴµ� ���� ������ �ѹ��� ������
select distinct job from emp;
select distinct job from emp order by job asc;
SELECT distinct job from emp order by 1; --�÷���ȣ�� 1������, ���� ����

--ename �� smith�� ��� ��ȸ
select * from emp where ename='SMITH';--���Ұ��� ��ҹ��� ����
select * from emp where ename='ward'; --sql��ɾ�� ��ҹ��� ��������� �����ʹ� ��Ȯ�� ����Ѵ�.
select * from emp where ename = 'SMITH' or ename = 'WARD'; -- ������ ���������� ������ ���� ����ǥ ' '
select ename, sal from emp;

--�÷������� ����
select ename "�����", sal "�޿�" from emp; --���� ����� ������ ���ѵǾ� ���� ��� �ݵ�� "" �� �����ش�.
select ename �����,sal �޿� from emp;

--���� �÷��� ���ؼ� �ϳ��� �÷����� ����� ���
select '�� �̸��� '||ename||'�̰� ������ '||job||'�Դϴ�' from emp;
select '�� �̸��� '||ename||'�̰� ������ '||job||'�Դϴ�' "���" from emp;

--���� �����
--smith ���� ������ 800�����Դϴ�
select ename||'���� ������ '||sal||'�����Դϴ�.' ���� from emp; 

--������ 2000~3000���� ��ȸ
select ename,sal from emp where sal >= 2000 and sal <= 3000;

--between�� �̿��ؼ� ��ȸ����
select ename,sal from emp where sal between 1000 and 2000;

-- ������ salesmen, manager, clerk ��ȸ
select ename,job from emp where job='SALESMAN' or job='MANAGER' or job='CLERK';

--IN�� �̿��ؼ� ���� �������� ����غ���
select ename,job from emp where job in ('SALESMAN', 'MANAGER', 'CLERK');

--MGR�� 7902, 7839, 7788 ��ȸ(�÷��� ename, job, mgr) - in ����ؼ�
select ename,job,mgr from emp where mgr in(7902,7839,7788);

--MGR�� null�� ��츸 ���
select * from emp where mgr is null;

--comm�� null�� ���
select * from emp where comm is null;

--comm�� null�� �ƴ� ���
select * from emp where comm is not null;

--������ȸ�� %, _�� �̿��ؼ� ��ȸ
--ename�� A�� �����ϴ� ��� ��ȸ
select ename,sal from emp where ename like 'A%';

--ename�� n���� ������ ��� ��ȸ
select ename,sal from emp where ename like '%N';

--�̸��� �ι�° ���ڰ� A�� ��� ��ȸ
select ename,sal from emp where ename like '_A%'; --������ �ι�° ���ڰ� A�� ���, �ڿ� ���ڴ� ��� ����

--�̸��� ����° ���ڰ� A�� ��� ��ȸ
select ename,sal from emp where ename like '__A%';

--�̸��� S�� M���� �����ϴ� ��� ��ȸ
select ename,sal from emp where ename like 'S%' or ename like 'M%'; 
--�̸��� S�� �����ϴ� ��� �߿� sal�� 2000 �̻��� ��� ��ȸ
select ename,sal from emp where ename like 'S%' and sal >= 2000;

--MGR�� 7902,7788,7566�� �ƴ� ����� ��ȸ
select ename,sal,mgr from emp where mgr not in ('7902','7788','7566');

--comm, comm+1000�� ��� ���
select comm, comm+1000 from emp; --null�� ���� ���ص� ����� null

--�Լ� �� NVL(�÷���, ���� ��� �ʱⰪ), MYSQL�� ifnull�̴�.
select NVL(comm, 0), NVL(comm, 0)+1000 from emp; --null�� ��� 0���� ��� �Ǵ� ���

--���� sql���� �÷������� �߰��Ͽ� �ϼ��Ͻÿ� "comm", "comm2"
select NVL(comm, 0) COMM, NVL(comm, 0)+1000 COMM2 from emp; --�Ӽ��� ���ϴ� ��� ����

--SAL�� 2000~3000�� �ƴ� ��� ��ȸ, �ΰ��� ������� �غ���
select ename,sal from emp where sal < 2000 or sal > 3000;
select ename,sal from emp where sal not between 2000 and 3000;

--GROUP�Լ� (count, max, min, avg, sum)
select count(*) from emp;--��ü �ο���
select max(sal) from emp;--�ְ���
select min(sal) from emp;--�ּҿ���
select sum(sal) from emp;--sal�� �հ�
select avg(sal) from emp;--sal�� ���

--avg�� �Ҽ��� ���ϰ� ���� ������ ��찡 ���Ƽ� round,cell,floor��� ���� ���� ���
--����� �Ҽ��� ���� ���ڸ������� ������ �ϱ�
select round(avg(sal),2) from emp;--2073.21 �ݿø�
select ceil(avg(sal)) from emp; --������ �ø� ceil : õ��
select floor(avg(sal)) from emp;--������ ����

--PPT 57page group by ��
--job�� �׷����� �� ������ �ο��� ���غ���
select job ����,count(*) �ο��� from emp group by job;--job�� �������� group by �ϰڴ�.

--���� ����� ������ ������������ ���
select job ����,count(*) �ο��� from emp group by job order by ����;--�÷������� �������ϱ�
select job ����,count(*) �ο��� from emp group by job order by 1;--�÷���ȣ�� �������ϱ�

--���� ����� �ο����� �������� ���
select job ����,count(*) �ο��� from emp group by job order by �ο���;--�ο����� �������ϱ�
select job ����,count(*) �ο��� from emp group by job order by 2; --2�� �Ӽ� �������� �������ϰڴ�
select job ����,count(*) �ο��� from emp group by job order by �ο��� desc;--�ο����� �������ϱ� ��������

--������ �ο����� �ְ���, ��������, ��տ���(������ �ø�)�� ���غ��ÿ�.
select job ����,count(*) �ο���,max(sal) �ְ���,min(sal) ��������, ceil(avg(sal)) ��տ��� from emp group by job;

--having�� group������ �׷��Լ��� �̿��ؼ� ������ ��Ÿ�� ���
--������ �ο����� �ְ� ������ ���ϴµ� ������ �ο����� 3�� �̻��� ��츸 ��ȸ�� �Ͻÿ�
select job, count(*), max(sal) from emp group by job having count(job) >= 3;

--����Ŭ������ ���� ��¥�� ���� �� SYSDATE, MYSQL�� NOW()
select sysdate from dual;--���� �ֿܼ� ���� ��¥ ���
--3�ϵ�
select sysdate+3 from dual;--���� ��¥ ���ϱ� 3��
--30dlfenl
select sysdate+30 from dual;--���� ��¥ ���ϱ� 30��

--��¥ Ÿ���� ���ڿ��� ��ȯ to_char : ��ȣ y,m,d,hh, hh24, mi, ss,am,pm��
select to_char(sysdate, 'yyyy') from dual;
select to_char(sysdate, 'year') from dual; --�����ڷ� ǥ��
select to_char(sysdate, 'mm') from dual;
select to_char(sysdate, 'month') from dual; --�������� ���� ����

--��ȣ�� ���� ���µ� �پ��� ��ȣ�� ��¥�� ����غ���
select to_char(sysdate, 'yyyy-mm-dd') from dual;
select to_char(sysdate, 'yyyy-mm-dd hh:mi')from dual;
select to_char(sysdate, 'yyyy-mm-dd am hh:mi')from dual;--am �Ǵ� pm���� �ڵ����� ������
select to_char(sysdate, 'yyyy-mm-dd hh24:mi')from dual;

--emp���� hiredate(��¥Ÿ��)�� �̿��ؼ� ����غ���
select ename,to_char(hiredate, 'yyyy-mm-dd') HIREDATE from emp;

--���⵵�� 1987���� ��� ��� 
select * from emp where to_char(hiredate,'yyyy')='1987';
select * from emp where to_char(hiredate,'yyyy')=1987;
select ename,to_char(hiredate,'yyyy')HIREYEAR from emp where to_char(hiredate,'yyyy')=1987;

--������ 5���� ��� ���
select * from emp where to_char(hiredate,'mm')='05';
select * from emp where to_char(hiredate,'mm')=05;
select * from emp where to_char(hiredate,'mm')=5;

--SUBQUERY(select �� �ȿ� �� select ���� �ִ� ���)
--SCOTT�� ������ ���� ������ ���� ����� ���Ͻÿ�
select * from emp where sal=(select sal from emp where ename='SCOTT') and not ename='SCOTT';

--��տ������� ���� �޴� ����� ���� ���
select * from emp where sal>(select avg(sal) from emp);








