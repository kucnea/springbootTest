<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<style>
	.centertd {
		text-align : center
	}
	
	th,td{
		border : 1px solid #444444;
	}
	
	a:hover {
	  text-decoration : underline;
	  color : orange;
	}
</style>

<body>
<h1> 게시판 </h1>
	<div style="float:right;">
		<input type="button" value="작성하기" onclick="location.href='/board/insertboardpage'">
	</div>
	<c:choose>
		<c:when test="${msg eq '1' }">
				<h6>작성된 글이 없습니다.</h6>
		</c:when>
		<c:otherwise>
			<table width="100%" height="30%">
			<tr>
				<th width="20%">글 번호</th>
				<th width="60%">글 제목</th>
				<th width="20%">작성자</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td class="centertd">${vo.getBIdx() }</td>
					<td><a onclick="location.href='/board/readboard?BIdx=${vo.getBIdx()}'">${vo.getBTitle() }</a></td>
					<c:choose>
						<c:when test="${vo.getMember() eq null }"> <td class="centertd">익명</td></c:when> 
						<c:otherwise><td class="centertd">${vo.getMember().getMId() }</td></c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
			</table>
			
		</c:otherwise>
	</c:choose>
	
</body>
</html>