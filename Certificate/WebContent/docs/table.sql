create table s_member(
 mem_id varchar2(20) not null primary key,
 mem_name varchar2(15) not null,
 mem_pw varchar2(15) not null,
 mem_cell varchar2(15),
 mem_email varchar2(50),
 mem_addr varchar2(100),
 mem_register date not null,
 mem_level varchar2(15) default 1 not null
);

create table s_board(
 nb_num number not null primary key,
 nb_subject varchar2(40) not null,
 nb_content clob not null,
 mem_id not null,
 nb_register date not null,
 nb_filename varchar2(20),
 nb_hit number(3) default 0 not null,
 constraint s_board_fk foreign key (mem_id) references s_member(mem_id) 
);

create sequence s_board_seq;

create table iboard_reply(
re_num number  not null,
re_content varchar2(900)  not null,
re_date date  not null,
re_ip varchar2(40) not null,
num number  not null,
id varchar2(12) not null,
constraint iboard_reply_pk primary key (re_num),
constraint iboard_reply_member_fk2 foreign key(id) references s_member (mem_id)
);

create sequence iboard_reply_seq;

create table s_blogboard(
 nb_num number not null primary key,
 nb_subject varchar2(40) not null,
 nb_content clob not null,
 mem_id not null,
 nb_register date not null,
 nb_filename varchar2(20),
 nb_hit number(3) default 0 not null,
 constraint s_blogboard_fk foreign key (mem_id) references s_member(mem_id) 
);

create sequence s_blogboard_seq;

create table s_reviewboard(
 nb_num number not null primary key,
 nb_subject varchar2(40) not null,
 nb_content clob not null,
 mem_id not null,
 nb_register date not null,
 nb_filename varchar2(20),
 nb_hit number(3) default 0 not null,
 constraint s_reviewboard_fk foreign key (mem_id) references s_member(mem_id) 
);

create sequence s_reviewboard_seq;

create table s_seoulboard(
 nb_num number not null primary key,
 nb_subject varchar2(40) not null,
 nb_content clob not null,
 mem_id not null,
 nb_register date not null,
 nb_filename varchar2(20),
 nb_hit number(3) default 0 not null,
 constraint s_seoulboard_fk foreign key (mem_id) references s_member(mem_id) 
);

create sequence s_seoulboard_seq;

--������ 100�� �ֱ� ����--
DECLARE
i number := 1;
BEGIN
   WHILE i <= 100 loop
      INSERT INTO s_board(nb_num, nb_subject, mem_id, nb_content, nb_register)
         VALUES(
                     (SELECT NVL(MAX(nb_num)+1, 1) FROM s_board), '����'||i,
                       'jisoo', '����'||i, '20171210'
                  );
      i := i+1;
   END loop;
END;
