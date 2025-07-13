<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>MySite</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/board.css">
    </head>

    <body>
      <div class="wrap">
         	<!-- 해더 + 네비 ------------------------------------>
            <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
            <!-- 해더 + 네비 ------------------------------------>

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

                    <div id="board-list">
                        <form action="" method="">
                            <input type="text" name="kwd" value="">
                            <button class="btn btn-gray btn-input" type="submit">검색</button>
                        </form>
                        
                        
                        <table>
							<colgroup>
									<col style="width: 10%;">
									<col style="width: 45%;">
									<col style="width: 10%;">
									<col style="width: 10%;">
									<col style="width: 15%;">
									<col style="width: 10%;">
								</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>조회수</th>
									<th>작성일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								
								<c:forEach items="${requestScope.pMap.boardList}"  var="boardVO">
									<tr>
										<td>${boardVO.no}</td>
										<td class="txt-left"><a href="#">${boardVO.title}</a></td>
										<td>${boardVO.userName}</td>
										<td>${boardVO.hit}</td>
										<td>${boardVO.regDate}</td>
										<td>
	                                        <button class="btn btn-white btn-sm" type="button">삭제</button>
	                                    </td>
									</tr>
								
								</c:forEach>
								
							</tbody>
						</table>
                        <div class="paging">
							<ul class="clearfix">
							
								<c:if test="${requestScope.pMap.prev}">
									<li><a href="${pageContext.request.contextPath}/board/list3?crtpage=${requestScope.pMap.startPageBtnNo-1}&kwd=${param.kwd}">◀</a></li>
								</c:if>
								
								<c:forEach begin="${requestScope.pMap.startPageBtnNo}" 
								           end="${requestScope.pMap.endPageBtnNo}"
								           step="1" var="page">
								    
								    <c:choose>
								    	<c:when test="${param.crtpage == page}">
								    		<li class="active"><a  href="${pageContext.request.contextPath}/board/list3?crtpage=${page}&kwd=${param.kwd}">${page}</a></li>	
								    	</c:when>
								    	<c:otherwise>
								    		<li><a  href="${pageContext.request.contextPath}/board/list3?crtpage=${page}&kwd=${param.kwd}">${page}</a></li>
								    	</c:otherwise>
								    </c:choose>
								
								</c:forEach>
								
								<c:if test="${requestScope.pMap.next}">
									<li><a href="${pageContext.request.contextPath}/board/list3?crtpage=${requestScope.pMap.endPageBtnNo+1}&kwd=${param.kwd}">▶</a></li>
								</c:if>
								
							</ul>
						</div>
                        <div class="btn-box">
                            <a class="btn btn-blue btn-md" href="">글쓰기</a>
                        </div>
                    </div>

                    
                </main>
            </div>
            
			<!-- footer -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
			<!-- //footer -->

        </div>
     
    </body>
</html>