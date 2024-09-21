-- 코드를 입력하세요
select COUNT(AGE) as USERS
from USER_INFO 
where 20 <= AGE AND AGE <= 29 AND JOINED LIKE "2021%";