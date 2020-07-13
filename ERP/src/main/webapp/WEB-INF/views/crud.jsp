<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smart Wizard 3 - Basic Example  - a javascript jQuery wizard control plugin</title>
<!--link href="form-wizard/css/demo_style.css" rel="stylesheet" type="text/css"-->

	<link href="/start/resources/mytheme/dashboard/css/bootstrap.css" rel="stylesheet">

	<link href="/start/resources/mytheme/dashboard/css/dataTables.css" rel="stylesheet">
	<!-- Loading Stylesheets -->    
	
	<link href="/start/resources/mytheme/dashboard/css/responsive.css" rel="stylesheet">
	<link href="/start/resources/mytheme/dashboard/css/archon.css" rel="stylesheet">
	<link href="/start/resources/mytheme/dashboard/css/prettify.css" rel="stylesheet">
	<link href="/start/resources/mytheme/dashboard/css/style.css" rel="stylesheet">
	<!-- Loading Custom Stylesheets -->    
	<link href="/start/resources/mytheme/dashboard/css/custom.css" rel="stylesheet">
	
	<script type="text/javascript" src="/start/resources/mytheme/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>

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
	<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<table id="myTable" class="table">
						<thead>
						<tr>
						<c:forEach items="${Attribute}" var="attr">
							<th>${attr}</th>
						</c:forEach>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${result}" var="row">
				    		<tr>
				      			<c:forEach items="${row}" var="cell">
				        			<td>${cell}</td>
				      			</c:forEach>
				    		</tr>
				  		</c:forEach>
				  		</tbody>
				  	</table>
			 	</div>
	</div>		
	<div class="row">
		<div class="col-sm-5 col-sm-offset-1">
		<h4 class="text-danger">Column names are in alphabetic order</h4>
		</div>
	</div> 		
</div>	
</body>	
</html>		