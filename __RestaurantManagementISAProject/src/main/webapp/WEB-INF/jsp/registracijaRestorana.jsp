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
<title>Registracija restorana</title>
</head>
<body>

	<div class="polje1">
	<c:url var="action" value="/systemManager/registracijaRestorana/try" />
		<form:form id="register3" action="${action}" method="post" modelAttribute="restaurantRegistration">
			<table>
			<tr>
				
				<td><form:input path="naziv" type="text" placeholder="Naziv restorana" /></td>
				<td><form:errors path="naziv" /></td>
			</tr>
			<tr>
				
				<td><form:input path="adresa" type="text" placeholder="Adresa restorana" /></td>
				<td><form:errors path="adresa" /></td>
			</tr>
			<tr>
				
				<td><form:input path="vrsta" type="text" placeholder="Vrsta restorana" /></td>
				<td><form:errors path="vrsta" /></td>
			</tr>
			<tr>
				
				<td><form:select path="emailManager">
                	<form:option value="NONE" label="Dodaj menadzera restorana" />
                	<c:forEach items="${restaurantManagers}" var="rm">
                    <form:option value="${rm.email}"><c:out value="${rm.ime} ${rm.prezime}"/></form:option>
                	</c:forEach>
                	</form:select></td>
				<td><form:errors path="emailManager"/></td>
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