$( document ).ready(function() {
	/*var countExam = $('#countExam').val();
    console.log( "ready!" + countExam );*/
});
function createExam(num){
	num++;
	var lstTr =$('.exam-value').last();
	var clone = $('.exam-value').last().clone();
	$(clone).insertAfter($(lstTr ));
	var selectNew = $(clone).find('select');
	$(selectNew).attr('name','exams['+ num +'].id').attr("count",num);
	$(selectNew).val("");
}
function removeExam(num){
	if($('.exam-value').length ==1){
		return;
	}
	var removeSelected = $('a[count="'+num+'"]').closest('.exam-value');
	$(removeSelected).remove();
}

function validAnswer(){
	var countInputVal =0;
	var countCheckboxVal =0;
	$('.answer-list').find("input[type='text']").each(function(){
		if($(this).val().trim() != ''){
			countInputVal++;
		}
	});
	$('.answer-list').find("input[type='checkbox']").each(function(){
		if($(this).is(":checked")){
			countCheckboxVal++;
		}
	});
	if(countCheckboxVal > countInputVal || countInputVal ==0 ||countCheckboxVal ==0){
		alert("Red Alert!!");
		return;
	}
	$("#question").submit();
}