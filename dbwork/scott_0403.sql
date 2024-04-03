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