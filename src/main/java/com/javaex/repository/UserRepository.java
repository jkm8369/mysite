package com.javaex.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVO;

@Repository
public class UserRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//메소드 일반
	//--user저장(회원가입)
	public int userInsert(UserVO userVO) {
		System.out.println("UserRepository.userInsert()");
		
		int count = sqlSession.insert("user.insert" ,userVO);
		System.out.println(count);
		
		return count;
	}
	
	//--user 정보 가져오기 (id password)
	public UserVO userSelectOneByIdPw(UserVO userVO) {
		System.out.println("UserRepository.userSelectOneByIdPw()");
		
		//System.out.println(userVO);// id pw  0x999
		
		UserVO authUser = sqlSession.selectOne("user.selectOneByIdPw", userVO);   
		
		//System.out.println(authUser);  // 다 들어있다 0x567
		
		return authUser;
	}
	
	//user 정보 가져오기(no) --> 회원수정 폼
	public UserVO userSelectOneByNo(int no) {
		System.out.println("UserRepository.userSelectOne()");
		//System.out.println(no);
		
		UserVO userVO = sqlSession.selectOne("user.selectOneByNo", no);
		
		
		return userVO;
	}
	
	//--회원정보수정
	public int userUpdate(UserVO userVO) {
		System.out.println("userRepository.userUpdate()");
		//System.out.println(userVO);
		
		int count = sqlSession.update("user.update", userVO);
		
		return count;
	}
	
	//--아이디 사용유무 체크(회원가입)
	public UserVO userSelectById(String id) {
		System.out.println("UserRepository.userSelectById()");
		
		UserVO userVO = sqlSession.selectOne("user.selectOneById", id);
		
		return userVO;
	}
	
	
	
	
	
	
	
	
	
	
}
