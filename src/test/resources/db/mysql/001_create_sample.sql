create table t_board(
board_id INT PRIMARY KEY auto_increment COMMENT '��̳���ID',
board_name VARCHAR(150) NOT NULL default '' COMMENT '��̳�����',
board_desc VARCHAR(255) DEFAULT NULL COMMENT '��̳�������',
topic_name INT NOT NULL default '0' COMMENT '������Ŀ'
)ENGINE = InnoDB AUTO_INCREMENT = 9 DEFAULT CHARSET = utf-8;

CREATE TABLE t_post(
post_id INT PRIMARY KEY auto_increment COMMENT '����ID',
board_id int NOT NULL default 0 COMMENT '��̳ID',
topic_id INT NOT NULL default 0 COMMENT '����ID',
user_id INT NOT NULL DEFAULT 0 COMMENT '������ID', 
post_type TINYINT not NULL DEFAULT 2 COMMENT '�������� 1:������ 2���ظ���',
post_title varchar(50) not NULL COMMENT '���ӱ���',
post_text text not NULL COMMENT '��������',
create_time datetime NOT NULL COMMENT '����ʱ��'
)ENGINE = InnoDB AUTO_INCREMENT = 25 DEFAULT CHARSET = utf-8 COMMENT '����';
