<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/designMenuItems.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${naziv}</title>
</head>
<body>
	
	<div class="naslov">
	Podaci o restoranu:<br><br>
	</div>
	
	<div class="forma">
	<c:url var="action" value="/urediProfil/${naziv}/try" />
		<form:form id="register3" action="${action}" method="post" modelAttribute="restaurantRegistration">
			<table>
			<tr>
				
				<td><form:input path="naziv" type="text" value="${restaurant.naziv}" placeholder="Naziv restorana" /></td>
				<td><form:errors path="naziv" /></td>
			</tr>
			<tr>
				
				<td><form:input path="adresa" type="text" value="${restaurant.adresa}" placeholder="Adresa restorana" /></td>
				<td><form:errors path="adresa" /></td>
			</tr>
			<tr>
				
				<td><form:input path="vrsta"  type="text" value="${restaurant.vrsta}" placeholder="Vrsta restorana" /></td>
				<td><form:errors path="vrsta" /></td>
			</tr>
					<form:hidden path="emailManager" value="${restaurant.emailManager}"/>
					
			<tr><td colspan="2"><button type="submit">Edit</button></td></tr>
			</table><br>
			${poruka}
		</form:form>
	</div>
	
	
	
</body>
</html>