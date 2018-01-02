<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sc_section sc_section_block">
	<div class="sc_section_inner">
		<div class="sc_section_content_wrap">

			<s:form class="exam-form" method="post" commandName="examDto"
				action="${pageContext.request.contextPath }/exam/showexam.html">
				<input type="hidden" name="exam.id" value="${exam.id}" />
				<input type="hidden" name="account.id" value="1" />
				<input type=hidden id="complete" name="complete" value="false" />

				<div class="top_panel_title">
					<div class="top_panel_title_inner">
						<h1 class="page_title">Tests and Quizzes</h1>
					</div>
				</div>
				<div class="wpb_column vc_column_container vc_col-sm-12"
					style="text-align: left;">
					<div class="wpProQuiz_question_text" style="color: #1ebeb4;">
						Time limit: <input type="text" style="width: 150px;"
							value="${time }">

					</div>
					<br>
					
					<c:set var="countAnswer" scope="session" value="0" />
					<c:forEach items="${questions}" var="question" varStatus="status">

						<div class="wpProQuiz_question_text">
							<p>${status.index + 1}.${question.content}</p>
						</div>

						<c:forEach items="${question.answers}" var="answer"
							varStatus="stt">
							<input type="hidden" name="resultDTOs[${countAnswer }].isTrue"
								value="false"
								class="answer_${countAnswer } question_${question.id }" />
							<input type="hidden"
								name="resultDTOs[${countAnswer }].result.answer.id"
								value="${answer.id}" />
							<input type="hidden"
								name="resultDTOs[${countAnswer }].result.question.id"
								value="${question.id }" />
							<input type="hidden"
								name="resultDTOs[${countAnswer }].result.exam.id"
								value="${exam.id }" />
							<input type="hidden"
								name="resultDTOs[${countAnswer }].result.account.id"
								value="${accountId }" />
							<label>${answer.prefix}</label>
							<label style="display: block;"> 
							<c:choose>
                            <c:when test="${question.questiontype.name=='radio' }">
                                <input class="wpProQuiz_questionInput" questionId="${question.id }" bindInput="${countAnswer }" type="radio" name="questions[${status.index }]" >${answer.content}
                            </c:when>
                            <c:otherwise>
                                <input class="wpProQuiz_questionInput" questionId="${question.id }" bindInput="${countAnswer }" type="checkbox" name="resultDTOs[${countAnswer }].isTrue" >${answer.content}
                            </c:otherwise>
                        </c:choose>${answer.content}
							</label>
							<c:set var="countAnswer" scope="session"
								value="${countAnswer +1 }" />
						</c:forEach>

					</c:forEach>
				</div>
				<br></br>
				<input type="button" id="buttonSubmitExam" value="SUBMIT HERE" />
			</s:form>

		</div>
	</div>
</div>
<script>
var a = $('.wpProQuiz_question_text').find('input');
$(document).ready(function(){
    $(window).bind('beforeunload', function(e){
        return "A";
	});
    $('#buttonSubmitExam').on("click",function(){
    	$("form.exam-form").submit();
    });
    startTimer();
    $('.wpProQuiz_questionInput').on("change",function(){
    	var questionId = $(this).attr('questionid');
    	var answerNumber = $(this).attr('bindinput');
    	var status = $(this).prop("checked");
        if($(this).attr('type') == "radio"){
            $('.question_'+questionId).val(false);
        }
    	if(status){
    		$('.answer_' +answerNumber ).val(true);	
    	}else{
    		$('.answer_' +answerNumber ).val(false);   
    	}
    });
    /* $("#submit").on("click",function(){
    	
    }); */
});
function startTimer() {
    var presentTime = a.val();
    var timeArray = presentTime.split(/[:]+/);
    var m = timeArray[0];
    var s = checkSecond((timeArray[1] - 1));
    if(s==59){m=m-1}
    if(m<0){
    	$("form.exam-form").submit();
	}
    a.val(m + ":" + s);
    setTimeout(startTimer, 1000);
  }
  
  function checkSecond(sec) {
    if (sec < 10 && sec >= 0) {sec = "0" + sec}; // add zero in front of numbers < 10
    if (sec < 0) {sec = "59"};
    return sec;
  }
 
</script>