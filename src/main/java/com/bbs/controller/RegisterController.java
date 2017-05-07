package com.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.domain.User;
import com.bbs.exception.UserExistException;
import com.bbs.service.UserService;
/**
 * 
 * @author John
 *
 */
@Controller
public class RegisterController extends BaseController{

	@Autowired
	private UserService userService;
	/**
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
//	@RequestMapping(value = "/bbs/register",method = RequestMethod.POST)
//	public ModelAndView registerByUser(HttpServletRequest request,User user){
//		ModelAndView view =new ModelAndView();
//		view.setViewName("/sucess");//���ص�ҳ������
//		try{
//			userService.register(user);
//		}catch(UserExistException e){
//			view.addObject("errorMsg","�û��Ѿ����ڣ���ѡ����������");
//			view.setViewName("forword:/register.jsp");//��ת
//		}
//		setSessionUser(request,user);
//		return view;
//		
//	}
	
	//value��"/"����ǰ��
	//ȥ�������ĸ�·����url-pattern�е�·��֮�����ƥ��
	@RequestMapping(value ="/register",method = RequestMethod.POST)
	public ModelAndView registerByName(HttpServletRequest request,HttpServletResponse response){
		ModelAndView view =new ModelAndView();
		String name = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");
		view.setViewName("successRegister");
		User user = new User();
		try{
			user.setUserName(name);
			user.setPassword(password);
			user.setLocked(0);
			user.setUserIp("");
			user.setUserType(1);
			userService.register(user);
		}catch(UserExistException e){
			view.addObject("errorMsg","�û��Ѿ����ڣ���ѡ����������");
			view.setViewName("register");//��ת
		}
		return view;
	}
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public ModelAndView test(){
		System.out.println("success");
		return null;
		
	}
	
}
