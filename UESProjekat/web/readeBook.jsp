<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="eBooks" type="java.util.List" scope="request"/>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="eBookList"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
<%-- 	<c:if test="${sessionScope.admin==null}">
		<c:redirect url="./login.jsp" />
	</c:if> --%>
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
			<c:if test="${sessionScope.type==requestScope.tipAdmin }">
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

					<td><a href="./PrepareUpdateController?eBookId=${eBook.id}"><fmt:message key="editeBook"/></a></td>
					<td><a href="./DeleteController?eBookId=${eBook.id}"><fmt:message key="delete"/></a></td>		
						
						
				</tr>
				</c:forEach>
				</c:if>
				
			<c:if test="${sessionScope.type==requestScope.tipPretplatnik }">
				<c:forEach items="${eBooks}" var="eBook">
					<c:if test="${eBook.category.id == sessionScope.category_id }">
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
					<td><a href="./DownloadFileServlet?filename=${eBook.filename}" target="_blank">Download</a></td>
							
				</tr>
				</c:if>
				</c:forEach>
			</c:if>
			
			<c:if test="${sessionScope.type==requestScope.tipPretplatnik }">
				<c:forEach items="${eBooks}" var="eBook">
					<c:if test="${sessionScope.category_id == null }">
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
					<td><a href="./DownloadFileServlet?filename=${eBook.filename}" target="_blank">Download</a></td>
							
				</tr>
				</c:if>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
		<c:if test="${sessionScope.type==requestScope.tipAdmin }">
			[<a href="./PrepareCreateController"><fmt:message key="addNeweBook"/></a>]<br/>
		</c:if>
		[<a href="./LogoutController"><fmt:message key="Logout"/></a>]<br/>
		[<a href="./MainController"><fmt:message key="mainMenu"/></a>]<br/>
		
	</body>	
</html>