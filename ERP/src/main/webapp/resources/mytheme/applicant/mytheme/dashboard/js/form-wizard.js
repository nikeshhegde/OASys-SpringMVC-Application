$(document).change(function(){

if($("#check_address").checked==true)
	{
	var perm=$("admission_user_p_address").text();
	$("admission_user_c_address").val($("admission_user_c_address").val()+perm);	
	}
});