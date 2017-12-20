<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form class="exam-form" method="post" commandName="examDto"
	action="${pageContext.request.contextPath }/exam/showexam.html">
    <input type="hidden" name="exam.id" value="${examId}"/>
    <input type="hidden" name="account.id" value="1"/>
    <input type = hidden id = "complete" name = "complete" value = "false"/>
    
	<div>${exam.name}</div>
	<div class="top_panel_title">
		<div class="top_panel_title_inner">
			<h1 class="page_title">Tests and Quizzes</h1>
		</div>
	</div>                         
	<div class="wpb_column vc_column_container vc_col-sm-12" style="text-align : left;">
	<div class="wpProQuiz_question_text" style="color:#1ebeb4;">
		Time limit: <input type="text" style="width:150px;" value="05:00">
		
	</div>
	<br>
    <c:set var = "countAnswer" scope = "session" value = "0"/>
		<c:forEach items="${questions}" var="question" varStatus="status">

				<div class="wpProQuiz_question_text">
					<p>${status.index + 1}.${question.content}</p>
				</div>
				<ul class="wpProQuiz_questionList" data-question_id="4" data-type="single">
					<li class="wpProQuiz_questionListItem" data-pos="0">
						<c:forEach items="${question.answers}" var="answer" varStatus="stt">
                        <input type="hidden" name ="answers[${countAnswer }].prefix" value="${answer.prefix}"/>
                        <input type="hidden" name ="answers[${countAnswer }].content" value="${answer.content}"/>
                        <input type="hidden" name ="answers[${countAnswer }].istrue"  value="false" class="answer_${countAnswer } question_${question.id }"/>
                        <input type="hidden" name ="answers[${countAnswer }].isStudent"  value="true" />
                        <input type="hidden" name ="answers[${countAnswer }].question.id"  value="${question.id }"/>
                        <label>${answer.prefix}</label>
						<label style="display: block;">
							<input class="wpProQuiz_questionInput" questionId="${question.id }" bindInput="${countAnswer }" type="radio" name="questions[${status.index }]" >${answer.content} 
						</label>
                        <c:set var = "countAnswer" scope = "session" value = "${countAnswer +1 }"/>
					</c:forEach>
					</li>
				</ul>		
		</c:forEach>
	</div>
	<br></br>
	<input type="button" id="buttonSubmitExam" value = "SUBMIT HERE" />
</s:form>
<script>
var a = $('.wpProQuiz_question_text').find('input');
$(document).ready(function(){
    $(window).bind('beforeunload', function(e){
        return "A";
	});
    $('#buttonSubmitExam').on("click",function(){
    	$("form.exam-form").submit();
    });
    a.val("1000:00");
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