package com.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import com.bbs.cons.CommonConstant;
import com.bbs.domain.User;
/**
 * �������Ʋ�
 * @author John
 *
 */
public class BaseController {
	
	protected static final String ERROR_MSG_KEY = "errorMsg";
	/**
	 * ��ȡsession�е�user����
	 * @param request
	 * @return
	 */
	protected User getSessionUser(HttpServletRequest request){
		return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}
	/**
	 * ���û��Զ��󱣴���session��
	 */
	protected void setSessionUser(HttpServletRequest request,User user){
		request.setAttribute(CommonConstant.USER_CONTEXT, user);
	}

	/**
	 * ��ȡ����Ӧ�ó����url����·��
	 * @param request
	 * @param url
	 * @return
	 */
	public final String getAppbaseUrl(HttpServletRequest request,String url){
		return url;
		
	}
}
