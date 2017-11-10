<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- Liste des import -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- include statique -->
<%@include file="header.jsp" %>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="transfer"/></title>
</head>

<body>
<form action="Transfer" method="post">
	<table>
		<tr>
			<td> <fmt:message key="transmitter" /><br><br></td>
			<td> <select name="transmitter">
					<c:forEach var="compte" items="${Comptes}">
						<option value="${compte.key.num}"}>	${compte.key.num} </option>
					</c:forEach>
				</select><br><br>
			</td>
		</tr>
		<tr>
			<td> <fmt:message key="receiver" /> </td>
			<td> <select name="receiver">
					<c:forEach var="compte" items="${Comptes}">
						<option value="${compte.key.num}"}>	${compte.key.num} </option>
					</c:forEach>
				</select><br><br>
			</td>
		</tr>
		<tr>
			<td> <fmt:message key="Amount"/> </td>
			<td> <input type="text" name="amount"></td>
		</tr>
		<tr>
			<td> <fmt:message key="Libelle"/> </td>
			<td> <input type="text" name="libelle"></td>
		</tr>
		
		<tr>
		<td></td>
			<td> <button type="submit"> <fmt:message key="OK" /></button></td>
		</tr>
		
		<tr>
		<td>
		<label>
		<c:choose>
			<c:when test="${result == true }">  <fmt:message key="transacOK" />     </c:when>
			<c:when test="${result == false }"> <fmt:message key="transacNOK" /> </c:when>
			
			<c:otherwise></c:otherwise>
		</c:choose>
		</label>
		</td>
		</tr>
	</table>
</form>
	
</body>
</html>