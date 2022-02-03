<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>

<script  type="text/javascript">
	function loginfail(){
		alert("로그인 실패. 아이디와 비밀번호를 확인하세요");
	}
</script>

<body>

	<form id="loginForm"action="/join/loginmember" method="post">
		<c:if test="${result == 1 }">
			<script>
				loginfail();
			</script>
		</c:if>
		ID : <input type="text" id="MId" name="MId" placeholder="ID를 입력하세요" required> <br>
		PW : <input type="text" id="MPw" name="MPw" placeholder="PW를 입력하세요" required>
		<input type="submit" value="로그인">
	</form>

</body>
</html>