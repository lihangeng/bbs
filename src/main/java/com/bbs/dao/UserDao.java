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
	 * 根据用户名得到用户实体
	 * @param userName
	 * @return
	 */
	public User getUserByName(String userName){
		if(getHibernateTempate().find(queryString, userName).size()>0){
			User user = (User) getHibernateTempate().find(queryString, userName).get(0);
			return user;
		}
		return null;
		
		
	}
}
