package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//메소드 일반
	//--가입 폼
	@RequestMapping(value="/user/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinform()");
		
		
		return "/user/joinform";
	}
	
	//--회원가입
	@RequestMapping(value= "/user/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVO userVO) {
		System.out.println("UserController.join()");
		
		try {
			userService.exeJoin(userVO);
			return "/user/joinok";
			
		} catch (DuplicateKeyException e) {
			System.out.println(e);
			System.out.println("중복아이디");
			return "redirect:/user/joinform";
			
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/user/joinform";
		}
		
		
	}
	
	//--로그인 폼
	@RequestMapping(value="/user/loginform", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginform() {
		System.out.println("UserController.loginform()");
		
		
		
		return "/user/loginform";
	}
	
	//--로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVO userVO, HttpSession session) {
		System.out.println("UserController.login()");
		
		UserVO authUser = userService.exeLogin(userVO);
		System.out.println(authUser);
		
		//세션에 확인용 값을 넣어준다  --> 로그인
		session.setAttribute("authUser", authUser);
		
		return "redirect:/";
	}
	
	//--로그아웃
	@RequestMapping(value="/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
		//세션의 확인용 값을 지운다
		//session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
	//--수정폼
	@RequestMapping(value= "/user/mform", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value= "no") int personId, Model model) {
		System.out.println("UserController.modifyForm()");
		
		UserVO userVO = userService.exeModifyForm(personId);
		
		model.addAttribute("userVO", userVO);
		
		
		return "";
	}
	
	
	
	
	
	
}
