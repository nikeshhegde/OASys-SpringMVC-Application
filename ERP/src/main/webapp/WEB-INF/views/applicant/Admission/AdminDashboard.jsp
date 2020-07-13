<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Admin Dashboard</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Loading Bootstrap -->
	<link href="resources/applicant/dashboard/css/bootstrap.css" rel="stylesheet">

	<!-- Loading Stylesheets -->    
	<link href="resources/applicant/dashboard/css/style.css" rel="stylesheet">
	<link href="resources/applicant/dashboard/css/responsive.css" rel="stylesheet">
	<link href="resources/applicant/dashboard/css/prettify.css" rel="stylesheet">

	<!-- Loading Custom Stylesheets -->    
	<link href="resources/applicant/dashboard/css/custom.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/applicant/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>

	<link rel="shortcut icon" href="images/favicon.ico">

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<![endif]-->
	
	<script>
</script>
</head>
<body>
	<div class="frame">
		<!-- /Sidebar -->
		<div class="sidebar">
			<div class="wrapper">
				<a href="index.html" class="logo"><img src="resources/applicant/dashboard/images/logo.png" alt="Archon Admin" /></a>
				<ul class="nav  nav-list">
					<!-- sidebar input search box -->
					<li class="nav-search">
						<!--div class="form-group">
							<input type="text" class="form-control nav-search" placeholder="Search through site" />
							<span class="input-icon fui-search"></span>
						</div-->
					</li>

					<!-- Sidebar header @add class nav-header for sidebar header -->
					<!--li class="nav-header">Overview</li-->
					<li><a href="#"><i class="fa fa-dashboard"></i>Dashboard </a></li>
					<li><a href="#"><i class="fa fa-book"></i>Prospectus</a></li>
					<li class="active"><a href="#"><i class="fa fa-suitcase"></i>Admission Form</a></li>
					<li><a href="app"><i class="fa fa-print"></i>Print Application</a></li>					
					<li><a href="#"><i class="fa fa-key"></i>Change Password</a></li>				
				</ul>	
			</div>
		</div>
		<!-- Main content starts here-->
		
		<div class="content">
			<div class="navbar">
				<a href="#" onclick="return false;" class="btn pull-left toggle-sidebar"><i class="fa fa-list"></i></a>
				<a class="navbar-brand" href="index.html">Archon</a>

				<!-- Top right user menu -->
				
					
			</div><!-- / Navbar-->

			<div id="main-content">
				<!--div class="row">
					<div class="col-mod-12">
						<ul class="breadcrumb">
							<li><a href="index.html">Archon Admin</a></li>
							<li><a href="#">Home</a></li>
							<li class="active">Bread Crumb</li>
						</ul>
					</div>
				</div-->

				<h3 class="page-header">Dashboard</h3>
				
				<iframe src="adminChangeUserStatus" style="position:relative; width:100%;height:50%;" frameborder="0"></iframe>			
			</div>
			<!--div class="panel-footer">
				Installed apps : <span class="text-info">30</span> <a href="#" class="pull-right">Explore All</a>
			</div-->
		</div>
	<!-- / Installed Plugins -->

				<!-- Real time Graph -->
				<!--div class="row  visible-lg">
					<div class="col-md-12">
						<div class="panel panel-archon">
							<div class="panel-heading">
								<h3 class="panel-title">
									Real Time Visitors
									<span class="pull-right">
										<a  href="#" class="panel-minimize"><i class="fa fa-chevron-up"></i></a>
										<a  href="#"  class="panel-settings"><i class="fa fa-cog"></i></a>
										<a  href="#"  class="panel-close"><i class="fa fa-times"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<div id="placeholder" class="realtime graph"></div>
							</div>
							<div class="panel-footer">
								<p>Time between updates: <input id="updateInterval" type="text" value="" > milliseconds</p>
							</div>
						</div>
					</div>
				</div-->

				<!-- Modal -->
				<!--div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h5 class="modal-title">Panel Settings</h5>
								<span class="small">Some sort of settings with a form</span>
							</div>
							<div class="modal-body">
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label for="inputEmail1" class="col-lg-2 control-label">Label</label>
										<div class="col-lg-10">
											<input type="email" class="form-control" id="inputEmail1" placeholder="Label">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword1" class="col-lg-2 control-label">Second Label</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="inputPassword1" placeholder="Label two">
										</div>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save changes</button>
							</div>
						</div--><!-- /.modal-content -->
					<!--/div--><!-- /.modal-dialog -->
				<!--/div--><!-- /.modal -->

			<!--/div--><!-- /Main Content  @7 -->

		<!--/div--><!-- / Content @5 -->

		<!--div class="row footer">
			<div class="col-md-12 text-center">
				© 2013 <a href="http://www.siesgst.net/">SIES Graduate School Of Technology</a>
			</div>
		</div-->
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
	<!--script src="js/map-icons.js"></script-->

	<!-- Archon JS =============================-->
	<!--script src="js/archon.js"></script>
	<script src="js/knobs-custom.js"></script>
	<script src="js/sparkline-custom.js"></script>
	<script src="js/dashboard-custom.js"></script-->
</body>
</html>
