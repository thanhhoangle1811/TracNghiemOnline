<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type='text/javascript'
    src='${pageContext.request.contextPath }/assets/js/jquery.timepicker.js?v=1.0'></script>
<link property="stylesheet" rel='stylesheet' id='timeline-css-css'
    href='${pageContext.request.contextPath }/assets/css/jquery.timepicker.css?ver=4.7.7'
    type='text/css' media='all' />
<input type="hidden" id="countExam" value="0"/>
<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">
			<s:form method="post" commandName="exam"
				action="${pageContext.request.contextPath }/exam/create-exam.html">
				<div class="top_panel_title">
					<div class="top_panel_title_inner">
						<h1 class="page_title">Add Tests and Quiz</h1>
					</div>
				</div>
				<table>
					<tr>
						<td>
							<h4>Name :</h4> <input type="text" name="name" /> <br></br>
						</td>
						<td>
							<h4>Time :</h4> <input id="timeformat" type="text" name="time" /> <br></br>
						</td>
					</tr>
					<tr>
						<td>
							<h4>Category :</h4> <select name="category.id">
								<option value="">--- Select ---</option>
								<c:forEach items="${categories} " var="category" varStatus="stt">
									<option value="${categories[stt.index].id}">${categories[stt.index].name}</option>
								</c:forEach>
						</select>
						</td>
					</tr>
				</table>
				
				<br></br>
				<button type="submit">Accept</button>
			</s:form>
		</div>
	</div>
</div>
<script>

$(document).ready(function() {
	$('#timeformat').timepicker({ 'timeFormat': 'H:i:s' });
});
</script>