function uploadTheFile() {
	$('#fileuploadDialog').dialog("option", "title", 'Allot Subject');
	$('#fileuploadDialog').dialog('open');
}

/*function editAllotment(id) {

	$.get("get/" + id, function(result) {

		$("#fileuploadDialog").html(result);

		$('#fileuploadDialog').dialog("option", "title", 'Edit Subject Alloted');

		$("#fileuploadDialog").dialog('open');

		initializeDatePicker();
	});
}*/

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

	$('#fileuploadDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 660,
		buttons : {
			"Upload" : function() {
				$('#fileUploadForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#fileUploadForm'));

			$(this).dialog('close');
		}
	});

/*	initializeDatePicker();
*/});
