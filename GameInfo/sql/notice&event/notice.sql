create table notice(
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
, recom number(5) default 0
, read_count number(10) default 0
, reply_count number(10) default 0
, cont varchar2(4000) not null
, regdate date
);

create sequence notice_seq increment by 1 start with 1;

insert into notice values(notice_seq.nextval,'�쇱씠�⑤컻議몃씪 �대젮���뗣뀑�뗣뀑�뗣뀑�뗣뀑�뗣뀑','愿�━��,0,0,0,0,0,0,0,0,0,0,0,1234,0,0,0,'移댁뭅移댁뭅移댁뭅移댁뭅移댁뭅移�,sysdate,0);


		select no,	title, regdate , r
		from (
		select row_number() over(order by no desc) as r ,
		no,	title, regdate
		from notice)
		where r between 2 and 5;