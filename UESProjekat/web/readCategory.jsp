<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="categorys" type="java.util.List" scope="request"/>

<fmt:setBundle basename="messages.messages"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title><fmt:message key="categoryList"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
<body>
	
		<body>
			<table class="listaUseraTabela">
				<thead>
					<tr>
						<th><fmt:message key="category"/></th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categorys}" var="i">
					<tr>
						<td>${i.name}</td>
						<td><a href="./PrepareCategoryUpdateController?id=${i.id }"><fmt:message key="editCategory"/></a></td>
						<td><a href="./DeleteCategoryController?id=${i.id}"><fmt:message key="delete"/></a></td>			
					</tr>
					</c:forEach>
				</tbody>
			</table>
			[<a href="./LogoutController"><fmt:message key="Logout"/></a>]<br/>
			[<a href="./PrepareCreateCategoryController"><fmt:message key="addNewCategory"/></a>]<br/>
			[<a href="./MainController"><fmt:message key="mainMenu"/></a>]<br/>
		</body>
	
</body>
</html>