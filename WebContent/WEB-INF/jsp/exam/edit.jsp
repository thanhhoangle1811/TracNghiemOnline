<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type='text/javascript'
    src='${pageContext.request.contextPath }/assets/js/create-exam.js?v=1.0'></script>
<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">
			<s:form method="post" commandName="question"
				action="${pageContext.request.contextPath }/exam/edit.html">
				<div class="top_panel_title">
					<div class="top_panel_title_inner">
						<h1 class="page_title">Edit</h1>
					</div>
				</div>

				<table>
					<tr>
						<td><input type="hidden" name="id" value="${question.id}" />
							<%-- <input type="hidden" name="questiontype.id"
							value="${question.questiontype.id}" /> <input type="hidden"
							name="exam.id" value="${question.exam.id}" /> --%></td>
						<td>
							<h4>Content :</h4> <input type="text" name="content"
							value="${question.content}" />

						</td>

						<td>
							<h4>Grade :</h4> <input type="text" name="grade"
							value="${question.grade}" />
						</td>
						<td>
							<h4>Questiontype :</h4> 
							<select name="questiontype.id" value="${question.questiontype.id}">
								<option value="">--- Select ---</option>
								<c:forEach items="${questionTypes} " var="type" varStatus="stt">
								
								<c:choose>
								    <c:when test="${question.questiontype.id == questionTypes[stt.index].id}">
								        <option value="${questionTypes[stt.index].id} " selected>${questionTypes[stt.index].name}</option>
								    </c:when>    
								    <c:otherwise>
								        <option value="${questionTypes[stt.index].id} ">${questionTypes[stt.index].name}</option>
								    </c:otherwise>
								</c:choose>
									
								</c:forEach>
						</select>
						</td>
					</tr>
				</table>
				
				<br></br>
                <input type="hidden" id="countExam" value="${fn:length(question.exams)}"/>
				<table>
					<tr>
						<td>Exam</td>
					</tr>
					<c:forEach items="${question.exams }" var="exam" varStatus="examStatus">
					<tr class="exam-value">
						<td>
						<select name="exams[${examStatus.index }].id" count="${examStatus.index }">
								<option value="">--- Select ---</option>
								<c:forEach items="${exams} " var="exam" varStatus="stt">
								<c:choose>
								    <c:when test="${question.exams[examStatus.index].id == exams[stt.index].id}">
								        <option value="${exams[stt.index].id} " selected>${exams[stt.index].name}</option>
								    </c:when>    
								    <c:otherwise>
								    	<option value="${exams[stt.index].id}">${exams[stt.index].name}</option>
								    </c:otherwise>
								</c:choose>
									
								</c:forEach>
						</select></td>
						<td><a class="remove-question" count="${examStatus.index }">- (Question)</a></td>
					</tr>
					</c:forEach>
					<tr class="exam-value">
                        <td>
                        <select name="exams[${fn:length(question.exams) }].id" count="${fn:length(question.exams) }">
                        <option value="">--- Select ---</option>
                                <c:forEach items="${exams} " var="exam" varStatus="stt">
                                
                                        <option value="${exams[stt.index].id}">${exams[stt.index].name}</option>
                                    
                                    
                                </c:forEach>
                        </select></td>
                        <td><a class="remove-question" count="${fn:length(question.exams) }">- (Question)</a></td>
                    </tr>
				</table>
                <a id="create-exam">+ (Exam)</a>
				<br><br>
				<table>
					<tr>
						<td>
							<h4>Answer</h4>
							<ul style="list-style-type: none">
								<c:forEach items="${question.answers}" var="answer"
									varStatus="statusA">
									<li><input type="hidden"
										name="answers[${statusA.index}].id" value="${answer.id }" /> <c:if
											test="${answer.istrue }">
											<input type="checkbox"
												name="answers[${statusA.index}].istrue" checked="checked" />
										</c:if> <c:if test="${!answer.istrue }">
											<input type="checkbox"
												name="answers[${statusA.index}].istrue" />
										</c:if> <input name="answers[${statusA.index}].content"
										value="${answer.content }" /></li>
								</c:forEach>
							</ul>

						</td>
					</tr>
				</table>
				<br />

				<button type="submit">Accept</button>
			</s:form>
		</div>
	</div>
</div>
<script>

$(document).ready(function() {
    var countExam = $('#countExam').val();
    $("#create-exam").on("click",function(){
        createExam(countExam);
        var changeATag = $('a[count="'+countExam+'"]').last();
        countExam++;
        $(changeATag).attr("count",countExam);
        $('#countExam').val(countExam);
        $('.remove-question').off("click");
        $('.remove-question').on("click",function(){
            var count = $(this).attr('count');
            removeExam(count);
        });
    });
    $('.remove-question').on("click",function(){
        var count = $(this).attr('count');
        removeExam(count);
    });
    
});
</script>