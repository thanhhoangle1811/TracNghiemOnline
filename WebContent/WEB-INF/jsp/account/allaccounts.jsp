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
							<th>Email</th>
							<th></th>
						</tr>
						</thead>
						<c:forEach var="account" items="${accounts }"  varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${account.firstname } ${account.lastname }</td>
								<td>${account.email }</td>
								<td><a
									href="${pageContext.request.contextPath }/account/userquizhistory.html?id=${account.id }">View Quiz History</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>