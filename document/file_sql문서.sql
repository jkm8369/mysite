create table file(
	file_no		int				primary key			auto_increment,
	org_name	varchar(200),
    ex_name		varchar(200),
    save_name  	varchar(200),
    file_path	varchar(200),
    file_size 	long
);

drop table file;

select	file_no 	fileNo,
	    org_name 	orgName,
	    ex_name		exName,
        save_name	saveName,
        file_path	filePath,
        file_size	fileSize
from file
;

insert into file 
values(null,'ddd','ccc','bbb','aaa',123)
;
