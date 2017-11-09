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
	<title><fmt:message key="updatepass" /></title>
</head>
<body>
<br><br>
<form action="UpdateClientPassword" method="post">
        <label><fmt:message key="CurrentPass" /></label>   <br> 
        <input type="password" name="currentPass"></input> <br><br>
        
        <label><fmt:message key="NewPass" /></label>       <br>
        <input type="password" name="newPass1"></input>    <br>
        <input type="password" name="newPass2"></input>    <br>
        <button type="submit"><fmt:message key="OK" /></button> <br>
		<label Name="error">
		<c:choose>
			<c:when test="${result == 0 }"><fmt:message key="updatePassResponse0" /> </c:when>
			<c:when test="${result == 1 }"><fmt:message key="updatePassResponse1" /> </c:when>
			<c:when test="${result == 2 }"><fmt:message key="updatePassResponse2" /> </c:when>
			<c:when test="${result == 3 }"><fmt:message key="updatePassResponse3" /> </c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		</label>

</form>


</body>
</html>