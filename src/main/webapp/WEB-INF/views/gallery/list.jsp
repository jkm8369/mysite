<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/gallery.css">
        <script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-3.7.1.js"></script>
    </head>

    <body>
      <div class="wrap">
            <!-- 해더 + 네비 ------------------------------------>
            <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
            <!-- 해더 + 네비 ----->
              
               
			    

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
                            <button id="uploadBtn" class="btn btn-blue btn-md" type="submit">이미지올리기</button>
                        </div>
                        
                        <ul class="clearfix">
							
							<!-- 이미지반복영역 -->
							
							<c:forEach items="${requestScope.galleryList}" var="galleryVO">
								 <li>
	                                <div class="card" >
	                                    <img src="${pageContext.request.contextPath}/upload/${galleryListsaveName}">
	                                    <div class="writer">
	                                        작성자: <strong>유재석</strong>
	                                    </div>
	                                </div>
                            	 </li>
							</c:forEach>
						
							
                           
                            
							<!-- 이미지반복영역 -->
							
						</ul>
                    </div>
                    
                </main>
            </div>
            
            <!-- footer -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
			<!-- //footer -->

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
            <img src="${pageContext.request.contextPath}/assets/images/Gangho-dong.jpg">


            <div class="img-content">
                여기는 입력한 코멘트가 나옵니다.
            </div>

            <div class="btn-box">
			    <button type="submit" class="btn-del btn btn-blue btn-md">삭제</button>
            </div>

        </div>
			
		
	</div>

</div>


<script>
//돔트리가 완료되었을 때
$(document).ready(function(){
	console.log('돔트리');
	//이미지올리기 버튼 클릭했을 때
	$('#uploadBtn').on('click', function(){
		console.log('이미지올리기 버튼 클릭');
		
		
		
		
	});
	
	
	
});
	
	
	
	

</script>

    </body>
</html>