-- 문제 : 아래의 결과를 자바파일로 실행해서 출력되도록 하세요
select 
	buseo, count(*) inwon, max(score) maxscore, ceiling(avg(score)) avgscore
from sawon 
group by buseo;
                
-- shop과 cart join
select 
	cartnum, 
    username,
    sangpum, 
    price, 
    color, 
    date_format(guipday, '%Y-%m-%d %H : %i')
from shop, cart
where shop.shopnum = cart.shopnum;

-- 방법2
select 
	cartnum, 
    username,
    sangpum, 
    price, 
    color, 
    date_format(guipday, '%Y-%m-%d %H : %i') guipday
from shop
inner join cart
where shop.shopnum = cart.shopnum;

-- '동' 입력시 동이 포함된 이름을 가진 데이터 모두 출력
select * from sawon where name like '%동%';

-- 없을 경우
select * from sawon where name like '%락%';

select * from sawon where name like concat('%','동' ,'%');

select * from sawon;

delete from sawon where name = '차민규';

insert into sawon (name, score, gender, buseo) values ('나나','34','여자','인사부');
