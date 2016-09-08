<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>게시판</h1>
<form method="post" action="write.jsp" name="form">
	<table cellspacing="0" border="1">
	<thead>
		<tr>
			<th>NO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="listInfo" items="${list }">
			<tr>
				<td>${listInfo.seq }</td>
				<td>${listInfo.title }</td>
				<td>${listInfo.writer }</td>
				<td>${listInfo.regDate }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<div>
		<input type="button" value="글쓰기" onclick="writeFrom()"/>
	</div>
</form>

<script type="text/javascript">
function writeFrom(){
	location.href = "writeForm.do";
	
}
</script>
</body>
</html>