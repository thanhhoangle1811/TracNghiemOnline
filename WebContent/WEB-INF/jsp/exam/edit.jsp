<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="post" commandName="question"
	action="${pageContext.request.contextPath }/exam/edit.html">
		<table>
			<tr>
				<td><input type="hidden" name="id"
					value="${question.id}" />
					<input type="hidden" name="questiontype.id"
					value="${question.questiontype.id}" />
					<input type="hidden" name="exam.id"
					value="${question.exam.id}" />
					</td>
				<td><input name="content"
					value="${question.content}" /></td>
				<td><input name="grade"
					value="${question.grade}" /></td>
				<td><input name="questiontype.name"
					value="${question.questiontype.name}" /></td>
			</tr>
			<tr>
			<c:forEach items="${question.answers}" var="answer" varStatus="statusA">
				<td>
                <input type="hidden" name="answers[${statusA.index}].id" value="${answer.id }"/>
                <c:if test="${answer.istrue }">
                <input type="checkbox" name="answers[${statusA.index}].istrue"  checked="checked" />
                </c:if>
                <c:if test="${!answer.istrue }">
                <input type="checkbox" name="answers[${statusA.index}].istrue"/>
                </c:if>
                
                <input name="answers[${statusA.index}].content"
					value="${answer.content }" />
                    </td>
			</c:forEach>
			</tr>

		</table>
		<br />
	
	<button type="submit">Accept</button>
</s:form>