package com.bbs.dao;

import org.springframework.stereotype.Repository;

import com.bbs.domain.User;
/**
 * 
 * @author John
 *
 */
@Repository
public class UserDao extends BaseDao<User> {
	
	String queryString = "from User where userName = ?";

	/**
	 * �����û����õ��û�ʵ��
	 * @param userName
	 * @return
	 */
	public User getUserByName(String userName){
		User user = (User) getHibernateTempate().find(queryString, userName).get(0);
		return user;
	}
}
