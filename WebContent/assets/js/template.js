$( document ).ready(function() {
	/*var countExam = $('#countExam').val();
    console.log( "ready!" + countExam );*/
	var label = $("#label-flag").val();
	
	if(label !=''){
		$('.menu-item').removeClass('current-menu-ancestor');
	
		$('#'+label).addClass('current-menu-ancestor');
	}
	$('table').DataTable({
		"bLengthChange" : false
	}); 
});