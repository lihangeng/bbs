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
 * ����
 * @author John
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//���û������
@Table(name = "t_topic")
public class Topic extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//�������ɲ���
	@Column(name ="topic_id")
	private int topicId;
	/*
	 * ���Id
	 */
	@Column(name ="board_id")
	private int boardId;
	/*
	 * ���ӱ��⣬���н�������
	 */
	@Column(name ="topic_title")
	private String topicTitle;
	/*
	 * �����û�.���н�������
	 */
	@Column(name ="user_id")
	private int userId;
	/*
	 * ����ʱ��
	 */
	@Column(name ="create_time")
	private String createTime;
	/*
	 * ���ظ�ʱ��
	 */
	@Column(name ="last_post")
	private String lastPost;
	/*
	 * �����
	 */
	@Column(name ="topic_views")
	private int topicViews;
	/*
	 * �ظ���
	 */
	@Column(name ="topic_replies")
	private int topicReplies;
	/*
	 * �ǲ��Ǿ�������
	 */
	@Column(name ="digest")
	private int digest;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastPost() {
		return lastPost;
	}

	public void setLastPost(String lastPost) {
		this.lastPost = lastPost;
	}

	public int getTopicViews() {
		return topicViews;
	}

	public void setTopicViews(int topicViews) {
		this.topicViews = topicViews;
	}

	public int getTopicReplies() {
		return topicReplies;
	}

	public void setTopicReplies(int topicReplies) {
		this.topicReplies = topicReplies;
	}

	public int getDigest() {
		return digest;
	}

	public void setDigest(int digest) {
		this.digest = digest;
	}
	
	

}
