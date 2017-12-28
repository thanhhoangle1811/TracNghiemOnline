<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table cellpadding="2" cellspacing="2">
	<tr>
		<th>Id</th>
		<th>Exams</th>
		<th>Time</th>
	</tr>
	<tr>
		<c:forEach items="${exams}" var="exam">
			<tr>
				<td>${exam.id }</td>
				<td>
					<a href="${pageContext.request.contextPath }/exam/showexam.html?id=${exam.id }">${exam.name }</a>				
				</td>
				<td>${exam.time }</td>
			</tr>
		</c:forEach>
	</tr>
</table>