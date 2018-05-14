create sequence seq_users_no
  start with 1
  increment by 1
  nocache ;

create sequence seq_category_no
  start with 1
  increment by 1
  nocache ;

create sequence seq_post_no
  start with 1
  increment by 1
  nocache ;

create sequence seq_comments_no
  start with 1
  increment by 1
  nocache ;

create table users(
  userno number primary key ,
  id varchar2(50) not null unique ,
  username varchar2(100) not null ,
  password varchar2(50) not null ,
  joindate date not null
);

create table blog(
  id varchar2(50) primary key,
  blogtitle varchar2(200) not null ,
  logofile varchar2(200) not null ,
  foreign key (id) references users(id)
);

create table category(
  cateno number primary key ,
  id varchar2(250) not null ,
  catename varchar2(200) not null ,
  description varchar2(500),
  regdate date not null ,
 foreign key (id) references blog(id)
);

create table post(
  postno number primary key ,
  cateno number not null ,
  posttitle varchar2(300) not null ,
  postcontent varchar2(4000),
  regdate date not null ,
  foreign key (cateno) references category(cateno)
);

create table comments(
  cmtno number primary key ,
  postno number not null ,
  userno number not null ,
  cmtcontent varchar2(1000) not null ,
  regdate date not null ,
  foreign key (postno) references post(postno),
  foreign key (userno) references users(userno)
);