<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

</head>
<body>
	<h4>Welcome </h4>
	<br />

<c:if test="${not empty ktapp}">
${ktapp}
</c:if>
<H4 style="margin-left:10%;">
Instructions<br><br><br>
1. Click on the tab "KT Form" Tab. <br>
2. Choose the type of KT you want to apply for (As many as you want).<br>
3. Submit the Subjects.<br>
4. Click on the tab "KT Form Receipt" Tab. <br>
5. Save the receipt as ".pdf".<br>
</H4> 
</body>
</html>