<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- include statique -->
<%@include file="header.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><fmt:message key="Title" /></title>
	</head>
<body>

	<form action="Accueil" method="post">
		<p><fmt:message key="s1" />     <input type="text" name="login"></p>
	    <p><fmt:message key="s2" /> <input type="password" name="password"></p>
	    <button type="submit"><fmt:message key="s3" /></button><br>
	    <label Name="error">${message}</label>
	</form>

</body>
</html>