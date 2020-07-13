 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
 <html lang="en">
<head>

	<meta charset="utf-8">
	<title>SIESGST | Exam Cell</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Loading Bootstrap -->
	<link href='<c:url value="resources/gstian/dashboard/css/bootstrap.css"/>' rel="stylesheet">
	<!-- Loading Stylesheets -->    
	<link href='<c:url value="resources/gstian/dashboard/css/style.css"/>' rel="stylesheet">
<%-- 	<link href='<c:url value="/web-resources/dashboard/css/responsive.css"/>' rel="stylesheet">--%>
 	<link href='<c:url value="resources/gstian/dashboard/css/prettify.css"/>' rel="stylesheet">

	<!-- Loading Custom Stylesheets -->    
	<link href='<c:url value="resources/gstian/dashboard/css/custom.css"/>' rel="stylesheet">
	<link rel="icon" href='<c:url value="resources/gstian/dashboard/images/favicon.png"/>'>

<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.css.map"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.css.map"/>' rel="stylesheet">

	

	
</head>
<body>
	<div class="frame">
		<!-- /Sidebar -->
		<div class="sidebar">
			<div class="wrapper">
				<a href="index.html" class="logo"><img src='<c:url value="resources/gstian/dashboard/images/logo.png"/>' alt="Archon Admin" /></a>
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
					<li><a href='<c:url value="/admin/help" />' target="iframe_a"><i class="fa fa-dashboard"></i>Home</a></li>
					<li><a href='<c:url value="/subjectallotment/listSubjectAlloted" />' target="iframe_a"><i class="fa fa-book"></i>Subject Allotment</a></li>
					<li><a href=""><i class="fa fa-book"></i>Seat No Allotment</a></li>
					<li><a href=""><i class="fa fa-suitcase"></i>Regular Form Report</a></li>
					<li><a href='<c:url value="/adminreporting/appliedstudents" />' target="iframe_a"><i class="fa fa-suitcase"></i>KT Form Report</a></li>
					<li><a href='<c:url value="/fileupload/listofuploaded" />' target="iframe_a"><i class="fa fa-print"></i>Upload Marks</a></li>					
					<li><a href="j_spring_security_logout"><i class="fa fa-user"></i>Sign Out</a></li>
					<!--<li><a href=""><i class="fa fa-key"></i>Change Password</a></li>
					<li><a href=""><i class="fa fa-list-alt"></i>Exam</a></li>					-->
				</ul>	
			</div>
		</div>
		<!-- Main content starts here-->
		<div class="content">
			<div class="navbar"> <h3 style="float: right; color:white; " >Welcome ${Name}</h3></div><!-- / Navbar-->

			
			
		<div class="embed-responsive embed-responsive-4by3">
			<iframe class=" embed-responsive-item" name ="iframe_a" src='<c:url value="/admin/help" />' ></iframe>
		    </div>	
		    </div>
		<div class="row footer">
			<div class="col-md-12 text-center">
				© 2015 <a href="http://www.siesgst.net/">SIES Graduate School Of Technology</a>
			</div>
		</div>
	</div> <!-- Frame -->
	


</body>
</html>
 