<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">
		<div class="top_panel_title">
					<div class="top_panel_title_inner">
						<h1 class="page_title">Edit</h1>
					</div>
				</div>
			<s:form method="post" commandName="category"
				action="${pageContext.request.contextPath }/category/edit.html" style="text-align: center;">
				
				<input type="hidden" name="id" value="${category.id}" />
				<h4>Name :</h4> <input type="text" name="name" value="${category.name}" />
				
				
				<div>${msg }</div>
				<br />

				<button type="submit">Accept</button>
			</s:form>
		</div>
		<br></br>
		<div><a class="pushy_button sc_button" href="${pageContext.request.contextPath }/category/index.html"><span class="icon-left-open"></span> All Categories</a></div>
	</div>
</div>