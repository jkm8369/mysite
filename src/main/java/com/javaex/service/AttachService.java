package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.repository.AttachRepository;
import com.javaex.vo.FileVO;

@Service
public class AttachService {

	//필드
	@Autowired
	private AttachRepository attachRepository;
	
	//생성자 메소드gs
	
	//메소드 일반
	public String exeUpload(MultipartFile file) {
		System.out.println("AttachService.exeUpload()");
		String saveDirectory = "C:\\javaStudy\\upload\\";
		
		//(1)파일정보를 추출 저장(DB)
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);
		
		//확장자
		//int index = orgName.lastIndexOf(".");
		String exName = orgName.substring(orgName.lastIndexOf(".")+1);
		System.out.println(exName);
		
		//저장 파일명(겹치지 않는 파일명 - 덮어쓰기 방지용)
		//System.out.println(System.currentTimeMillis());
		//System.out.println(UUID.randomUUID().toString());
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + "." + exName;
		System.out.println(saveName);
		
		//파일 경로
		String filePath = saveDirectory + saveName;
		System.out.println(filePath);
		
		//파일 사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);
		
		//vo에 묶는다 --> db저장
		FileVO fileVO = new FileVO(orgName, exName, saveName, filePath, fileSize);
		System.out.println(fileVO);
		
		//--> db저장
		//과제(주황색)
		int count = attachRepository.uploadInsert(fileVO);
		
		//System.out.println(count);
		
		//(2)실물 파일을 하드디스크에 저장
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveName;
		
		
	}
	
	
}
