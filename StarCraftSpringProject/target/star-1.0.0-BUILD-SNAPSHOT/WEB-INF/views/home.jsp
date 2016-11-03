<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html lang="ko">
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<p>
<%
int a = 3+4;
out.print(a); 
%>2
</p>

<script type="text/javascript">
var i = 3+4;
//alert("i의 값은 : "+i);
</script>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<div ng-app>
 	<p>My first expression: {{ 3 + 4 }}</p>
</div>

<div>
 	<p>My second expression: <span ng-bind="3+4"></span></p>
</div>


<div style="margin:0px auto; width:520px; height:520px; border-style: solid; ">
<%
for(int i=0 ; i<100;i++){
%>
   <div style="float:left; width:50px; height:50px; background:red; margin:1px;"></div>
   
<%
}
%>
</div>
</body>
</html>
