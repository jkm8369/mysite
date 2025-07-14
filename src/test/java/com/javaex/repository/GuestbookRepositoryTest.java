package com.javaex.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javaex.vo.GuestbookVO;

@SpringBootTest
public class GuestbookRepositoryTest {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	
	//리스트 테스트
	@Test
	public void selectAll() {
		List<GuestbookVO> guestbookList = guestbookRepository.guestbookSelect();
		System.out.println("------------------------");
		System.out.println(guestbookList);
		System.out.println("------------------------");
		
		assertThat(guestbookList).isNotNull();
	}
	
	//삭제하기 테스트
	@Test
	public void delete() {
		GuestbookVO guestbookVO = new GuestbookVO();
		guestbookVO.setNo(23);
		guestbookVO.setPassword("12345");
		System.out.println(guestbookVO);
		
		
		int count = guestbookRepository.guestbookDelete(guestbookVO);
		assertThat(count).isEqualTo(0);

	}
	
	//추가하기 테스트
	@Test
	public void insert() {
		GuestbookVO guestbookVO = new GuestbookVO();
		
		guestbookVO.setName("지석진");
		guestbookVO.setPassword("12345");
		guestbookVO.setContent("안녕하세요");
		
		System.out.println(guestbookVO);
		
		
		int count = guestbookRepository.guestbookInsert(guestbookVO);
		
		assertThat(count).isEqualTo(1);

		
	}
	
	
}
