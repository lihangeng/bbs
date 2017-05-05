package com.bbs.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.LoginLogDao;
import com.bbs.dao.UserDao;
import com.bbs.domain.LoginLog;
import com.bbs.domain.User;
import com.bbs.exception.UserExistException;
/**
 * 用户
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	
	/**
	 * 注册一个新用户
	 * @param user
	 * @throws UserExistException
	 */
	public void register(User user) throws UserExistException{
		User u = this.getUserByUserName(user.getUserName());
		if(u!=null){
			throw new UserExistException("用户名已经存在");
		}else{
			user.setCredit(100);
			user.setUserType(1);
			userDao.save(user);
		}
		
	}
	/**
	 * 根据用户名返回实体
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName){
		return userDao.getUserByName(userName);
	}
	/**
	 * 根据用户Id返回用户实体
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId){
		return userDao.get(userId);
	}
	/**
	 * 锁定用户，用户不能登录
	 * @param userName
	 */
	public void lockUser(String userName){
		User user = userDao.getUserByName(userName);
		user.setLocked(User.USER_LOCK);
		userDao.update(user);
	}
	/**
	 * 解除用户的锁定
	 * @param userName
	 */
	public void unlockUser(String userName){
		User user = userDao.getUserByName(userName);
		user.setLocked(User.USER_UNLOCK);
		userDao.update(user);
	}
	/**
	 * 根据用户名模糊查询
	 * @param userName
	 * @return
	 */
	public List<User> queryUserByUserName(String userName){
		return null;
//		return userDao.queryUserByUserName();
		
	}
	/**
	 * 登录成功，用户积分加5，并记录日志
	 * @param user
	 */
	public void loginSuccess(User user){
		user.setCredit(5+user.getCredit());
		LoginLog loginLog = new LoginLog();
		loginLog.setUser(user);
		loginLog.setIp(user.getUserIp());
		loginLog.setLoginDatetime(new Date());
		userDao.save(user);
		loginLogDao.save(loginLog);
	}
	

}
