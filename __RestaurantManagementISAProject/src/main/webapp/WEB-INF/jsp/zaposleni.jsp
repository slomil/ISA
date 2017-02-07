<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/js/zaposleni.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" ></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/jquery-ui.min.js" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/designEmployee.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evidencija zaposlenih</title>
</head>
<body>
	<c:set var="profils">konobar,sanker,kuvar</c:set>
	<c:set var="count" value="0" ></c:set>
		
		<div class="naslov">
		Registracija zaposlenog:<br><br>
		</div>
		<div class="selekcija">
		<select name="profilType" id="idselekt" onchange="changeFunc()">
		<option value="NONE" label="Izaberi profil"/>
		<c:forTokens items="${profils}" delims="," var="profil">
		<option value="${profil}"><c:out value="${profil}"/></option>
		</c:forTokens>
		</select>
		</div>
		
		<script>
		//MENJA HIDDEN POLJE U FORMI U ZAVISNOSTI OD TOGA STA JE KLIKNUTO
		$(document).ready(function(){
			$("#forma").hide();
			$("#idselekt").change(function(){
	
			var x=changeFunc();
			if(x=="konobar") x="WAITER";
			if(x=="sanker") x="BARTENDER";
			if(x=="kuvar") x="COOK";
			$("#uloga").val(x);
			});
		
		});
		
		</script>
		
		<div class="employee">
		<c:url var="action" value="/employeeRegistration/try" />
		<form:form id="forma" action="${action}" method="post" modelAttribute="workerRegistration">
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
				<form:hidden path="role" id="uloga" value=""/>
			<tr>
				<td><form:input path="datumRodjenja" type="text" placeholder="Datum rodjenja"/></td>
				<td><form:errors path="datumRodjenja" /></td>
			</tr>	
			<tr>
				<td><form:input path="konfekcijskiBr" type="text" placeholder="Konfekcijski broj"/></td>
				<td><form:errors path="konfekcijskiBr" /></td>
			</tr>
			<tr>
				<td><form:input path="obucaBr" type="text" placeholder="Broj obuce"/></td>
				<td><form:errors path="obucaBr" /></td>
			</tr>
			<tr>
				<td><form:select path="nazivRestorana">
                	<form:option value="NONE" label="Izaberi restoran" />
                	<c:forEach items="${restaurantList}" var="r">
                    <form:option value="${r.naziv}"><c:out value="${r.naziv}"/></form:option>
                	</c:forEach>
                	</form:select></td>
				<td><form:errors path="nazivRestorana" /></td>
			</tr>
			<tr><td colspan="2"><button type="submit">Register</button></td></tr>
			</table>
		</form:form>
		<br>
		</div>
		
		<div id="poruka" class="poruka">${poruka}</div>
		
		<form name="formakal" action ="" accept-charset="UTF-8"  method="post">
		<div id="kalendar" class="kalendar">
		<table class="tabela" border="true" width="550" cellpadding="20">
			<tr><th colspan="7">February</th></tr>
			<tr>
			<td>&nbsp;</td><td>&nbsp;</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td>
			</tr>
			<tr>
			<td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td><td>12</td>
			</tr>
			<tr>
			<td>13</td><td>14</td><td>15</td><td>16</td><td>17</td><td>18</td><td>19</td>
			</tr>
			<tr>
			<td>20</td><td>21</td><td>22</td><td>23</td><td>24</td><td>25</td><td>26</td>
			</tr>
			<tr>
			<td>27</td><td>28</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			</tr>
		</table><br>
		<button></button>
		</div>
		</form>
		
		
		
</body>
</html>