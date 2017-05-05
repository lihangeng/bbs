package com.bbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 论坛版块
 * @author John
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//设置缓存策略
@Table(name = "t_board")
public class Board extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
	@Column(name ="board_id")
	private int boardId;
	/*
	 * 论坛版块名称
	 */
	@Column(name = "board_name")
	private String boardName;
	/*
	 * 论坛版块描述
	 */
	@Column(name = "board_desc")
	private String boardDesc;
	/*
	 * 话题名个数
	 */
	@Column(name = "topic_num")
	private int topicNum;
	
	public Board(){
		
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardDesc() {
		return boardDesc;
	}

	public void setBoardDesc(String boardDesc) {
		this.boardDesc = boardDesc;
	}

	public int getTopicNum() {
		return topicNum;
	}

	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}
	
	

}
