<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">
			<div class="top_panel_title">
					<div class="top_panel_title_inner">
						<h1 class="page_title">Add Category</h1>
					</div>
				</div>
			<s:form method="post" commandName="category"
				action="${pageContext.request.contextPath }/category/create.html" style="text-align: center;">
				
							<h4>Name :</h4> <input type="text" name="name" /> <br></br>

				<div>${msg }</div>
				<button type="submit">Accept</button>
			</s:form>
		</div>
		<br></br>
		<div><a href="${pageContext.request.contextPath }/category/index.html">All Categories</a></div>
	</div>
</div>