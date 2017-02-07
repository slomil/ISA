<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/designHome.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<c:if test="${userR.role == 'SYSTEM_MANAGER0' or userR.role == 'SYSTEM_MANAGER'}">
<ul>
  <li><a href="<c:url value="systemManager/profil"/>">Profil</a></li>
  <li class="dropdown">
  <a href="javascript:void(0)" class="dropbtn">Aktivnosti</a>
  <div class="dropdown-content">
      <a href="<c:url value="systemManager/registracijaMenadzeraRestorana"/>">Registracija menadzera restorana</a>
      <a href="<c:url value="systemManager/registracijaRestorana"/>">Registracija restorana</a>
      <c:if test="${userR.role == 'SYSTEM_MANAGER0'}">
      <a href="<c:url value="systemManager/registracijaMenadzeraSistema"/>">Registracija menadzera sistema</a>
      </c:if>
    </div></li>
  <li><a href="<c:url value="home/logout"/>">Logout</a></li>
</ul>
</c:if>

<c:if test="${userR.role== 'GUEST'}">
<ul>
   <li><a href="<c:url value="guest/profil"/>">Profil</a></li>
  <li><a href="#news">Rezervacija restorana</a></li>
  <li><a href="#news">Istorija poseta restorana</a></li>
  <li><a href="#news">Prijatelji</a></li>
  <li><a href="<c:url value="home/logout"/>">Logout</a></li>
</ul>
</c:if>

<c:if test="${userR.role== 'RESTAURANT_MANAGER'}">
<ul>
   <li><a href="<c:url value="restaurants"/>">Restorani</a></li>
   <li><a href="<c:url value="employee"/>">Zaposleni</a></li>
   <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Ponude za namirnice</a>
    <div class="dropdown-content">
      <a href="<c:url value="restaurantManager/registracijaPonudjaca"/>">Registracija ponudjaca</a>
      <a href="#">Objava ponuda za namirnice</a>
    </div>
  </li>
  <li><a href="<c:url value="home/logout"/>">Logout</a></li>
</ul>
</c:if>
<div class="footer"></div>
<br>
</body>
</html>