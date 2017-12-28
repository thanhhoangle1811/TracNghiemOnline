<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		<c:forEach var="category" items="${categories }">
			<tr>
				<td>${category.id }</td>
				<td>
				<a href="${pageContext.request.contextPath }/category/examsbycategory.html?id=${category.id }">${category.name }</a>				
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>