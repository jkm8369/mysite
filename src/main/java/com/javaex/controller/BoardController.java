package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//--게시판 전체 리스트
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("BoardController.List()");
		
		List<BoardVO> boardList = boardService.exeList();
		
		model.addAttribute("boardList", boardList);
		
		
		return "board/list";
	}
	
	//--게시판 전체 리스트2 (페이징)
	@RequestMapping(value="/list2", method= {RequestMethod.GET, RequestMethod.POST})
	public String list2(@RequestParam(value="crtpage", required = false, defaultValue = "1")int crtPage, Model model) {
		System.out.println("BoardController.List2()");
		
		Map<String, Object> pMap = boardService.exeList2(crtPage);
		
		System.out.println(pMap);
		
		model.addAttribute("pMap", pMap);
		
		
		return "board/list2";
	}
	
	//--게시판 전체 리스트3 (페이징 + 검색)
	@RequestMapping(value="/list3", method= {RequestMethod.GET, RequestMethod.POST})
	public String list3(@RequestParam(value="crtpage", required = false, defaultValue = "1") int crtPage, 
						@RequestParam(value="kwd", required = false, defaultValue = "") String kwd,
						Model model ) {
		System.out.println("BoardController.list3()");
		
		Map<String, Object> pMap = boardService.exeList3(crtPage, kwd);
		System.out.println("-------------------------------");
		System.out.println(pMap);
		System.out.println("-------------------------------");
		
		
		model.addAttribute("pMap", pMap);
		
		return "board/list3";
	}

	
	//--삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute BoardVO boardVO) {
		System.out.println("BoardController.delete()");
		
		
		//boardService.exeDelete(boardVO);
		
		return "redirect:/board/list";
	}
	
	//--글읽기
	@RequestMapping(value="/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam(value="content")String content, Model model) {
		System.out.println("BoardController.read()");
		
		
		
		
		
		return "";
	}
	
	
	
}
