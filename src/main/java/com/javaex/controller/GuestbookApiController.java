package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		List<GuestbookVO> guestbookList = guestbookService.exeGuestbookList();
		System.out.println(guestbookList);
		
		return guestbookList;
	}
	
	//--방명록 저장
	@ResponseBody
	@RequestMapping(value="/api/guestbook/add", method= {RequestMethod.GET, RequestMethod.POST})
	public GuestbookVO add(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("GuestbookApiController.add()");
		System.out.println(guestbookVO);
		
		//guestbookVO(3) --> gVO(4, 출력용)
		GuestbookVO gVO = guestbookService.exeGuestbookAddKey(guestbookVO);
		
		return gVO;
	}
	
	//--방명록 삭제
	@ResponseBody
	@RequestMapping(value="/api/guestbook/remove", method= {RequestMethod.GET, RequestMethod.POST})
	public int remove(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("GuestbookApiController.remove()");
		
		System.out.println(guestbookVO);
		int count = guestbookService.exeGuestbookRemove(guestbookVO);
		
		return count;
	}
	
	
	
	
	
}
	