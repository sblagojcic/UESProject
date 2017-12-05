<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<link href="./theme.css" rel="stylesheet" type="text/css" />
		<title>Search</title>
		<script type="text/javascript">
			function checkStatus(){
				param = window.location.search;
				if(param.indexOf("?") != -1){
					document.getElementById("message").innerHTML = "No data found";
				}
			}
		</script>
	</head>
	<body>
		<c:if test="${searchTypes == null || occures == null}">
			<script type="text/javascript" >
				window.location = "PrepareSearch";
			</script>
		</c:if>
		<center>
		<img alt="logo" src="./images/ebook.jpg" width="150px" height="150px">
		<br><span id="message" style="color:red;font-size:20px">&nbsp;</span>
		<form action="Search" method="post">
			<table>
				<tr>
					<th>Attribute</th>
					<th>Search value</th>
					<th>Search type</th>
					<th>Search condition</th>
				</tr>
				<tr>
					<td>Keywords</td>
					<td><input type="text" name="kw"/></td>
					<td><select name="kwst">
							<c:forEach items="${searchTypes}" var="st">
								<option value="${st}">${st}</option>
							</c:forEach>
						</select>
					</td>
					<td><select name="kwsc">
							<c:forEach items="${occures}" var="o">
								<option value="${o}">${o}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title"/></td>
					<td><select name="titlest">
							<c:forEach items="${searchTypes}" var="st">
								<option value="${st}">${st}</option>
							</c:forEach>
						</select>
					</td>
					<td><select name="titlesc">
							<c:forEach items="${occures}" var="o">
								<option value="${o}">${o}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
						<tr>
					<td>Author</td>
					<td><input type="text" name="author"/></td>
					<td><select name="authores">
							<c:forEach items="${searchTypes}" var="st">
								<option value="${st}">${st}</option>
							</c:forEach>
						</select>
					</td>
					<td><select name="authorsc">
							<c:forEach items="${occures}" var="o">
								<option value="${o}">${o}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				
				<tr>
				
					<td>Text</td>
					<td><input type="text" name="text"/></td>
					<td><select name="textst">
							<c:forEach items="${searchTypes}" var="st">
								<option value="${st}">${st}</option>
							</c:forEach>
						</select>
					</td>
					<td><select name="textsc">
							<c:forEach items="${occures}" var="o">
								<option value="${o}">${o}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr><td colspan="4" align="center"><input type="submit" value="Search"/></td></tr>
			</table>
		</form>
		</center>
		
		<c:if test="${sessionScope.type==requestScope.tipAdmin}">
		Go to:
			<br><a href="upload.jsp">[File upload]</a>
		</c:if>
		<script type="text/javascript">
			checkStatus();
		</script>
	</body>
</html>