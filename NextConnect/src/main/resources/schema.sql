drop table if exists users;
drop table if exists posts;
drop table if exists like_details;
drop table if exists post_comments;
drop table if exists followers;

drop sequence if exists following_seq;
drop sequence if exists comment_seq;
drop sequence if exists post_seq;

create table users(USER_ID INT,       
EMAIL_ID           VARCHAR(200),
IMAGE_URL          VARCHAR(4000),
USER_NAME          VARCHAR(200));

create table posts(POST_ID       NUMBER,     
POSTED_BY              NUMBER  references users(user_id),
POST_CONTENT           VARCHAR(3000),
NUM_LIKES              NUMBER,
CREATION_DATE          TIMESTAMP(6),
STATUS                 VARCHAR(2) );

create table like_details(
POST_ID  NUMBER references posts(post_id),
LIKED_BY  NUMBER references users(user_id));


create table post_comments (
POST_ID               NUMBER  references posts(post_id),    
COMMENT_ID            NUMBER      ,
COMMENT_CONTENT       NCLOB       ,
STATUS                VARCHAR(1) ,
COMMENT_BY            NUMBER references users(user_id));

create table followers(
	USER_ID            NUMBER references users(user_id),
FOLLOWING             NUMBER references users(user_id),
RELATIONSHIP_ID       NUMBER);

create table msg_tokens(
user_id number references users(user_id),
token varchar(2000)
);

create sequence following_seq start with 1 increment by 5;
create sequence comment_seq start with 1 increment by 5;
create sequence post_seq start with 1 increment by 5;
