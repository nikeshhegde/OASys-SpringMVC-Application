<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DSE - Step III</title>
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
<div id="step-4" class="swMain">
                        <form id="form" action="dse4" method="get">
			<h2 class="StepTitle">Step 4-Parents and Guardian details</h2>	
            <h4>All fields are mandatory</h4>
			<label name="step-4-error" class="text-danger"></label>
			<table class="table">
				<tr>
					<td></td>
					<td>Father</td>
					<td>Mother</td>
					<td>Guardian</td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="admissionUserFatherName" id="name_father" value='<c:out value="${userModel.admissionUserFatherName}" />' placeholder="Father's name"></td>
					<td><input type="text" name="admissionUserMotherName" id="name_mother" value='<c:out value="${userModel.admissionUserMotherName}"/>' placeholder="Mother's name"></td>
					<td><input type="text" name="admissionUserPGGuardianName" id="name_guardian" placeholder="Guardian's name"></td>
				</tr>
				<tr>
					<td>Occupation(Service/Business)</td>
					<td><input type="text" name="admissionUserPGFatherOccupation" id="occ_father" placeholder="Father's Occupation"></td>
					<td><input type="text" name="admissionUserPGMotherOccupation" id="occ_mother" placeholder="Mother's Occupation"></td>
					<td><input type="text" name="admissionUserPGGuardianOccupation" id="occ_guardian" placeholder="Guardian's Occupation"></td>
				</tr>
				<tr>
					<td>Office Address</td>
					<td><input type="text" name="admissionUserPGFatherOfficeAddress" id="off_father"></td>
					<td><input type="text" name="admissionUserPGMotherOfficeAddress" id="off_mother"></td>
					<td><input type="text" name="admissionUserPGGuardianOfficeAddress" id="off_guardian"></td>
				</tr>
				<tr>
					<td>Telephone number</td>
					<td><input type="text" name="admissionUserPGFatherTelephoneNumber" id="tele_father"></td>
					<td><input type="text" name="admissionUserPGMotherTelephoneNumber" id="tele_mother"></td>
					<td><input type="text" name="admissionUserPGGuardianTelephoneNumber" id="tele_guardian"></td>
					</tr>
				<tr>
					<td>Mobile number</td>
					<td><input type="text" name="admissionUserPGFatherMobileNumber" id="mob_father"></td>
					<td><input type="text" name="admissionUserPGMotherMobileNumber" id="mob_mother"></td>
					<td><input type="text" name="admissionUserPGGuardianMobileNumber" id="mob_guardian"></td>				
				</tr>
				<tr>
					<td>Email ID</td>
					<td><input type="text" name="admissionUserPGFatherEmail" id="email_father"></td>
					<td><input type="text" name="admissionUserPGMotherEmail" id="email_mother"></td>
					<td><input type="text" name="admissionUserPGGuardianEmail" id="email_guardian"></td>				
				</tr>
				<tr>
					<td>Annual Income</td>
					<td><input type="text" name="admissionUserPGFatherAnnualIncome" id="ann_father"></td>		
					<td><input type="text" name="admissionUserPGMotherAnnualIncome" id="ann_mother"></td>					
					<td><input type="text" name="admissionUserPGGuardianAnnualIncome" id="ann_guardian"></td>					
					
				</tr>
			</table>	
		<div class="form-group">	
		<input type="submit" value="Next" class="buttonNext"/>

		<a href="dse2"><input type="button" value="Previous" class="buttonPrevious" /></a>	
		</div>
	</form>	
	</div>
	</body>	
</html>		