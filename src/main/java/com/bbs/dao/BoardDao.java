package com.bbs.dao;

import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.bbs.domain.Board;
/**
 * 论坛版块的DAO
 * @author John
 *
 */
@Repository
public class BoardDao extends BaseDao<Board> {

	protected final String GET_BOARD_NUM = "select count(f.board) from Board";
	/**
	 * 获取论坛版块的数目
	 * @return
	 */
	public long getBoardNum(){
		Iterator it = getHibernateTempate().iterate(GET_BOARD_NUM);
		return (Long)it.next();
	}
	
}
