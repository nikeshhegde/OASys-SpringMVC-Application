<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Home | Archon Admin Template</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Loading Bootstrap -->
	<link href="/start/resources/mytheme/dashboard/css/bootstrap.css" rel="stylesheet">

	<!-- Loading Stylesheets -->    
	<link href="/start/resources/mytheme/dashboard/css/style.css" rel="stylesheet">
	<link href="/start/resources/mytheme/dashboard/css/responsive.css" rel="stylesheet">
	<link href="/start/resources/mytheme/dashboard/css/prettify.css" rel="stylesheet">

	<!-- Loading Custom Stylesheets -->    
	<link href="/start/resources/mytheme/dashboard/css/custom.css" rel="stylesheet">

	<link rel="shortcut icon" href="images/favicon.ico">

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
				
					<c:forEach items="${tables}" var="table" varStatus="status">
						<c:if test="${status.index % 3==0}">
							<div class="row">
						</c:if>
					<div class="col-md-4">
						<div class="web-stats danger">
							<div class="pull-left">
								<h5><a href="${url[status.index]}">${table}</a></h5>
								<!--span class="description">Returns</span-->
							</div>
							<!--span class=" pull-right  mini-graph danger"></span-->
						</div>
					</div>
						<c:if test="${status.index % 3==2}">
							</div>
						</c:if>
					</c:forEach>
				
					

</body>
</html>
