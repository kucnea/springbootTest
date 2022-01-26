<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>
<h1> 게시판 </h1>
	<c:choose>
		<c:when test="${msg eq '1' }">
				<h6>작성된 글이 없습니다.</h6>
		</c:when>
		<c:otherwise>
			<table>
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.getBIdx() }</td>
					<td>${vo.getBTitle() }</td>
					<td>${vo.Member.getMId() }</td>
				</tr>
			</c:forEach>
			</table>
			
		</c:otherwise>
	</c:choose>
	
</body>
</html>