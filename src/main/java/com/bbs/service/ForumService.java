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
 * ��̳ҵ���
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
	 *����һ�����������û����ּ�10����̳�����������Ŀ��1
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
	 * ɾ��һ�����������û����ּ�ȥ50����̳�����������ȥ1
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
