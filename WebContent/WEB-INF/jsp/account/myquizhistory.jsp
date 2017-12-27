<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>My Quiz History</div>
<table cellpadding="2" cellspacing="">
	<tr>
		<th>No</th>
		<th>Quiz Name</th>
		<th>Mark</th>
	</tr>
	<c:forEach var="quiz" items="${quizes}" varStatus="status">
		<tr>
			<td>${status.index + 1}</td>
			<td>${quiz.examName}</td>
			<td>${quiz.mark}/${quiz.totalMark}</td>
		</tr>
	</c:forEach>
</table>	
