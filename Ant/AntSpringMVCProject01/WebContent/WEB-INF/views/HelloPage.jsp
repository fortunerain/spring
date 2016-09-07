<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Home - SecondSpringMVC2</title>
</head>
<body>
	<h1>First Spring MVC2 Application Demo</h1>
	<form method="post" action="welcome">
		name: <input type="text" name="name" /> 		 	        
		<input type="submit" value="Search" /> 
	</form>

	<h2>${welcomeMessage}</h2>
	<table border="1">
		<c:forEach items = '${authUsers}' var='authitem'> 
			<tr>
				<td><c:out value='${authitem.id}'/>  </td>
				<td><c:out value='${authitem.password}'/>  </td>
				<td><c:out value='${authitem.name}'/>  </td>
				<td><c:out value='${authitem.role}'/>  </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
