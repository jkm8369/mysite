package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.AttachService;
import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVO;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

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
		
		List<GalleryVO> galleryList = galleryService.exeGalleryList();
		
		model.addAttribute("galleryList", galleryList);
		
		return "gallery/list";
	}
	
	//업로드
	@RequestMapping(value="/gallery/upload", method= {RequestMethod.GET, RequestMethod.POST})
	public String galleryUpload(@RequestParam(value="file") MultipartFile file, 
								Model model,
								@ModelAttribute GalleryVO galleryVO,
								HttpSession Session) {
		
		System.out.println("GalleryController.galleryUpload()");
		
		UserVO authUser = (UserVO)Session.getAttribute("authUser");
		
		String saveName = attachService.exeUpload(file);
		String filePath = "C:\\javaStudy\\upload\\";
		String orgName = file.getOriginalFilename();
		long fileSize = file.getSize();
		
		galleryVO.setSaveName(saveName);
		galleryVO.setFilePath(filePath);
		galleryVO.setOrgName(orgName);
		galleryVO.setFileSize(fileSize);
		
		
		return "";
	}
	
	//업로드 결과
	
	
	
}
