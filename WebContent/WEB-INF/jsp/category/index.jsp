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
							<th>Id</th>
							<th>Name</th>
							<th>Action</th>
							</tr>
						</thead>
						<c:forEach var="category" items="${categories }">
							<tr>
								<td>${category.id }</td>
								<td>${category.name }</td>
								<td>
									<a href="${pageContext.request.contextPath }/category/examsbycategory.html?id=${category.id }">See exams of this</a> / 
									<a href="${pageContext.request.contextPath }/category/edit.html?categoryid=${category.id }">Edit</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<br/><br/>
	<div><a href="${pageContext.request.contextPath }/category/create.html">Create New Category</a></div>
</div>