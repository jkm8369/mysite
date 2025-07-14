package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.util.JsonResult;
import com.javaex.vo.GuestbookVO;

//데이터로 응답하는 애들
@RestController   //@Controller + @ResponseBody
public class GuestbookApiController {

	@Autowired
	GuestbookService guestbookService;
	
	//메소드
	@GetMapping(value="/api/guestbooks")
//	@RequestMapping(value="/api/guestbooks", method= RequestMethod.GET)
	public JsonResult list() {
		System.out.println("GuestbookApiController.list()");
		
		List<GuestbookVO> guestbookList = guestbookService.exeGuestbookList();
		System.out.println(guestbookList);
		
		if(guestbookList !=null) {
			return JsonResult.success(guestbookList);
		} else{
			return JsonResult.fail("알 수 없는 오류");
		}
		
		
	}
	
	//--방명록 저장
	@PostMapping(value="/api/guestbooks")
//	@RequestMapping(value="/api/guestbooks", method= RequestMethod.POST)
	public JsonResult add(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("GuestbookApiController.add()");
		System.out.println(guestbookVO);
		
		//guestbookVO(3) --> gVO(4, 출력용)
		GuestbookVO gVO = guestbookService.exeGuestbookAddKey(guestbookVO);
		
		if(gVO !=null) {
			return JsonResult.success(gVO);
		} else {
			return JsonResult.fail("저장에 실패");
		}
		
		
	}
	
	//--방명록 삭제
	@DeleteMapping("/api/guestbooks{no}")
//	@RequestMapping(value="/api/guestbooks/{no}", method= RequestMethod.DELETE)
	public JsonResult remove(@ModelAttribute GuestbookVO guestbookVO,
					  		 @PathVariable(value="no") int no
			) {
		System.out.println("GuestbookApiController.remove()");
		//guestbookVO는 password 값만 있다
		System.out.println(guestbookVO);
		System.out.println("PathVariable로 받은 값:" + no);
		
		//guestbookVO에 no 값을 넣어준다
		guestbookVO.setNo(no);
		System.out.println(guestbookVO);
		
		int count = guestbookService.exeGuestbookRemove(guestbookVO);
		
		if(count == 1) {
			return JsonResult.success(count);
		} else {
			return JsonResult.fail("패스워드 틀림");
		}
		
		
		
		
	}
	
	
	
	
	
}
	