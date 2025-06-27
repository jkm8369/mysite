package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	//필드
	
	
	//생성자
	
	
	//메소드gs
	
	
	//메소드 일반
	//--사이트 시작 페이지
	@RequestMapping(value="/", method= {RequestMethod.GET, RequestMethod.POST})
	public String index() {
		System.out.println("MainController.index()");
		
		
		return "main/index";
	}
	
	
	
	
}
