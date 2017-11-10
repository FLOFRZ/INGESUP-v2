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
	<title><fmt:message key="AccountPage"/></title>
</head>

<body>
<br>
<h2><fmt:message key="AccountTitle" /></h2>

<table>
	<tr><td><fmt:message key="NumAccount" /></td> <td><fmt:message key="Libelle" /></td><td><fmt:message key="solde" /></td></tr>
	<c:forEach var="compte" items="${Comptes}">
	<tr>
		<td>${compte.key.num}      </td>
		<td>${compte.key.libelle}  </td>
		<td>${compte.value} &euro; </td>
		<td><a href="/AppBancairev2/Transactions/${compte.key.num}"> 
				<input type="button" value=<fmt:message key="Select"/> >
			</a> 
		</td>
	</tr>
	</c:forEach>
</table>


<!-- Include dynamique -->
<jsp:include page="greetings.jsp">
	<jsp:param value="?!" name="punctuation" /> 
</jsp:include>

</body>
</html>