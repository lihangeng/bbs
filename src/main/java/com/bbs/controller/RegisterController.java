package com.bbs.controller;

import javax.servlet.http.HttpServletRequest;

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
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,User user){
		ModelAndView view =new ModelAndView();
		view.setViewName("/sucess");//���ص�ҳ������
		try{
			userService.register(user);
		}catch(UserExistException e){
			view.addObject("errorMsg","�û��Ѿ����ڣ���ѡ����������");
			view.setViewName("forword:/register.jsp");//��ת
		}
		setSessionUser(request,user);
		return view;
		
	}
	
}
