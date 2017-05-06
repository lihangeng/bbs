package com.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import com.bbs.cons.CommonConstant;
import com.bbs.domain.User;
/**
 * 基础控制层
 * @author John
 *
 */
public class BaseController {
	
	protected static final String ERROR_MSG_KEY = "errorMsg";
	/**
	 * 获取session中的user对象
	 * @param request
	 * @return
	 */
	protected User getSessionUser(HttpServletRequest request){
		return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}
	/**
	 * 将用户对对象保存在session中
	 */
	protected void setSessionUser(HttpServletRequest request,User user){
		request.setAttribute(CommonConstant.USER_CONTEXT, user);
	}

	/**
	 * 获取基于应用程序的url绝对路径
	 * @param request
	 * @param url
	 * @return
	 */
	public final String getAppbaseUrl(HttpServletRequest request,String url){
		return url;
		
	}
}
