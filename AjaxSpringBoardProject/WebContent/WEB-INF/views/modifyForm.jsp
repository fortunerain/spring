<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
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
			<td><input type="text" style="width: 100%" id="title" value="${boardVo.title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="100" id="content">${boardVo.content }</textarea></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" style="width: 100%" id="password"></td>
		</tr>
	</table>
	<div>
		<input type="button" value="확인" id="modifyButton" />
		<input type="button" value="목록" onclick="javascript:location.href = 'board'"/>
		<input type="button" value="삭제" id="delButton" />
	</div>
</form>

</body>
<script type="text/javascript">

function isPwdEmpty(){
	var password = $("#password");
	if(password.val() == ''){
		alert("비밀번호를 입력해주세요.");
		password.focus();
		return false;
	}
	return true;
}

$('#modifyButton').click(function(){
	if(isPwdEmpty()){
		var seq = $("#seq").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var password = $("#password").val();
		
		$.ajax({
			url : "modify", type : "POST", dataType : "json",
			data : 
			{
				seq : seq,
				title : title,
				content : content,
				password : password
			},
			success : function(data){
				var returnCode = data.returnCode;
				if(returnCode == "updateSuccess"){
					alert("변경되었습니다.");
				}else if(returnCode == "deleteSuccess"){
					alert("삭제되었습니다.");
					location.href="board";
				}else if(returnCode == "notMatchNum"){
					alert("해당 글이 존재하지 않습니다.");
				}else if(returnCode == "notMatchPassword"){
					alert("비밀번호가 일치하지 않습니다.");
					$("#password").focus();
				}else{
					alert("오류가 발생했습니다.");
				}
			}
		});
	}
});


$('#delButton').click(function(){
	if(isPwdEmpty()){
		var seq = $("#seq").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var password = $("#password").val();
		
		$.ajax({
			url : "delete", type : "POST", dataType : "json",
			data : 
			{
				seq : seq,
				title : title,
				content : content,
				password : password
			},
			success : function(data){
				var returnCode = data.returnCode;
				if(returnCode == "updateSuccess"){
					alert("변경되었습니다.");
				}else if(returnCode == "deleteSuccess"){
					alert("삭제되었습니다.");
					location.href="board";
				}else if(returnCode == "notMatchNum"){
					alert("해당 글이 존재하지 않습니다.");
				}else if(returnCode == "notMatchPassword"){
					alert("비밀번호가 일치하지 않습니다.");
					$("#password").focus();
				}else{
					alert("오류가 발생했습니다.");
				}
			}
		});
	}
});
</script>
</html>