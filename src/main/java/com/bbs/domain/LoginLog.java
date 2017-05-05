package com.bbs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 登陆信息
 * @author John
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//设置缓存策略
@Table(name = "t_login_log")
public class LoginLog extends BaseDomain {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	/*
	 * 日志Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="login_id")
	private int logId;
	/*
	 * 发表者Id
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	/*
	 * 登录Ip
	 */
	@Column(name = "ip")
	private String ip;
	/*
	 * 登录时间
	 */
	@Column(name = "login_datetime")
	private Date loginDatetime;
	
	public LoginLog(){
		
	}

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginDatetime() {
		return loginDatetime;
	}

	public void setLoginDatetime(Date loginDatetime) {
		this.loginDatetime = loginDatetime;
	}
	
	

}
