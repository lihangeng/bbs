package com.bbs.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Entity;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//���û������
@Table(name = "t_login_log")
public class LoginLog extends BaseDomain {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	/*
	 * ��־Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="login_id")
	private int logId;
	/*
	 * ������Id
	 */
	@Column(name = "user_id")
	private int user_id;
	/*
	 * ��¼Ip
	 */
	@Column(name = "ip")
	private String ip;
	/*
	 * ��¼ʱ��
	 */
	@Column(name = "login_datetime")
	private String loginDatetime;
	
	public LoginLog(){
		
	}

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLoginDatetime() {
		return loginDatetime;
	}

	public void setLoginDatetime(String loginDatetime) {
		this.loginDatetime = loginDatetime;
	}
	
	

}
