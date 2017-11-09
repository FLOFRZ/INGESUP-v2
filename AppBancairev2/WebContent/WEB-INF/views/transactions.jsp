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
	<title><fmt:message key="TransactionPage" /></title>
</head>

<body>
<br>
<h2><fmt:message key="TransactionTitle" /> ${NumCompte}</h2>
<table>
	<tr>
		<td><fmt:message key="ID" /></td>
		<td><fmt:message key="Libelle" /> </td>
		<td><fmt:message key="Date" /></td>
		<td><fmt:message key="Amount" /></td>
	</tr>
	<c:forEach items="${Transactions}" var="transac">
	<tr>
		<td>${transac.transacID}  </td>
		<td>${transac.libelle}    </td>
		<td>${transac.dateTransac}</td>
		<td>${transac.montant}    </td>
	</tr>
	</c:forEach>
</table>


</body>
</html>