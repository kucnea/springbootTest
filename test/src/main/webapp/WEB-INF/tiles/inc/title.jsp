<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
</head>
	<div style="background-color:orange;" >
		<b style="font-size:2em;" >hello Test Page</b>
		<div style="float:right; height:100%">
		<c:choose>
			<c:when test="${member eq null }">
				<input type="button" id="joinBtn" value="회원가입" width="30%" height="100%" onclick="location.href='/join/joinpage'">
				<input type="button" id="loginBtn" value="로그인" width="30%" height="100%" onclick="location.href='/join/loginpage'">			
			</c:when>
			<c:otherwise>
				${member.getMId() }님 환영합니다.
				<input type="button" id="logoutBtn" value="로그아웃" width="30%" height="100%" onclick="location.href='/join/logout'">
			</c:otherwise>
		</c:choose>
		<input type="button" id="BoardBtn" value="게시판" width="30%" height="100%" onclick="location.href='/board/boardpage'">
		
		</div>
	</div>
