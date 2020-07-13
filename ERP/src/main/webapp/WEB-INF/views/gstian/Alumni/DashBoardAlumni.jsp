<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alumni Dashboard</title>
<!--link href="/start/resources/mytheme/dashboard/form-wizard/css/demo_style.css" rel="stylesheet" type="text/css">

<link href="/start/resources/mytheme/dashboard/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css"-->
<script type="text/javascript" src="/resources/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
<!--script type="text/javascript" src="/start/resources/dashboard/form-wizard/js/jquery.smartWizard.js"></script-->



<link href="/resources/gstian/dashboard/css/archon.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/css/responsive.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/login/css/style.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/css/bootstrap.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/css/style.css" rel="stylesheet">
<link href="/resources/gstian/dashboard/css/custom.css" rel="stylesheet">
<link rel="stylesheet" href="/resources/gstian/bootstrap/css/bootstrap.min.css">
<script src="/resources/gstian/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<h1 align="center">Welcome, ${alumniModel.getAlumniFname()}</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<a href="edit-profile-alumni" class="btn btn-default">Edit profile</a>
		</div>
	</div>
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
					<td>${alumniModel.getAlumniSurname()}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>${alumniModel.getAlumniFname()}</td>
				</tr>
				<tr>
					<td>Father's name</td>
					<td>${alumniModel.getAlumniFatherName()}</td>
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
					<td>${alumniModel.getAlumniDepartment()}</td>
				</tr>
				<tr>
					<td>Year of passing</td>
					<td>${alumniModel.getAlumniYearOfPassing()}</td>
				</tr>
				<tr>
					<td>Father's name</td>
					<td>${alumniModel.getAlumniFatherName()}</td>
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
					<td>${alumniModel.getAlumniContactNumber()}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${alumniModel.getAlumniEmail()}</td>	
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
					<td><c:catch var="exception">${alumniModel.getAlumniCurrentEmployment()}</c:catch><c:if test="${not empty exception}"></c:if></td>
				</tr>
				<tr>
					<td>Current Workplace</td>
					<td><c:catch var="exception">${alumniModel.getAlumniCurrentWorkPlace()}</c:catch><c:if test="${not empty exception}"></c:if></td>
				</tr>
				<tr>
					<td>Area of Expertise</td>
					<td><c:catch var="exception">${alumniModel.getAlumniAreaOfExpertise()}</c:catch><c:if test="${not empty exception}"></c:if></td>
				</tr>	
			</table>
		</div>
	</div>
	
	
	
</body>	
</html>		