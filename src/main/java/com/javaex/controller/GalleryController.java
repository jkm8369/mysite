package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.AttachService;
import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVO;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class GalleryController {
	
	//필드
	@Autowired
	private GalleryService galleryService;
	@Autowired
	private AttachService attachService;

	
	//메소드 일반
	//갤러리 전체 리스트
	@RequestMapping(value="/gallery", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GalleryController.list()");
		
		List<GalleryVO> galleryList =  galleryService.exeGalleryList();
		
		model.addAttribute("galleryList", galleryList);
		
		return "gallery/list";
	}
	
	
	//갤러리 업로드 등록(저장)
	@RequestMapping(value="/gallery/upload", method= {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam(value="file") MultipartFile file, 
						 GalleryVO galleryVO, 
						 Model model,
						 HttpSession session) {
		
		System.out.println("GalleryController.upload()");
		
	    UserVO authUser = (UserVO) session.getAttribute("authUser");
	    
	    if (authUser == null) {
	        
	        return "redirect:/user/loginform";
	    }
		
		String saveName = attachService.exeUpload(file);
		String filePath = "C:\\javaStudy\\upload\\";
		String orgName = file.getOriginalFilename();
		long fileSize = file.getSize();
		
		galleryVO.setSaveName(saveName);
		galleryVO.setFilePath(filePath);
		galleryVO.setOrgName(orgName);
		galleryVO.setFileSize(fileSize);
		galleryVO.setUserNo(authUser.getNo());
		
		galleryService.exeGalleryUpload(galleryVO);
		
		model.addAttribute("saveName", saveName);
		
		return "redirect:/gallery"; //redirect
	}
	

	//갤러리 삭제
	@ResponseBody
	@RequestMapping(value="/gallery/delete/{no}", method= RequestMethod.POST)
	public int delete(@ModelAttribute GalleryVO galleryVO,
						 @PathVariable(value="no") int no,
						 HttpSession session) {
		
		System.out.println("GalleryController.delete()");
		
	    UserVO authUser = (UserVO) session.getAttribute("authUser");
	    if (authUser == null) {
	        return 0;
	    }
		
		galleryVO.setNo(no);
		galleryVO.setUserNo(authUser.getNo());
		
		int count = galleryService.exeGalleryRemove(galleryVO);
		
		return count;
	}
	
	
	
}
