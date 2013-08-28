create table member(
no number(38) primary key
 , user_id varchar2(20) not null
 , user_pass varchar2(20) not null
 , user_name varchar2(20) not null
 , user_nickname varchar2(50) not null
 , user_birth varchar2(20) not null
 , user_mail varchar2(20)
 , user_maildomain varchar2(20)
 , user_phone1 varchar2(3)not null
 , user_phone2 varchar2(4)not null
 , user_phone3 varchar2(4)not null
 , user_zip1 varchar2(3) not null
 , user_zip2 varchar2(3) not null
 , user_addr1 varchar2(500) not null
 , user_addr2 varchar2(400) not null
 , user_state varchar2(20) default 0
 , user_delcont varchar2(4000)
 , user_regdate date
 , user_deldate date
 );
 
 select * from member;
 create sequence mem_seq increment by 1 start with 1;
 
 insert into member values ('1','madnix','12345','김정엽','매가더짱구','19830524','alex_madnix','@naver.com' 
                ,'010','2870','1238','405','719','인천광역시 남동구 간석3동','두진아파트','admin',0,sysdate,sysdate);
 insert into member values ('2','NExT','12345','매드닉스','짱구','19830527','zzangu20','@naver.com' 
                ,'010','2850','2436','405','719','인천광역시 남동구 간석3동','두진아파트',0,0,sysdate,sysdate);
 insert into member values ('3','kal','12345','도라에몽','영구','19830527','babo','@naver.com' 
                ,'010','2850','2436','405','719','인천광역시 남동구 간석3동','두진아파트',0,0,sysdate,sysdate);
 insert into member values ('4','been','12345','매가더짱구','맹구','19830527','yeonggu','@naver.com' 
                ,'010','2850','2436','405','719','인천광역시 남동구 간석3동','두진아파트',0,0,sysdate,sysdate);