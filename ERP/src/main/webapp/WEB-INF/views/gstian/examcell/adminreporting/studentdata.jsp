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

	
	<link rel="icon" href='<c:url value="resources/gstian/dashboard/images/favicon.png"/>'>
</head>
<body style="margin:2%">

<c:choose>
<c:when test="${not empty message}">
${message}
</c:when>

<c:when test="${empty message}">
<h3>Applied Students are</h3>
<table class="table table-condensed">
<thead>
<tr>
<th>Sr No</th>
<th>RollNumber</th>
<th>Name</th>
</tr>
</thead>

<tbody>
<c:forEach items="${students}" var="student" varStatus="LoopCounter">
<tr><td><c:out value="${LoopCounter.count}" ></c:out></td>
<td><c:out value="${student.rollnumber}"></c:out></td>
<td><c:out value="${student.studentName}"></c:out></td></tr>
</c:forEach>
</tbody>
</table>

<a href='<c:url value="/adminreporting/acknowledgement" />'><input class="btn btn-warning" type=submit value="Generate Pdf">

</c:when>

</c:choose>


</body>
</html>