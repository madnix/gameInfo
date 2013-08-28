create table info_pc(
no number(38) primary key
, title varchar2(100) not null
, nickname varchar2(100) not null
, main_file varchar2(100)
, sub_file1 varchar2(100)
, sub_file2 varchar2(100)
, sub_file3 varchar2(100)
, sub_file4 varchar2(100)
, sub_file5 varchar2(100)
, sub_file6 varchar2(100)
, sub_file7 varchar2(100)
, sub_file8 varchar2(100)
, sub_file9 varchar2(100)
, sub_file10 varchar2(100)
, sub_mfile varchar2(100)
, pwd varchar2(5)
, read_count number(5) default 0
, recom number(5) default 0
, reply_count number(10) default 0
, cont varchar2(4000) not null
, regdate date
);

create sequence info_pc_seq increment by 1 start with 1;