package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVO;

//데이터로 응답하는 애들
@Controller
public class GuestbookApiController {

	@Autowired
	GuestbookService guestbookService;
	
	//메소드
	@ResponseBody
	@RequestMapping(value="/api/guestbook/list", method= {RequestMethod.GET, RequestMethod.POST})
	public List<GuestbookVO> list() {
		System.out.println("GuestbookApiController.list()");
		
		List<GuestbookVO> guestbookList = guestbookService.exeList();
		System.out.println(guestbookList);
		
		return guestbookList;
	}
	
}
	