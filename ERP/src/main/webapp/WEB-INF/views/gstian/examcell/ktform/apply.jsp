<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KT apply</title>
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.css.map"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.css.map"/>' rel="stylesheet">
	<link rel="shortcut icon" href='<c:url value="resources/gstian/dashboard/images/favicon.ico"/>'>
</head>
<body  >
<h1>Select KT subjects</h1>
<div style="text-align:center;margin-left:35%;">
<form:form  modelAttribute="ktubjectList" class="form-group"  method="POST" action="ProcessRequest">
<ul >
<li><form:checkboxes items="${subjects}" itemLabel="${subjects}" itemValue="${subjects}" path="listOfKtSubject"/><br></li>
</ul>
<br><br><input class="btn btn-warning"  type="button" value="Submit"> 
</form:form>
</div>
</body>
</html>