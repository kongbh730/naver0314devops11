--카페에서 scott_table을 다운받아 naver0314에 넣은 후 
--cmd 창에서 naver0314 폴더로 이동 후 (cd naver0314)
--sqlplus로 scott계정으로 접속 후
--@scott_table 엔터
--자동으로 안에 있는 sql명령어가 실행
select *from tab; -- 생성된 테이블 확인
select *from emp; --emp테이블의 연습용 데이터 확인
commit; --추가된 데이터 커밋, 커밋 안할 시 추가된 데이타가 취소됨