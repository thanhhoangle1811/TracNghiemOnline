<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">
			<div id="sc_vacancies_508391825_wrap" class="sc_vacancies_wrap">
				<div id="sc_vacancies_508391825" class="sc_vacancies sc_table">
					<table border="1" cellpadding="2" cellspacing="2">
						<thead>
						<tr>
							<th>No</th>
							<th>Content</th>
							<th>Mark</th>
							<th>Question Type</th>
							<th>Answer</th>
							<th>Action</th>
						</tr>
						</thead>
						<c:forEach var="question" items="${questions }"  varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${question.content }</td>
								<td>${question.grade }</td>
								<td>${question.questiontype.name }</td>
								<td>
									<ul>
										<c:forEach var="answer" items="${question.answers }"  varStatus="status">
											<li>${answer.content }</li>
										</c:forEach>
									</ul>
								</td>
								<td class="employment">
									<a href="${pageContext.request.contextPath }/exam/edit.html?questionid=${question.id }"><span class="part">Edit</span></a>
								</td>
							</tr>
						</c:forEach>						
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<br/><br/>
	<div><a class="pushy_button sc_button" href="${pageContext.request.contextPath }/exam/create.html">Create New Question</a>
	</div>
</div>