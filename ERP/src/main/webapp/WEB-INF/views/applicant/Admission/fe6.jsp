<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FE - Step VI</title>
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
			
			<div id="step-6" class="swMain">
			            <form id="form" action="fe7" method="get">
			<h2 class="StepTitle">Step 6-Declarations</h2>

			<h3>Declaration for parents</h3>
			<br>
			<p>
			I, <strong>${fullName}</strong> declare that the particulars furnished by my son/daughter/ward in this 
			application form are correct to the best of my knowledge and belief.
			<br>
			<br>
			I understand and abide myself to pay on behalf of my son/daughter/ward such fees,charges 
			etc. which the Government of Maharashtra/ University may levy from time to time by due date
			and in the event of failure on my part and/or on the part of my son/daughter/ward, the principal
			of Graduate School of Technology may take such action against my son/daughter/ward, as he may deem fit.
			I also undertake to pay the difference in the fees, if the fee structure is revised by the government at any
			time during the period of my study in the Graduate School of Technology.
			<br>
			<br>
			I assure that my son/daughter/ward will not indulge in any act of ragging. I hereby agree that if he/she is found guilty
			of any aspect of ragging, he/she may be punished as per the provision of prohibition of ragging act of 1997, and rules
			made there under.
			</p>
			<b><input type="checkbox" name="declaration" id="declaration">I agree to sign the requisite agreement bond as prescribed by the Government.</b> 
			<br>
			<br>
			
			<h3>Declaration by the Candidate</h3>
			<br>
			<p>
			I , <strong>${fullName}</strong> have read a copy of the rules for admission published by the statutory and regulatory authorities and the institute and have understood
			and have accepted the same. I understand, agree and accept that the institute shall not be held liable and/or responsible in any manner
			whatsoever if I fail to comply with all the admission procedures and formalities.<br>
			<br>
			I understand, agree and accept that the college only grants me Provisional Admission and that my admission is subject to confirmation by
			statutory and/or regulatory authorities. I understand, agree and accept that it is my duty and responsibility to ensure that I complete all
			admission procedures and formalities including obtaining eligibility certificates and equivalence certificate where .
			<br>
			<br>
			The information given by me in this application is true to the best of knowledge and belief. I understand that if any of the statements made by 
			by me in the application form or any information supplied by me in connection with my admission, are found to be false or incorrect, at any point,
			my admission will be cancelled, fees forfeited and that I may be expelled from the Graduate School of Technology by the Principal. I have not been debarred from appearing at any examination held by any Government constituted or statutory examination authority.
			<br>
			<br>
			I fully understand and accept that the offer of a course will be made to me depending on my inter se merit and availability of a seat at the time
			of scrutiny of my application when I actually report to the admitting authority according to the schedule of admission. I am aware that the 
			institute authority will not make any correspondence with me regarding admission. I am also aware that it is entirely my responsibility to check 
			the notice board of the Graduate School of Technology.
			<br>
			<br>
			I hereby agree, accept and undertake to conform to any rules, acts and laws enforced by the Government and I shall not undertake any act inside or outside the Graduate School of Technology, which may result in disciplinary action against me under the rules, acts and laws referred to. 
			I understand that the Principal of The Graduate School of Technology has a right to expel me from the Graduate School of Technology for any infringement of the rules of conduct and discipline prescribed by the Graduate School of Technology and /or the University and/or Government 
			and/or any other statutory and/or regulatory authority infringement of the undertaking given above.
			<br>
			<br>
			I am aware of the punishment for ragging and in case I a found guilty of any misconduct or involvement in ragging, I shall be liable for punishment under the Prohibition of Ragging Act, 1997 and the rules made there under.
			<br>
			<br>
			I am fully aware that I will not be allowed for the examination if I do not attend 75% classes of theory, practicals, drawing etc. I am also aware that I will not be allowed to appear examination, if I fail to submit satisfactorily al the assignments, jobs, journals, drawings, reports
			as specified by the University within the stipulated time limit.
			</p> 
			<br>
			<b><input type="checkbox" name="declaration" id="declaration">I agree to sign the requisite agreement bond as prescribed by the Government.</b> 
			<br>
			<br>
			<label for="today_date">Date:</label>
		
			<input type="hidden" id="today_date1">			</input>
			<p id="today_date" name="today_date">&nbsp;</p>
<div class="form-group">	
		<input type="submit" value="Next" class="buttonNext"/>

		<a href="fe5"><input type="button" value="Previous" class="buttonPrevious" /></a>	
		</div>
	</form>	
	</div>
</body>	
</html>		