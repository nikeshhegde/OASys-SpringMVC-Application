<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<script src="/resources/gstian/js/jquery-1.10.2.js"></script>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="/resources/gstian/bootstrap/css/bootstrap.min.css" />
		

		<!-- Optional theme -->
		<link rel="stylesheet" href="/resources/gstian/bootstrap/css/bootstrap-theme.min.css">

        <link rel="stylesheet" href="<c:url value="/resources/2.css"/>"/>
		<!-- Latest compiled and minified JavaScript -->
		<script src="/resources/gstian/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<style>
	#me {
    -webkit-animation: rotation 8s infinite linear;
	}

	@-webkit-keyframes rotation {
    from {-webkit-transform: rotate(0deg);}
    to   {-webkit-transform: rotate(359deg);}
	}


	body{
      background-image: url("/resources/images/background1.jpg");
      background-repeat: no-repeat;
      background-size:cover;
	}

	.logobg{
      background-image: url("/resources/images/sies1.png");
      width:440px;
      height:200px;
	}

	</style>
	<body>
    <div class="row">
	<div class="col-md-2 col-md-offset-5 logobg">
      <img src="/resources/images/chakra.png" alt="logo" id="me"/>
	</div>
    </div>
	<div class="row" style="margin-top:10%">
      <div class="col-md-2 col-md-offset-2"> <a href="/applicant"><img style="width:100%; height:auto"  src="/resources/images/Applicant.png"/></a>	</div>
	  <div class="col-md-2 col-md-offset-4"> <a href="/login"><img style="width:100%; height:auto" src="/resources/images/Existing.png"/></a>   </div>
	</body>
	<div class="row" style="margin-top:10%">
      <div class="col-md-9 col-md-offset-3"><h3>If you are an <b>ALUMNUS</b> of SIES-GST. Please click <a href="/new-alumni">Here</a> to Register</h3>	</div>
	  </body>
</html>
