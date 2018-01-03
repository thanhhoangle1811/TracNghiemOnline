$( document ).ready(function() {
	var countExam = $('#countExam').val();
    console.log( "ready!" + countExam );
});
function createExam(num){
	num++;
	var lstTr =$('.exam-value').last();
	var clone = $('.exam-value').last().clone();
	$(clone).insertAfter($(lstTr ));
	var selectNew = $(clone).find('select');
	$(selectNew).attr('name','exams['+ num +'].id').attr("count",num);
}
function removeExam(num){
	var removeSelected = $('a[count="'+num+'"]').closest('.exam-value');
	$(removeSelected).remove();
}