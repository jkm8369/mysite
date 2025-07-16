package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.AttachService;
import com.javaex.service.GalleryService;
import com.javaex.vo.FileVO;

@Controller
public class GalleryController {

	@Autowired
	private AttachService attachService;
	
	@Autowired
	private GalleryService galleryService;
	
	
	//갤러리 리스트
	@RequestMapping(value="/gallery", method= {RequestMethod.GET, RequestMethod.POST})
	public String galleryList(Model model) {
		System.out.println("GalleryController.gallerylist()");
		
		return "gallery/list";
	}
	
	//업로드
	@RequestMapping(value="/gallery/upload", method= {RequestMethod.GET, RequestMethod.POST})
	public String galleryUpload(@RequestParam(value="file") MultipartFile file, Model model) {
		System.out.println("GalleryController.galleryUpload()");
		
		FileVO fileVO = attachService.exeUpload(file);
		
		System.out.println(fileVO);
		
		
		return "";
	}
	
	//업로드 결과
	
	
	
}
