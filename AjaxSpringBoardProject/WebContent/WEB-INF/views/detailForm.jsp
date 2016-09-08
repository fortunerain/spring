<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>글 상세</h1>
<form method="post" action="modifyForm" name="form">
	<input type="hidden" id="seq" name="seq" value="${boardVo.seq }"/>
	<table cellspacing="0" border="1" style="width: 1000px;">
	<col width="10%"><col width="*">
		<tr>
			<th>글번호</th>
			<td><pre>${boardVo.seq }</pre></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><pre>${boardVo.title }</pre></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre>${boardVo.content }</pre></td>
		</tr>
	</table>
	<div>
		<input type="button" value="취소" onclick="javascript:history.go(-1)"/>
		<input type="submit" value="수정" />
	</div>
</form>

</body>
</html>