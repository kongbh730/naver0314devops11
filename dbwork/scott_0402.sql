--ī�信�� scott_table�� �ٿ�޾� naver0314�� ���� �� 
--cmd â���� naver0314 ������ �̵� �� (cd naver0314)
--sqlplus�� scott�������� ���� ��
--@scott_table ����
--�ڵ����� �ȿ� �ִ� sql��ɾ ����
select *from tab; -- ������ ���̺� Ȯ��
select *from emp; --emp���̺��� ������ ������ Ȯ��
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










