package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVO;

@Repository
public class GalleryRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVO> gallerySelect() {
		System.out.println("GalleryRepository.gallerySelect()");
		
		List<GalleryVO> galleryList = sqlSession.selectList("gallery.selectList");
		
		System.out.println(galleryList);
		
		
		
		
		return galleryList;
		
	}
	
}
