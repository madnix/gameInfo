create table com(
no number(38) primary key
, bbsname varchar2(50)not null
, bbsno number(38)not null
, nickname varchar2(50)not null
, com varchar2(4000)not null
, pwd varchar(5)
, regdate date
);
create sequence com_seq increment by 1 start with 1;