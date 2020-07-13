<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Dashboard for FE</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Loading Bootstrap -->
	<link href="resources/applicant/dashboard/css/bootstrap.css" rel="stylesheet">

	<!-- Loading Stylesheets -->    
	<link href="resources/applicant/dashboard/css/style.css" rel="stylesheet">
	<link href="resources/applicant/dashboard/css/responsive.css" rel="stylesheet">
	<link href="resources/applicant/dashboard/css/prettify.css" rel="stylesheet">

	<!-- Loading Custom Stylesheets -->    
	<link href="resources/applicant/dashboard/css/custom.css" rel="stylesheet">

	<link rel="shortcut icon" href="images/favicon.ico">

</head>
<body>
	<div class="frame">
		<!-- /Sidebar -->
		<!-- Main content starts here-->
		<div class="content">
			<div id="main-content">
			<c:forEach var="listValue" items="${loggedinuserdetails}">
					<h2>Welcome, ${listValue.getAdmissionUserFname()}</h2>
				</c:forEach>
				<h3 class="page-header">Dashboard</h3>
		

				<!-- Graph -->
				<div class="row">
					<div class="col-md-3">
						<div class="web-stats info">
							<div class="pull-left">
								<h5><a href="applicants-admin?type=fe">Applicants</a></h5>
								<!--span class="description">Month Sales</span-->
							</div>
							<!--span class=" pull-right   mini-graph info"></span-->
						</div>
					</div>
					<div class="col-md-3">
						<div class="web-stats warning">
							<div class="pull-left">
								<h5><a href="">Generate Merit List</a></h5>
								<!--span class="description">Page Views</span-->
							</div>
							<!--span class=" pull-right  mini-graph pie"></span-->
						</div>
					</div>
					<div class="col-md-3">
						<div class="web-stats danger">
							<div class="pull-left">
								<h5>View Merit List</h5>
								<!--span class="description">Returns</span-->
							</div>
							<!--span class=" pull-right  mini-graph danger"></span-->
						</div>
					</div>
				</div>
					<div class="row">
					<div class="col-md-3">
						<div class="web-stats success">
							<div class="pull-left">
								<h5>Fee Payment</h5>
								<!--span class="description">Unique Views</span-->
							</div>
							<!--span class="pull-right  mini-graph success"></span-->
						</div>
					</div>
					<div class="col-md-3">
						<div class="web-stats info">
							<div class="pull-left">
								<h5>Allot Seats</h5>
								<!--span class="description">Month Sales</span-->
							</div>
							<!--span class=" pull-right   mini-graph info"></span-->
						</div>
					</div>
					<div class="col-md-3">
						<div class="web-stats warning">
							<div class="pull-left">
								<h5>Admitted Student</h5>
								<!--span class="description">Page Views</span-->
							</div>
							<!--span class=" pull-right  mini-graph pie"></span-->
						</div>
					</div>
				</div>

				
		
	</div> <!-- Frame -->


	<!-- Load JS here for greater good =============================-->
	<!--script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="js/jquery.ui.touch-punch.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/bootstrap-switch.js"></script>
	<script src="js/jquery.tagsinput.js"></script>
	<script src="js/jquery.placeholder.js"></script>
	<script src="js/bootstrap-typeahead.js"></script>
	<script src="js/application.js"></script>
	<script src="js/moment.min.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/jquery.sortable.js"></script>
	<script type="text/javascript" src="js/jquery.gritter.js"></script-->

	<!-- Charts  =============================-->
	<!--script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.resize.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.pie.min.js"></script>	
	<script src="js/jquery.sparkline.min.js"></script>	
	<script src="js/jquery.knob.js"></script-->


	<!-- NVD3 graphs  =============================-->
	<!--script src="js/d3.v3.js"></script>
	<script src="js/nv.d3.js"></script>
	<script src="js/legend.js"></script>
	<script src="js/pie.js"></script>
	<script src="js/pieChart.js"></script>
	<script src="js/utils.js"></script-->
	<!--script src="js/sample.nvd3.js"></script-->

	<!-- Map and icons on map-->
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
	<!--script src="js/map-icons.js"></script-->

	<!-- Archon JS =============================-->
	<!--script src="js/archon.js"></script>
	<script src="js/knobs-custom.js"></script>
	<script src="js/sparkline-custom.js"></script>
	<script src="js/dashboard-custom.js"></script-->
</body>
</html>
