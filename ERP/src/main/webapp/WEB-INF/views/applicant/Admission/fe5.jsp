<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FE - Step V</title>
<link href="resources/applicant/Dashboard/form-wizard/css/demo_style.css" rel="stylesheet" type="text/css">

<link href="resources/applicant/Dashboard/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/applicant/Dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="resources/applicant/Dashboard/form-wizard/js/jquery.smartWizard.js"></script>


<link href="resources/applicant/Dashboard/css/bootstrap.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/archon.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/responsive.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/login/css/style.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/style.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/custom.css" rel="stylesheet">

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
/*
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
*/
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
	$(document).ready(function(){
		
		var dc="${userModel.getAdmissionUserDomicile()}";
		
		var lm="${userModel.getAdmissionUserAppliedUnder()}";
		
		if(lm!="Linguistic Minority")
			{
			$("#lmrow").hide();			
			}
		if(dc!="Yes")
			{
			$("#dcrow").hide();
			}
			
	});
</script>
</head>
<body>
<div id="step-5" class="swMain">
			            <form id="form" action="savefiles" method="POST" enctype="multipart/form-data">
			<h2 class="StepTitle">Step 5-Attach documents</h2>	
			
			<table class="table">
				<tr>
				<td>
					<label for="ssc" class="col-lg-7 control-label">SSC/Std. X Examination marksheet</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="files[0]" id="ssc">
						<label id="ssc-error" class="text-danger"></label>
				</td>
				</tr>
				
				<tr>
				<td>	
					<label for="slc" class="col-lg-7 control-label">School Leaving certificate from the Institution which the candidate has passed the examination</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="files[1]" id="slc">
						<label id="slc-error" class="text-danger"></label>
				</td>
				</tr>
				
				
				<tr>
				<td>
					<label for="hsc" class="col-lg-7 control-label">Marksheet at the qualifying examination (Std. XII or equivalent)</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="files[2]" id="hsc">
						<label id="hsc-error" class="text-danger"></label>
				</td>
				</tr>
			
				<tr>
				<td>	
					<label for="slc" class="col-lg-7 control-label">College Leaving certificate from the Institution which the candidate has passed the examination</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="files[3]" id="clc">
						<label id="slc-error" class="text-danger"></label>
				</td>
				</tr>
				
				
				<tr>
				<td>	
					<label for="ppc" class="col-lg-7 control-label">Physical fitness certificate from a registered medical practitioner</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="files[4]" id="ppc">
						<label id="ppc-error" class="text-danger"></label>
				</td>
				</tr>
				
				<tr>
				<td>	
					<label for="jee" class="col-lg-7 control-label">JEE(main) Score card</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="files[5]" id="jee">
						<label id="jee-error" class="text-danger"></label>
				</td>
				</tr>
				<tr id="dcrow">
				<td>
					<label for="dc" class="col-lg-7 control-label" >Domicile certificate</label>
				</td>
				<td>
								<input type="file" class="form-controlfile" name="files[6]" id="dc">		
								<label id="dc-error" class="text-danger"></label>
				</td>
				</tr>
				<tr id="lmrow">
							<td>
								<label for="lma" class="col-lg-7 control-label" id="lma-label" >Linguistic minority affidavit</label>
							</td>
							<td>
								<input type="file" class="form-controlfile" name="files[7]" id="lma">
								<label id="lma-error" class="text-danger"></label>
							</td>
						</tr>
		
			</table>
<div class="form-group">	
		<input type="submit" value="Next" class="buttonNext"/>

		<a href="fe4"><input type="button" value="Previous" class="buttonPrevious" /></a>	
		</div>
	</form>	
	</div>
	</body>	
</html>		