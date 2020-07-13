<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="resources/mytheme/gstian/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="resources/mytheme/gstian/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="resources/mytheme/gstian/js/bootstrap.js" />"></script>
<script src="<c:url value="resources/mytheme/gstian/js/bootstrap.min.js" />"></script>
<style>
.jumbotron{
width: 740px;
height: 400px;
margin-left: 287px;
margin-top: 22px;
border-radius: 22px;
background-color: #F9F9F9;
}
</style>
<title>Validate Your Details</title>
<link href='<c:url value="resources/mytheme/gstian/ashboard/css/bootstrap.css"/>' rel="stylesheet">

	<!-- Loading Stylesheets -->    
	<link href='<c:url value="resources/gstian/dashboard/css/style.css"/>' rel="stylesheet">
	<!--<link href='<c:url value="resources/gstian/dashboard/css/responsive.css"/>' rel="stylesheet">-->
	<link href='<c:url value="resources/gstian/dashboard/css/prettify.css"/>' rel="stylesheet">

	<!-- Loading Custom Stylesheets -->    
	<link href='<c:url value="resources/gstian/dashboard/css/custom.css"/>' rel="stylesheet">

	<link rel="shortcut icon" href='<c:url value="resources/gstian/dashboard/images/favicon.ico"/>'>
</head>
<body>

<div class="jumbotron" style="width:800px; height: 400px; float:center">
        

<%-- <form class="form-horizontal"  method="post" action="verified" > --%>
	
<div class="form-group">
	<label for="rollNumber" class="col-sm-2 control-label">Roll Number</label>
	<div class="col-sm-4">
		<input type="text" class="form-control" value="${studentDetails.rollnumber}" readonly  />
	</div>
</div>

<div class="form-group">
	<label for="Name" class="col-sm-2 control-label">Name</label>
	<div class="col-sm-4">
		<input type="text" class="form-control" value="${studentDetails.studentName}" readonly />
	</div>
</div>


<div class="form-group">
	<label for="branch" class="col-sm-2 control-label">Branch</label>
	<div class="col-sm-4">
		<input type="text" class="form-control" value="${studentDetails.branch}" readonly  />
	</div>
</div>

<div class="form-group">
	<label for="semester" class="col-sm-2 control-label">Semester</label>
	<div class="col-sm-4">
		<input type="text" class="form-control" value="${studentDetails.semester}"  readonly />
	</div>
</div>
              
       <div class="form-group">
	<div class="col-sm-offset-2 col-sm-4">
               <a href= '<c:url value="/regularform/verified" />'><button class="btn btn-primary btn-lg">Validate</button></a>
          </div>
     </div>     
         

<%-- </form>           --%>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>


