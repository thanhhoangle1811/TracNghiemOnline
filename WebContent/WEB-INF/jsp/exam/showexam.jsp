<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="post" commandName="exam"
	action="${pageContext.request.contextPath }/exam/showexam.html">
	<div>${exam.name}</div>
	
	<%-- <c:forEach items="${questions}" var="question" varStatus="status">
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
		
	</c:forEach> --%>
	<div class="top_panel_title">
		<div class="top_panel_title_inner">
			<h1 class="page_title">Tests and Quizzes</h1>
		</div>
	</div>
	<div class="wpb_column vc_column_container vc_col-sm-12" style="text-align : left;">
		<c:forEach items="${questions}" var="question" varStatus="status">
				<div class="wpProQuiz_question_text">
					<p>${status.index + 1}.${question.content}</p>
				</div>
				<ul class="wpProQuiz_questionList" data-question_id="4" data-type="single">
					<li class="wpProQuiz_questionListItem" data-pos="0">
						<c:forEach items="${question.answers}" var="answer" varStatus="stt">
						<label style="display: block;">
							<input class="wpProQuiz_questionInput" type="radio" name="questions[${status.index }].result[${stt.index }].answer.istrue" value="${answer.id}">${answer.content} 
						</label>
					</c:forEach>
					</li>
				</ul>	
				<%-- 
				<div style="margin-left: 30px;">
					<c:forEach items="${question.answers}" var="answer" varStatus="stt">
						<label style="display: block;">
							<input type="radio" name="questions[${status.index }].result[${stt.index }].answer.istrue" value="${answer.id}">${answer.content} 
						</label>
					</c:forEach>
				</div>
				--%>	
		</c:forEach>
	</div>
	<br></br>
	<input type="submit" />
</s:form>