<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Applicants - Admin</title>
<!--link href="form-wizard/css/demo_style.css" rel="stylesheet" type="text/css"-->

	<link href="/resources/applicant/Dashboard/css/bootstrap.css" rel="stylesheet">

	<link href="/resources/applicant/Dashboard/css/dataTables.css" rel="stylesheet">
	<!-- Loading Stylesheets -->    
	
	<link href="/resources/applicant/Dashboard/css/responsive.css" rel="stylesheet">
	<link href="/resources/applicant/Dashboard/css/archon.css" rel="stylesheet">
	<link href="/resources/applicant/Dashboard/css/prettify.css" rel="stylesheet">
	<link href="/resources/applicant/Dashboard/css/style.css" rel="stylesheet">
	<!-- Loading Custom Stylesheets -->    
	<link href="/resources/applicant/Dashboard/css/custom.css" rel="stylesheet">
	
	<script type="text/javascript" src="/resources/applicant/Dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>

	<link rel="shortcut icon" href="images/favicon.ico">
	
	<!--link href="//datatables.net/download/build/nightly/jquery.dataTables.css?_=947222ad3c359bf81b211b75237870e1" rel="stylesheet"-->

	<!--link href="http://cdn.datatables.net/plug-ins/f2c75b7247b/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet"-->
		
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<script src="//datatables.net/download/build/nightly/jquery.dataTables.js?_=c4860a4a5b8636021ae24650f795f55b"></script>
	
	<script src="//cdn.datatables.net/plug-ins/f2c75b7247b/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>

<script>

var d=new Date();

var current=d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();

$(function(){

$("#today_date").text(current);

});

</script>

<style>
td,th
{
text-align:center;
}
</style>

</head>
<body>		
<div>
				
		    <!--jquery refer zillion screenshots
				<label for="" class="col-lg-3 control-label">Student Merit List for  </label> 
			-->
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<h2>Applicant Information</h2>
				</div>
			</div>
			<form action="applicants-admin-action" method="post">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
								<table class="table">
									<thead>
										<tr>
											<th>Sr. No</th>
											<th>Applicant ID</th>
											<th>Name of the Applicant</th>
											<th>Status</th>
											<th>Change Status</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="student" items="${students}">
									<tr>
										<td>${student.getId()}</td>
										<td>${student.getId()}</td>										
										<td><a href="payment-info?id=${student.getId()}" title="View Payment Details" target="_blank">${student.getAdmissionUserFname()}</a> </td>
										<c:choose>
											<c:when test="${student.getAdmissionUserStatus()=='Registered' }">
												<td><span class="status status-primary">${student.getAdmissionUserStatus()}</span></td>
											</c:when>
											<c:when test="${student.getAdmissionUserStatus()=='Application Fee Pending' }">
												<td><span class="status status-pending">${student.getAdmissionUserStatus()}</span></td>											
											</c:when>
											<c:when test="${student.getAdmissionUserStatus()=='Application Fee Paid' }">
												<td><span class="status status-warning">${student.getAdmissionUserStatus()}</span></td>											
											</c:when>
											<c:when test="${student.getAdmissionUserStatus()=='Applied' }">
												<td><span class="status status-success">${student.getAdmissionUserStatus()}</span></td>											
											</c:when>
											<c:when test="${student.getAdmissionUserStatus()=='Annual Fee Pending' }">
												<td><span class="status status-pending">${student.getAdmissionUserStatus()}</span></td>											
											</c:when>
											<c:when test="${student.getAdmissionUserStatus()=='Annual Fee Paid' }">
												<td><span class="status status-warning">${student.getAdmissionUserStatus()}</span></td>											
											</c:when>
										</c:choose>
										<td>
										<center>
										<select name="${student.getId()}" class="input-sm">
										<option value="">Change status</option>
										<option value="Registered">Registered</option>
										<option value="Application Fee Pending">Application Fee Pending</option>
										<option value="Application Fee Paid">Application Fee Paid</option>
										<option value="Applied">Applied</option>
										<option value="Annual Fee Pending">Annual Fee Pending</option>
										<option value="Annual Fee Paid">Annual Fee Paid</option>
										</select>
										</center> 
										</td>
									</tr>
									</c:forEach>
									</tbody>
								</table>
					</div>										
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
			<input type="submit" value="Save Changes" class="form-control"/>
				</div>
			</div>	
			</form>  		
</div>		
   <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>		

</body>
</html>
