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
 * 论坛登录验证过滤器,需要在web.xml中配置
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

		//判断是不是最后一个过滤链
        if(request != null && request.getAttribute(FILTERED_REQUEST) != null ){
        	chain.doFilter(request, response);
		}else{
			//设置过滤标示，防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			User userContext = getSessionUser(httpRequest);
			//用户未登录，且当前URL资源需要登录才能访问
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
	 * 判断当前Url是不是要登录才能访问
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
