<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.css.map"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.css.map"/>' rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="shortcut icon" href='<c:url value="resources/gstian/dashboard/images/favicon.png"/>'>
	<!-- <style>
	.control-label{
	padding-left:30%;
	padding-top:4px;
	
	}
	.form-group{
	margin-top:10%;
	margin-right:20%;
	}
	
.btn{
margin-top:2%;
margin-left:52%;
}
	</style> -->
</head>
<body>

<div style="height:40px;width:400px;margin-left:15%;margin-top:5%;">

<form  action="studentdata" method="post" >

<label class="control-label col-sm-6" for="inputGroupSuccess1">Select Semester</label>
<!-- <div class="col-sm-6"> -->
<select class="form-control" name="semester" id="inputGroupSuccess1">
<option value="3">Semester-3</option>
<option value="4">Semester-4</option>
<option value="5">Semester-5</option>
<option value="6">Semester-6</option>
</select>

<br>

<label class="control-label col-sm-6" for="inputGroupSuccess2">Select Branch</label>
<!-- <div class="col-sm-6"> -->
<select class="form-control" name="branch" id="inputGroupSuccess2">
<option value="1">Computer Engineering</option>
<option value="2">Electronics & Telecommunication</option>
<option value="3">Information Technology</option>
<option value="4">Printing & Packaging</option>
<option value="5">Biotechnology</option>
<option value="6">Mechnical Engnineering</option>
</select>

<br>
<input class="btn btn-warning" type=submit value=Submit>

</form>
</div>


</body>
</html>