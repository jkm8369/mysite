<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<header class="clearfix">

<h1><a href="/">MySite</a></h1>
       
	<%-- ${!empty sessionScope.authUser } --%>
  	<%-- ${sessionScope.authUser != null } --%>
  	<!-- 로그인 되었을때 (세션에 값이 있을 때) -->
    <c:if test="${sessionScope.authUser != null }">
      	
      	<ul class="clearfix">
		<li><span class="user-welcome">${sessionScope.authUser.name} 님 안녕하세요^^</span></li>
		<li>
			<a class="btn btn-white btn-sm" href="/user/logout">로그아웃</a>
        </li>
        <li>
            <a class="btn btn-white btn-sm" href="/user/modify">정보수정</a>
        </li>
    </ul>

    </c:if>
          
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
	<!-- 로그인 되지 않을 때 (세션에 값이 없을 때) -->
	<c:if test="${sessionScope.authUser == null }">
            
		<ul class="clearfix">
			<li>
        		<a class="btn btn-white btn-sm" href="/user/loginform">로그인</a>
    		</li>
		    <li>
		        <a class="btn btn-white btn-sm" href="/user/joinform">회원가입</a>
		    </li>
                
        </ul>
    </c:if>  	
            
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