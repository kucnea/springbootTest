<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<script type="text/javascript">

	function validId(){
		if(document.getElementById("MId").value.length > 0){
			location.href="/join/validid?MId="+document.getElementById("MId").value
		}else{
			alert("입력된 아이디가 없습니다.");
		}
	}
	
</script>


<body>
<h1>회원가입</h1>
<hr>
<form id="joinform" action="/join/insertmember" method="post">
	ID : <input type="text" id="MId" name="MId" placeholder="Input Your ID" value="${preset }"> <input type="button" value="중복확인" onclick="validId()">
	<c:choose>
    	<c:when test="${result == 1 }">
    		<font size="0.7em" color="red"> 사용 가능한 ID 입니다.</font>
    	</c:when>
    	<c:when test="${result1 == 2 }">
    		<font size="0.7em" color="red"> 사용 불가한 ID 입니다.</font>
    	</c:when>
    </c:choose>
     <br>
	PW : <input type="text" id="MPw" name="MPw" placeholder="Input Your PASSWORD"> <br>
	<input type="submit" value="가입하기">
</form>


</body>
</html>