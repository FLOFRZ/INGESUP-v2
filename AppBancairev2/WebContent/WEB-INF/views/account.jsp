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
	<tr><td><fmt:message key="NumAccount" /></td> <td><fmt:message key="Libelle" /></td></tr>
	<c:forEach items="${Comptes}" var="compte">
	<tr>
		<td>${compte.num}     </td>
		<td>${compte.libelle} </td>
		<td><a href="/AppBancairev2/Transactions/${compte.num}"> <input type="button" value=<fmt:message key="Select" />> </a> </td>
	</tr>
	</c:forEach>
</table>




<p>Ajouter un client </p>
<form action="Name" method="post">
    <div>
        <label for="nomC">Nom :</label>
        <textarea type="text" name="nomC"></textarea>
    </div>
    <div>
        <label for="prenomC">Prenom :</label>
        <textarea type="text" name="prenomC"></textarea>
    </div>
    <div>
        <label for="loginC">Login :</label>
        <textarea type="text" name="loginC"></textarea>
    </div>
 	<div>
        <label for="passC">password :</label>
        <textarea type="text" name="passC"></textarea>
    </div>
    <div class="button">
        <button type="submit">ajouter</button>
    </div>
</form>



<!-- Include dynamique -->
<jsp:include page="greetings.jsp">
	<jsp:param value="?!" name="punctuation" /> 
</jsp:include>

</body>
</html>