<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="post" commandName="question"
	action="${pageContext.request.contextPath }/exam/edit.html">
	<div class="top_panel_title">
		<div class="top_panel_title_inner">
			<h1 class="page_title">Edit</h1>
		</div>
	</div>
	
	<table>
		<tr>
		<td>
			<input type="hidden" name="id"
			value="${question.id}" />
			<input type="hidden" name="questiontype.id"
			value="${question.questiontype.id}" />
			<input type="hidden" name="exam.id"
			value="${question.exam.id}" />
		</td>
		<td>
			<h4>Content :</h4> <input type="text" name="content"
					value="${question.content}" />
			
		</td>
		
			<td>
			<h4>Grade : </h4>
			<input type="text" name="grade"
					value="${question.grade}" />
			</td>
			<td>
			<h4>Questiontype : </h4>
			<input type="text" name="questiontype.name"
					value="${question.questiontype.name}" />
			</td>
		</tr>
	</table>
	<br></br>
	<table>
		<tr>
			<td>
			<h4>Answer</h4>
				<ul style="list-style-type:none">
				 	<c:forEach items="${question.answers}" var="answer" varStatus="statusA">
					<li>
                	<input type="hidden" name="answers[${statusA.index}].id" value="${answer.id }"/>
                	<c:if test="${answer.istrue }">
                	<input type="checkbox" name="answers[${statusA.index}].istrue"  checked="checked" />
                	</c:if>
                	<c:if test="${!answer.istrue }">
                	<input type="checkbox" name="answers[${statusA.index}].istrue"/>
                	</c:if>
                	<input name="answers[${statusA.index}].content"
					value="${answer.content }" />
                    </li>
			</c:forEach>
				 </ul>
			
			</td>
		</tr>
	</table>
		<br />
	
	<button type="submit">Accept</button>
</s:form>