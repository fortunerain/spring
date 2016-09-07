<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>글 쓰기</h1>
<form method="post" action="write" name="form">
	<table cellspacing="0" border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" style="width: 100%" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="100" name="content"></textarea></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" style="width: 100%" name="password"></td>
		</tr>
	</table>
	<div>
		<input type="button" value="취소" onclick="javascript:history.go(-1)"/>
		<input type="submit" value="확인" />
	</div>
</form>

</body>
</html>