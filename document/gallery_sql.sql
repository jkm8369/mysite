create table gallery(
	no			int					primary key		auto_increment		comment '글번호',
    user_no		int					comment '회원식별번호',
    content		varchar(1000)		comment '글 내용',
    file_path	varchar(500)		comment '파일경로',
    org_name	varchar(200)		comment '오리지날 파일명',
    save_name	varchar(500) 		comment '저장파일명',
    file_size	int				comment	'파일사이즈',
    CONSTRAINT gallery_fk
    FOREIGN KEY (user_no) REFERENCES users(no)
);

drop table gallery;

insert into gallery
values(null, '', '', '', '', '')
;

show tables;

select *
from users
;

select *
from gallery
;
-- 전체 리스트 조회
select g.no,
	   g.user_no userNo,
       u.name userName,
       g.content,
       g.file_path 	filePath,
       g.org_name 	orgName,
       g.save_name 	saveName,
       g.file_size 	fileSize
from gallery g, users u
where g.user_no = u.no
order by g.no desc
;


select no,
	   user_no userNo,
       content,
       file_path filePath,
       org_name orgName,
       save_name saveName,
       file_size fileSize
from gallery
order by no desc
;

select	no,
		user_no,
		content,
		file_path,
		org_name,
		save_name,
		file_size
from gallery
order by no desc
;

select * from file;