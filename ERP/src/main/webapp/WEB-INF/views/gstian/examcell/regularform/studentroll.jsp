<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="resources/gstian/bootstrap/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="resources/gstian/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/webjars/bootstrap/js/bootstrap.js" />"></script>
<script src="<c:url value="/webjars/bootstrap/js/bootstrap.min.js" />"></script>
<title>Student RollNumber</title>
<link href='<c:url value="resources/gstian/dashboard/css/bootstrap.css"/>' rel="stylesheet">

	<!-- Loading Stylesheets -->    
	<link href='<c:url value="resources/gstian/dashboard/css/style.css"/>' rel="stylesheet">
	<!--<link href='<c:url value="resources/gstian/dashboard/css/responsive.css"/>' rel="stylesheet">-->
	<link href='<c:url value="resources/gstian/dashboard/css/prettify.css"/>' rel="stylesheet">

	<!-- Loading Custom Stylesheets -->    
	<link href='<c:url value="resources/gstian/dashboard/css/custom.css"/>' rel="stylesheet">

	<link rel="shortcut icon" href='<c:url value="resources/gstian/dashboard/images/favicon.ico"/>'>
</head>
<body>

<form:form class="form-inline" id="regularForm" commandName="studentRollNumber" method="post" action="regularform">

		
          <div class="form-group" >
              <label for="rollNumber">Roll Number</label>
              <form:input path="rollNumber" placeholder="Enter RollNumber"  class="form-control"/>
              
               <button class="btn btn-default" type="submit" value="submit">Submit</button>
          </div>
          
         

</form:form>          
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>