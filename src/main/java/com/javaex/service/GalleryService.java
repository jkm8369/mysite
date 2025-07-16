package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.GalleryRepository;
import com.javaex.vo.GalleryVO;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryRepository galleryRepository;
	
	
	public List<GalleryVO> exeGalleryList() {
		System.out.println("GalleryService.exeGalleryList");
		
		List<GalleryVO> galleryList = galleryRepository.gallerySelect();
		
		
		
		return galleryList;
	}
	
	public void exeGalleryUpload() {
		
		
		
	}
	
}
