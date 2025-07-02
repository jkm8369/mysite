package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.BoardRepositoryRe;
import com.javaex.vo.BoardVO;

@Service
public class BoardServiceRe {

	@Autowired
	private BoardRepositoryRe boardRepositoryRe;
	
	//--전체 리스트
	public List<BoardVO> exeList() {
		System.out.println("BoardRepositoryRe.exeList()");
		
		List<BoardVO> boardList= boardRepositoryRe.boardSelectList();
		
		return boardList;
	}
	
	//--전체리스트 (페이징)
	public Map<String, Object> exeList2(int crtPage) {
		System.out.println("BoardServiceRe.exeList2()");
		
		//////////-- 리스트 가져오기////////////
		
		//한 페이지의 출력 갯수
		int listCnt = 10;
		
		//시작번호
		int startRowNo = (crtPage-1) * listCnt;
		
		//두개의 데이터를 묶는다.
		HashMap<String, Integer> listMap = new HashMap<String, Integer>();
		listMap.put("startRowNo", startRowNo);
		
		listMap.put("listCnt", listCnt);
		
		//레파지토리에 보낸다
		List<BoardVO> boardList = boardRepositoryRe.boardSelectList2(listMap);
		
		/////////////페이징 버튼 (하단 버튼)//////////////
		
		
		
		return null;
	}
	
	
	
	
	
	
	
}
