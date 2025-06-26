<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
    </head>

    <body>
        <div class="wrap">
            <header class="clearfix">
                <h1><a href="">MySite</a></h1>
              
                <!--
			    <ul class="clearfix">
				    <li><span class="user-welcome">황일영 님 안녕하세요^^</span></li>
				    <li>
                        <a class="btn btn-white btn-sm" href="">로그아웃</a>
                    </li>
                    <li>
                        <a class="btn btn-white btn-sm" href="">정보수정</a>
                    </li>
			    </ul>
                -->
                 	
               <ul class="clearfix">
                    <li>
                        <a class="btn btn-white btn-sm" href="">로그인</a>
                    </li>
                    <li>
                        <a class="btn btn-white btn-sm" href="">회원가입</a>
                    </li>
                </ul>
            </header>
                 
            <nav>
                <ul class="clearfix">
                    <li><a href="">입사지원서</a></li>
                    <li><a href="">게시판</a></li>
                    <li><a href="">갤러리</a></li>
                    <li><a href="">방명록</a></li>
                </ul>
            </nav>

            <div class="content clearfix">
                <main>
                    <div id="main-home">
                        <img class="profile" src="${pageContext.request.contextPath}/assets/images/profile.jpg">
                        <div class="greeting-box">
                            <p class="greeting">
                                안녕하세요!!<br>
                                황일영의 MySite에 오신 것을 환영합니다.<br>
                                <br>
                                이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.
                            </p>
                            
                            <p class="introduce">
                                사이트 소개, 회원가입, 방명록, 게시판으로 구성되어 있으며<br>
                                jsp&serlvet(모델2) 방식으로 제작되었습니다.<br>
                                <br>
                                자바 수업 + 데이터베이스 수업 + 웹프로그래밍 수업<br>
                                배운 거 있는거 없는 거 다 합쳐서 만들어 놓은 사이트 입니다.<br>
                                <br>
                                (자유롭게 꾸며보세요!!)
                                <br>
                                <br>
                                <br>
                                <a href="">[방명록에 글 남기기]</a>
                            </p>
                        </div>
                    </div>
                </main>
            </div>

            <footer>
                <p>
                    Copyright ⓒ 2025 황일영. All right reserved  
                </p>
            </footer>
        </div>
    </body>
</html>