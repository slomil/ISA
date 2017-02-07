<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/designLogin.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<div class="polje1">
	<c:url var="action" value="/login/try" />
		<form:form id="login" action="${action}" method="post" modelAttribute="userLogin">
			<table>
			<tr>
				<td class="email"><form:input path="email" type="text" placeholder="Username"/></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td class="email"><form:input path="password" type="password" placeholder="Password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr><td colspan="2"><button type="submit">Sign in</button></td></tr>
		
			</table>
		</form:form><br>
		${model.poruka}
		</div>
	
		<br><br>
		<div class="polje2">
		Niste registrovani?<a href="<c:url value="/registracija"/>">Registracija</a>
		</div>
		<br>
		
</body>
</html>