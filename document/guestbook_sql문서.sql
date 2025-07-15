/***************************************************
			web 계정에서 사용 - guestbook
***************************************************/
-- web_db 사용
use web_db;

-- 테이블 목록 조회
show tables;

-- 테이블 삭제
drop table guestbook;

-- guestbook(방명록) 테이블 생성
create table guestbook(
	no			int				primary key 		auto_increment,
    name  		varchar(50)		not null,
    password	varchar(50),
    content		varchar(200),
    reg_date	varchar(100)
    
);

select * from guestbook;

insert into guestbook 
values(null, '강호동', '123123', '무르팍', now());

select no,
	   id,
       name,
       gender
from users
where id = 'aaa'
;
/*
1이면 이미지사용중인 아이디
0 사용가능한 아이디
*/

select * from users;

show tables;

select no,
	   name,
       password,
       content,
       reg_date regDateguestbookguestbook
from guestbook
order by no desc
;