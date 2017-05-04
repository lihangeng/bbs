package com.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void register(User user){
		
		
	}
	
	public User getUserByUserName(){
		return null;
		
	}
	

}
