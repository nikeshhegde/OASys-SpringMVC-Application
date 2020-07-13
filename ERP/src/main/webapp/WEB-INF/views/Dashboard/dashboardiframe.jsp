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
	<link href="/resources/applicant/Dashboard/css/style.css" rel="stylesheet">
	<link href="/resources/applicant/Dashboard/css/responsive.css" rel="stylesheet">
	<link href="/resources/applicant/Dashboard/css/prettify.css" rel="stylesheet">

	<!-- Loading Custom Stylesheets -->    
	<link href="/resources/applicant/Dashboard/css/custom.css" rel="stylesheet">

	<link rel="shortcut icon" href="images/favicon.ico">

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<![endif]-->
</head>

<body>	
	<div class="frame">
	<div class="content">
			<div id="main-content">
			
				<c:forEach var="menuItem" items="${menu}" varStatus="index">
					<c:if test="${index.index % 4==0}">
						<div class="row">
					</c:if>
						<div class="col-md-3">
							<div class="web-stats success">
								<div class="pull-left">
									<h5><a href="${menuItem.getDashboardMenuUrl()}">${menuItem.getDashboardMenuCaption()}</a></h5>
								</div>
							</div>	
						</div>
					<c:if test="${index.index % 4==3}">
						</div>
					</c:if>	
						
				</c:forEach>						
			</div>			
	</div>	
	</div>	
</body>	
</html>		