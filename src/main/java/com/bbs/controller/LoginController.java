package com.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.dao.UserDao;
import com.bbs.domain.User;

/**
 * ��¼���Ʋ�
 * @author John
 *
 */
@Controller
public class LoginController extends BaseController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		String userName = (String) request.getParameter("name");
		String password =  (String) request.getParameter("password");
		User user = new User();
		user = userDao.getUserByName(userName);
		if(user != null && user.getPassword().equals(password)){
			setSessionUser(request,user);
			model.setViewName("successLogin");
		}
		return model;
		
	}
	

}
