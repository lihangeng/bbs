package com.bbs.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.BoardDao;
import com.bbs.dao.LoginLogDao;
import com.bbs.dao.PostDao;
import com.bbs.dao.TopicDao;
import com.bbs.domain.Board;
import com.bbs.domain.MainPost;
import com.bbs.domain.Post;
import com.bbs.domain.Topic;
/**
 * 论坛业务层
 * @author John
 *
 */
@Service
public class ForumService {

	@Autowired
	private PostDao postDap;
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private LoginLogDao loginLogDao;
	/**
	 *发表一个主题帖，用户积分加10，论坛版块主题帖数目加1
	 * @param topic
	 */
	public void addTopic(Topic topic){
		Board board = boardDao.get(topic.getBoardId());
		board.setTopicNum(board.getTopicNum()+1);
		boardDao.save(board);
		
		topic.getMainPost().setTopic(topic);
		MainPost mainPost = topic.getMainPost();
		mainPost.setCreateTime(new Date());
		mainPost.setUser(topic.getUser());
	}
	/**
	 * 删除一个主题帖，用户积分减去50，论坛版块主题帖减去1
	 * @param topicId
	 */
	public void removeTopic(int topicId){
		
	}
	/**
	 * 
	 * @param post
	 */
	public void addPost(Post post){

	}
	
	public void removePost(int postId){
		
		
	}
	
}
