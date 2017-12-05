<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="categorys" type="java.util.List" scope="request"/>
<jsp:useBean id="countrys" type="java.util.List" scope="request"/>
<jsp:useBean id="languages" type="java.util.List" scope="request"/>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="addNewMovie"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<form action="./CreateController" method="post"class="dodavanjeVozilaForma" accept-charset="ISO-8859-1">
			<table class="dodavanjeVozilaTabela">
				<tr>
					<td><fmt:message key="title"/>:</td>
					<td><input type="text" name="title" value="${eBookIndex.title}"></td>			
				</tr>
				<tr>
					<td><fmt:message key="author"/>:</td>
					<td><input type="text" name="author" value="${eBookIndex.author}"></td>			
				</tr>
				<tr>
					<td><fmt:message key="keywords"/>:</td>
					<td><input type="text" name="keywords" value="${eBookIndex.keywords}"></td>				
				</tr>
				<tr>
					<td><fmt:message key="publicationYear"/>:</td>
					<td><input type="text" name="publicationYear" ></td>				
				</tr>
				<tr>
					<td><fmt:message key="filename"/>:</td>
					<td><input type="text" name="filename" value="${eBookIndex.filename}"></td>			
				</tr>
				<tr>
					<td><fmt:message key="MIME"/>:</td>
					<td><input  type="text" name="MIME" value="application/pdf"></td>				
				</tr>

				
				<tr>
					<td><fmt:message key="category"/>:</td>
				<c:if test="${sessionScope.category_id!=null }">
					<td>
						<select name="category">
						<c:forEach items="${categorys}" var="category">
							<c:if test="${category.id == sessionScope.category_id }">
							<option value="${category.id}">${category.name}</option>
							</c:if>
						</c:forEach>
						</select>
					</td>				
				</c:if>
				<c:if test="${sessionScope.category_id==null }">
				<td>
						<select name="category">
						<c:forEach items="${categorys}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
						</select>
					</td>
				</c:if>	
				</tr>	
				<tr>
					<td><fmt:message key="country"/>:</td>
					<td>
						<select name="country">
						<c:forEach items="${countrys}" var="country">
							<option value="${country.id}">${country.name}</option>
						</c:forEach>
						</select>
					</td>				
				</tr>
				
				<tr>
					<td><fmt:message key="language"/>:</td>
					<td>
						<select name="language">
						<c:forEach items="${languages}" var="language">
							<option value="${language.id}">${language.name}</option>
						</c:forEach>
						</select>
					</td>				
				</tr>
									
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="<fmt:message key="dodaj"/>"></td>				
				</tr>
			</table>							
		</form>
		[<a href="./ReadControllereBook"><fmt:message key="eBookList"/></a>]<br/>
		[<a href="./LogoutController"><fmt:message key="odjava"/></a>]<br/>
	<body>
</html>