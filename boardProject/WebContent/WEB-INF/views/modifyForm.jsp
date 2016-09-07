<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body onload="result()">
<h1>글 수정</h1>
<form method="post" action="modify" name="form">
	<input type="hidden" id="seq" name="seq" value="${boardVo.seq }"/>
	<table cellspacing="0" border="1">
		<tr>
			<th>글번호</th>
			<td>${boardVo.seq }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" style="width: 100%" name="title" value="${boardVo.title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="100" name="content">${boardVo.content }</textarea></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" style="width: 100%" name="password" id="password"></td>
		</tr>
	</table>
	<div>
		<input type="button" value="확인" onclick="modify()"/>
		<input type="button" value="목록" onclick="javascript:location.href = 'board'"/>
		<input type="button" value="삭제" onclick="del();"/>
	</div>
</form>

</body>
<script type="text/javascript">
function result(){
	var returnCode = "${returnCode }";
	if(returnCode != "searchSuccess"){
		if(returnCode == "updateSuccess"){
			alert("변경되었습니다.");
			returnCode = "";
		}else if(returnCode == "deleteSuccess"){
			alert("삭제되었습니다.");
			location.href="board";
		}else if(returnCode == "notMatchNum"){
			alert("해당 글이 존재하지 않습니다.");
		}else if(returnCode == "notMatchPassword"){
			alert("비밀번호가 일치하지 않습니다.");
			var password = document.getElementById('password');
			password.focus();
		}else{
			alert("오류가 발생했습니다.");
		}
	}
}

function isPwdEmpty(){
	var password = document.getElementById('password');
	if(password.value == ''){
		alert("비밀번호를 입력해주세요.");
		password.focus();
		return false;
	}
	return true;
}

function modify(){
	if(isPwdEmpty()){
		form.action = "modify";
		form.submit();
	}
}

function del(){
	if(isPwdEmpty()){
		form.action = "delete";
		form.submit();
	}
}
</script>
</html>