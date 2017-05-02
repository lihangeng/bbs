package com.bbs.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Entity;
/**
 * �û�
 * @author John
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//���û������
@Table(name = "t_user")
public class User extends BaseDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//�������ɲ���
	@Column(name ="user_id")
	private int userId;
	/*
	 * �û���
	 */
	@Column(name ="user_name")
	private String userName;
	/*
	 * �û�����
	 */
	@Column(name ="password")
	private String password;
	/*
	 * �û�����
	 */
	@Column(name ="user_type")
	private int userType;
	/*
	 * �û��Ƿ���
	 */
	@Column(name ="locked")
	private int locked;
	/*
	 * �û�����
	 */
	@Column(name ="credit")
	private int credit;
	/**
	 * �չ��캯��������hibernate����ʵ������
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
	

	

}
