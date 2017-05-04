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
	 * ��ȡ��̳���ĳһҳ�ľ������������������ظ�ʱ���Լ���������������
	 * @param boardId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getBoardDigestTopics(int boardId,int pageNo,int pageSize){
		return pagedQuery(GET_BOARD_DIGEST_TOPIC_HQL,pageNo,pageSize,boardId);
	}
	/**
	 * ��ȡ��̳ĳһҳ���������
	 * @param boardId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getPagedTopics(int boardId,int pageNo,int pageSize){
		return pagedQuery(GET_PAGED_TOPICS,pageNo,pageSize,boardId);
	}
	/**
	 * ��ȡ������������ģ��ƥ�����������ĳһҳ�����ݣ�
	 * @param boardId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getPagedTopicByTitle(int boardId,int pageNo,int pageSize){
		return pagedQuery(QUERY_TOPIC_BY_TITLE,pageNo,pageSize,boardId);
	}

}
