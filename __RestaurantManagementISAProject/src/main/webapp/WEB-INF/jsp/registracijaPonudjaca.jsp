<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/designRegistration.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registracija ponudjaca</title>
</head>
<body>
	
	<div class="polje1">
	<c:url var="action" value="/restaurantManager/registracijaPonudjaca/try" />
		<form:form id="register3" action="${action}" method="post" modelAttribute="bidderRegistration">
			<table>
			<tr>
				
				<td><form:input path="ime" type="text" placeholder="Ime" /></td>
				<td><form:errors path="ime" /></td>
			</tr>
			<tr>
				
				<td><form:input path="prezime" type="text" placeholder="Prezime"/></td>
				<td><form:errors path="prezime" /></td>
			</tr>
			<tr>
				
				<td><form:input path="email" type="text" placeholder="Email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				
				<td><form:input path="password" type="password" placeholder="Lozinka"/></td>
				<td><form:errors path="password" /></td>
			</tr>
		    <tr>
				
				<td><form:input path="repeatPassword" type="password" placeholder="Potvrda lozinke"/></td>
				<td><form:errors path="repeatPassword" /></td>
			</tr> 
				<form:hidden path="role" value="BIDDER"/>
			<tr>
				
				<td><form:select path="nazivRestorana">
                	<form:option value="NONE" label="Izaberi restoran" />
                	<c:forEach items="${restaurantList}" var="rl">
                    <form:option value="${rl.naziv}"><c:out value="${rl.naziv}"/></form:option>
                	</c:forEach>
                	</form:select>
				<td><form:errors path="nazivRestorana"/></td>
			</tr>
			<tr><td colspan="2"><button type="submit">Submit</button></td></tr>
			</table><br>
			${poruka}
		</form:form>
		</div>
		<div class="polje2"><a href=<c:url value="/home"/>>Povratak na pocetnu stranicu</a>
		</div>


</body>
</html>