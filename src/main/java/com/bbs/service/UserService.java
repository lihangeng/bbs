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
 * �û�
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	
	/**
	 * ע��һ�����û�
	 * @param user
	 * @throws UserExistException
	 */
	public void register(User user) throws UserExistException{
		User u = this.getUserByUserName(user.getUserName());
		if(u!=null){
			throw new UserExistException("�û����Ѿ�����");
		}else{
			user.setCredit(100);
			user.setUserType(1);
			userDao.save(user);
		}
		
	}
	/**
	 * �����û�������ʵ��
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName){
		return userDao.getUserByName(userName);
	}
	/**
	 * �����û�Id�����û�ʵ��
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId){
		return userDao.get(userId);
	}
	/**
	 * �����û����û����ܵ�¼
	 * @param userName
	 */
	public void lockUser(String userName){
		User user = userDao.getUserByName(userName);
		user.setLocked(User.USER_LOCK);
		userDao.update(user);
	}
	/**
	 * ����û�������
	 * @param userName
	 */
	public void unlockUser(String userName){
		User user = userDao.getUserByName(userName);
		user.setLocked(User.USER_UNLOCK);
		userDao.update(user);
	}
	/**
	 * �����û���ģ����ѯ
	 * @param userName
	 * @return
	 */
	public List<User> queryUserByUserName(String userName){
		return null;
//		return userDao.queryUserByUserName();
		
	}
	/**
	 * ��¼�ɹ����û����ּ�5������¼��־
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
