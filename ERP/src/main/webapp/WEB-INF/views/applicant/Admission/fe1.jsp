<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FE - Step I</title>
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

<script type="text/javascript">

var appliedunder = "${userModel.getAdmissionUserAppliedUnder()}";


</script>

<script>

$(document).ready(function(){
	var component="#state option";
	var id="#state";
	var db="${userModel.getAdmissionUserState()}";
$(component).each(function()
		{
		   if($(this).val()==db)
			   {
			   $(id).val(db);
			   }
		});
});		
	
</script>

<script>

$(document).ready(function(){
	var component="#caste option";
	var id="#caste";
	var db="${userModel.getAdmissionUserCaste()}";	
$(component).each(function()
		{
		   if($(this).val()==db)
			   {
			   $(id).val(db);
			   }
		});
});		
	
</script>




</head>
<body>
<div id="step-1" class="swMain">
  			<form id="form" action="fe2" method="get">	
            <h2 class="StepTitle">Step 1-Personal details
			</h2>
			<!--div class="form-group">
				<label for="form_id" class="col-lg-2 control-label">
				Application ID
				</label>
				<div class="col-lg-11"-->
					<!-- Monika -->
					<!--input type="hidden"  name="id" id="id"  value="${userID}"  />
					<input type="text" class="form-control" name="admission_user_form_id" id="admission_user_form_id" value="${ApplicationID}" readonly />
				</div>
			</div-->
            <div class="form-group">
				<label for="admission_user_applied" class="col-lg-2 control-label">
				Applied under:(Select any one)
				</label>
				<div class="col-lg-11">
					<label class="radio">Linguistic Minority</label>
					<input type="radio" class="radio" name="admissionUserAppliedUnder" id="admission_user_applied_lm" value="Linguistic Minority">
					<br>
					<label class="radio">Religious Minority</label>
					<input type="radio" class="radio" name="admissionUserAppliedUnder" id="admission_user_applied_rm" value= "Religious Minority">
					<br>
					<label class="radio">Other Linguistic Minority</label>
					<input type="radio" class="radio" name="admissionUserAppliedUnder" id="admission_user_applied_olm" value= "Other Linguistic Minority">
					<br>
					<label class="radio">CAP</label>
					<input type="radio" class="radio" name="admissionUserAppliedUnder" id="admission_user_applied_cap" value="CAP">
					<br>
					<label class="radio">Institute level</label>
					<input type="radio" class="radio" name="admissionUserAppliedUnder" id="admission_user_applied_il" value="Institute level">
					<br>
					<label class="radio">J & K</label>
					<input type="radio" class="radio" name="admissionUserAppliedUnder" id="admission_user_applied_jk" value="JK">				
					<label for="admission_user_surname" id="admission_user_surname-error" class="text-danger"></label>  
				</div> 
			</div>
			<div class="form-group">
				<label for="surname" class="col-lg-2 control-label">
				Surname 
				</label>
				<div class="col-lg-11">
				<!-- Monika -->
					<input type="text" class="form-control" name="admissionUserSurName" id="admission_user_surname" value='<c:out value="${userModel.getAdmissionUserSurName()}"/>' placeholder="Surname">
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
					<input type="text" class="form-control" name="admissionUserFname" id="admission_user_name"  placeholder="Username" value='<c:out value="${userModel.getAdmissionUserFname()}"/>'>
					<label for="admission_user_name" id="admission_user_name-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Father's Name</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserFatherName" id="admission_user_father_name" value='<c:out value="${userModel.getAdmissionUserFatherName()}"/>' placeholder="Father's name">
					<label for="admission_user_father_name" id="admission_user_father_name-error" class="text-danger"></label>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Mother's Name</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserMotherName" id="admission_user_mother_name" value='<c:out value="${userModel.getAdmissionUserMotherName()}"/>' placeholder="Mother's name">
					<label for="admission_user_mother_name" id="admission_user_mother_name-error" class="text-danger"></label>
				</div>
			</div>			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Permanent Address</label>
				<div class="col-lg-11">
					<textarea class="form-control" name="admissionUserPermanentAddress" id="admission_user_p_address" placeholder="Permanent Address"><c:catch var="exception">${userModel.getAdmissionUserPermanentAddress()}</c:catch><c:if test="${not empty exception}"></c:if></textarea>
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
					<textarea class="form-control" name="admissionUserCurrentAddress" id="admission_user_c_address" placeholder="Current Address" ><c:catch var="exception">${userModel.getAdmissionUserCurrentAddress()}</c:catch><c:if test="${not empty exception}"></c:if></textarea>
					<label for="admission_user_c_address" id="admission_user_c_address-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Landline</label>
				<div class="col-lg-11">
					<div class="input-group">
						<input type="tel" class="form-control" id="admission_user_landline" name="admissionUserLandlineNumber" value='<c:catch var="exception">${userModel.getAdmissionUserLandlineNumber()}</c:catch><c:if test="${not empty exception}"></c:if>'> 
						<label for "admission_user_landline" id="admission_user_landline-error" class="text-danger"></label>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Mobile</label>
				<div class="col-lg-11">
					<div class="input-group">
						<span class="input-group-addon">+91</span><input type="tel" class="form-control" id="admission_user_mobile" name="admissionUserMobileNumber" value='<c:catch var="exception">${userModel.getAdmissionUserMobileNumber()}</c:catch><c:if test="${not empty exception}"></c:if>'> 
					<label for "admission_user_mobile" id="admission_user_mobile-error" class="text-danger"></label>
					</div>
																		
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Email</label>
			<div class="col-lg-11">
					<input type="email" class="form-control" name="admissionEmail" id="email" value='<c:out value="${userModel.getAdmissionUserEmail()}"/>' placeholder="Email">
					<label for="email" id="email-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Date of Birth</label>
			<div class="col-lg-11">
					<input type="date" class="form-control" name="admissionUserDateOfBirth" value='<c:catch var="exception">${userModel.getAdmissionUserDateOfBirth()}</c:catch><c:if test="${not empty exception}"></c:if>' id="date">
					<label for="date" id="date-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Place of Birth</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserPlaceOfBirth" id="place_of_birth" value='<c:catch var="exception">${userModel.getAdmissionUserPlaceOfBirth()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Place of Birth">
					<label for="place_of_birth" id="place_of_birth-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Gender</label>
				<div class="col-lg-11">
					<select name="admissionUserGender" id="gender" class="form-control">
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
					<select name="admissionUserDomicile" id="domicile" class="form-control">
						<option value="">---Domicile---</option>
						<option value="Yes">Yes</option>
						<option value="No">No</option>
					</select>
					<label for="domicile" id="domicile-error" class="text-danger"></label>
				</div>
			</div>
			
			
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">State</label>
			<div class="col-lg-11">
					<!--input type="text" class="form-control" name="admissionUserState" id="state" value='<c:catch var="exception">${userModel.admissionUserState}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="State"-->
					<select name="admissionUserState" id="state" class="form-control">
                                        <option value="Choose One...">Select Your State...</option>
                                        <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
                                        <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                                        <option value="Assam">Assam</option>
                                        <option value="Bihar">Bihar</option>
                                        <option value="Chandigarh">Chandigarh</option>
                                        <option value="Chhattisgarh">Chhattisgarh</option>
                                        <option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
                                        <option value="Daman and Diu">Daman and Diu</option>
                                        <option value="Delhi">Delhi</option>
                                        <option value="Goa">Goa</option>
                                        <option value="Gujarat">Gujarat</option>
                                        <option value="Haryana">Haryana</option>
                                        <option value="Himachal Pradesh">Himachal Pradesh</option>
                                        <option value="Jammu and Kashmir">Jammu and Kashmir</option>
                                        <option value="Jharkhand">Jharkhand</option>
                                        <option value="Karnataka">Karnataka</option>
                                        <option value="Kerala">Kerala</option>
                                        <option value="Lakshadweep">Lakshadweep</option>
                                        <option value="Madhya Pradesh">Madhya Pradesh</option>
                                        <option value="Maharashtra">Maharashtra</option>
                                        <option value="Manipur">Manipur</option>
                                        <option value="Meghalaya">Meghalaya</option>
                                        <option value="Mizoram">Mizoram</option>
                                        <option value="Nagaland">Nagaland</option>
                                        <option value="Orissa">Orissa</option>
                                        <option value="Puducherry">Puducherry</option>
                                        <option value="Punjab">Punjab</option>
                                        <option value="Rajasthan">Rajasthan</option>
                                        <option value="Sikkim">Sikkim</option>
                                        <option value="Tamil Nadu">Tamil Nadu</option>
                                        <option value="Telengana">Telengana</option>
                                        <option value="Tripura">Tripura</option>
                                        <option value="Uttar Pradesh">Uttar Pradesh</option>
                                        <option value="Uttarakhand">Uttarakhand</option>
                                        <option value="West Bengal">West Bengal</option>
                                    </select>
					<label for="state" id="state-error" class="text-danger"></label>
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Nationality</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserNationality" id="nationality" value='<c:catch var="exception">${userModel.getAdmissionUserNationality()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Nationality">
					<label for "nationality" id="nationality-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Religion</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserReligion" id="religion" value='<c:catch var="exception">${userModel.getAdmissionUserReligion()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Religion">
					<label for ="religion" id="religion-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Mother Tongue</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserMotherTongue" id="mothertongue" value='<c:catch var="exception">${userModel.getAdmissionUserMotherTongue()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Mother Tongue">
					<label for ="mothertongue" id="mothertongue-error" class="text-danger"></label>
				</div>
			</div>
			
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Caste</label>
				<div class="col-lg-11">
					<select name="admissionUserCaste" id="caste" class="form-control">
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
					<select name="admissionUserPhyHandicapped" id="handicap" class="form-control">
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
					<select name="admissionUserEcoBackward" id="econ_backward" class="form-control">
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
					<select name="admissionUserBloodGroup" id="blood_group" class="form-control">
						<option>A</option>
						<option>B</option>
						<option>AB</option>
						<option>O</option>
					</select>
					
					<select name="admissionUserRh" id="rh" class="form-control">
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
		<div class="form-group">	
		<input type="submit" value="Next" class="buttonNext"/> 			
		</div>
	</form>	
</div>

	</body>	
</html>		