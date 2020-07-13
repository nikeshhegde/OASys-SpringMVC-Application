<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Admin Applicant Page</title>
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
      
      </style>
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<![endif]-->
</head>
<body>
	<div class="frame">
		<!-- /Sidebar -->
		<!-- Main content starts here-->
		<div class="content">
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
				<c:forEach var="listValue" items="${loggedinuserdetails}">
					<h2>Welcome, ${listValue.getAdmissionUserFname()}</h2>
				</c:forEach>
				<h3 class="page-header">Dashboard</h3>
				<!--div class="row">
					<div class="col-mod-12">
						<div class="alert alert-dismissable alert-success alert-dashboard fade in">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
							<strong>Hellooo!</strong> Its good to see you. Please check all the features.If you feel something is missing you name it, I will add it in next release
						</div>
					</div>
				</div-->

				<!-- Graph -->
				<div class="row">
					
					<div class="col-md-3">
						<div class="web-stats warning">
							<div class="pull-left">
								<!-- h5><a href="applicants-admin?type=fe">First Year</a></h5>
								<!--span class="description">Page Views</span-->
								<form action="roll-number" method="GET">
								<input type="hidden" value="FirstYearEngineering" name="Admission">
								<input type="submit" class="button_example" value="First Year">
								</form>
							</div>
							<!--span class=" pull-right  mini-graph pie"></span-->
						</div>
					</div>
					<div class="col-md-3">
						<div class="web-stats danger">
							<div class="pull-left">
								<!--  h5><a href="applicants-admin?type=dse">Direct Second Year</a></h5>
								<!--span class="description">Returns</span-->
								<form action="roll-number" method="GET">
								<input type="hidden" value="Diploma" name="Admission">
								<input type="submit" class="button_example" value="Direct Second Year">
								</form>
							</div>
							<!--span class=" pull-right  mini-graph danger"></span-->
						</div>
					</div>
					<div class="col-md-3">
						<div class="web-stats success">
							<div class="pull-left">
								<!-- h5><a href="#">Higher Semesters</a></h5>
								<!--span class="description">Unique Views</span-->
							</div>
							<!--span class="pull-right  mini-graph success"></span-->
						</div>
					</div>
			</div>						

				<!-- Most visited and Traffic sources Graph -->
				<!--div class="row">
					<div class="col-md-12">
						<div class="panel panel-archon main-graph">
							<div class="panel-heading">
								<h3 class="panel-title">Line and Bar Graphs
									<span class="pull-right">
										<a  href="#" class="panel-minimize"><i class="fa fa-chevron-up"></i></a>
										<a  href="#"  class="panel-settings"><i class="fa fa-cog"></i></a>
										<a  href="#"  class="panel-close"><i class="fa fa-times"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<div id="chart1" class='with-3d-shadow with-transitions'>
									<svg> </svg>
								</div>
							</div>
						</div>
					</div>
				</div-->

				<!-- Knobs -->
				<!--div class="row">
					<div class="col-md-2 col-sm-4">
						<div class="panel panel-knob">
							<div class="panel-heading">
								<h3 class="panel-title">CPU Usage
									<span class="pull-right">
										<a  href="#" class="panel-refresh"><i class="fa fa-refresh"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<input class="knob" data-width="150" data-fgColor="#222222" data-thickness=.3 value="47">
							</div>
							<div class="panel-footer">
								some description can be here
							</div>
						</div>
					</div>
					<div class="col-md-2 col-sm-4">
						<div class="panel panel-knob">
							<div class="panel-heading">
								<h3 class="panel-title">Memory Used
									<span class="pull-right">
										<a  href="#" class="panel-refresh"><i class="fa fa-refresh"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<input class="knob" data-width="150" data-fgColor="#222222" data-thickness=.3 value="86">
							</div>
							<div class="panel-footer">
								some description can be here
							</div>
						</div>
					</div>
					<div class="col-md-2 col-sm-4">
						<div class="panel panel-knob">
							<div class="panel-heading">
								<h3 class="panel-title">Server Load
									<span class="pull-right">
										<a  href="#" class="panel-refresh"><i class="fa fa-refresh"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<input class="knob" data-width="150" data-fgColor="#222222" data-thickness=.3 value="36">
							</div>
							<div class="panel-footer">
								some description can be here
							</div>
						</div>
					</div>
					<div class="col-md-2 col-sm-4">
						<div class="panel panel-knob">
							<div class="panel-heading">
								<h3 class="panel-title">Active Users
									<span class="pull-right">
										<a  href="#" class="panel-refresh"><i class="fa fa-refresh"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<input class="knob" data-width="150" data-fgColor="#222222" data-thickness=.3 value="98">
							</div>
							<div class="panel-footer">
								some description can be here
							</div>
						</div>
					</div>
					<div class="col-md-2 col-sm-4">
						<div class="panel panel-knob">
							<div class="panel-heading">
								<h3 class="panel-title">Real Time
								</h3>
							</div>
							<div class="panel-body">
								<input class="knob realtime" data-width="150" data-fgColor="#222222" data-thickness=.3 value="17">
							</div>
							<div class="panel-footer realtime-footer">
								some description can be here
							</div>
						</div>
					</div>
					<div class="col-md-2 col-sm-4">
						<div class="panel panel-knob">
							<div class="panel-heading">
								<h3 class="panel-title">Direct
									<span class="pull-right">
										<a  href="#" class="panel-refresh"><i class="fa fa-refresh"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<input class="knob" data-width="150" data-fgColor="#222222" data-thickness=.3 value="66">
							</div>
							<div class="panel-footer">
								some description can be here
							</div>
						</div>
					</div>
				</div-->	<!-- / knobs -->


				<!-- Summary widget -->
				<!--div class="row">
					<div class="col-md-3">
						<div class="panel panel-summary">
							<div class="panel-heading">
								<h3 class="panel-title">Account Summary
									<span class="pull-right">
										<a  href="#"  class="panel-settings"><i class="fa fa-cog"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<div class="up pull-left">
									86% <i class="fa fa-caret-up text-primary"></i>
								</div>
								<div class="down pull-rgiht">
									23% <i class="fa fa-caret-down text-danger"></i>
								</div>
								<div class="clearfix"></div>
								<div class="statistics">
									<div class="small">Your account balance</div>
									<div class="available">$48,743</div>
									<a href="#" class="report">View Complete report</a>
								</div-->
								<!--div class="category-summary panel-group" id="accordion"-->
									<!-- First panel -->
									<!--div class="panel panel-default">
										<div class="panel-heading">
											<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
												<h4 class="panel-title">
													This Week
													<span class="label label-inverse pull-right text-warning">$1200</span>
												</h4>
											</a>
										</div>
										<div id="collapseOne" class="panel-collapse collapse in">
											<div class="panel-body">
												<ul class="list-unstyled">
													<li class="clearfix">
														<p class="pull-left">Income</p>
														<span class="pull-right">$5600</span>
													</li>
													<li class="clearfix">
														<p class="pull-left">Salaries</p>
														<span class="pull-right">$2000</span>
													</li>
													<li class="clearfix">
														<p class="pull-left">Expenditure</p>
														<span class="pull-right ">$3000</span>
													</li>
													<li class="clearfix">
														<p class="pull-left">Extra income</p>
														<span class="pull-right ">$600</span>
													</li>
												</ul>
											</div>
										</div>
									</div--><!-- /First panel -->

									<!-- Second panel -->
									<!--div class="panel panel-default">
										<div class="panel-heading">
											<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
												<h4 class="panel-title">
													This Month
													<span class="label label-inverse pull-right text-warning">$3400</span>
												</h4>
											</a>
										</div>
										<div id="collapseTwo" class="panel-collapse collapse">
											<div class="panel-body">
												<ul class="list-unstyled">
													<li class="clearfix">
														<p class="pull-left">Income</p>
														<span class="pull-right">$5600</span>
													</li>
													<li class="clearfix">
														<p class="pull-left">Salaries</p>
														<span class="pull-right">$2000</span>
													</li>
													<li class="clearfix">
														<p class="pull-left">Expenditure</p>
														<span class="pull-right ">$3000</span>
													</li>
													<li class="clearfix">
														<p class="pull-left">Extra income</p>
														<span class="pull-right ">$600</span>
													</li>
												</ul>
											</div>
										</div>
									</div--><!-- /First panel -->

									<!-- First panel -->
									<!--div class="panel panel-default">
										<div class="panel-heading">
											<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
												<h4 class="panel-title">
													Last 3 Months
													<span class="label label-inverse pull-right text-warning">$7900</span>
												</h4>
											</a>
										</div>
										<div id="collapseThree" class="panel-collapse collapse">
											<div class="panel-body">
												<ul class="list-unstyled">
													<li class="clearfix">
														<p class="pull-left">Income</p>
														<span class="pull-right">$5600</span>
													</li>
													<li class="clearfix">
														<p class="pull-left">Salaries</p>
														<span class="pull-right">$2000</span>
													</li>
													<li class="clearfix">
														<p class="pull-left">Expenditure</p>
														<span class="pull-right ">$3000</span>
													</li>
													<li class="clearfix">
														<p class="pull-left">Extra income</p>
														<span class="pull-right ">$600</span>
													</li>
												</ul>
											</div>
										</div>
									</div><!-- /First panel -->

								<!--/div--><!-- /Panel Group -->
							<!--/div>
						</div>
					</div-->
					<!-- /summary widget -->

					<!-- Users widget -->
					<!--div class="col-md-9">
						<div class="panel panel-users">
							<div class="panel-heading">
								<h3 class="panel-title">Users Widget
									<span class="pull-right">
										<a  href="#" class="panel-minimize"><i class="fa fa-chevron-up"></i></a>
										<a  href="#"  class="panel-settings"><i class="fa fa-cog"></i></a>
										<a  href="#"  class="panel-close"><i class="fa fa-times"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<table class="table users-table table-condensed table-hover " >
									<thead>
										<tr>
											<th  class="visible-lg">#</th>
											<th >Avatar</th>
											<th  class="visible-lg">First Name</th>
											<th class="visible-lg">Last Name</th>
											<th class="visible-lg">Email</th>
											<th>Username</th>
											<th>&nbsp;</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="visible-lg">1</td>
											<td><img src="images/avatarOne.png" alt=" " class="avatar"></td>
											<td class="visible-lg">John </td>
											<td class="visible-lg">Deo</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td class="visible-lg">2</td>
											<td><img src="images/avatarTwo.png" alt=" " class="avatar"></td>
											<td  class="visible-lg">Jane </td>
											<td class="visible-lg">Doe</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td class="visible-lg">3</td>
											<td><img src="images/avatarThree.png" alt=" " class="avatar"></td>
											<td  class="visible-lg">Jump </td>
											<td class="visible-lg">Deo</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td  class="visible-lg">4</td>
											<td><img src="images/avatarFour.png" alt=" " class="avatar"></td>
											<td  class="visible-lg">Jump </td>
											<td class="visible-lg">Doe</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td class="visible-lg">5</td>
											<td><img src="images/avatarOne.png" alt=" " class="avatar"></td>
											<td class="visible-lg">John </td>
											<td class="visible-lg">Deo</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td class="visible-lg">6</td>
											<td><img src="images/avatarTwo.png" alt=" " class="avatar"></td>
											<td  class="visible-lg">Jane </td>
											<td class="visible-lg">Doe</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td class="visible-lg">7</td>
											<td><img src="images/avatarThree.png" alt=" " class="avatar"></td>
											<td  class="visible-lg">Jump </td>
											<td class="visible-lg">Deo</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td  class="visible-lg">8</td>
											<td><img src="images/avatarFour.png" alt=" " class="avatar"></td>
											<td  class="visible-lg">Jump </td>
											<td class="visible-lg">Doe</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td class="visible-lg">9</td>
											<td><img src="images/avatarOne.png" alt=" " class="avatar"></td>
											<td class="visible-lg">John </td>
											<td class="visible-lg">Deo</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td class="visible-lg">10</td>
											<td><img src="images/avatarTwo.png" alt=" " class="avatar"></td>
											<td  class="visible-lg">Jane </td>
											<td class="visible-lg">Doe</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td class="visible-lg">11</td>
											<td><img src="images/avatarThree.png" alt=" " class="avatar"></td>
											<td  class="visible-lg">Jump </td>
											<td class="visible-lg">Deo</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
										<tr>
											<td  class="visible-lg">12</td>
											<td><img src="images/avatarFour.png" alt=" " class="avatar"></td>
											<td  class="visible-lg">Jump </td>
											<td class="visible-lg">Doe</td>
											<td class="visible-lg">johndeo@example.com</td>
											<td>@johndeo</td>
											<td>
												<button type="button" class="btn btn-success"><i class="fa fa-envelope"></i></button>
												<button type="button" class="btn btn-info"><i class="fa fa-eye"></i></button>
												<button type="button" class="btn btn-warning"><i class="fa fa-edit"></i></button>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div-->	<!-- / Users widget-->

				<!-- Chat and todo list -->
				<!--div class="row"-->
					<!-- Chat Box -->
					<!--div class="col-md-9">
						<div class="panel panel-archon panel-chat ">
							<div class="panel-heading">
								<h3 class="panel-title">Chat Box
									<span class="pull-right">
										<a  href="#" class="panel-minimize"><i class="fa fa-chevron-up"></i></a>
										<a  href="#"  class="panel-settings"><i class="fa fa-cog"></i></a>
										<a  href="#"  class="panel-close"><i class="fa fa-times"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<div class="users-column">
									<ul class="list-unstyled">
										<li class="unread">
											<img src="images/avatarOne.png" alt="" class="avatar">
											<span class="username">Anusha</span> 
											<i class="fa fa-circle text-success"></i>
										</li>
										<li>
											<img src="images/avatarTwo.png" alt="" class="avatar">
											<span class="username">Vijay Kumar</span> 
											<i class="fa fa-circle text-success"></i>
										</li>
										<li>
											<img src="images/avatarThree.png" alt="" class="avatar">
											<span class="username">Veerendhra</span> 
											<i class="fa fa-circle text-danger"></i>
										</li >
										<li class=" clearfix">
											<img src="images/avatarFour.png" alt="" class="avatar">
											<span class="username">Srikanth</span> 
											<i class="fa fa-circle text-success"></i>
										</li>
										<li>
											<img src="images/avatarFive.png" alt="" class="avatar">
											<span class="username">Sanjana</span> 
											<i class="fa fa-circle text-warning"></i>
										</li>
										<li>
											<img src="images/avatarSix.png" alt="" class="avatar">
											<span class="username">Pravallika</span> 
											<i class="fa fa-circle text-warning"></i>
										</li>
										<li>
											<img src="images/avatarSevene.png" alt="" class="avatar">
											<span class="username">Akhil</span> 
											<i class="fa fa-circle text-danger"></i>
										</li>
										<li>
											<img src="images/avatarEight.png" alt="" class="avatar">
											<span class="username">Akash</span> 
											<i class="fa fa-circle text-danger"></i>
										</li>
										<li>
											<img src="images/avatarThree.png" alt="" class="avatar">
											<span class="username">Veerendhra</span> 
											<i class="fa fa-circle text-danger"></i>
										</li >
										<li class=" clearfix">
											<img src="images/avatarFour.png" alt="" class="avatar">
											<span class="username">Srikanth</span> 
											<i class="fa fa-circle text-success"></i>
										</li>
										<li>
											<img src="images/avatarFive.png" alt="" class="avatar">
											<span class="username">Sanjana</span> 
											<i class="fa fa-circle text-warning"></i>
										</li>
										<li>
											<img src="images/avatarSix.png" alt="" class="avatar">
											<span class="username">Pravallika</span> 
											<i class="fa fa-circle text-warning"></i>
										</li>
										<li>
											<img src="images/avatarSevene.png" alt="" class="avatar">
											<span class="username">Akhil</span> 
											<i class="fa fa-circle text-danger"></i>
										</li>
										<li>
											<img src="images/avatarEight.png" alt="" class="avatar">
											<span class="username">Akash</span> 
											<i class="fa fa-circle text-danger"></i>
										</li>
										<li>
											<img src="images/avatarOne.png" alt="" class="avatar">
											<span class="username">Kumar</span> 
											<i class="fa fa-circle text-danger"></i>
										</li>
									</ul>
								</div--><!-- / Users Column -->
								<!--div class="message-column">
									<div class="user-block">
										<img src="images/avatarOne.png" alt="" class="avatar">
										<span class="username">Jane Deo
											<i class="fa fa-circle text-success"></i>
										</span>
									</div--><!-- /User Block -->
									<!--div class="messages">
										<ul class="list-unstyled">
											<li>
												<img src="images/avatarOne.png" alt="" class="avatar">
												<div class="message">
													<span class="username">
														Tupakula kumar
													</span>
													<span class="time pull-right">
														06:58 pm
													</span>
													<p>
														Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's ... 
													</p>
												</div>
											</li>
											<li class="sender">
												<img src="images/avatarTwo.png" alt="" class="avatar">
												<div class="message">
													<span class="username">
														Jane Deo
													</span>
													<span class="time pull-right">
														06:58 pm
													</span>
													<p>
														Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's ... 
													</p>
												</div>
											</li>
											<li>
												<img src="images/avatarOne.png" alt="" class="avatar">
												<div class="message">
													<span class="username">
														Tupakula kumar
													</span>
													<span class="time pull-right">
														06:58 pm
													</span>
													<p>
														Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's ... 
													</p>
												</div>
											</li>
											<li class="sender">
												<img src="images/avatarTwo.png" alt="" class="avatar">
												<div class="message">
													<span class="username">
														Jane Deo
													</span>
													<span class="time pull-right">
														06:58 pm
													</span>
													<p>
														Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's ... 
													</p>
												</div>
											</li>
											<li>
												<img src="images/avatarOne.png" alt="" class="avatar">
												<div class="message">
													<span class="username">
														Tupakula kumar
													</span>
													<span class="time pull-right">
														a minute ago
													</span>
													<p>
														Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's ... 
													</p>
												</div>
											</li>
											<li class="sender">
												<img src="images/avatarTwo.png" alt="" class="avatar">
												<div class="message">
													<span class="username">
														Jane Deo
													</span>
													<span class="time pull-right">
														06:58 pm
													</span>
													<p>
														Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's ... 
													</p>
												</div>
											</li>
										</ul>
									</div>
									<div class="composer">
										<form method="post">
											<div class="input-group">
												<input type="text" class="form-control text-input" placeholder="Please type your message">
												<span class="input-group-btn">
													<button class="btn btn-info message-send" type="button">Send</button>
												</span>
											</div--><!-- /input-group -->
										<!--/form>
									</div>
								</div--><!-- /Message column -->
							<!--/div--><!-- / Panel Body -->
						<!--/div--><!-- /Panel -->
					<!--/div--><!-- /Chat Box -->

					<!-- Todo list -->
					<!--div class="col-md-3">
						<div class="panel panel-archon panel-todo">
							<div class="panel-heading">
								<h3 class="panel-title">Todo List 
									<span class="pull-right">
										<a  href="#" class="panel-minimize"><i class="fa fa-chevron-up"></i></a>
										<a  href="#"  class="panel-settings"><i class="fa fa-cog"></i></a>
										<a  href="#"  class="panel-close"><i class="fa fa-times"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<ul class="list-unstyled todo-list sortable">
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Click and drag to sort</span>
										<span class="time">Tomorrow</span>
									</li>
									<li class="finish">
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Pick up granny on the airport</span>
										<span class="time">Evening</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Feed the dog with milk</span>
										<span class="time">Night</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Body workout for 2 hours</span>
										<span class="time">Evening</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Meeting with Charlie about his new idea</span>
										<span class="time">Saturday</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Watch Cricket match Team A vs Team B</span>
										<span class="time">Morning</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Collect the mobile from repair shop</span>
										<span class="time">2 days later</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Dinner with my Girl friend tonight</span>
										<span class="time">12/25/2013</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Install more plugins </span>
										<span class="time">later</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Indentation with 2 spaces</span>
										<span class="time">now</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Clean up clode</span>
										<span class="time">Next hour</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Call with a customer for resolution</span>
										<span class="time">Afternoon</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Visit Doc for dental check up</span>
										<span class="time">when possible</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">One more todo </span>
										<span class="time">Today</span>
									</li>
									<li>
										<input type="checkbox" value="1" class="finish-task">
										<span class="description">Nothing else for now</span>
										<span class="time">ok</span>
									</li>
								</ul>
							</div>
						</div>
					</div--><!-- /Todo list -->
				<!--/div--><!-- /Chat and todo list -->

				<!-- Most visited and Traffic sources Graph -->
				<!--div class="row">
					<div class="col-md-8">
						<div class="panel panel-primary panel-map">
							<div class="panel-heading">
								<h3 class="panel-title">Most Visited
									<span class="pull-right">
										<a  href="#" class="panel-minimize"><i class="fa fa-chevron-up"></i></a>
										<a  href="#"  class="panel-settings"><i class="fa fa-cog"></i></a>
										<a  href="#"  class="panel-close"><i class="fa fa-times"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<div id="map-canvas" class="graph"--></div><!-- /Map holder -->
							<!--/div-->
							<!--div class="panel-footer">
								<p>Some footer text for summary or statistics or buttons </p>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">Traffic Source 
									<span class="pull-right">
										<a  href="#" class="btn btn-inverse "><i class="fa fa-cog"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body graph realtime-bar">
								<svg> </svg>
							</div>
							<div class="panel-footer">
								<button type="button" class="btn btn-danger btn-block" id="start-stop-button">Stop Live Stream</button>
							</div>
						</div>
					</div>
				</div-->	<!-- / Most visited and Traffic sources Graph -->

				<!-- Latest Activities -->
				<!--div class="row">
					<div class="col-md-6">
						<div class="panel panel-plain latest-activities">
							<div class="panel-heading">
								<h3 class="panel-title">Latest Activities
									<span class="pull-right">
										<a  href="#" class="panel-minimize"><i class="fa fa-chevron-up"></i></a>
										<a  href="#"  class="panel-settings"><i class="fa fa-cog"></i></a>
										<a  href="#"  class="panel-close"><i class="fa fa-times"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<ul class="list-unstyled">
									<li>
										<img src="images/clocks.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
									<li>
										<img src="images/cup.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
									<li>
										<img src="images/dj.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
									<li>
										<img src="images/flag.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
									<li>
										<img src="images/fit.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
									<li>
										<img src="images/clocks.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
									<li>
										<img src="images/games.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
									<li>
										<img src="images/google.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
									<li>
										<img src="images/graph.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
									<li>
										<img src="images/android.svg" class="activity-icon" alt="">
										<p>content goes here for small description of the latest activity  activity ... 
											<span class="time">10/09/2013</span>
											<a href="#" class="pull-right activity-link"><i class=" fa fa-arrow-right"></i></a>
										</p>
									</li>
								</ul>
							</div>
							<div class="panel-footer">
								Some description here <a href="#" class="pull-right">View All</a>
							</div>
						</div>
					</div--><!-- / Latest Activities-->

					<!--  Installed Plugins -->
					<!--div class="col-md-6">
						<div class="panel panel-plain installed-plugins">
							<div class="panel-heading">
								<h3 class="panel-title">Installed plugins
									<span class="pull-right">
										<a  href="#" class="panel-minimize"><i class="fa fa-chevron-up"></i></a>
										<a  href="#"  class="panel-settings"><i class="fa fa-cog"></i></a>
										<a  href="#"  class="panel-close"><i class="fa fa-times"></i></a>
									</span>
								</h3>
							</div>
							<div class="panel-body">
								<ul class="list-inline">
									<li class="primary">
										<i class="fa fa-cog"></i>
										<h5>Settings</h5>
									</li>
									<li class="success">
										<i class="fa fa-file"></i>
										<h5>Files</h5>
									</li>
									<li class="orange">
										<i class="fa fa-dropbox"></i>
										<h5>Dropbox</h5>
									</li>
									<li class="blue">
										<i class="fa fa-android"></i>
										<h5>Android</h5>
									</li>
									<li class="pink">
										<i class="fa fa-bug"></i>
										<h5>Bug</h5>
									</li>
									<li class="success">
										<i class="fa fa-linux"></i>
										<h5>Linux</h5>
									</li>
									<li class="thickblue">
										<i class="fa fa-weibo"></i>
										<h5>Weibo</h5>
									</li>
									<li class="blue">
										<i class="fa fa-bitbucket"></i>
										<h5>Bit Buck</h5>
									</li>
									<li class="green">
										<i class="fa fa-flickr"></i>
										<h5>Flickr</h5>
									</li>
									<li class="primary">
										<i class="fa fa-youtube-sign"></i>
										<h5>Youtube</h5>
									</li>
									<li class="primary">
										<i class="fa fa-cog"></i>
										<h5>Settings</h5>
									</li>
									<li class="success">
										<i class="fa fa-file"></i>
										<h5>Files</h5>
									</li>
									<li class="orange">
										<i class="fa fa-dropbox"></i>
										<h5>Dropbox</h5>
									</li>
									<li class="blue">
										<i class="fa fa-android"></i>
										<h5>Android</h5>
									</li>
									<li class="pink">
										<i class="fa fa-bug"></i>
										<h5>Bug</h5>
									</li>
									<li class="success">
										<i class="fa fa-linux"></i>
										<h5>Linux</h5>
									</li>
									<li class="thickblue">
										<i class="fa fa-weibo"></i>
										<h5>Weibo</h5>
									</li>
									<li class="blue">
										<i class="fa fa-bitbucket"></i>
										<h5>Bit Buck</h5>
									</li>
									<li class="green">
										<i class="fa fa-flickr"></i>
										<h5>Flickr</h5>
									</li>
									<li class="primary">
										<i class="fa fa-youtube-sign"></i>
										<h5>Youtube</h5>
									</li>
									<li class="primary">
										<i class="fa fa-cog"></i>
										<h5>Settings</h5>
									</li>
									<li class="success">
										<i class="fa fa-file"></i>
										<h5>Files</h5>
									</li>
									<li class="orange">
										<i class="fa fa-dropbox"></i>
										<h5>Dropbox</h5>
									</li>
									<li class="blue">
										<i class="fa fa-android"></i>
										<h5>Android</h5>
									</li>
									<li class="pink">
										<i class="fa fa-bug"></i>
										<h5>Bug</h5>
									</li>
									<li class="success">
										<i class="fa fa-linux"></i>
										<h5>Linux</h5>
									</li>
									<li class="thickblue">
										<i class="fa fa-weibo"></i>
										<h5>Weibo</h5>
									</li>
									<li class="blue">
										<i class="fa fa-bitbucket"></i>
										<h5>Bit Buck</h5>
									</li>
									<li class="green">
										<i class="fa fa-flickr"></i>
										<h5>Flickr</h5>
									</li>
									<li class="primary">
										<i class="fa fa-youtube-sign"></i>
										<h5>Youtube</h5>
									</li>
								</ul>
							</div>
							<div class="panel-footer">
								Installed apps : <span class="text-info">30</span> <a href="#" class="pull-right">Explore All</a>
							</div>
						</div>
					</div>
				</div-->	<!-- / Installed Plugins -->

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
