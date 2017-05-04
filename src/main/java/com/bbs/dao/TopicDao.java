package com.bbs.dao;

import org.springframework.stereotype.Repository;

import com.bbs.domain.Topic;
/**
 * 
 * @author John
 *
 */
@Repository
public class TopicDao extends BaseDao<Topic> {
	private final String GET_BOARD_DIGEST_TOPIC_HQL = "from Topic t where t.boardId = ?"
			+ " and digest > 0 order by t.lastPost desc,digest desc";
	private final String GET_PAGED_TOPICS ="from Topic where boardId = ?"
			+ " order by lastPost";
	private final String QUERY_TOPIC_BY_TITLE = "from Topic where topicTitle like ?"
			+ "order by lastPost desc";
	
	/**
	 * 获取论坛版块某一页的精华主题帖，按照最后回复时间以及精华级别降序排列
	 * @param boardId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getBoardDigestTopics(int boardId,int pageNo,int pageSize){
		return pagedQuery(GET_BOARD_DIGEST_TOPIC_HQL,pageNo,pageSize,boardId);
	}
	/**
	 * 获取论坛某一页主题的帖子
	 * @param boardId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getPagedTopics(int boardId,int pageNo,int pageSize){
		return pagedQuery(GET_PAGED_TOPICS,pageNo,pageSize,boardId);
	}
	/**
	 * 获取和主题帖标题模糊匹配的主题帖（某一页的数据）
	 * @param boardId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getPagedTopicByTitle(int boardId,int pageNo,int pageSize){
		return pagedQuery(QUERY_TOPIC_BY_TITLE,pageNo,pageSize,boardId);
	}

}
