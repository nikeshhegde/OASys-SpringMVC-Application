<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admission Form Wizard</title>
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
	$('.form-control-hsc').change(function(){
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

<div class="frame">
	<div class="sidebar">
		<div class="wrapper">
		<a href="index.html" class="logo"><img src="resources/applicant/dashboard/images/logo.png" alt="Archon Admin" /></a>
			<ul class="nav  nav-list">

					<!-- sidebar input search box -->
					<li class="nav-search">
						<!--div class="form-group">
							<input type="text" class="form-control nav-search" placeholder="Search through site" />
							<span class="input-icon fui-search"></span>
						</div-->
					</li>

					<!-- Sidebar header @add class nav-header for sidebar header -->
					<!--li class="nav-header">Overview</li-->
					<li><a href="index.html"><i class="fa fa-dashboard"></i>Dashboard </a></li>
					<li><a href=""><i class="fa fa-book"></i>Prospectus</a></li>
					<li class="active"><a href=""><i class="fa fa-suitcase"></i>Admission Form</a></li>
					<li><a href=""><i class="fa fa-print"></i>Print Application</a></li>					
					<li><a href=""><i class="fa fa-key"></i>Change Password</a></li>				
			</ul>	
		</div>
	</div>
<div class="content">
		<div class="navbar">
		</div>
		<div class="main-content">
			<div class="row">
			</div>
			<h1>Session value is ${userID}</h1>
			
			
			
			
			
			
			<h3 class="page-header">Form Wizard</h3>	
<table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td> 

  		<div id="wizard" class="swMain">
  			<ul>
  				<li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                   out of 6<br />
                   <small>Personal details</small>
                </span>
            </a></li>
  				<li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                   out of 6<br />
                   <small>Academic details</small>
                </span>
            </a></li>
  				<li><a href="#step-3">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                  out of 6<br />
                   <small>Branch Selection</small>
                </span>                   
             </a></li>
  				<li><a href="#step-4">
                <label class="stepNumber">4</label>
                <span class="stepDesc">
                   out of 6<br />
                   <small>Guardians' Details</small>
                </span>                          </a></li>
			
			<li><a href="#step-5">
                <label class="stepNumber">5</label>
                <span class="stepDesc">
                   out of 6<br />
                   <small>Attach Documents</small>
                </span>                   
            </a></li>
			
			
			<li><a href="#step-6">
                <label class="stepNumber">6</label>
                <span class="stepDesc">
                   out of 6<br />
                   <small>Declaration</small>
                </span>                   
            </a></li>
			
			
  			</ul>
  			
 
  			<div id="step-1">
  			<form id="form" method="post">	
            <h2 class="StepTitle">Step 1-Personal details
			</h2>
			<div class="form-group">
				<label for="form_id" class="col-lg-2 control-label">
				Application ID
				</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admission_user_form_id" id="admission_user_form_id" value="${ApplicationID}" readonly />
				</div>
			</div>
            <div class="form-group">
				<label for="admission_user_applied" class="col-lg-2 control-label">
				Applied under:(Select any one)
				</label>
				<div class="col-lg-11">
					<label class="radio">Linguistic Minority</label>
					<input type="radio" class="radio" name="admission_user_applied" id="admission_user_applied" value="LM">
					<br>
					<label class="radio">Religious Minority</label>
					<input type="radio" class="radio" name="admission_user_applied" id="admission_user_applied" value= "RM">
					<br>
					<label class="radio">Other Linguistic Minority</label>
					<input type="radio" class="radio" name="admission_user_applied" id="admission_user_applied" value= "OLM">
					<br>
					<label class="radio">CAP</label>
					<input type="radio" class="radio" name="admission_user_applied" id="admission_user_applied" value="CAP">
					<br>
					<label class="radio">Institute level</label>
					<input type="radio" class="radio" name="admission_user_applied" id="admission_user_applied" value="IL">
					<br>
					<label class="radio">J & K</label>
					<input type="radio" class="radio" name="admission_user_applied" id="admission_user_applied" value="JK">				
					<label for="admission_user_surname" id="admission_user_surname-error" class="text-danger"></label>  
				</div>
			</div>
			<div class="form-group">
				<label for="surname" class="col-lg-2 control-label">
				Surname
				</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admission_user_surname" id="admission_user_surname" placeholder="Surname">
					<label for="admission_user_surname" id="admission_user_surname-error" class="text-danger"></label>  
				</div>
			</div>
			</br>
			</br>

			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">
				Name
				</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admission_user_name" id="admission_user_name"  placeholder="Username">
					<label for="admission_user_name" id="admission_user_name-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Father's Name</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admission_user_father_name" id="admission_user_father_name"  placeholder="Father's name">
					<label for="admission_user_father_name" id="admission_user_father_name-error" class="text-danger"></label>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Mother's Name</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admission_user_mother_name" id="admission_user_mother_name"  placeholder="Mother's name">
					<label for="admission_user_mother_name" id="admission_user_mother_name-error" class="text-danger"></label>
				</div>
			</div>			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Permanent Address</label>
				<div class="col-lg-11">
					<textarea class="form-control" name="admission_user_p_address" id="admission_user_p_address"  placeholder="Permanent Address"></textarea>
					<label for="admission_user_p_address" id="admission_user_p_address-error" class="text-danger"></label>
				</div>
			</div>

			<div class="form-group">
				<label for="check_address" class="col-lg-2 control-label"></label>
				<div class="col-lg-11">
				<label>
				<input type="checkbox" id="check_address" name="check_address">
														Click here if Current and permanent address is same
				</label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Current Address</label>
				<div class="col-lg-11">
					<textarea class="form-control" name="admission_user_c_address" id="admission_user_c_address"  placeholder="Current Address" ></textarea>
					<label for="admission_user_c_address" id="admission_user_c_address-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Landline</label>
				<div class="col-lg-11">
					<div class="input-group">
						<input type="tel" class="form-control" id="admission_user_landline" name="admission_user_landline" >
						<label for "admission_user_landline" id="admission_user_landline-error" class="text-danger"></label>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Mobile</label>
				<div class="col-lg-11">
					<div class="input-group">
						<span class="input-group-addon">+91</span><input type="tel" class="form-control" id="admission_user_mobile" name="admission_user_mobile" >
					<label for "admission_user_mobile" id="admission_user_mobile-error" class="text-danger"></label>
					</div>
																		
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Email</label>
			<div class="col-lg-11">
					<input type="email" class="form-control" name="email" id="email" placeholder="Email">
					<label for="email" id="email-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Date of Birth</label>
			<div class="col-lg-11">
					<input type="date" class="form-control" name="date" id="date">
					<label for="date" id="date-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Place of Birth</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="place_of_birth" id="place_of_birth" placeholder="Place of Birth">
					<label for="place_of_birth" id="place_of_birth-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Gender</label>
				<div class="col-lg-11">
					<select name="gender" id="gender" class="form-control">
						<option value="">---Gender---</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
						<option value="Other">Other</option>
					</select>
					<label for="gender" id="gender-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Domicile</label>
				<div class="col-lg-11">
					<select name="domicile" id="domicile" class="form-control">
						<option value="">---Domicile---</option>
						<option value="Yes">Yes</option>
						<option value="No">No</option>
					</select>
					<label for="domicile" id="domicile-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group" id="dc">
			<table class="table">
				<tr>
				<td>
					<label for="dc" class="col-lg-7 control-label">Domicile certificate</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="dc" id="dc">
						<label id="dc-error" class="text-danger"></label>
				</td>
				</tr>
			</table>	
			</div>
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">State</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="state" id="state" placeholder="State">
					<label for="state" id="state-error" class="text-danger"></label>
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Nationality</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="nationality" id="nationality" placeholder="Nationality">
					<label for "nationality" id="nationality-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Religion</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="religion" id="religion" placeholder="Religion">
					<label for ="religion" id="religion-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Caste</label>
				<div class="col-lg-11">
					<select name="caste" id="caste" class="form-control">
						<option value="">---Caste---</option>
						<option value="Open">Open</option>
						<option value="SC">SC</option>
						<option value="ST">ST</option>
						<option value="OBC">OBC</option>
						<option value="SBC">SBC</option>
						<option value="NT1">NT1</option>
						<option value="NT2">NT2</option>
						<option value="NT3">NT3</option>
						<option value="DT">DT</option>
						<option value="VJ">VJ</option>
						<option value="Maratha">Maratha</option>
					</select>
					<label for="caste" id="caste-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Handicap</label>
				<div class="col-lg-11">
					<select name="handicap" id="handicap" class="form-control">
						<option value="">Handicap</option>
						<option value="No">No</option>
						<option value="Yes">Yes</option>
					</select>
					<label for="handicap" id="handicap-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">EBC</label>
				<div class="col-lg-11">
					<select name="econ_backward" id="econ_backward" class="form-control">
						<option value="">Economically Backward</option>
						<option value="No">No</option>
						<option value="Yes">Yes</option>
					</select>
					<label for="econ_backward" id="econ_backward-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Blood Group</label>
				<div class="col-lg-11">
					<select name="blood_group" id="blood_group" class="form-control">
						<option>A</option>
						<option>B</option>
						<option>AB</option>
						<option>O</option>
					</select>
					
					<select name="rh" id="rh" class="form-control">
						<option>+ve</option>
						<option>-ve</option>
					</select>
				</div>
			</div>
			
			<table class="table">
				<tr>
				<td>
					<label for="lma" class="col-lg-7 control-label" id="lma-label">Linguistic minority affidavit</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="lma" id="lma">
						<label id="lma-error" class="text-danger"></label>
				</td>
				</tr>
			</table>
			
			<!-- /form -->
			
			
					
        </div>
  			<div id="step-2">
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
					<input type="text" class="form-control" name="marks_maths_obtained" id="marks_maths_obtained" placeholder="Marks obtained" >
					<label id="marks_maths_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="marks_total_maths" id="marks_total_maths" placeholder="Maximum marks"  >
					<label id="marks_total_maths-error" class="text-danger"></label>
				</div>
			</div>
			<br>
			<br>
			<br>
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Grand Total</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="marks_grand_obtained" id="marks_grand_obtained" placeholder="Marks obtained" >
						<label id="marks_grand_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="marks_total_grand" id="marks_total_grand" placeholder="Maximum marks" >
				<label id="marks_total_grand-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Percentage obtained</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="percentage_obtained" id="percentage_obtained" placeholder="Do not use % sign" >
						<label id="percentage_obtained-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Year of passing</label>
				<div class="col-lg-11">
						<input type="year" class="form-control" name="year_of_passing" id="year_of_passing" placeholder="Year of passing" >
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
						<select name="xii_board" id="xii_board" class="form-control">
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
					<input type="text" class="form-control" name="marks_english_obtained" id="marks_english_obtained" placeholder="Marks obtained" >
					<label id="marks_english_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="marks_total_english" id="marks_total_english" placeholder="Maximum marks" >
					<label id="marks_total_english-error" class="text-danger"></label>
					<label class="text-danger"></label>
				</div>
			</div>


			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Physics (P)</label>
				<div class="col-lg-11">
						<input type="text" class="form-control-hsc" name="marks_physics_hsc_obtained" id="marks_physics_hsc_obtained" placeholder="Marks obtained" >
						<label id="marks_physics_hsc_obtained-error" class="text-danger"></label>
						<input type="text" class="form-control-hsc" name="marks_total_hsc_physics" id="marks_total_hsc_physics" placeholder="Maximum marks" >
						<label id="marks_total_hsc_physics-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Chemistry (C)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-hsc" name="marks_chem_hsc_obtained" id="marks_chem_hsc_obtained" placeholder="Marks obtained" >
					<label id="marks_chem_hsc_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-hsc" name="marks_total_hsc_chem" id="marks_total_hsc_chem" placeholder="Maximum marks" >
					<label id="marks_total_hsc_chem-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Maths (M)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-hsc" name="marks_maths_hsc_obtained" id="marks_maths_hsc_obtained" placeholder="Marks obtained" >
					<label id="marks_maths_hsc_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-hsc" name="marks_total_hsc_maths" id="marks_total_hsc_maths" placeholder="Maximum marks" >
					<label id="marks_total_hsc_maths-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Vocational Subject (V)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-hsc" name="marks_voc_hsc_obtained" id="marks_voc_hsc_obtained" placeholder="Marks obtained" >
					<label id="marks_voc_hsc_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-hsc" name="marks_total_hsc_voc" id="marks_total_hsc_voc" placeholder="Maximum marks" >
					<label id="marks_total_hsc_voc-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">PCM total</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="marks_pcm_obtained" id="marks_pcm_obtained" placeholder="Marks obtained">
					<label id="marks_pcm_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="marks_total_pcm" id="marks_total_pcm" placeholder="Maximum marks" >
					<label id="marks_total_pcm-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">PMV total</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="marks_pmv_obtained" id="marks_pmv_obtained" placeholder="Marks obtained">
					<label id="marks_pmv_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="marks_total_pmv" id="marks_total_pmv" placeholder="Maximum marks" >
					<label id="marks_total_pmv-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Year of passing</label>
				<div class="col-lg-11">
						<input type="year" class="form-control" name="hsc_year_of_passing" id="hsc_year_of_passing" placeholder="Year of passing" >
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
					<input type="text" class="form-control-jee" name="marks_jee_phy_obtained" id="marks_jee_phy_obtained" placeholder="Marks obtained" >
					<label id="marks_jee_phy_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-jee" name="marks_total_phy_jee" id="marks_total_phy_jee" placeholder="Maximum marks" >
					<label id="marks_total_phy_jee-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Chemistry (C)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-jee" name="marks_jee_chem_obtained" id="marks_jee_chem_obtained" placeholder="Marks obtained" >
					<label id="marks_jee_chem_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-jee" name="marks_total_chem_jee" id="marks_total_chem_jee" placeholder="Maximum marks" >
					<label id="marks_total_chem_jee-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Maths (M)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-jee" name="marks_jee_maths_obtained" id="marks_jee_maths_obtained" placeholder="Marks obtained" >
					<label id="marks_jee_maths_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-jee" name="marks_total_maths_jee" id="marks_total_maths_jee" placeholder="Maximum marks" >
					<label id="marks_total_maths_jee-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Total</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="marks_jee_total_obtained" id="marks_jee_total_obtained" placeholder="Marks obtained" >
						<label id="marks_jee_total_obtained-error" class="text-danger"></label>
						<input type="text" class="form-control" name="marks_total_jee" id="marks_total_jee" placeholder="Maximum marks" >
						<label id="marks_total_jee-error" class="text-danger"></label>
					</div>
			</div>
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">JEE Percentile</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="jee_percentile_obtained" id="jee_percentile_obtained" placeholder="Do not use % sign" >
						<label id="jee_percentile_obtained-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Board Percentile</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="board_percentile_obtained" id="board_percentile_obtained" placeholder="Do not use % sign" >
						<label id="board_percentile_obtained-error" class="text-danger"></label>
				</div>
			</div>
			
			
			
			
			
        </div>                      
  			<div id="step-3">
            <h2 class="StepTitle">Step 3-Branch Selection</h2>	
			<h4>Assign priority to the branch ranging from 1-6</h4>
			<h4>1:Highest priority and 6:Least priority</h4>		
			<h4>Priority for each branch must be unique</h4>	
			<b><p id="invalid_priority" class="text-danger"></p></b>
			<label class="col-lg-2 control-label">EXTC</label>
				<div class="col-lg-11">
					<select class="form-control" name="extc" id="extc">
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
					<select class="form-control" name="ce" id="ce">
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
					<select class="form-control" name="it" id="it">
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
					<select class="form-control" name="ppt" id="ppt">
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
					<select class="form-control" name="bt" id="bt">
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
					<select class="form-control" name="mech" id="mech">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option selected>6</option>
					</select>
				</div>


		  
        </div>
  			<div id="step-4">
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
					<td><input type="text" name="name_father" id="name_father"></td>
					<td><input type="text" name="name_mother" id="name_mother"></td>
					<td><input type="text" name="name_guardian" id="name_guardian"></td>
				</tr>
				<tr>
					<td>Occupation(Service/Business)</td>
					<td><input type="text" name="occ_father" id="occ_father"></td>
					<td><input type="text" name="occ_mother" id="occ_mother"></td>
					<td><input type="text" name="occ_guardian" id="occ_guardian"></td>
				</tr>
				<tr>
					<td>Office Address</td>
					<td><input type="text" name="off_father" id="off_father"></td>
					<td><input type="text" name="off_mother" id="off_mother"></td>
					<td><input type="text" name="off_guardian" id="off_guardian"></td>
				</tr>
				<tr>
					<td>Telephone number</td>
					<td><input type="text" name="tele_father" id="tele_father"></td>
					<td><input type="text" name="tele_mother" id="tele_mother"></td>
					<td><input type="text" name="tele_guardian" id="tele_guardian"></td>
					</tr>
				<tr>
					<td>Mobile number</td>
					<td><input type="text" name="mob_father" id="mob_father"></td>
					<td><input type="text" name="mob_mother" id="mob_mother"></td>
					<td><input type="text" name="mob_guardian" id="mob_guardian"></td>				
				</tr>
				<tr>
					<td>Email ID</td>
					<td><input type="text" name="email_father" id="email_father"></td>
					<td><input type="text" name="email_mother" id="email_mother"></td>
					<td><input type="text" name="email_guardian" id="email_guardian"></td>				
				</tr>
				<tr>
					<td>Annual Income</td>
					<td><input type="text" name="ann_father" id="ann_father"></td>		
					<td><input type="text" name="ann_mother" id="ann_mother"></td>					
					<td><input type="text" name="ann_guardian" id="ann_guardian"></td>					
					
				</tr>
			</table>	
        </div>
		
		
		
		
		
			<div id="step-5">
			<h2 class="StepTitle">Step 5-Attach documents</h2>	
			
			<table class="table">
				<tr>
				<td>
					<label for="ssc" class="col-lg-7 control-label">SSC/Std. X Examination marksheet</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="ssc" id="ssc">
						<label id="ssc-error" class="text-danger"></label>
				</td>
				</tr>
				
				<tr>
				<td>	
					<label for="slc" class="col-lg-7 control-label">School Leaving certificate from the Institution which the candidate has passed the examination</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="slc" id="slc">
						<label id="slc-error" class="text-danger"></label>
				</td>
				</tr>
				
				
				<tr>
				<td>
					<label for="hsc" class="col-lg-7 control-label">Marksheet at the qualifying examination (Std. XII or equivalent)</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="hsc" id="hsc">
						<label id="hsc-error" class="text-danger"></label>
				</td>
				</tr>
			
				<tr>
				<td>	
					<label for="slc" class="col-lg-7 control-label">College Leaving certificate from the Institution which the candidate has passed the examination</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="slc" id="slc">
						<label id="slc-error" class="text-danger"></label>
				</td>
				</tr>
				
				
				<tr>
				<td>	
					<label for="ppc" class="col-lg-7 control-label">Physical fitness certificate from a registered medical practitioner</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="ppc" id="ppc">
						<label id="ppc-error" class="text-danger"></label>
				</td>
				</tr>
				
				<tr>
				<td>	
					<label for="jee" class="col-lg-7 control-label">JEE(main) Score card</label>
				</td>
				<td>
						<input type="file" class="form-controlfile" name="jee" id="jee">
						<label id="jee-error" class="text-danger"></label>
				</td>
				</tr>
			
			</table>
			
			
			</div>
			
			<div id="step-6">
			<h2 class="StepTitle">Step 6-Declarations</h2>

			<h3>Declaration for parents</h3>
			<br>
			<p>
			Mr/Mrs.__________declare that the particulars furnished by my son/daughter/ward in this 
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
			I have read a copy of the rules for admission published by the statutory and regulatory authorities and the institute and have understood
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
			I am fully aware that I will not be allowed for the examination if I do not attend 75% classes of theory, practicals, drawing etc. I am also aware taht I will not be allowed to appear examination, if I fail to submit satisfactorily al the assignments, jobs, journals, drawings, reports
			as specified by the University within the stipulated time limit.
			</p> 
			<br>
			<b><input type="checkbox" name="declaration" id="declaration">I agree to sign the requisite agreement bond as prescribed by the Government.</b> 
			<br>
			<br>
			<label for="today_date">Date:</label>
		
			<input type="hidden" id="today_date1">			</input>
			<p id="today_date" name="today_date">&nbsp;</p>

			
			</div>
			
			
  		</div>
		<input type="hidden" name="user_sess" id="user_sess" value="${userID}">
 		</form>
</td></tr>
</table>
</div>
</div>
</div>
   <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>		
</body>
</html>
