package com.bbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 用户
 * @author John
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//设置缓存策略
@Table(name = "t_user")
public class User extends BaseDomain {
	public static final int USER_LOCK = 1;
	public static final int USER_UNLOCK = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
	@Column(name ="user_id")
	private int userId;
	/*
	 * 用户名
	 */
	@Column(name ="user_name")
	private String userName;
	/*
	 * 用户密码
	 */
	@Column(name ="password")
	private String password;
	/*
	 * 用户类型
	 * 1:普通用户 2：管理员
	 */
	@Column(name ="user_type")
	private int userType;
	/*
	 * 用户是否被锁
	 * 0：未锁定 1：锁定
	 */
	@Column(name ="locked")
	private int locked;
	/*
	 * 用户积分
	 */
	@Column(name ="credit")
	private int credit;
	
	@Transient
	private String userIp;
	/**
	 * 空构造函数，用于hibernate创建实例对象
	 */
	public User(){
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

}
