<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="../../assets/css/reset.css">
        <link rel="stylesheet" href="../../assets/css/mysite.css">
        <link rel="stylesheet" href="../../assets/css/board.css">
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

            <div class="content2 clearfix">
                <aside>
                    <h2>게시판</h2>
                    <ul>
                        <li><a href="">일반게시판</a></li>
                        <li><a href="">댓글게시판</a></li>
                    </ul>
                </aside>


				<main>

				    <div class="main-head clearfix">
                        <h3>일반게시판</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>게시판</li>
                            <li>일반게시판</li>
                        </ol>
                    </div>
	
					<div id="board-editform">
						
						<form class="form-box" action="#" method="get">
							<!-- 작성자 -->
							<div class="info-row">
								<span class="info-title">작성자</span>
								<span>정우성</span>
							</div>
							
							<!-- 조회수 -->
							<div class="info-row">
								<span class="info-title">조회수</span>
								<span>123</span>
							</div>
							
							<!-- 작성일 -->
							<div class="info-row">
								<span class="info-title">작성일</span>
								<span>2020-03-02</span>
							</div>
							
							<!-- 제목 -->
							<div class="info-row">
								<label class="info-title" for="txt-title">제&nbsp;&nbsp;&nbsp;목</label>
								<input type="text" id="txt-title" name="" value="">
							</div>
						
							<!-- 내용 -->
							<div class="info-row">
								<textarea id="txt-content">
										여기에는 본문내용이 출력됩니다.
										여기에는 본문내용이 출력됩니다.
										여기에는 본문내용이 출력됩니다.
										여기에는 본문내용이 출력됩니다.
										여기에는 본문내용이 출력됩니다.
										여기에는 본문내용이 출력됩니다.
										여기에는 본문내용이 출력됩니다.
										여기에는 본문내용이 출력됩니다. 
								</textarea>
							</div>
							
                            <div class="btn-box">
                                <a class="btn btn-gray btn-md" href="">목록</a>
							    <button class="btn btn-blue btn-md" type="submit" >수정</button>
                            </div>
							
						</form>

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