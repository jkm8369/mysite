create table gallery(
	no			int					primary key		auto_increment		comment '글번호',
    user_no		int					comment '회원식별번호',
    content		varchar(1000)		comment '글 내용',
    file_path	varchar(500)		comment '파일경로',
    org_name	varchar(200)		comment '오리지날 파일명',
    save_name	varchar(500) 		comment '저장파일명',
    file_size	int					comment	'파일사이즈',
    CONSTRAINT gallery_fk
    FOREIGN KEY (user_no) 
    REFERENCES users(no)
);

show tables;

select *
from users
;

select no,
	   user_no userNo,
       content,
       file_path 	filePath,
       org_name 	orgName,
       save_name 	saveName,
       file_size 	fileSize
from gallery
;