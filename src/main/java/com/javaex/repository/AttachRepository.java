package com.javaex.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FileVO;

@Repository
public class AttachRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int uploadInsert(FileVO fileVO) {
		System.out.println("AttachRepository.uploadInsert()");
		
		int count = sqlSession.insert("gallery.insert", fileVO);
		
		//System.out.println(count);
		
		return count;
	}
	
	public void GalleryInsert() {
		System.out.println("AttachRepository.GalleryInsert()");
		
		
	}
	
	
}
