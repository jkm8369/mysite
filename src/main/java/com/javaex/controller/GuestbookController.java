package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVO;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	//-- 방명록 전체 리스트
	@RequestMapping(value="/guestbook/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController.list()");
		
		List<GuestbookVO> guestbookList = guestbookService.exeGuestbookList();	
		
		model.addAttribute("gList", guestbookList);
		
		
		return "/guestbook/addlist";
	}
	
	//--방명록 글 저장
	@RequestMapping(value="/guestbook/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("GuestbookController.add()");
		
		guestbookService.exeGuestbookAdd(guestbookVO);
		
		return "redirect:/guestbook/list";
	}
	
	//--방명록 글 삭제 폼
	@RequestMapping(value="/guestbook/rform", method= {RequestMethod.GET, RequestMethod.POST})
	public String removeForm() {
		System.out.println("GuestbookController.removeForm()");
		
		return "/guestbook/removeform";
	}
	
	//--방명록 글 삭제
	@RequestMapping(value="/guestbook/remove", method= {RequestMethod.GET, RequestMethod.POST})
	public String remove(GuestbookVO guestbookVO) {
		System.out.println("GuestbookController.remove()");
		
		guestbookService.exeGuestbookRemove(guestbookVO);
		return "redirect:/guestbook/list";
	}
	
	
	
	
	
}
