package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.BoardRepository;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	//메소드일반
	//--게시판 전체리스트
	public List<BoardVO> exeList() {
		System.out.println("BoardService.exeList()");
	
		List<BoardVO> boardList =boardRepository.boardSelectList();
	
		return boardList;
	}
	

	//--게시판 전체리스트2(페이징)
	public Map<String, Object> exeList2(int crtPage) {
		System.out.println("BoardService.exeList2()");
		
		////////////////////////////////////////////////////////
		///리스트 가져오기
		////////////////////////////////////////////////////////
		//한페이지의 출력갯수
		int listCnt = 10;
		
		//시작번호
		/*
		 1->(1,10),  2->(11,20), 3->(21,30)  사람
		 1->(0,10),  2->(10,10), 3->(20,10)  mysql
		 startRowNo = (crtPage-1)*listCnt
		 */
		int startRowNo = (crtPage-1)*listCnt;
		
		//두개의 데이터를 묶는다 -->Map사용
		Map<String, Integer> limitMap = new HashMap<String, Integer>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		
		//레파이토리에 보낸다
		List<BoardVO> boardList = boardRepository.boardSelectList2(limitMap);
		
		////////////////////////////////////////////////////////
		///페이징버튼 (하단 버튼)
		////////////////////////////////////////////////////////
		
		//페이지당 버튼갯수
		int pageBtnCount = 5;
		
		
		//마지막 버튼 번호 endPageBtnNo
		/*
		 1  2  3  4  5  >
		 1->(1, 5)
		 2->(1, 5)
		 3->(1, 5)
		 4->(1, 5)
		 5->(1, 5)
		 6->(6, 10)
		 7->(6, 10)
		 ...
		 10->(6, 10)
		 11->(11, 15)	
		 
		 1->  올림(1/5)5  --> 0.2(1)*5  -->5
		 2->  올림(2/5)5  --> 0.4(1)*5  -->5
		 3->  올림(3/5)5  --> 0.6(1)*5  -->5
		 4->  올림(4/5)5  --> 0.8(1)*5  -->5
		 5->  올림(5/5)5  --> 1.0(1)*5  -->5
		 6->  올림(6/5)5  --> 1.2(2)*5  -->10
		 11-> 올림(11/5)5 --> 2.2(3)*5  -->15
		*/
		int endPageBtnNo = ((int)Math.ceil(crtPage/((double)pageBtnCount)))*pageBtnCount;
		           
		
		//시작 버튼 번호 startPageBtnNo
		/*
		 1-> (1, 5)    ===> (5 - 5) + 1  ==> 1
		 2-> (1, 5)    ===> (5 - 5) + 1  ==> 1
		 6-> (6, 10)   ===> (10 - 5) + 1  ==> 6
		 13->(11, 15)  ===> (15 - 5) + 1  ==> 11
		 13페이지이면       (마지막페이지번호-페이지당버튼갯수)+1
		 */
		int startPageBtnNo = (endPageBtnNo - pageBtnCount)+1;
		
		
		//다음 화살표 유무 next
		/* 총글수와 연관이 있음  , 한페이지당 글갯수
		 1)
		 전체글 갯수 51
		 1  2  3  4  5  > 
		 한페이지당글갯수(10)*5 <  전체글갯수(51)    --> true
		 
		 2)
		 전체글 갯수 49
		 1  2  3  4  5  
		 한페이지당글갯수(10)*5 >  전체글갯수(49)    --> false
		*/
		
		//--전체글갯수
		int totalCount = boardRepository.selectTotalCount();
		boolean next = false;
		if(listCnt*endPageBtnNo < totalCount) { //한페이지당글갯수(10)*마지막 버튼 번호(5) <  전체글갯수(51)  
			next = true;
		}else { //다음 화살표가 false 일때 마지막 버튼 번호를 다시계산해야한다
	    	//181 --> 19page  181/10 --> 18.1  --> 19 올림처리한다
	    	
	    	endPageBtnNo = (int)Math.ceil(totalCount/((double)listCnt));                 
	    }

		
		//이전 화살표 유무 prev
	    boolean prev = false;
	    if(startPageBtnNo != 1) {
	    	prev = true;
	    }
	    
	    
	    //모두 묶어서 컨트롤러에 리턴해준다 --> Map 사용
	    Map<String, Object> pMap = new HashMap<String, Object>();
	    pMap.put("boardList", boardList);  //리스트
	   
	    pMap.put("prev", prev);  //이전버튼 유무
	    pMap.put("next", next);  //다음버튼 유무
	    pMap.put("startPageBtnNo", startPageBtnNo);  //시작버튼 번호
	    pMap.put("endPageBtnNo", endPageBtnNo);  //마지막버튼 번호
	    
		return pMap;
	}
	
	
	//--게시판 전체리스트3(페이징+검색)
	public Map<String, Object> exeList3(int crtPage, String kwd) {
		System.out.println("BoardService.exeList3()");
		
		System.out.println(crtPage);
		System.out.println(kwd);
		
		////////////////////////////////////////////////////////
		///리스트 가져오기
		////////////////////////////////////////////////////////
		//한페이지의 출력갯수
		int listCnt = 10;
		
		//시작번호
		int startRowNo = (crtPage-1)*listCnt;
		
		//두개의 데이터를 묶는다 -->Map사용
		Map<String, Object> limitMap = new HashMap<String, Object>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		limitMap.put("kwd", kwd);
		
		//레파지토리에 보낸다
		List<BoardVO> boardList = boardRepository.boardSelectList3(limitMap);

		////////////////////////////////////////////////////////
		///페이징버튼 (하단 버튼)
		////////////////////////////////////////////////////////
		
		//페이지당 버튼갯수
		int pageBtnCount = 5;
		
		
		//마지막 버튼 번호 endPageBtnNo
		int endPageBtnNo = ((int)Math.ceil(crtPage/((double)pageBtnCount)))*pageBtnCount;
		           
		
		//시작 버튼 번호 startPageBtnNo
		int startPageBtnNo = (endPageBtnNo - pageBtnCount)+1;
		
		//--전체글갯수
		int totalCount = boardRepository.selectTotalCountByKwd(kwd);
		
		boolean next = false;
		if(listCnt*endPageBtnNo < totalCount) { //한페이지당글갯수(10)*마지막 버튼 번호(5) <  전체글갯수(51)  
			next = true;
		}else { //다음 화살표가 false 일때 마지막 버튼 번호를 다시계산해야한다
	    	//181 --> 19page  181/10 --> 18.1  --> 19 올림처리한다
	    	
	    	endPageBtnNo = (int)Math.ceil(totalCount/((double)listCnt));                 
	    }

		
		//이전 화살표 유무 prev
	    boolean prev = false;
	    if(startPageBtnNo != 1) {
	    	prev = true;
	    }
	    
	    
	    //모두 묶어서 컨트롤러에 리턴해준다 --> Map 사용
	    Map<String, Object> pMap = new HashMap<String, Object>();
	    pMap.put("boardList", boardList);  //리스트
	   
	    pMap.put("prev", prev);  //이전버튼 유무
	    pMap.put("next", next);  //다음버튼 유무
	    pMap.put("startPageBtnNo", startPageBtnNo);  //시작버튼 번호
	    pMap.put("endPageBtnNo", endPageBtnNo);  //마지막버튼 번호
	    
		return pMap;
	}
	
	
	
	
	
	
	
	
	
	/*
	 * @Autowired private BoardRepository boardRepository;
	 * 
	 * //--게시판 리스트 public List<BoardVO> exeList() {
	 * System.out.println("BoardService.exeList()");
	 * 
	 * List<BoardVO> boardList = boardRepository.boardSelectList();
	 * 
	 * return boardList; }
	 * 
	 * //--게시판 전체리스트2 (페이징) public Map<String, Object> exeList2(int crtPage) {
	 * System.out.println("BoardService.exeList2()");
	 * 
	 * System.out.println(crtPage);
	 * 
	 * ///////////////////////////////////////////////// ///리스트 가져오기
	 * ///////////////////////////////////////////////// //한 페이지의 출력 갯수 int listCnt
	 * = 10;
	 * 
	 * //시작번호
	 * 
	 * 1--> (1, 10) 2--> (11, 20) 3--> (21, 30) 사람 2--> (0, 10) 2--> (10, 10) 3-->
	 * (20,10) mysql
	 * 
	 * int startRowNo = (crtPage-1) * listCnt;
	 * 
	 * //두개의 데이터를 묶는다 --> Map 사용 Map<String, Integer> limitMap = new HashMap<String,
	 * Integer>(); limitMap.put("startRowNo", startRowNo);
	 * 
	 * limitMap.put("listCnt", listCnt);
	 * 
	 * //레파지토리에 보낸다 List<BoardVO> boardList =
	 * boardRepository.boardSelectList2(limitMap);
	 * 
	 * 
	 * ///////////////////////////////////////////////// ///페이징 버튼 (하단 버튼)
	 * ///////////////////////////////////////////////// int pageBtnCount =5;
	 * 
	 * //마지막 버튼 번호 endPageBtnNo
	 * 
	 * 1 2 3 4 5 > 1->(1,5) 2->(1,5) 3->(1,5)
	 * 
	 * 6->6,10 7->6,10
	 * 
	 * 10-> 6 10 11->11,15
	 * 
	 * 1--> 올림(1/5)5 --> 0.2(1)*5 --> 5 2--> 올림(2/5)5 --> 0.4(1)*5 --> 5 3-->
	 * 올림(3/5)5 --> 0.6(1)*5 --> 5 4--> 올림(4/5)5 --> 0.8(1)*5 --> 5 5--> 올림(5/5)5
	 * --> 1.0(1)*5 --> 5 6--> 올림(6/5)5 --> 1.2(2)*5 --> 10 11-> 올림(11/5)5 -->
	 * 2.2(3)*5 --> 15
	 * 
	 * 
	 * 
	 * int endPageBtnNo =
	 * ((int)Math.ceil(crtPage/(double)pageBtnCount))*pageBtnCount;
	 * 
	 * System.out.println("endPageBtnNo-->" + endPageBtnNo);
	 * 
	 * 
	 * //시작 버튼 번호 startPageBtnNo int startPageBtnNo = (endPageBtnNo -
	 * pageBtnCount)+1;
	 * 
	 * //다음 화살표 유무 next
	 * 
	 * 총 글수와 관련이 있음, 한페이지당 글 갯수
	 * 
	 * 전체글 갯수 51 1 2 3 4 5 --> true
	 * 
	 * 한페이지당 글 갯수 10*(5) < 전체글 갯수 (51) --> true
	 * 
	 * 
	 * 전체글 갯수 49 1 2 3 4 5
	 * 
	 * 한페이지당 글 갯수 10*(5 > 전체글 갯수 (49) --> false
	 * 
	 * 10*5 50 다음버튼 없어야 함
	 * 
	 * //전체 글 갯수 int totalCount = boardRepository.selectTotalCount();
	 * 
	 * boolean next = false;
	 * 
	 * if(listCnt*endPageBtnNo < totalCount) { //한 페이지당 글 갯수(10)*마지막 버튼 번호(5) < 전체 글
	 * 갯수(51) next = true; } else { //다음 화살표가 false일 때 마지막 버튼 번호를 다시 계산해야한다 //185
	 * --> 19 page 181/10 --> 18.1 --> 19가 되도록 올림처리한다.
	 * 
	 * endPageBtnNo = (int)Math.ceil(totalCount/((double)listCnt)); }
	 * 
	 * //이전 화살표 유무 prev boolean prev = false;
	 * 
	 * if(startPageBtnNo !=1) { prev = true;
	 * 
	 * }
	 * 
	 * System.out.println("---------------------------------");
	 * System.out.println("prev ->" + prev); System.out.println("next ->" + next);
	 * System.out.println("startPageBtnNo ->" + startPageBtnNo);
	 * System.out.println("endPageBtnNo ->" + endPageBtnNo);
	 * System.out.println("pageBtnCount ->" + pageBtnCount);
	 * 
	 * Map<String, Object> pMap = new HashMap<String, Object>();
	 * pMap.put("boardList", boardList); //리스트 pMap.put("prev", prev); //이전버튼 유무
	 * pMap.put("next", next); //다음버튼 유무 pMap.put("startPageBtnNo", startPageBtnNo);
	 * //시작버튼 번호 pMap.put("endPageBtnNo", endPageBtnNo); //마지막 버튼 번호
	 * 
	 * return pMap; }
	 * 
	 * 
	 * //--게시판 전체리스트3 (페이징+검색) public Map<String, Object> exeList3(int crtPage,
	 * String kwd) { System.out.println("BoardService.exeList3()");
	 * 
	 * 
	 * ///////////////////////////////////////////////// ///리스트 가져오기
	 * ///////////////////////////////////////////////// //한 페이지의 출력 갯수 int listCnt
	 * = 10;
	 * 
	 * //시작번호 int startRowNo = (crtPage-1) * listCnt;
	 * 
	 * //두개의 데이터를 묶는다 --> Map 사용 Map<String, Object> limitMap = new HashMap<String,
	 * Object>(); limitMap.put("startRowNo", startRowNo); limitMap.put("listCnt",
	 * listCnt); limitMap.put("kwd", kwd);
	 * 
	 * //레파지토리에 보낸다 List<BoardVO> boardList =
	 * boardRepository.boardSelectList3(limitMap);
	 * 
	 * 
	 * ///////////////////////////////////////////////// ///페이징 버튼 (하단 버튼)
	 * ///////////////////////////////////////////////// int pageBtnCount =5;
	 * 
	 * // 마지막 버튼 번호 endPageBtnNo int endPageBtnNo =
	 * ((int)Math.ceil(crtPage/((double)pageBtnCount)))*pageBtnCount;
	 * 
	 * 
	 * //시작 버튼 번호 startPageBtnNo int startPageBtnNo = (endPageBtnNo -
	 * pageBtnCount)+1;
	 * 
	 * //전체 글 갯수 int totalCount = boardRepository.selectTotalCountByKwd(kwd);
	 * 
	 * boolean next = false;
	 * 
	 * if(listCnt*endPageBtnNo < totalCount) { //한 페이지당 글 갯수(10)*마지막 버튼 번호(5) < 전체 글
	 * 갯수(51) next = true; } else { //다음 화살표가 false일 때 마지막 버튼 번호를 다시 계산해야한다 //185
	 * --> 19 page 181/10 --> 18.1 --> 19가 되도록 올림처리한다.
	 * 
	 * endPageBtnNo = (int)Math.ceil(totalCount/((double)listCnt)); }
	 * 
	 * //이전 화살표 유무 prev boolean prev = false;
	 * 
	 * if(startPageBtnNo !=1) { prev = true;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * //모두 묶어서 컨트롤러에 리턴해준다 --> Map 사용 Map<String, Object> pMap = new
	 * HashMap<String, Object>();
	 * 
	 * pMap.put("boardList", boardList); //리스트
	 * 
	 * pMap.put("prev", prev); //이전버튼 유무 pMap.put("next", next); //다음버튼 유무
	 * pMap.put("startPageBtnNo", startPageBtnNo); //시작버튼 번호
	 * pMap.put("endPageBtnNo", endPageBtnNo); //마지막 버튼 번호
	 * 
	 * return pMap; }
	 * 
	 * 
	 * 
	 * //--게시판 삭제 public int exeDelete(BoardVO boardVO) {
	 * System.out.println("BoardService.exeDelete()");
	 * 
	 * int count = boardRepository.boardDelete(boardVO);
	 * 
	 * 
	 * return count; }
	 * 
	 * //--게시판 글 읽기 public void exeRead() {
	 * System.out.println("BoardService.exeRead()");
	 * 
	 * }
	 */

}
