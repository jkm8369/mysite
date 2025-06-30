package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;

@Repository
public class BoardRepository {

	
	@Autowired
	private SqlSession sqlSession;
	
	//--전체리스트 가져오기 (게시판리스트)
	public List<BoardVO> boardSelectList() {
		System.out.println("BoardRepository.boardSelect()");
		
		List<BoardVO> boardList = sqlSession.selectList("board.selectList");
		
		System.out.println(boardList);
		
		return boardList;
	}
	
	public int boardDelete(BoardVO boardVO) {
		System.out.println("BoardRepository.boardDelete()");
		
		int count = sqlSession.delete("board.delete");
		
		return count;
	}
	
	
	
	
	
	
	
	
}
