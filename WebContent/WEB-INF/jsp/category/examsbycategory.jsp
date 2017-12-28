<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sc_vacancies_508391825_wrap" class="sc_vacancies_wrap">
	<div id="sc_vacancies_508391825" class="sc_vacancies sc_table">
		<table cellpadding="2" cellspacing="2">
			<tr>
				<th>Exams</th>
				<th>Time</th>
			</tr>
			<tr>
				<c:forEach items="${exams}" var="exam">
					<tr>
						<td><a
							href="${pageContext.request.contextPath }/exam/showexam.html?id=${exam.id }">${exam.name }</a>
						</td>
						<td>${exam.time }</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</div>
</div>