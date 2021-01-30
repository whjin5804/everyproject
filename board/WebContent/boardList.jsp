<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

table {
	border : 1px solid black;
	border-collapse: collapse;
	text-align: center;
	padding : 10px;
}

tr, td {
	border : 1px solid black;
	border-collapse: collapse;
	padding : 10px;
}

.button1 {
	border: none;	
}

</style>
</head>
<body>
<table>
	<tr>
		<td>글번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
	</tr>
		<c:choose>
			<c:when test="${list.size() eq 0 }">
				<tr>
					<td colspan="4">데이터가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="board">
					<tr>
						<td>${board.number }</td>
						<td><a href="selectBoardDetail.bo">${board.title }</a></td>
						<td>${board.writer }</td>
						<td>${board.date }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr class="button1">
			<td colspan="4" style="text-align: center;" class="button1"><input type="button" value="글쓰기"
			onclick="location.href='boardWriteForm.bo';">
		</tr>
		
</table>

</body>
</html>