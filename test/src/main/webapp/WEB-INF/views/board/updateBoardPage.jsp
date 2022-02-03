<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<script type="text/javascript">

	function insertfail(){
		alert("작성에 실패했습니다. 관리자에게 문의하십시오. \n kucnea@naver.com");
	}
	
</script>


<body>
<h1>게시글 작성하기</h1>
<hr>
<c:if test="${result == 1 }">
			<script>
				insertfail();
			</script>
</c:if>

<form id="boardform" action="/board/updateboard" method="post">
	<input type="hidden" id="BIdx" name="BIdx" value="${board.getBIdx() }">
	제목 : <input type="text" id="BTitle" name="BTitle" value="${board.getBTitle() }" required> <br>
	작성자 : <input type="text" value="${member.getMId() }" readonly>
    <br>
	<textarea id="BContent" rows="30" cols="175" name="BContent" value="${board.getBContent() }" required></textarea> <br>
	<input type="submit" value="작성하기">
</form>


</body>
</html>