<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restorani</title>
</head>
<body>
<h1>Lista restorana</h1>

<c:forEach items="${restaurantList}" var="rl">
	<div style="clear: left;"><p style="float: left;">
	<a href="<c:url value="restaurant/${rl.naziv}"/>">
	<img src="no_image1.png" border="0" alt="Null">
	</a>
	</p></div><p>${rl.naziv}</p>
	<br><br>
</c:forEach>

</body>
</html>