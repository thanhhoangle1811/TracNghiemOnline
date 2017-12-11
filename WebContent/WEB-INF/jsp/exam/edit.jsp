<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="post" commandName="questions"
	action="${pageContext.request.contextPath }/exam/edit.html">
	<c:forEach items="${questions}" var="question" varStatus="status">
		<table>
			<tr>
				<td><input disabled="true" name="questions[${status.index}].id"
					value="${question.id}" /></td>
				<td><input name="questions[${status.index}].content"
					value="${question.content}" /></td>
				<td><input name="questions[${status.index}].grade"
					value="${question.grade}" /></td>
				<td><input name="questions[${status.index}].questiontype.name"
					value="${question.questiontype.name}" /></td>
			</tr>
			<tr>
			<c:forEach items="${question.answers}" var="answer" varStatus="statusA">
				<td>
                <input type="hidden" name="questions[${status.index}].answers[${statusA.index}].id" />
                <c:if test="${answer.istrue }">
                <input type="checkbox" name="questions[${status.index}].answers[${statusA.index}].istrue"  checked="checked" />
                </c:if>
                <c:if test="${!answer.istrue }">
                <input type="checkbox" name="questions[${status.index}].answers[${statusA.index}].istrue"/>
                </c:if>
                
                <input name="questions[${status.index}].answers[${statusA.index}].content"
					value="${answer.content }" />
                    </td>
			</c:forEach>
			</tr>

		</table>
		<br />
	</c:forEach>
	<button type="submit">Accept</button>
</s:form>