<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="nematePristup"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<h1><fmt:message key="nematePristup"/></h1>
		<p><fmt:message key="pristupOnemogucen"/></p>
		[<a href="./LogoutController"><fmt:message key="Logout"/></a>]<br/>
		<c:if test="${sessionScope.pretplatnik!=null}">
		[<a href="./ModeratorController"><fmt:message key="mainMenu"/></a>]<br/>
		</c:if>
		<c:if test="${sessionScope.admin!=null}">
		[<a href="./MainController"><fmt:message key="mainMenu"/></a>]<br/>
		</c:if>
		<c:if test="${sessionScope.admin == null || sessionScope.pretplatnik == null}">
			<c:redirect url="./login.jsp" />
		</c:if>
	</body>
</html>	