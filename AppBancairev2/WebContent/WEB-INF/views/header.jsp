<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="messages.messages"/>

<h1><a href="ClientAccount"><fmt:message key="HeaderTitle"/></a></h1>

<table>sss
	<TR>
		<td><p>${Client.nom} ${Client.prenom} <br>
 			   ${Client.clientID}</p> 
 		</td>
 		<td>
			<form>
				<select id="language" name="language" onchange="submit()">
					<option value="fr_FR" ${language == 'fr_FR' ? 'selected' : ''}>Français</option>
					<option value="en_US" ${language == 'en_US' ? 'selected' : ''}>English</option>
				</select>
			</form>
 		</td>
 		<td>
 			<a href="UpdateClientPassword" >
 				<button type="button"> <fmt:message key="updatepass" /> </button>
 			</a>
 		</td>
 		<td>
 			<a href="">
 				<button type="button"> <fmt:message key="addClient"/>  </button>
 			</a>
 		</td>
	</TR>
</table>

</html>