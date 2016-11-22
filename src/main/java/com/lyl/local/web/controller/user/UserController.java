package com.lyl.local.web.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyl.local.entity.user.UserEntity;
import com.lyl.local.service.user.UserService;

// 中文转码在spring-mvc.xml 属性supportedMediaTypes设置过，此处无需设置
//@RequestMapping(value="user",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
@RequestMapping(value="user")
@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("getUserById")
	@ResponseBody
	public String getUserById(int id,HttpServletRequest request){
		logger.info("in");
		int Id = Integer.valueOf(request.getParameter("id"));
		UserEntity result=userService.getUserById(Id);
		String rs = result.getUserName();
		System.out.println(id);
		System.out.println(rs);
		return rs;
	}
}

