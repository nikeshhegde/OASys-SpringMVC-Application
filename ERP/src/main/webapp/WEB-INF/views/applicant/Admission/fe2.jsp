<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FE - Step II</title>
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
	$('.form-control-hsc').change(function(){
			//alert("Hsc entry");
			var pcm=0;
			var pcm_total=0;
			var p_marks=$('#marks_physics_hsc_obtained').val();
			pcm=pcm+parseInt(p_marks);
			var p_total=$('#marks_total_hsc_physics').val();
			pcm_total=pcm_total+parseInt(p_total);
			var m_marks=$('#marks_maths_hsc_obtained').val();
			var m_total=$('#marks_total_hsc_maths').val();
			pcm_total=pcm_total+parseInt(m_total);
			pcm=pcm+parseInt(m_marks);
			var pmv=pcm;
			var pmv_total=pcm_total;
			var c_marks=$('#marks_chem_hsc_obtained').val();
			var c_total=$('#marks_total_hsc_chem').val();
			pcm_total=pcm_total+parseInt(c_total);
			pcm=pcm+parseInt(c_marks);
			var v_marks=$('#marks_voc_hsc_obtained').val();
			var v_total=$('#marks_total_hsc_voc').val();
			pmv_total=pmv_total+parseInt(v_total);
			var pmv=pmv+parseInt(v_marks);
			if(!isNaN(pcm))
				{
				//alert("once"+pcm);
				$('#marks_pcm_obtained').val(pcm.toString());
				}
		
			if(!isNaN(pcm_total))
				{
				//alert("once"+pcm);
				$('#marks_total_pcm').val(pcm_total.toString());
				}	
		
		
			if(!isNaN(pmv))
				{
				//alert("once"+pcm);
				$('#marks_pmv_obtained').val(pmv.toString());
				}	
				
			if(!isNaN(pmv_total))
				{
				//alert("once"+pcm);
				$('#marks_total_pmv').val(pmv_total.toString());
				}	

			});
			
			});
</script>

<script>
$(function(){
	$('.form-control-jee').change(function(){
			//alert("Jee entry");
			var pcm=0;
			var pcm_total=0;
			var p_marks=$('#marks_jee_phy_obtained').val();
			pcm=pcm+parseInt(p_marks);
			var p_total=$('#marks_total_phy_jee').val();
			pcm_total=pcm_total+parseInt(p_total);
			var m_marks=$('#marks_jee_maths_obtained').val();
			var m_total=$('#marks_total_maths_jee').val();
			pcm_total=pcm_total+parseInt(m_total);
			pcm=pcm+parseInt(m_marks);
			var pmv=pcm;
			var pmv_total=pcm_total;
			var c_marks=$('#marks_jee_chem_obtained').val();
			var c_total=$('#marks_total_chem_jee').val();
			pcm_total=pcm_total+parseInt(c_total);
			pcm=pcm+parseInt(c_marks);
			
			if(!isNaN(pcm))
				{
				//alert("once"+pcm);
				$('#marks_jee_total_obtained').val(pcm.toString());
				}
		
			if(!isNaN(pcm_total))
				{
				//alert("once"+pcm);
				$('#marks_total_jee').val(pcm_total.toString());
				}	
		

		});

});
</script>
<script>
$(function(){
	$('.form-control-merit-score').change(function(){
	//alert("entering merit jquery");
	var jeepercentile=$("#jee_percentile_obtained").val();
	var boardpercentile=$("#board_percentile_obtained").val();
	
	var meritscore=0.5*(parseInt(jeepercentile)+parseInt(boardpercentile));
	if(!isNaN(meritscore))
	{
	//alert("once"+pcm);
	$('#merit_score').val(meritscore.toString());
	}
	});
});	

</script>

<!-- script>
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
</script-->



</head>
<body>
	<div id="step-2" class="swMain">
            <form id="form" action="fe3" method="GET">
			<h2 class="StepTitle">Step 2-Academic details</h2>	
			<div class="form-group">
			<label for="inputEmail1" class="col-lg-2 control-label"></label>
					<div class="col-lg-11">
						<h3>SSC</h3>
					</div>
			</div>	
            <div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Maths</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserFeAcademicsSscMathsMarksObtained" id="marks_maths_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsSscMathsMarksObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained"  >
					<label id="marks_maths_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="admissionUserFeAcademicsSscMathsMarksTotal" id="marks_total_maths" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsSscMathsMarksTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_maths-error" class="text-danger"></label>
				</div>
			</div>
			<br>
			<br>
			<br>
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Grand Total</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserFeAcademicsSscGrandMarksObtained" id="marks_grand_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsSscGrandMarksObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
						<label id="marks_grand_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="admissionUserFeAcademicsSscGrandMarksTotal" id="marks_total_grand" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsSscGrandMarksTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
				<label id="marks_total_grand-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Percentage obtained</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="admissionUserFeAcademicsSscPercentageObtained" id="percentage_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsSscPercentageObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Do not use % sign" >
						<label id="percentage_obtained-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Year of passing</label>
				<div class="col-lg-11">
						<input type="year" class="form-control" name="admissionUserFeAcademicsSscYearOfPassing" id="year_of_passing" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsSscYearOfPassing()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Year of passing" >
						<label id="year_of_passing-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
			<label for="inputEmail1" class="col-lg-2 control-label"></label>
					<div class="col-lg-11">
						<h3>HSC</h3>
					</div>
			</div>	
			
			<div class="form-group">
			<label for="inputEmail1" class="col-lg-2 control-label">12th board</label>
					<div class="col-lg-11">
						<select name="admissionUserFeAcademicsXiiBoard" id="xii_board" class="form-control">
							<option>HSC</option>
							<option>CBSE</option>
							<option>ICSE</option>
							<option>Others</option>
						</select>
					</div>
			</div>


			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">English (E)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserFeAcademicsXiiEnglishMarksObtained" id="marks_english_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiEnglishMarksObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
					<label id="marks_english_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="admissionUserFeAcademicsXiiEnglishMarksTotal" id="marks_total_english" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiEnglishMarksTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_english-error" class="text-danger"></label>
					<label class="text-danger"></label>
				</div>
			</div>


			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Physics (P)</label>
				<div class="col-lg-11">
						<input type="text" class="form-control-hsc" name="admissionUserFeAcademicsXiiPhysicsMarksObtained" id="marks_physics_hsc_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiPhysicsMarksObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
						<label id="marks_physics_hsc_obtained-error" class="text-danger"></label>
						<input type="text" class="form-control-hsc" name="admissionUserFeAcademicsXiiPhysicsMarksTotal" id="marks_total_hsc_physics" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiPhysicsMarksTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
						<label id="marks_total_hsc_physics-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Chemistry (C)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-hsc" name="admissionUserFeAcademicsXiiChemistryMarksObtained" id="marks_chem_hsc_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiChemistryMarksObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
					<label id="marks_chem_hsc_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-hsc" name="admissionUserFeAcademicsXiiChemistryMarksTotal" id="marks_total_hsc_chem" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiChemistryMarksTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_hsc_chem-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Maths (M)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-hsc" name="admissionUserFeAcademicsXiiMathsMarksObtained" id="marks_maths_hsc_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiMathsMarksObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
					<label id="marks_maths_hsc_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-hsc" name="admissionUserFeAcademicsXiiMathsMarksTotal" id="marks_total_hsc_maths" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiMathsMarksTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_hsc_maths-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Vocational Subject (V)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-hsc" name="admissionUserFeAcademicsXiiVocationalMarksObtained" id="marks_voc_hsc_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiVocationalMarksObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
					<label id="marks_voc_hsc_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-hsc" name="admissionUserFeAcademicsXiiVocationalMarksTotal" id="marks_total_hsc_voc" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiVocationalMarksTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_hsc_voc-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">PCM total</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserFeAcademicsXiiPcmObtained" id="marks_pcm_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiPcmObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained">
					<label id="marks_pcm_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="admissionUserFeAcademicsXiiPcmTotal" id="marks_total_pcm" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiPcmTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_pcm-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">PMV total</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserFeAcademicsXiiPmvObtained" id="marks_pmv_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiPmvObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained">
					<label id="marks_pmv_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="admissionUserFeAcademicsXiiPmvTotal" id="marks_total_pmv" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiPmvTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_pmv-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Year of passing</label>
				<div class="col-lg-11">
						<input type="year" class="form-control" name="admissionUserFeAcademicsXiiYearOfPassing" id="hsc_year_of_passing" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsXiiYearOfPassing()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Year of passing" >
						<label id="hsc_year_of_passing-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
			<label for="inputEmail1" class="col-lg-2 control-label"></label>
					<div class="col-lg-11">
						<h3>JEE(main)</h3>
					</div>
			</div>	
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Physics (P)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-jee" name="admissionUserFeAcademicsJeePhysicsObtained" id="marks_jee_phy_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsJeePhysicsObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
					<label id="marks_jee_phy_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-jee" name="admissionUserFeAcademicsJeePhysicsTotal" id="marks_total_phy_jee" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsJeePhysicsTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_phy_jee-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Chemistry (C)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-jee" name="admissionUserFeAcademicsJeeChemistryObtained" id="marks_jee_chem_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsJeeChemistryObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
					<label id="marks_jee_chem_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-jee" name="admissionUserFeAcademicsJeeChemistryTotal" id="marks_total_chem_jee" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsJeeChemistryTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_chem_jee-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Maths (M)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-jee" name="admissionUserFeAcademicsJeeMathsObtained" id="marks_jee_maths_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsJeeMathsObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
					<label id="marks_jee_maths_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-jee" name="admissionUserFeAcademicsJeeMathsTotal" id="marks_total_maths_jee" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsJeeMathsTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
					<label id="marks_total_maths_jee-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Total</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="admissionUserFeAcademicsJeeTotalObtained" id="marks_jee_total_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsJeeTotalObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" >
						<label id="marks_jee_total_obtained-error" class="text-danger"></label>
						<input type="text" class="form-control" name="admissionUserFeAcademicsJeeTotal" id="marks_total_jee" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsJeeTotal()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" >
						<label id="marks_total_jee-error" class="text-danger"></label>
					</div>
			</div>
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">JEE Percentile</label>
				<div class="col-lg-11">
						<input type="text" class="form-control form-control-merit-score" name="admissionUserFeAcademicsJeePercentileObtained" id="jee_percentile_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsJeePercentileObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Do not use % sign" >
						<label id="jee_percentile_obtained-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Board Percentile</label>
				<div class="col-lg-11">
						<input type="text" class="form-control form-control-merit-score" name="admissionUserFeAcademicsBoardPercentileObtained" id="board_percentile_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsBoardPercentileObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Do not use % sign" >
						<label id="board_percentile_obtained-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Merit Score(Composite score)</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="admissionUserFeAcademicsMeritScore" id="merit_score" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsMeritScore()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Do not use % sign" readonly>
						<label id="merit_score-error" class="text-danger"></label>
				</div>
			</div>
			
			
			
			
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">All India JEE Rank</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="admissionUserFeAcademicsAllIndiaJeeRank" id="board_percentile_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsAllIndiaJeeRank()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Do not use % sign" >
						<label id="board_percentile_obtained-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">State JEE Rank</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="admissionUserFeAcademicsStateJeeRank" id="board_percentile_obtained" value='<c:catch var="exception">${userModelAcademics.getAdmissionUserFeAcademicsStateJeeRank()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Do not use % sign" >
						<label id="board_percentile_obtained-error" class="text-danger"></label>
				</div>
			</div>
		<div class="form-group">	
		<input type="submit" value="Next" class="buttonNext"/>

		<a href="fe1"><input type="button" value="Previous" class="buttonPrevious"/></a>	
		</div>
	</form>	
	</div>
	</body>	
</html>		