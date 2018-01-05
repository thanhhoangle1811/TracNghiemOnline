<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type='text/javascript'
    src='${pageContext.request.contextPath }/assets/js/create-exam.js?v=1.0'></script>
    <input type="hidden" id="countExam" value="0"/>
<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">
			<s:form method="post" commandName="question"
				action="${pageContext.request.contextPath }/exam/create.html">
				<div class="top_panel_title">
					<div class="top_panel_title_inner">
						<h1 class="page_title">Add Tests and Quiz</h1>
					</div>
				</div>
				<table>
					<tr>
						<td>
							<h4>Content :</h4> <input type="text" name="content" /> <br></br>
						</td>
						<td>
							<h4>Grade :</h4> <input type="text" name="grade" /> <br></br>
						</td>
					</tr>
					<tr>
						<td>
							<h4>QuestionType :</h4> <select name="questiontype.id">
								<option value="">--- Select ---</option>
								<c:forEach items="${questionTypes} " var="type" varStatus="stt">
									<option value="${questionTypes[stt.index].id}">${questionTypes[stt.index].name}</option>
								</c:forEach>
						</select>
						</td>
					</tr>
				</table>
				<br></br>
                <table>
                <tr><td>Exam</td></tr>
                <tr class="exam-value">
                    <td>
                        <select name="exams[0].id" count="0">
                                    <c:forEach items="${exams} " var="exam"
                                        varStatus="stt">
                                        <option
                                            value="${exams[stt.index].id}">${exams[stt.index].name}</option>
                                    </c:forEach>
                        </select>
                    </td>
                    <td><a class="remove-question" count="0">- (Question)</a></td>
                </tr>
                </table>
                <a id="create-exam">+ (Exam)</a>
				<table>
					<tr>
						<td>
							<h4>Answer</h4>
							<ul class="answer-list" style="list-style-type: none">
								
								<c:forEach begin="0" end="3" varStatus="status">
									<li>
										<input type="checkbox" name="answers[${status.index }].istrue">
										<input type="text" name="answers[${status.index }].content" />
										</li>
									</c:forEach>
							</ul>

						</td>
					</tr>
				</table>
				<br></br>
				<button id="submitButton" type="button">Accept</button>
			</s:form>
		</div>
	</div>
</div>
<script>

$(document).ready(function() {
    var countExam = $('#countExam').val();
    /* countExam = createExam(countExam)
    $('#countExam').val(countExam); */
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
    $("#submitButton").on("click",validAnswer());
});
</script>