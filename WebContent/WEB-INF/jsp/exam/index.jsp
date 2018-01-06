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
							<th>Name</th>
							<th>Category</th>
							<th>Action</th>
						</tr>
						</thead>
						<c:forEach var="exam" items="${exams }"  varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${exam.name }</td>
								<td>${exam.category.name }</td>
								<td class="employment">
									<a href="${pageContext.request.contextPath }/exam/questionlist.html?examid=${exam.id }"><span class="full">See question of this exam</span></a>
									<a href="${pageContext.request.contextPath }/exam/create-exam.html?examid=${exam.id }"><span class="part">Edit</span></a>
								</td>
							</tr>
						</c:forEach>						
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<br/><br/>
	<div>
		<a class="pushy_button sc_button" href="${pageContext.request.contextPath }/exam/create-exam.html">Add New Exam</a>
	</div>
</div>