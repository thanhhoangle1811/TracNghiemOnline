<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="post" commandName="questions"
	action="${pageContext.request.contextPath }/exam/showexam.html">
	<div>${exam.name}</div>
	
	<c:forEach items="${questions}" var="question" varStatus="status">
		<div>
			<span>${status.index + 1}.</span>
			<span>${question.content}</span>
			<div style="margin-left: 30px;">
				<c:forEach items="${question.answers}" var="answer" varStatus="stt">
					<label style="display: block;">
				      <input type="radio" name="${question.id}" value="${answer.id}">${answer.content}
				    </label>
				</c:forEach>
			</div>
		</div>
		
	</c:forEach>
	
	<input type="submit" />
</s:form>