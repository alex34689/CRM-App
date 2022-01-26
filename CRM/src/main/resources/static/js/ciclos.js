$(document).ready(function() {
	$('#ciclosList').DataTable({
		 "autoWidth": true
	});
});

$(function() {
  $('input[name="daterange"]').daterangepicker({
	format: 'DD/MM/YYYY',
    opens: 'left'

  }, function(start, end, label) {
    console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
	$("#fechaInicio").val(start.format('YYYY-MM-DD'));
	$("#fechaFin").val(end.format('YYYY-MM-DD'));	
  });
});

