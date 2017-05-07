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
 * 论坛登录验证过滤器,需要在web.xml中配置，如果有多个filter则按照早web.xml文件中配置的顺序进行
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

		//判断是否被这个过滤器所过滤，如果已经被过滤则交个下一个过滤器
        if(request != null && request.getAttribute(FILTERED_REQUEST) != null ){
        	chain.doFilter(request, response);
		}else{
			//设置过滤标示，防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			User userContext = getSessionUser(httpRequest);
			//用户未登录，且当前URL资源需要登录才能访问
			if(userContext == null && !isURLLogin(httpRequest.getRequestURI().toString(),httpRequest)){
				String toUrl = httpRequest.getRequestURI().toString();
				if(!StringUtils.isEmpty(httpRequest.getQueryString())){
					toUrl += "?"+httpRequest.getQueryString();
				}
				//将用户请求的url保存在Session中，用于登录之后，跳转到目标URL
				httpRequest.getSession().setAttribute(CommonConstant.LOGIN_TO_URL, toUrl);
				//转发到登录页面
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
			chain.doFilter(request, response);
		}
		
	}

	//getContextPath是返回的项目上下文的名字（其实也就是项目名）；

    //getServletPath是返回的是项目名到当前jsp文件的路径（意思就是在这个项目首页到文件的路径）

    //getRequestURI是返回的是项目名到整个文件的请求路径

    //getRealPath是返回的文件所在的绝对路劲。相对于当前计算机的真实路径

    //getRequestURL是返回的整个URL的路径请求（意思就是返回的浏览器地址栏的整个地址）
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
