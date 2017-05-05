create table t_board(
board_id INT PRIMARY KEY auto_increment COMMENT '论坛版块ID',
board_name VARCHAR(150) NOT NULL default '' COMMENT '论坛版块名',
board_desc VARCHAR(255) DEFAULT NULL COMMENT '论坛版块描述',
topic_name INT NOT NULL default '0' COMMENT '帖子数目'
)ENGINE = InnoDB AUTO_INCREMENT = 9 DEFAULT CHARSET = utf-8;

CREATE TABLE t_post(
post_id INT PRIMARY KEY auto_increment COMMENT '帖子ID',
board_id int NOT NULL default 0 COMMENT '论坛ID',
topic_id INT NOT NULL default 0 COMMENT '话题ID',
user_id INT NOT NULL DEFAULT 0 COMMENT '发表者ID', 
post_type TINYINT not NULL DEFAULT 2 COMMENT '帖子类型 1:主题帖 2：回复贴',
post_title varchar(50) not NULL COMMENT '帖子标题',
post_text text not NULL COMMENT '帖子内容',
create_time datetime NOT NULL COMMENT '创建时间'
)ENGINE = InnoDB AUTO_INCREMENT = 25 DEFAULT CHARSET = utf-8 COMMENT '帖子';
