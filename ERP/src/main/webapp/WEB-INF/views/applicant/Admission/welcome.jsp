<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Welcome Page</title>

<style>		

			.button_example{
border:3px solid #25729a; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #3093c7; background-image: -webkit-gradient(linear, left top, left bottom, from(#3093c7), to(#1c5a85));
 background-image: -webkit-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -moz-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -ms-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -o-linear-gradient(top, #3093c7, #1c5a85);
 background-image: linear-gradient(to bottom, #3093c7, #1c5a85);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#3093c7, endColorstr=#1c5a85);
 margin-top:20px;
}

.button_example:hover{
 border:3px solid #1c5675;
 background-color: #26759e; background-image: -webkit-gradient(linear, left top, left bottom, from(#26759e), to(#133d5b));
 background-image: -webkit-linear-gradient(top, #26759e, #133d5b);
 background-image: -moz-linear-gradient(top, #26759e, #133d5b);
 background-image: -ms-linear-gradient(top, #26759e, #133d5b);
 background-image: -o-linear-gradient(top, #26759e, #133d5b);
 background-image: linear-gradient(to bottom, #26759e, #133d5b);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#26759e, endColorstr=#133d5b);
}

.table-striped > tbody > tr:nth-child(odd) > td,
.table-striped > tbody > tr:nth-child(odd) > th {
  background-color: #f9f9f9;
}
.inline
{
display:inline-block;
}
</style><link href="<c:url value="/resources/applicant/welcome/css/reg_css.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/applicant/welcome/css/style.css" />" rel="stylesheet">
        <script src="/resources/gstian/js/jquery-1.10.2.js"></script>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="/resources/gstian/bootstrap/css/bootstrap.min.css" />
		<script src="/resources/gstian/bootstrap/js/bootstrap.min.js"></script>
<center>
<head>Welcome to SIES-GST OASys - Online Admission System</head></center>
<body>
<center>
<form action="gateWay" method="POST">
<table>
	<tr>
		<td colspan="3" align="center">
			<img class="img1" src="/resources/applicant/login/image/logo2.png" />
		</td>
	</tr>
</table>	
		<div class="col-md-4 col-md-offset-4">
			<input type="radio" name="newUser" value="AdmissionSeeker" class="form-control inline"/><label class="inline">New Applicant</label>


			<input type="radio" name="newUser" value="ExistingStudent" class="form-control inline"/><label class="inline">Existing Applicant</label>

		<br/>
			<input type="submit" value="Proceed" class="button_example">
		</div>
</form>
</center>
</body>
</html>