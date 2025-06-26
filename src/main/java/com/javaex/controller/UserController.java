package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	
	//메소드 일반
	//--가입 폼
	@RequestMapping(value="/user/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm()");
		
		return "/user/joinForm";
	}
}
