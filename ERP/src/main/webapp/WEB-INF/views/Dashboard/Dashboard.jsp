<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Home | Archon Admin Template</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Loading Bootstrap -->
	<link href="/resources/applicant/Dashboard/css/bootstrap.css" rel="stylesheet">

	<!-- Loading Stylesheets -->    
	
	<link href="/resources/applicant/Dashboard/css/responsive.css" rel="stylesheet">
	<link href="/resources/applicant/Dashboard/css/prettify.css" rel="stylesheet">
	<link href="/resources/applicant/Dashboard/css/style.css" rel="stylesheet">
	<!-- Loading Custom Stylesheets -->    
	<link href="/resources/applicant/Dashboard/css/custom.css" rel="stylesheet">
	
	<script type="text/javascript" src="/resources/applicant/Dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>

	<link rel="shortcut icon" href="images/favicon.ico">

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<![endif]-->
	
	
</head>
<style>

iframe
	{
	width:100%;
	}

</style>
<script>

	$(document).ready(function(){
		
	});


</script>
<script type="text/javascript">
var the_height=0;
var temp=0;
         function calcHeight()
         {
        	 //alert("Inside calcHeight");
         //find the height of the internal page
         the_height=document.getElementById('the_iframe').contentWindow.document.body.scrollHeight;
		
         //change the height of the iframe
        //alert(the_height+" > "+ temp);	
         temp=Math.max(the_height,temp);

         document.getElementById('the_iframe').height=temp;
         
         
         
         /*
         	if(the_height!=temp)
         			{
         			alert("not equal");
         			
         			}
         if(+the_height>+temp)
        	 {
        	 	alert(the_height+" > "+temp);
         		
         		temp=the_height;
        	 }	
         else
        	 {
        	 alert("wtf here "+temp+" "+the_height);
        	 document.getElementById('the_iframe').height=temp;
        	 }	
         
        	*/ 
         }
</script>
<body>.
	<div class="frame">
		<!-- /Sidebar -->
		<div class="sidebar">
			<div class="wrapper">
				<a href="index.html" class="logo"><img src="/resources/applicant/Dashboard/images/logo.png" alt="Archon Admin" /></a>
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
					<!--li><a href="#"><i class="fa fa-dashboard"></i>Dashboard </a></li>
					<li><a href="#"><i class="fa fa-book"></i>Prospectus</a></li>
					<li class="active"><a href="#"><i class="fa fa-suitcase"></i>Admission Form</a></li>
					<li><a href="app"><i class="fa fa-print"></i>Print Application</a></li>					
					<li><a href="#"><i class="fa fa-key"></i>Change Password</a></li-->		
					<c:forEach var="menuItem" items="${menu}">
						<li><a href="${menuItem.getDashboardMenuUrl()}" target="my_iframe">${menuItem.getDashboardMenuCaption()}</a></li>
					</c:forEach>
						<li><a href="/changePassword" target="my_iframe">Change password</a></li>
						<li><a href="/logout">Logout</a></li>		
				</ul>	
			</div>
		</div>
		<div class="content">
		<!-- Main content starts here-->
			<div class="main-content">
		<iframe src="Dashboard-iframe" name="my_iframe" id="the_iframe" style="width:100%;" onLoad="calcHeight();" onChange="calcHeight();" frameborder="0"></iframe>
			</div>
		</div>	
</div>
</body>
</html>
