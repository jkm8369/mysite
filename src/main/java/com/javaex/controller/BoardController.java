package com.javaex.controller;

import java.util.List;

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
	
	//--게시판 리스트 출력
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("BoardController.boardList()");
		
		List<BoardVO> boardList = boardService.exeList();
		
		model.addAttribute("boardList", boardList);
		
		
		return "board/list";
	}
	
	
	//--삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute BoardVO boardVO) {
		System.out.println("BoardController.delete()");
		
		
		boardService.exeDelete(boardVO);
		
		return "redirect:/board/list";
	}
	
	//--글읽기
	@RequestMapping(value="/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam(value="content")String content, Model model) {
		System.out.println("BoardController.read()");
		
		BoardVO boardVO = boardService.exeRead();
		
		return "";
	}
	
	
	
}
