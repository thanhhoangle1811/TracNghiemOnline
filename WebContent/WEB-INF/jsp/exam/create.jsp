<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="post" commandName="question"
	action="${pageContext.request.contextPath }/exam/create.html">
	<table cellpadding="2" cellspacing="2">
		<tr>
			<td>Content</td>
			<td><input name="content" /></td>
			<td>Grade</td>
			<td><input name="grade" /></td>
			<td>QuestionType</td>
			<td><select name="questiontype.id">
					<option value="">--- Select ---</option>
					<c:forEach items="${questionTypes} " var="type" varStatus="stt">
						<option value="${questionTypes[stt.index].id}">${questionTypes[stt.index].name}</option>
					</c:forEach>
			</select></td>
			<td>Exam</td>
			<td><select name="exam.id">
					<option value="">--- Select ---</option>
					<c:forEach items="${exam} " var="exam" varStatus="stt">
						<option value="${exams[stt.index].id}">${exams[stt.index].name}</option>
					</c:forEach>
			</select></td>
		<tr>
		
	</table>
	<table>
	<tr>
			<td>Answer</td>
		</tr>
		<tr>
			<td>
			<c:forEach begin="0" end="3" varStatus="status">
				<input type="checkbox" name="answers[${status.index }].istrue">
				<input name="answers[${status.index }].content" />
			</c:forEach>
				
			</td>
		</tr>
	</table>
	<button type="submit">Accept</button>
</s:form>