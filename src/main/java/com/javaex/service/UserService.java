package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.UserRepository;
import com.javaex.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//메소드 일반
	//--가입 폼
	public int exeJoin(UserVO userVO) {
		System.out.println("UserService.exeJoin()");
		
		
		int count = userRepository.userInsert(userVO);
		return count;
	}
	
	//--로그인
	public UserVO exeLogin(UserVO userVO) {
		System.out.println("UserService.exeLogin()");
		
		UserVO authUser = userRepository.userSelectOneByIdPw(userVO);
	
		
		
		
		return authUser;
	}
	
	//회원정보 폼
	public UserVO exeEditForm(int no) {
		System.out.println("userService.exeEditForm()");
		
		
		UserVO userVO = userRepository.userSelectOneByNo(no);
		
		return userVO;
	}
	
	//--회원정보수정
	public int exeEdit(UserVO userVO) {
		System.out.println("userService.exeEdit()");
		
		int count = userRepository.userUpdate(userVO);
		return count;
	}
	
	//--아이디 사용유무 체크(회원가입)
	public boolean exeIdCheck(String id) {
		System.out.println("UserService.exeIdCheck()");
		
		UserVO userVO = userRepository.userSelectById(id);
		
		if(userVO == null) {
			//사용할 수 있는 아이디
			return true;
		} else {
			//사용중인 아이디
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
}
