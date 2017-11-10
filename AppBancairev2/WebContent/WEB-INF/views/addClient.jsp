<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="header.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="addClient"/></title>
</head>
<body>

<p><fmt:message key="addClient" /> </p>
<form action="AddClient" method="post">
    <div>
        <label for="nomC"><fmt:message key="name"/> :</label>
        <input type="text" name="nomC"></input>
    </div>
    <div>
        <label for="prenomC"><fmt:message key="firstName"/> :</label>
        <input type="text" name="prenomC"></input>
    </div>
    <div>
        <label for="loginC"><fmt:message key="login"/> :</label>
        <input type="text" name="loginC"></input>
    </div>
 	<div>
        <label for="passC"><fmt:message key="password"/> :</label>
        <input type="password" name="passC"></input>
    </div>
    <div class="button">
        <button type="submit"><fmt:message key="add"/></button>
    </div>
    <label>
		<c:choose>
			<c:when test="${result == 0 }"> <fmt:message key="clientAdded" />     </c:when>
			<c:when test="${result == 1 }"> <fmt:message key="clientNotAdded1" /> </c:when>
			<c:when test="${result == 2 }"> <fmt:message key="clientNotAdded2" /> </c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</label>
</form>

</body>
</html>