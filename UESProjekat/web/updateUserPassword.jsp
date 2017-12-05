<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title><fmt:message key="changePassword"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
</head>
		<c:if test="${sessionScope.admin==null}">
			<c:redirect url="./login.jsp" />
		</c:if>
<body>
	<form method="post" action="./UpdateUserPasswordController" accept-charset="ISO-8859-1">
		<table>
			<tr>
				<td><fmt:message key="lozinka"/>:</td>
				<td><input type="password" name="password" value="${user.password}"></td>	
			</tr>
			<tr>
				<td><fmt:message key="repeatedPassword"/>:</td>
				<td><input type="password" name="repeatedPassword" value="${user.password}"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="${user.id}"></td>
				<td><input type="submit" name="submit" value="<fmt:message key="promeni"/>"></td>				
			</tr>
		</table>
	</form>
	[<a href="./LogoutController"><fmt:message key="odjava"/></a>]<br/>
</body>
</html>