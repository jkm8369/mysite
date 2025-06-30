package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.BoardRepository;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {

		@Autowired
		private BoardRepository boardRepository;
		
		//--게시판 리스트
		public List<BoardVO> exeList() {
			System.out.println("BoardService.exeList()");
			
			List<BoardVO> boardList = boardRepository.boardSelectList();
			
			return boardList;
		}
	
		//--게시판 삭제
		public int exeDelete(BoardVO boardVO) {
			System.out.println("BoardService.exeDelete()");
			
			int count = boardRepository.boardDelete(boardVO);
			
			
			return count;
		}
		
		//--게시판 글 읽기
		public void exeRead() {
			System.out.println("BoardService.exeRead()");
			
		}
		
		
		
		
}
