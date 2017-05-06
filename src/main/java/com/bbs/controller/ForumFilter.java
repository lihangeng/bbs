package com.bbs.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.bbs.cons.CommonConstant;
import com.bbs.domain.User;
/**
 * 
 * ��̳��¼��֤������,��Ҫ��web.xml������
 * @author John
 *
 */
public class ForumFilter implements Filter {
	
	private static final String FILTERED_REQUEST = "@ @Session_context_filtered_request";
	
	private static final String[] INHERENT_ESCAPE_URLS={"/index.jsp","/index.html","/login.jsp",
			"/register.jsp"};

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		//�ж��ǲ������һ��������
        if(request != null && request.getAttribute(FILTERED_REQUEST) != null ){
        	chain.doFilter(request, response);
		}else{
			//���ù��˱�ʾ����ֹһ�������ι���
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			User userContext = getSessionUser(httpRequest);
			//�û�δ��¼���ҵ�ǰURL��Դ��Ҫ��¼���ܷ���
			if(userContext == null && isURLLogin(httpRequest.getRequestURL().toString(),httpRequest)){
				String toUrl = httpRequest.getRequestURI().toString();
				if(!StringUtils.isEmpty(httpRequest.getQueryString())){
					toUrl += "?"+httpRequest.getQueryString();
				}
				httpRequest.getSession().setAttribute(CommonConstant.LOGIN_TO_URL, toUrl);
			}
			
		}
		
	}

	private User getSessionUser(HttpServletRequest httpRequest) {
		return (User) httpRequest.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}
	
	/**
	 * �жϵ�ǰUrl�ǲ���Ҫ��¼���ܷ���
	 * @param requestURL
	 * @param request
	 * @return
	 */
	private boolean isURLLogin(String requestURL,HttpServletRequest request){
		
		if(request.getContextPath().equalsIgnoreCase(requestURL) ||
				(request.getContextPath()+"/").equalsIgnoreCase(requestURL)){
			return true;
		 }
		for(String url:INHERENT_ESCAPE_URLS){
			if(requestURL != null && requestURL.indexOf(url)>=0){
				return true;
			}
		}
		return false;
		
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
