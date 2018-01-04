<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">
			<s:form method="post" commandName="category"
				action="${pageContext.request.contextPath }/category/edit.html">
				<div class="top_panel_title">
					<div class="top_panel_title_inner">
						<h1 class="page_title">Edit</h1>
					</div>
				</div>

				<table>
					<tr>
						<td><input type="hidden" name="id" value="${category.id}" /></td>
						<td>
							<h4>Name :</h4> <input type="text" name="name"
							value="${category.name}" />
						</td>
					</tr>
				</table>
				
				<div>${msg }</div>
				<br />

				<button type="submit">Accept</button>
			</s:form>
		</div>
		<br></br>
		<div><a href="${pageContext.request.contextPath }/category/index.html">All Categories</a></div>
	</div>
</div>