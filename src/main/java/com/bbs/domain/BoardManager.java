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
 * �û��Ͱ��Ĺ���ʵ��
 * @author John
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//���û������
@Table(name = "t_board_manager")
public class BoardManager extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ���id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//�������ɲ���
	@Column(name ="board_id")
	private int boardId;
	/*
	 * �û�Id
	 */
	@Column(name ="user_id")
	private int user_id;
	
	public BoardManager(){
		
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
}
