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

<form id="boardform" action="/board/insertboard" method="post">
	제목 : <input type="text" id="BTitle" name="BTitle" placeholder="제목을 입력하세요" required> <br>
	<c:choose>
    	<c:when test="${member eq null }">
    		작성자 : <input type="text" value="익명" readonly> <br>
    		<a style="color: red"> 익명 작성자 글은 수정, 삭제가 되지 않습니다.</a>
    	</c:when>
    	<c:when test="${member ne null }">
    		작정자 : <input type="text" value="${member.getMId() }" readonly>
    	</c:when>
    </c:choose>
    <br>
	<textarea id="BContent" rows="30" cols="175" name="BContent" placeholder="내용" required></textarea> <br>
	<input type="submit" value="작성하기">
</form>


</body>
</html>