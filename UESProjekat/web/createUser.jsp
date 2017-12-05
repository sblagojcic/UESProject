<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="category" type="java.util.List" scope="request"/>

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
		<form action="./CreateUserController" method="post"class="dodavanjeKorisnikaForma" accept-charset="ISO-8859-1">
			<table class="dodavanjeKorisnikaTable">
				<tr>
					<td><fmt:message key="userName"/>:</td>
					<td><input type="text" name="userName" ></td>			
				</tr>
				<tr>
					<td><fmt:message key="firstName"/>:</td>
					<td><input type="text" name="firstName" ></td>				
				</tr>
				<tr>
					<td><fmt:message key="lastName"/>:</td>
					<td><input type="text" name="lastName" ></td>				
				</tr>
				<tr>
					<td><fmt:message key="lozinka"/>:</td>
					<td><input type="password" name="password" ></td>				
				</tr>

				<tr>
                <td><fmt:message key="type"/>:</td>
					<td>
						<select name="type">
								<option value="admin">Administrator</option>
								<option value="pretplatnik">Pretplatnik</option>					
						</select>
					</td>
				</tr>
				
				<tr>
				<td><fmt:message key="category"/>:</td>
					<td>
						<select name="category" >
							<option></option>
						<c:forEach items="${category}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				
<%-- 				<c:if test="${user.type == Administrator}"><c:out value="disabled='disabled'"/></c:if> --%>


				
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="<fmt:message key="dodaj"/>"></td>				
				</tr>
			</table>							
		</form>
		[<a href="./ReadUserController"><fmt:message key="userList"/></a>]<br/>
		[<a href="./LogoutController"><fmt:message key="odjava"/></a>]<br/>
	<body>
</html>