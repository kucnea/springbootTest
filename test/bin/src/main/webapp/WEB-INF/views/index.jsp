<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<body>
	<!-- 
	<div style="margin:0 auto; background-color:orange; width:50%; height:50%;" >
	 -->

	<img src="/static/orange.jpg">
	<c:choose>
		<c:when test="${member ne null }">
			<h3>${member.getMId() }님 반갑습니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>로그인이 필요합니다.</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>