package com.bbs.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Entity;
/**
 * ��̳���
 * @author John
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//���û������
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)//�������ɲ���
	@Column(name ="board_id")
	private int boardId;
	/*
	 * ��̳�������
	 */
	@Column(name = "board_name")
	private String boardName;
	/*
	 * ��̳�������
	 */
	@Column(name = "board_desc")
	private String boardDesc;
	/*
	 * ������
	 */
	@Column(name = "topic_name")
	private int topicNum;

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
