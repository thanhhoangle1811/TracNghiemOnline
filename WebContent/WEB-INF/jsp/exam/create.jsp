<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="post" commandName="question"
	action="${pageContext.request.contextPath }/exam/create.html">
	
	 
	
	
	
		
			Content : <input type="text"  name="content" />
			<br></br>
			Grade : <input type="text" name="grade" />
			<br></br>
			QuestionType : 
			<select name="questiontype.id">
					<option value="">--- Select ---</option>
					<c:forEach items="${questionTypes} " var="type" varStatus="stt">
						<option value="${questionTypes[stt.index].id}">${questionTypes[stt.index].name}</option>
					</c:forEach>
			</select>
			Exam
			<select name="exam.id">
					<option value="">--- Select ---</option>
					<c:forEach items="${exam} " var="exam" varStatus="stt">
						<option value="${exams[stt.index].id}">${exams[stt.index].name}</option>
					</c:forEach>
			</select>
			<h4>Answer</h4>
				<ul style="list-style-type:none">
				 	<li>
				 		<c:forEach begin="0" end="3" varStatus="status">
							<input type="checkbox" name="answers[${status.index }].istrue">
							<input name="answers[${status.index }].content" />
						</c:forEach>
				 	</li>
				 </ul>
			<button type="submit">Accept</button>
</s:form>