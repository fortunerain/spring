<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
<h1>글 쓰기</h1>
<form method="post" action="write" name="form">
	<table cellspacing="0" border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" style="width: 100%" id="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="100" id="content"></textarea></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" style="width: 100%" id="password"></td>
		</tr>
	</table>
	<div>
		<input type="button" value="취소" onclick="javascript:history.go(-1)"/>
		<input type="button" value="확인" onclick="addBoard()" id="writeButton"/>
	</div>
</form>

</body>
<script type="text/javascript">
$('#writeButton').click(function(){
	var title = $("#title").val();
	var content = $("#content").val();
	var password = $("#password").val();
	
	$.ajax({
		url : "write", type : "POST", dataType : "json",
		data : 
		{
			title : title,
			content : content,
			password : password
		},
		success : function(data){
			if(data.returnCode=="insertSuccess"){
				alert("추가되었습니다.");
				location.href = "board";
			}else{
				alert("오류가 발생하였습니다.");
			}
		}
	});
});

</script>
</html>