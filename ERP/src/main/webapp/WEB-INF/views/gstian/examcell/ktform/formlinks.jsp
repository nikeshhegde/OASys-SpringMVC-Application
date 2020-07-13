<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.css.map"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.css.map"/>' rel="stylesheet">
<link rel="shortcut icon" href='<c:url value="resources/gstian/dashboard/images/favicon.ico"/>'>
</head>
<body style="margin-left:25%;margin-top:5%;">

<c:if test="${not empty NoKtsLeft}">
No KTs to register.
</c:if>
<br/>


<c:if test="${empty theoryListEmpty}">
Click <a href='<c:url value="/ktform/form/0" />'>HERE</a> to enter the theory KT form
</c:if>

<br/>
<br/>

<c:if test="${empty practicalListEmpty}">
Click <a href='<c:url value="/ktform/form/1" />'>HERE</a> to enter the practical/oral KT form
</c:if>

<br/>
<br/>

<c:if test="${empty oralListEmpty}">
Click <a href='<c:url value="/ktform/form/2" />'>HERE</a> to enter the oral KT form
</c:if>


<c:if test="${empty internalListEmpty}">
Click <a href='<c:url value="/ktform/form/3" />'>HERE</a> to enter the internal KT form
</c:if>


</body>
</html>