package com.bbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 话题
 * @author John
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//设置缓存策略
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
	@Column(name ="topic_id")
	private int topicId;
	/*
	 * 版块Id
	 */
	@Column(name ="board_id")
	private int boardId;
	/*
	 * 帖子标题，该列建立索引
	 */
	@Column(name ="topic_title")
	private String topicTitle;
	/*
	 * 发表用户.该列建立索引
	 */
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;
	/*
	 * 发表时间
	 */
	@Column(name ="create_time")
	private String createTime;
	/*
	 * 最后回复时间
	 */
	@Column(name ="last_post")
	private String lastPost;
	/*
	 * 浏览数
	 */
	@Column(name ="topic_views")
	private int topicViews;
	/*
	 * 回复数
	 */
	@Column(name ="topic_replies")
	private int topicReplies;
	/*
	 * 是不是精华话题  0:不是经精华帖 1：是精华帖 
	 */
	@Column(name ="digest")
	private int digest;
	
	@Transient
	private MainPost mainPost;
	
	public Topic(){
		
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public MainPost getMainPost() {
		return mainPost;
	}

	public void setMainPost(MainPost mainPost) {
		this.mainPost = mainPost;
	}
	
	

}
