-- ��������(system������ ����) : ������ ctrl+enter
 create user angel identified by a1234; --�����߻�
 
 -- �ֽŹ��������� �տ� ���빮�� c##�� �ٿ��� ���Ļ����� �ؾ߸� �Ѵ�.
 create user c##angel identified by a1234; 
 
 --system ������ ������ ���� Ȯ���ϱ�
 select username from dba_users;
 
 --c##angel ���� �����ϱ�
 drop user c##angel;
 
 --c## ���빮�ڸ� �Ⱥ��̰� ���������� �Ϸ��� ���Ǻ����� �ؾ߸� �Ѵ�.
 alter session set "_ORACLE_SCRIPT"=true;
 
 --angel ���� �����(��� a1234)
 create user angel identified by a1234;
 
 