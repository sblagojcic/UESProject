
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<jsp:useBean id="eBooks" type="java.util.List" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<link href="./theme.css" rel="stylesheet" type="text/css" />
		<title>Search results</title>
	</head>
	<body>
		<c:if test="${data==null}">
			<script type="text/javascript">
				window.location = "search.jsp";
			</script>
		</c:if>
		<center>
			<img alt="logo" src="./images/ebooksi.jpg" width="700px" height="300px">
			<br>Search results<br>
			<br>
			<table width="80%">
				<c:forEach items="${data}" var="res">
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr><td width="20%">title</td><td>${res.title}</td></tr>
					<tr><td width="20%">author</td><td>${res.author}</td></tr>
					<tr><td>Keywords</td><td>${res.keywords}</td></tr>
					<tr><td colspan="2">${res.highlight}</td></tr>
					<tr><td colspan="2">
						<c:if test="${sessionScope.admin!=null}">
							<c:if test="${sessionScope.type==requestScope.tipPretplatnik }">
								<c:forEach items="${eBooks}" var="eBook">
									<c:if test="${sessionScope.category_id==eBook.category.id}">
										<c:if test="${eBook.filename==res.location}">
											<a href="./DownloadFileServlet?filename=${res.location}" target="_blank">Download</a>
										</c:if>
									</c:if>
								</c:forEach>
							</c:if>
							<c:if test="${sessionScope.type==requestScope.tipAdmin}">
								<a href="./DownloadFileServlet?filename=${res.location}" target="_blank">Download</a>
							</c:if>
						</c:if>
					</td></tr>
								
				</c:forEach>
			</table>
		</center>
		
		
		Back to:
		<br><a href="search.jsp">[Search]</a>
		<c:if test="${sessionScope.type==requestScope.tipAdmin}">
			<br><a href="upload.jsp">[File upload]</a>
		</c:if>

	</body>
</html>