<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="eBook" type="rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.eBook" scope="request"/>
<jsp:useBean id="categorys" type="java.util.List" scope="request"/>
<jsp:useBean id="countrys" type="java.util.List" scope="request"/>
<jsp:useBean id="languages" type="java.util.List" scope="request"/>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="promenaVozila"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if>
	<body>
		<form action="./UpdateController" method="post" class="promenaVozilaForma" accept-charset="ISO-8859-1">
			<table class="promenaVozilaTabela">
				<tr>
					<td><fmt:message key="title"/>:</td>
					<td><input type="text" name="title" value="${eBook.title}"></td>			
				</tr>
				<tr>
					<td><fmt:message key="author"/>:</td>
					<td><input type="text" name="author" value="${eBook.author}"></td>			
				</tr>
				<tr>
					<td><fmt:message key="keywords"/>:</td>
					<td><input type="text" name="keywords" value="${eBook.keywords}"></td>				
				</tr>
				<tr>
					<td><fmt:message key="publicationYear"/>:</td>
					<td><input type="text" name="publicationYear" value="${eBook.publicationYear}" ></td>				
				</tr>
				<tr>
					<td><fmt:message key="filename"/>:</td>
					<td><input type="text" name="filename" value="${eBook.filename}"></td>			
				</tr>
				<tr>
					<td><fmt:message key="MIME"/>:</td>
					<td><input  type="text" name="MIME" value="${eBook.MIME}"></td>				
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
							<c:if test="${eBook.country.id == country.id}">
								<option value="${country.id}" selected="selected">${country.name}</option>
							</c:if>
							<c:if test="${eBook.country.id != country.id}">
								<option value="${country.id}">${country.name}</option>
							</c:if>
						</c:forEach>
						</select>
					</td>				
				</tr>
				<tr>
					<td><fmt:message key="language"/>:</td>
					<td>
						<select name="language">
						<c:forEach items="${languages}" var="language">
							<c:if test="${eBook.language.id == language.id}">
								<option value="${language.id}" selected="selected">${language.name}</option>
							</c:if>
							<c:if test="${eBook.language.id != language.id}">
								<option value="${language.id}">${language.name}</option>
							</c:if>
						</c:forEach>
						</select>
					</td>				
				</tr>					
				<tr>
					<td><input type="hidden" name="id" value="${eBook.id}"></td>
					<td><input type="submit" name="submit" value="<fmt:message key="promeni"/>"></td>				
				</tr>
			</table>											
		</form>
		[<a href="./ReadControllereBook"><fmt:message key="eBookList"/></a>]<br/>
		[<a href="./LogoutController"><fmt:message key="odjava"/></a>]<br/>
	</body>	
</html>