package com.javaex.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;

@Repository
public class BoardRepositoryRe {

	@Autowired
	private SqlSession sqlSession;
	
	//전체리스트 가져오기
	public List<BoardVO> boardSelectList() {
		System.out.println("BoardRepositoryRe.boardSelectList()");
		
		List<BoardVO> boardList = sqlSession.selectList("board.selectList");
		
		
		
		return boardList;
	}
	
	//전체리스트 가져오기2 (페이징)
	public List<BoardVO> boardSelectList2(Map<String, Integer> limitMap) {
		System.out.println("BoardRepositoryRe.boardSelectList2()");
		
		List<BoardVO> boardList = sqlSession.selectList("board.selectList2", limitMap);
		
		return boardList;
	}
	
	
	
	
	
	
	
}
