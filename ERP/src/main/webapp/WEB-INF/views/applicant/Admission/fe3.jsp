<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FE - Step III</title>
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
  			<div id="step-3" class="swMain">
			    <form id="form" action="fe4" method="GET">
            <h2 class="StepTitle">Step 3-Branch Selection</h2>	
			<h4>Assign priority to the branch ranging from 1-6</h4>
			<h4>1:Highest priority and 6:Least priority</h4>		
			<h4>Priority for each branch must be unique</h4>	
			<b><p id="invalid_priority" class="text-danger"></p></b>
			<label class="col-lg-2 control-label">EXTC</label>
				<div class="col-lg-11">
					<select class="form-control" name="admissionUserBranchSelectionEXTCPriority" id="extc">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
					</select>
				</div>
				<label for="inputEmail1" class="col-lg-2 control-label">CE</label>
				<div class="col-lg-11">
					<select class="form-control" name="admissionUserBranchSelectionCEPriority" id="ce">
						<option>1</option>
						<option selected>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
					</select>
				</div>
				
				<label for="inputEmail1" class="col-lg-2 control-label">IT</label>
				<div class="col-lg-11">
					<select class="form-control" name="admissionUserBranchSelectionITPriority" id="it">
						<option>1</option>
						<option>2</option>
						<option selected>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
					</select>
				</div>
				
				<label for="inputEmail1" class="col-lg-2 control-label">PPT</label>
				<div class="col-lg-11">
					<select class="form-control" name="admissionUserBranchSelectionPPTPriority" id="ppt">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option selected>4</option>
						<option>5</option>
						<option>6</option>
					</select>
				</div>
				
				<label for="inputEmail1" class="col-lg-2 control-label">BT</label>
				<div class="col-lg-11">
					<select class="form-control" name="admissionUserBranchSelectionBTPriority" id="bt">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option selected>5</option>
						<option>6</option>
					</select>
				</div>
				
				<label for="inputEmail1" class="col-lg-2 control-label">MECH</label>
				<div class="col-lg-11">
					<select class="form-control" name="admissionUserBranchSelectionMECHPriority" id="mech">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option selected>6</option>
					</select>
				</div>
		<div class="form-group">	
		<input type="submit" value="Next" class="buttonNext"/>

		<a href="fe2"><input type="button" value="Previous" class="buttonPrevious" /></a>	
		</div>
	</form>	
	</div>	
</body>	
</html>		