<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Error Page</title>
	<link href="/start/resources/mytheme/dashboard/form-wizard/css/demo_style.css" rel="stylesheet" type="text/css">

<link href="/start/resources/mytheme/dashboard/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/start/resources/mytheme/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/start/resources/mytheme/dashboard/form-wizard/js/jquery.smartWizard.js"></script>


<link href="/start/resources/mytheme/dashboard/css/bootstrap.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/css/archon.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/css/responsive.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/login/css/style.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/css/style.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/css/custom.css" rel="stylesheet">
<style>		
			.button_example{
			width:auto;
border:3px solid #25729a; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #3093c7; background-image: -webkit-gradient(linear, left top, left bottom, from(#3093c7), to(#1c5a85));
 background-image: -webkit-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -moz-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -ms-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -o-linear-gradient(top, #3093c7, #1c5a85);
 background-image: linear-gradient(to bottom, #3093c7, #1c5a85);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#3093c7, endColorstr=#1c5a85);
}

.button_example:hover{
width:auto;
 border:3px solid #1c5675;
 background-color: #26759e; background-image: -webkit-gradient(linear, left top, left bottom, from(#26759e), to(#133d5b));
 background-image: -webkit-linear-gradient(top, #26759e, #133d5b);
 background-image: -moz-linear-gradient(top, #26759e, #133d5b);
 background-image: -ms-linear-gradient(top, #26759e, #133d5b);
 background-image: -o-linear-gradient(top, #26759e, #133d5b);
 background-image: linear-gradient(to bottom, #26759e, #133d5b);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#26759e, endColorstr=#133d5b);
}
.button-container {
 margin-top: 15px;
}

</style>
	
</head>
<body>
<h1>Query Preview</h1>


<table class="table">
	 <c:forEach items="${students}" var="student">
	<tr>
		<c:forEach items="${student}" var="data" varStatus="index">
			
		<td>
		${data}
		</td>
		</c:forEach> 
	</tr>
	</c:forEach> 
</table>

</body>
</html>
