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
<body>

<c:choose>

<c:when test="${not empty enable}">


<form:form modelAttribute="listofkts" action="formProcess" method="post" style="margin-left:35%;margin-top:50px; ">
<form:checkboxes  path="Response" items="${list}" itemValue="subjectCode" itemLabel="subject"  delimiter="<br/>" />
<%-- <form:hidden path="type" value="1"/> <!-- Again this would be fetched through modelattribute ie $ kind ofthing and not @ModelAtt.  --> --%>

<br><br><br><form:button type="submit" class="btn btn-primary">Submit Subjects</form:button>

</form:form>

</c:when>

<c:otherwise>
Please click <a href='<c:url value="/ktform/" />' >HERE</a> to enter the form links page
</c:otherwise>

</c:choose>


</body>
</html>