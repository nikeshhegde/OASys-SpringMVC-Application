<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Status</title>
<link href="resources/applicant/dashboard/form-wizard/css/demo_style.css" rel="stylesheet" type="text/css">

<link href="resources/applicant/dashboard/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/applicant/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="resources/applicant/dashboard/form-wizard/js/jquery.smartWizard.js"></script>


<link href="resources/applicant/dashboard/css/bootstrap.css" rel="stylesheet">
<link href="resources/applicant/dashboard/css/archon.css" rel="stylesheet">
<link href="resources/applicant/dashboard/css/responsive.css" rel="stylesheet">
<link href="resources/applicant/dashboard/login/css/style.css" rel="stylesheet">
<link href="resources/applicant/dashboard/css/style.css" rel="stylesheet">
<link href="resources/applicant/dashboard/css/custom.css" rel="stylesheet">

<script type="text/javascript">
    $(document).ready(function(){
    	// Smart Wizard 	
  		$('#wizard').smartWizard();
/*      
      function onFinishCallback(){
        $('#wizard').smartWizard('showMessage','Finish Clicked');
        alert('Finish Clicked');
      }
*/	  
		});
</script>


<script>

	$(function(){
		
		$('input[name=admission_user_applied]').change(function()
		{
				var lma=$("#lma");	
			 	if($('#admission_user_applied').is(':checked'))
			 		{
				 	if($('#admission_user_applied').val()=="LM")
				 		{
				 		$("#lma-label").show();
					 	$("#lma").show();
				 		}
					else
						{
						$("#lma-label").hide();
						lma.replaceWith( lma = lma.clone( true ) );	
						$("#lma").hide();
						}
			
				 	}
				else
					{
					$("#lma-label").hide();
					lma.replaceWith( lma = lma.clone( true ) );	
					$("#lma").hide();
					}
		});

	});

</script>



<script>

var d=new Date();

var current=d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();

$(function(){

$("#today_date").text(current);

});

</script>


<script>
	$(function(){
	$('input[name=check_address]').change(function()
	{
	var temp=$(this).prop("checked");
	var perm;
	if(temp)
		{		
		perm=$('#admission_user_p_address').val();
		$('#admission_user_c_address').text(perm);
		}
	else
		{
		perm="";
		$('#admission_user_c_address').text(perm);
		}
	});
	});
</script>

<script>
$(function(){

		$('input[name=admission_user_mobile]').change(function(){
		//alert("warning:");
		var mob=$(this).val();
		var msg="";
		if(isNaN(mob) || mob.length<10)
			{
			flag=1;
			msg=" Mobile number should have 10 digits";
			$("#admission_user_mobile-error").text(msg);
			}
		else
			{
			$("#admission_user_mobile-error").text(msg);
			}
		});
		
		$('input[name=admission_user_landline]').change(function(){
		var mob=$(this).val();
		var msg="";
		if(isNaN(mob) || mob.length<11)
			{
			flag=1;
			msg=" Landline number should have 11 digits";
			$("#admission_user_landline-error").text(msg);
			}
		else
			{
			$("#admission_user_landline-error").text(msg);
			}
		});

});
</script>
<script>
$(function(){
$("#dc").hide();
$("#lma-label").hide();
$("#lma").hide()
$("handicap-disable").hide();
$("#domicile").change(function(){

var value=$(this).val();

var dc=$("#dc");
if(value=="Yes")
	{
	$("#dc").show();
	}
else
	{
	dc.replaceWith( dc = dc.clone( true ) );	
	$("#dc").hide();
	}
	

});
});
</script>



</head>
<body>
	<h2>Welcome, ${userModel.admissionUserFname}</h2>
	<c:choose>
		<c:when test="${userModel.getAdmissionUserStatus()=='Registered'}">
      	
      	<p>Payment Confirmation in progress...</p>
		 
      </c:when>
       <c:when test="${userModel.getAdmissionUserStatus()=='AppFeePaid'}">
   		<p> 
   		<a href="/start/resources/pdf/First Year Admission Prospectus.pdf">Click here to download the PDF!</a>
		</p> 
		<p>
		<a href="student"> Proceed to Application Form</a>
		</p>
      </c:when>
      <c:otherwise>
      	<p>Done...</p>
      </c:otherwise>
	</c:choose>
</body>	
</html>	