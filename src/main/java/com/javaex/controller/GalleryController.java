package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GalleryService;

@Controller
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	//갤러리 리스트
	@RequestMapping(value="/gallery", method= {RequestMethod.GET, RequestMethod.POST})
	public String list() {
		System.out.println("GalleryController.list()");
		
		return "gallery/list";
	}
	
	
}
