<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Dashboard Admin</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Loading Bootstrap -->
	<link href="resources/applicant/dashboard/css/bootstrap.css" rel="stylesheet">

	<!-- Loading Stylesheets -->    
	
	<link href="resources/applicant/dashboard/css/responsive.css" rel="stylesheet">
	<link href="resources/applicant/dashboard/css/prettify.css" rel="stylesheet">
	<link href="resources/applicant/dashboard/css/style.css" rel="stylesheet">
	<!-- Loading Custom Stylesheets -->    
	<link href="resources/applicant/dashboard/css/custom.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/applicant/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>

	<link rel="shortcut icon" href="images/favicon.ico">

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<![endif]-->
	
	<script>
	/*
	$(function(){
    	alert("starsst");
        var iFrames = $('.iframe');
        for (var i = 0, j = iFrames.length; i < j; i++) {
			alert("in the loop");
  		  iFrames[i].style.height = iFrames[i].contentWindow.document.body.offsetHeight + 'px';
  		  }
        this.style.height = this.contentWindow.document.body.offsetHeight + 'px';
    	function iResize() {
    		alert("entering here");
    		alert("Height:"+ iFrames[0].style.height);
    		for (var i = 0, j = iFrames.length; i < j; i++) {
    			
    		  iFrames[i].style.height = iFrames[i].contentWindow.document.body.offsetHeight + 'px';}
    	    }
    	    
    		
        	if ($.browser.safari || $.browser.opera) { 
        	
        	   iFrames.load(function(){
        	       setTimeout(iResize, 0);
               });
            
        	   for (var i = 0, j = iFrames.length; i < j; i++) {
        			var iSource = iFrames[i].src;
        			iFrames[i].src = '';
        			iFrames[i].src = iSource;
               }
               
        	} else {
        	   iFrames.load(function() { 
        		   //setTimeout(iResize,5);
        		   //alert("setting the widths");
        	       this.style.height = this.contentWindow.document.body.offsetHeight + 'px';
        	   });
        	}
        
        });
*/
</script>
</head>
<body>
	<div class="frame">
		<div class="content">
		<!-- Main content starts here-->
			<div class="main-content">
		<iframe src="dashboardhomeadmin" width=1010 height=650 frameborder="0"></iframe>
			</div>
		</div>	
</div>
</body>
</html>
