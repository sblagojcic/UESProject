<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="eBooks" type="java.util.List" scope="request"/>
<jsp:useBean id="categories" type="java.util.List" scope="request"/>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="eBookList"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
<%-- 	<c:if test="${sessionScope.admin==null}"> --%>
<%-- 		<c:redirect url="./login.jsp" /> --%>
<%-- 	</c:if> --%>
	<body>
		<table class="listaVozilaTabela">
			<thead>
				<tr>
					<th><fmt:message key="title"/></th>
					<th><fmt:message key="author"/></th>
					<th><fmt:message key="keywords"/></th>
					<th><fmt:message key="publicationYear"/></th>
					<th><fmt:message key="filename"/></th>
					<th><fmt:message key="MIME"/></th>
					<th><fmt:message key="country"/></th>
					<th><fmt:message key="language"/></th>
					<th><fmt:message key="category"/></th>

				</tr>
			</thead>
			<tbody>
		
			<c:forEach items="${eBooks}" var="eBook">
		
				<tr>
					<td>${eBook.title}</td>
					<td>${eBook.author}</td>
					<td>${eBook.keywords}</td>
					<td>${eBook.publicationYear}</td>
					<td>${eBook.filename}</td>
					<td>${eBook.MIME}</td>
					<td>${eBook.country.name}</td>
					<td>${eBook.language.name}</td>
					<td>${eBook.category.name}</td>
					

					

				</tr>
		
				</c:forEach>
			
					
			</tbody>
		</table>
		
		Filter by category:
				<form action="./ReadController">
					<select name="search">
					
						<c:forEach items="${categories}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					
					</select>
					
					<input type="submit" name="submit" value="<fmt:message key="dodaj"/>"/>
				</form>
		[<a href="./ReadController">Show all</a>]<br/>
		[<a href="search.jsp">Search</a>]<br/>
		[<a href="./MainController"><fmt:message key="prijava"/></a>]<br/>
		
	</body>	
</html>