package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	/*
	@RequestMapping(value="/", method= {RequestMethod.GET, RequestMethod.POST})
	public String index(@RequestParam(value="id")String id) {
		System.out.println("MainController.index()");
		
		System.out.println(id);
		System.out.println(id + "회원의 메인 사이트 정보를 가져와서 출력한다");
		
		return "main/index";
	}
	*/
	
	@RequestMapping(value="/{id}/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public String index2(@PathVariable(value="id")String id, 
						 @PathVariable(value="no") int no) {
		System.out.println("MainController.index()");
		
		System.out.println(id);
		System.out.println(id + "회원의 메인 사이트 정보를 가져와서 출력한다");
		
		System.out.println(no);
		System.out.println(no + "회원의 메인 사이트 정보를 가져와서 출력한다");
		
		return "main/index";
	}
	
	
	
}
