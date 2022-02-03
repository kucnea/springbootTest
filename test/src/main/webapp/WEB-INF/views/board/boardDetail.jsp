<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<script type="text/javascript">
	
</script>


<body>
<h1> 게시판 </h1>
	<div style="float:right; height:100%">
		<input type="button" value="글목록" onclick="location.href='/board/boardpage'">
		<c:choose>
			<c:when test="${member.getMIdx() eq board.getMember().getMIdx()}">
				<input type="button" value="수정하기" onclick="location.href='/board/updateboardpage?BIdx=${board.getBIdx() }'">
				<input type="button" value="삭제하기" onclick="location.href='/board/deleteboard?BIdx=${board.getBIdx() }'">
			</c:when>
		</c:choose>
		
	</div>
	
	<h3>${board.getBTitle() }</h3><br><hr>
	작성자 : 
	<c:choose>
		<c:when test="${board.getMember() eq null }">익명</c:when>
		<c:otherwise>${board.getMember().getMId() }</c:otherwise>
	</c:choose><br><br><br><hr>
	
	${board.getBContent() }
	<br><br><br>
	<hr>
	
</body>
</html>