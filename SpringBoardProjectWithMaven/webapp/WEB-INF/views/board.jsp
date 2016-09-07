<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>게시판</h1>
<form method="post" action="detailForm" name="form">
	<input type="hidden" id="seq" name="seq" value=""/>
	<table cellspacing="0" border="1" style="width: 1000px;">
	<col width="5%"><col width="*"><col width="10%"><col width="10%">
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
				<td><a href="#" onclick="detailForm(${listInfo.seq })">${listInfo.title }</a></td>
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
</body>

<script type="text/javascript">
function writeFrom(){
	location.href = "writeForm";
}

function detailForm(seq){
	document.getElementById('seq').value = seq;
	form.submit();
}
</script>
</html>