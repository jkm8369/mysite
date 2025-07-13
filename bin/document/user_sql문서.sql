show databases;

show tables;

create table users(
	no 			int				primary key		auto_increment,
    id 			varchar(20)		unique			not null,
    password 	varchar(20)		not null,
    name		varchar(20),
    gender		varchar(10)		
);

insert into users
values(null, 'aaa', '123', '정우성', 'male');

select no,
	   id,
       password,
       name,
       gender
from users
;

-- 로그인 (세션)
select no,
       name,
       gender
from users
where id = 'jkm'
and password = 'rkdals'
;

-- 회원정보 수정 폼
select no,
       id,
       password,
       name,
       gender
from users
where no = 5
;

-- 회원정보 수정
update users
set name = '이효리',
	password = 'abc',
    gender = 'female'
where no = 8
;