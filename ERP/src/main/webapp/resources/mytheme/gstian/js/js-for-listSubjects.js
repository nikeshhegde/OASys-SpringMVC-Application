function addSubject() {
	$('#subjectDialog').dialog("option", "title", 'Allot Subject');
	$('#subjectDialog').dialog('open');
}

function editAllotment(id) {

	$.get("get/" + id, function(result) {

		$("#subjectDialog").html(result);

		$('#subjectDialog').dialog("option", "title", 'Edit Subject Alloted');

		$("#subjectDialog").dialog('open');

		/*initializeDatePicker();*/
	});
}

/*function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}*/

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#subjectDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 660,
		buttons : {
			"Save" : function() {
				$('#subjectAllotmentForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#subjectAllotmentForm'));

			$(this).dialog('close');
		}
	});

/*	initializeDatePicker();
*/});
