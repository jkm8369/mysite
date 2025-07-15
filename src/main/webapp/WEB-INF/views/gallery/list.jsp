<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="../../assets/css/reset.css">
        <link rel="stylesheet" href="../../assets/css/mysite.css">
        <link rel="stylesheet" href="../../assets/css/gallery.css">
    </head>

    <body>
      <div class="wrap">
            <header class="clearfix">
                <h1><a href="">MySite</a></h1>
              
               
			    <ul class="clearfix">
				    <li><span class="user-welcome">황일영 님 안녕하세요^^</span></li>
				    <li>
                        <a class="btn btn-white btn-sm" href="">로그아웃</a>
                    </li>
                    <li>
                        <a class="btn btn-white btn-sm" href="">회원정보수정</a>
                    </li>
			    </ul>
               
                  <!--	
               <ul class="clearfix">
                    <li>
                        <a class="btn btn-white btn-sm" href="">로그인</a>
                    </li>
                    <li>
                        <a class="btn btn-white btn-sm" href="">회원가입</a>
                    </li>
                </ul>
                 -->
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
                    <h2>갤러리</h2>
                    <ul>
                        <li><a href="">일반갤러리</a></li>
                        <li><a href="">첨부파일연습</a></li>
                    </ul>
                </aside>

				<main>
                    <div class="main-head clearfix">
                        <h3>일반갤러리</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>갤러리</li>
                            <li>일반갤러리</li>
                        </ol>
                    </div>

                    <div id="gallery-list">
                        <div class="btn-box">
                            <button class="btn btn-blue btn-md" type="submit">이미지올리기</button>
                        </div>
                        
                        <ul class="clearfix">
							
							<!-- 이미지반복영역 -->
                            <li>
                                <div class="card" >
                                    <img src="../../assets/images/Gangho-dong.jpg">
                                    <div class="writer">
                                        작성자: <strong>유재석</strong>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="card" >
                                    <img src="../../assets/images/Gangho-dong.jpg">
                                    <div class="writer">
                                        작성자: <strong>유재석</strong>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="card" >
                                    <img src="../../assets/images/Gangho-dong.jpg">
                                    <div class="writer">
                                        작성자: <strong>유재석</strong>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="card" >
                                    <img src="../../assets/images/Gangho-dong.jpg">
                                    <div class="writer">
                                        작성자: <strong>유재석</strong>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="card" >
                                    <img src="../../assets/images/Gangho-dong.jpg">
                                    <div class="writer">
                                        작성자: <strong>유재석</strong>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="card" >
                                    <img src="../../assets/images/Gangho-dong.jpg">
                                    <div class="writer">
                                        작성자: <strong>유재석</strong>
                                    </div>
                                </div>
                            </li>
							<!-- 이미지반복영역 -->
							
						</ul>
                    </div>
                    
                </main>
            </div>
            
            <footer>
                <p>
                    Copyright ⓒ 2025 황일영. All right reserved  
                </p>
            </footer>

        </div>

        



<!-- 모달창 -->
<!-- 업로드 모달창 -->
<div id="modal-upload" class="modal-bg">

	<div class="modal-content" >
    
        <div class="clearfix">
            <button class="btn-close">X</button>
        </div>
        
		<p class="title">이미지등록 모달창</p>
		
		<form id="imgupload-form" action="" method="">
			<div class="info-row">
                <label for="txt-content">글작성</label>
				<input id="txt-content" type="text" name="content" value="">
			</div>

            <div class="info-row">
                <label for="txt-file">이미지선택</label>
				<input type="file" name="file" value="">
			</div>
            <div class="btn-box">
			    <button type="submit" class="btn-del btn btn-blue btn-md">등록</button>
            </div>
        </form>
		
	</div>

</div>


<!-- 이미지보기 모달창 -->
<div id="modal-view" class="modal-bg">

	<div class="modal-content" >
    
        <div class="clearfix">
            <button class="btn-close">X</button>
        </div>
        
		<p class="title">이미지보기 모달창</p>
		
		<div id="img-view">
            <img src="../../assets/images/Gangho-dong.jpg">


            <div class="img-content">
                여기는 입력한 코멘트가 나옵니다.
            </div>

            <div class="btn-box">
			    <button type="submit" class="btn-del btn btn-blue btn-md">삭제</button>
            </div>

        </div>
			
		
	</div>

</div>


    </body>
</html>