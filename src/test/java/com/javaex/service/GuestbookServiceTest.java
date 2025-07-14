package com.javaex.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javaex.vo.GuestbookVO;

@SpringBootTest
public class GuestbookServiceTest {

	@Autowired
	private GuestbookService guestbookService;
	
	@Test
	public void delete() {
		
		GuestbookVO guestbookVO = new GuestbookVO();
		guestbookVO.setNo(1);
		guestbookVO.setPassword("123");
		
		System.out.println(guestbookVO);
		
		
		int count = guestbookService.exeGuestbookRemove(guestbookVO);
		
		assertThat(count).isEqualTo(0);
		
	}
	
}
