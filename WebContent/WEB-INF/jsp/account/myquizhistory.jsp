<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">
			<div id="sc_vacancies_508391825_wrap" class="sc_vacancies_wrap">
				<div id="sc_vacancies_508391825" class="sc_vacancies sc_table">
					<div>My Quiz History</div>
					<table cellpadding="2" cellspacing="">
						<tr>
							<th>No</th>
							<th>Quiz Name</th>
							<th>Mark</th>
							<th>Date</th>
						</tr>
						<c:forEach var="quiz" items="${quizes}" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${quiz.examName}</td>
								<td>${quiz.mark}/${quiz.totalMark}</td>
								<td>${quiz.time}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
