<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">
			<div id="sc_vacancies_508391825_wrap" class="sc_vacancies_wrap">
				<div id="sc_vacancies_508391825" class="sc_vacancies sc_table">
					<table border="1" cellpadding="2" cellspacing="2">
						<tr>
							<th>Id</th>
							<th>Name</th>
						</tr>
						<c:forEach var="category" items="${categories }">
							<tr>
								<td>${category.id }</td>
								<td><a
									href="${pageContext.request.contextPath }/category/examsbycategory.html?id=${category.id }">${category.name }</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>