package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//메소드 일반
	//--가입 폼
	@RequestMapping(value="/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinform()");
		
		
		return "/user/joinform";
	}
	
	//--회원가입
	@RequestMapping(value= "/join", method= {RequestMethod.GET, RequestMethod.POST})
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
	@RequestMapping(value="/loginform", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginform() {
		System.out.println("UserController.loginform()");
		
		
		
		return "/user/loginform";
	}
	
	//--로그인
	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVO userVO, HttpSession session) {
		System.out.println("UserController.login()");
		
		UserVO authUser = userService.exeLogin(userVO);
		System.out.println(authUser);
		
		//세션에 확인용 값을 넣어준다  --> 로그인
		session.setAttribute("authUser", authUser);
		
		return "redirect:/";
	}
	
	//--로그아웃
	@RequestMapping(value="/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
		//세션의 확인용 값을 지운다
		//session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
	//--회원정보수정폼
	@RequestMapping(value= "/editform", method = {RequestMethod.GET, RequestMethod.POST})
	public String editForm(HttpSession session, Model model) {
		System.out.println("UserController.editForm()");
		
		/* 원래 로그인 여부 확인해야함 */
		
		//세션에서 no 값을 가져온다(지금 접속한 로그인된 사용자의 no 값)
		//파라미터로 안 받고 왜 세션에서 꺼내쓸까??
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		
		if(authUser == null) { //로그인 안했을 때
			
			return "redirect:/user/loginform";
			
		} else {
			
			int no = authUser.getNo();
			
			//no를 서비스에 넘겨서 no 회원의 정보를 userVO 형태로 받는다
			UserVO userVO = userService.exeEditForm(no);
			//System.out.println(userVO);
			
			//userVO 모델에 담는다 --> D.S야 request의 어트리뷰트에 넣어줘
			model.addAttribute("userVO", userVO);
			
			
			return "user/editform";
		}
		

	}
	
	//--회원정보수정
	@RequestMapping(value="/edit", method= {RequestMethod.GET, RequestMethod.POST})
	public String edit(@ModelAttribute UserVO userVO, HttpSession session) {
		System.out.println("UserController.edit()");
		
		//D.S가 파라미터 값을 묶어서 준다
		//System.out.println(userVO);
		
		//1.세션에서 no값을 꺼내온다
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		int no = authUser.getNo();
		//System.out.println(no);
		
		//2.DS가 묶어준 userVO에 세션에서 꺼낸 no를 추가한다
		userVO.setNo(no);
		//System.out.println(userVO);
		
		//3.서비스에 묶어둔 userVO를 넘긴다
		userService.exeEdit(userVO);
		
		//-----
		
		//4.헤더의 이름 변경 --> 세션의 이름 변경
		// 위에 1번에서 가져온 authUser의 이름을 변경한다
		authUser.setName(userVO.getName());
		
		/*
		String name = userVO.getName();
		authUser.setName(name);
		*/
		
		//메인 리다이렉트 시킨다
		return "redirect:/";
	}
	
	//--아이디 사용유무 체크(회원가입) --> 데이터만 응답
	@ResponseBody
	@RequestMapping(value = "/idcheck", method = {RequestMethod.GET, RequestMethod.POST})
	public String idcheck(@RequestParam(value="id") String id, Model model) {
		System.out.println("UserController.idcheck()");
		
		boolean isUse = userService.exeIdCheck(id);
		System.out.println(isUse);
		
		
		//기본방식 --> 이렇게 안한다
		//모델에 담으면 jsp에서 꺼내서 jsp를 가지고 공식 응답문서를 만든다
		//model.addAttribute("isUse", isUse);  //model --> jsp에 전달의미 지금은 아니다
		
		//데이터(json형식)만 보내준다 (html 없음)
		//json형식 {"isUse": true}
		
		String result = "{\"isUse\": "+isUse+"}";
		//@ResponseBody 상단에 붙이고 데이터는 return으로 보낸다
		
		
		
		return result;
	}
	
	
	
	
}
