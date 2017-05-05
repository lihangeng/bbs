create database bbs;
use bbs;

create table t_board(
board_id INT auto_increment PRIMARY KEY,
board_name VARCHAR(150) NOT NULL,
board_desc VARCHAR(255) DEFAULT NULL,
topic_num INT NOT NULL
)ENGINE = InnoDB DEFAULT CHARSET = UTF8;

create table t_board_manager(
board_id int auto_increment PRIMARY KEY,
user_id int
)ENGINE = InnoDB DEFAULT CHARSET = UTF8;

create table t_topic(
topic_id INT auto_increment PRIMARY KEY,
board_id INT NOT NULL,
topic_title varchar(100) NOT NULL,
user_id INT NOT NULL,
create_time datetime NOT NULL,
last_post datetime NOT NULL,
topic_views INT NOT NULL,
topic_replies INT NOT NULL,
digest INT NOT NULL
)ENGINE = InnoDB DEFAULT CHARSET = UTF8;

CREATE TABLE t_post(
post_id INT auto_increment PRIMARY KEY,
board_id int NOT NULL default 0,
topic_id INT NOT NULL default 0,
user_id INT NOT NULL DEFAULT 0,
post_type TINYINT not NULL DEFAULT 2,
post_title varchar(50) not NULL,
post_text text not NULL,
create_time datetime NOT NULL
)ENGINE = InnoDB DEFAULT CHARSET = UTF8;

CREATE TABLE t_user(
user_id INT auto_increment PRIMARY KEY,
user_name VARCHAR(30) NOT NULL,
password varchar(30) NOT NULL,
user_type TINYINT NOT NULL,
locked TINYINT NOT NULL,
credit INT
)ENGINE = InnoDB DEFAULT CHARSET = UTF8;

CREATE TABLE t_login_log(
login_log_id int auto_increment PRIMARY KEY,
user_id INT not NULL,
ip VARCHAR(30) NOT NULL,
login_datetime datetime not null
)ENGINE = InnoDB DEFAULT CHARSET = UTF8;

INSERT INTO t_user values(2,'admin',1234,2,0,0);

