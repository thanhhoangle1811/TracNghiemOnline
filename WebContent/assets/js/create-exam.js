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
	$(selectNew).attr('name','exam['+ num +'].id');
	return num;
}
function removeExam(num){
	
}