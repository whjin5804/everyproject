<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardWrite.bo" method="post">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<td>날짜</td>
			<td><input type="date" name="date"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="30px" cols="30px" name="content">내용</textarea></td>
		</tr>
	</table>
	<input type="submit" value="작성완료">
</form>
</body>
</html>