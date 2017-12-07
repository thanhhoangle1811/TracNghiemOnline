<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="post" commandName="questions"
	action="${pageContext.request.contextPath }/exam/create.html">
	<table cellpadding="2" cellspacing="2">
		<tr>
			<th>Content</th>
			<th>Answers</th>
			<th>Exams</th>
			<th>Grade</th>
		</tr>
		<tr>
			<c:forEach items="${questions}" var="question" varStatus="status">
				<tr>
					<td>
						<input name="questions[${status.index}].content" value="${question.content}"/>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</s:form>