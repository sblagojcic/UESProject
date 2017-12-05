<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="mainMenu"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		
		<table>
			<tr>
				<th><fmt:message key="userName"/></th>
				<th><fmt:message key="editUser"/></th>
				<th><fmt:message key="changePassword"/></th>
			</tr>
			
			<tr>
				<td>${sessionScope.admin.userName}</td>
	
				<td><a href="./PreparePersonalUpdateController?id=${sessionScope.admin.id }"><fmt:message key="editUser"/></a></td>
				
				<td><a href="./PrepareUserPassUpdateController?id=${sessionScope.admin.id }"><fmt:message key="changePassword"/></a></td>
			</tr>
		</table>
		<c:if test="${sessionScope.type==requestScope.tipAdmin}">
		[<a href="./ReadCategoryController"><fmt:message key="categoryList"/></a>]<br/>
		[<a href="./ReadUserController"><fmt:message key="userList"/></a>]<br/>
		</c:if>
		[<a href="search.jsp">Search</a>]<br/>
		[<a href="./ReadControllereBook"><fmt:message key="eBookList"/></a>]<br/>
		[<a href="./LogoutController"><fmt:message key="Logout"/></a>]<br/>
		
	</body>	
</html>