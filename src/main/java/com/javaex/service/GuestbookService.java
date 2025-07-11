package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.GuestbookRepository;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	//-- 방명록 전체 리스트
	public List<GuestbookVO> exeGuestbookList() {
		System.out.println("GuestbookService.exeList()");
		
		List<GuestbookVO> guestbookList = guestbookRepository.guestbookSelect();
		
		return guestbookList;
		
	}
	
	//-방명록 글 저장
	public int exeGuestbookAdd(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeAdd");
		
		int count = guestbookRepository.guestbookInsert(guestbookVO);
		
		return count;
	}
	
	//-방명록 글 삭제
	public int exeGuestbookRemove(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeRemove");
		
		int count = guestbookRepository.guestbookDelete(guestbookVO);
		
		return count;
	}
	
	//방명록 저장하기 key 조회(ajax)
	public GuestbookVO exeGuestbookAddKey(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookAddKey()");
		
		System.out.println(guestbookVO);
		int count = guestbookRepository.guestbookInsertKey(guestbookVO);
		System.out.println(guestbookVO);
		
		//추가된 방명록 글 가져오기
		GuestbookVO gVO = guestbookRepository.guestbookSelectOne(count);
		
		return gVO;
	}
	
	
}
