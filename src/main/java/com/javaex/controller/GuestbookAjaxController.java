package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GuestbookAjaxController {

	//필드
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	//ajax용 메인화면
	@RequestMapping(value = "/ajaxguestbook", method = {RequestMethod.GET, RequestMethod.POST})
	public String ajaxindex(Model model) {
		System.out.println("GuestbookController.ajaxindex()");
		
		
		
		return "ajaxguestbook/index";
	}

	
}
