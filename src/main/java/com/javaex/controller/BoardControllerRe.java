package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardServiceRe;
import com.javaex.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardControllerRe {

	@Autowired
	private BoardServiceRe boardServiceRe;
	
	@RequestMapping(value="/listRe", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("BoardControllerRe.list()");
		
		List<BoardVO> boardList = boardServiceRe.exeList();
		
		model.addAttribute("boardList", boardList);
		
		
		return "board/list";
	}
	
	@RequestMapping(value = "/listRe2", method = {RequestMethod.GET, RequestMethod.POST})
	public String list2(@RequestParam(value = "crtpage", required = false, defaultValue = "1" ) int crtPage) {
		System.out.println("BoardControllerRe.list2()");
		
		boardServiceRe.exeList2(crtPage);
			
		
		
		return "";
	}
	
	
	
	
	
	
}
