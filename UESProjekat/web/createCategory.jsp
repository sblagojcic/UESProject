<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="addNewUser"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<form action="./CreateCategoryController" method="post"class="dodavanjeKorisnikaForma" accept-charset="ISO-8859-1">
			<table class="dodavanjeKorisnikaTable">
				<tr>
					<td><fmt:message key="category"/>:</td>
					<td><input type="text" name="name" ></td>			
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="<fmt:message key="dodaj"/>"></td>				
				</tr>
			</table>							
		</form>
		[<a href="./ReadCategoryController"><fmt:message key="categoryList"/></a>]<br/>
		[<a href="./LogoutController"><fmt:message key="odjava"/></a>]<br/>
	<body>
</html>