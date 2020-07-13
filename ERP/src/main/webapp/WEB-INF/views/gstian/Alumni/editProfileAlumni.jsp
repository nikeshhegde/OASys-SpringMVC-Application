<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editing Alumni Profile</title>
<link href="/resources/applicant/dashboard/form-wizard/css/demo_style.css" rel="stylesheet" type="text/css">

<link href="/resources/applicant/dashboard/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resources/applicant/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/resources/applicant/dashboard/form-wizard/js/jquery.smartWizard.js"></script>


<link href="/resources/gstian/dashboard/css/bootstrap.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/css/archon.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/css/responsive.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/login/css/style.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/css/style.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/css/custom.css" rel="stylesheet">

<style>		
			.button_example{
			width:auto;
border:3px solid #25729a; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #3093c7; background-image: -webkit-gradient(linear, left top, left bottom, from(#3093c7), to(#1c5a85));
 background-image: -webkit-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -moz-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -ms-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -o-linear-gradient(top, #3093c7, #1c5a85);
 background-image: linear-gradient(to bottom, #3093c7, #1c5a85);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#3093c7, endColorstr=#1c5a85);
}

.button_example:hover{
width:auto;
 border:3px solid #1c5675;
 background-color: #26759e; background-image: -webkit-gradient(linear, left top, left bottom, from(#26759e), to(#133d5b));
 background-image: -webkit-linear-gradient(top, #26759e, #133d5b);
 background-image: -moz-linear-gradient(top, #26759e, #133d5b);
 background-image: -ms-linear-gradient(top, #26759e, #133d5b);
 background-image: -o-linear-gradient(top, #26759e, #133d5b);
 background-image: linear-gradient(to bottom, #26759e, #133d5b);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#26759e, endColorstr=#133d5b);
}
.button-container {
 margin-top: 15px;
}

</style>

<script>
var component="#branches option";
var db="${alumniModel.getAlumniDepartment()}";
$(document).ready(function(){
	
$(component).each(function()
		{
		   if($(this).val()==db)
			   {
			   $("#branches").val(db);
			   }
		});
});		
	
</script>

</head>
<body>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<h1 align="center">Welcome, ${alumniModel.getAlumniFname()}</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<a href="profile-alumni" class="btn btn-default">Back</a>
		</div>
	</div>
	<form action="edit-profile-action-alumni" method="POST">
	<div class="row">
		<div class="col-md-5 col-md-offset-1">
			<h2>Personal details</h2>
			<table class="table">
				<tr>
					<th>Particular</th>
					<th>Value</th>
				</tr>
				<tr>
					<td>Surname</td>
					<td><input type="text" name="alumniSurname" id="user_sur_name" placeholder="Surname" required oninvalid="setCustomValidity('Please enter your Surname')" oninput="setCustomValidity('')"  class="form-control" value="<c:catch var="exception">${alumniModel.getAlumniSurname()}</c:catch><c:if test="${not empty exception}"></c:if>"/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="alumniFname" id="user_fname" placeholder="First Name" required oninvalid="setCustomValidity('Please enter your First Name')" oninput="setCustomValidity('')"  class="form-control" value="<c:catch var="exception">${alumniModel.getAlumniFname()}</c:catch><c:if test="${not empty exception}"></c:if>"/></td>
				</tr>
				<tr>
					<td>Father's name</td>
					<td><input type="text" name="alumniFatherName" id="user_father_name" placeholder="Father's Name" required oninvalid="setCustomValidity('Please enter your Father's name')" oninput="setCustomValidity('')"  class="form-control" value="<c:catch var="exception">${alumniModel.getAlumniFatherName()}</c:catch><c:if test="${not empty exception}"></c:if>"/></td>
				</tr>	
			</table>
		</div>
		<div class="col-md-5">
			<h2>Academic details</h2>
			<table class="table">
				<tr>
					<th>Particular</th>
					<th>Value</th>
				</tr>
				<tr>
					<td>Department</td>
					<td>
				<select name="alumniDepartment" id="branches"  class="form-control">
					<option value="">Choose Department..</option>
					<option value="CE">Computer Engineering</option>
					<option value="EXTC">Electronics and Telecommunication</option>
					<option value="IT">Information Technology</option>
					<option value="PPT">Printing and Packaging Technology</option>
					<option value="MECH">Mechanical Engineering</option>
					<option value="BT">BioTechnology</option>
				</select>
				</td>
				</tr>
				<tr>
					<td>Year of passing</td>
					<td><input type="text" name="alumniYearOfPassing" id="user_father_name" placeholder="Year of passing" required oninvalid="setCustomValidity('Please enter your Year of passing')" oninput="setCustomValidity('')" class="form-control" value="<c:catch var="exception">${alumniModel.getAlumniYearOfPassing()}</c:catch><c:if test="${not empty exception}"></c:if>"/></td>
				</tr>	
			</table>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-5 col-md-offset-1">
			<h2>Contact details</h2>
			<table class="table">
				<tr>
					<th>Particular</th>
					<th>Value</th>
				</tr>
				<tr>
					<td>Contact number</td>
					<td><input type="text" name="alumniContactNumber" id="user_father_name" placeholder="Mobile Number" required oninvalid="setCustomValidity('Please enter your Mobile number')" oninput="setCustomValidity('')"  class="form-control" value="<c:catch var="exception">${alumniModel.getAlumniContactNumber()}</c:catch><c:if test="${not empty exception}"></c:if>"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="alumniEmail" id="user_email" placeholder="Email"  class="form-control" value="<c:catch var="exception">${alumniModel.getAlumniEmail()}</c:catch><c:if test="${not empty exception}"></c:if>" required /></td>
			</table>
		</div>
		<div class="col-md-5">
			<h2>Career details</h2>
			<table class="table">
				<tr>
					<th>Particular</th>
					<th>Value</th>
				</tr>
				<tr>
					<td>Current Employment</td>
					<td><input type="text" name="alumniCurrentEmployment" id="user_father_name" placeholder="Current Employment"   class="form-control" value="<c:catch var="exception">${alumniModel.getAlumniCurrentEmployment()}</c:catch><c:if test="${not empty exception}"></c:if>"/></td>
				</tr>
				<tr>
					<td>Current Workplace</td>
					<td><input type="text" name="alumniCurrentWorkPlace" id="user_father_name" placeholder="Current Workplace"  class="form-control" value="<c:catch var="exception">${alumniModel.getAlumniCurrentWorkPlace()}</c:catch><c:if test="${not empty exception}"></c:if>"/></td>
				</tr>
				<tr>
					<td>Area of Expertise</td>
					<td><input type="text" name="alumniAreaOfExpertise" id="user_father_name" placeholder="Area of expertise"  class="form-control" value="<c:catch var="exception">${alumniModel.getAlumniAreaOfExpertise()}</c:catch><c:if test="${not empty exception}"></c:if>"/></td>
				</tr>	
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 col-md-offset-1">
			<input type="submit" value="Update" class="form-control" />
		</div> 
	</div>
	</form>
</body>	
</html>		