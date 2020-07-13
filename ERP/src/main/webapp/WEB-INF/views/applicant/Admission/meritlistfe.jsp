<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merit List for F.E.</title>
<!--link href="form-wizard/css/demo_style.css" rel="stylesheet" type="text/css"-->

	<link href="resources/applicant/dashboard/css/bootstrap.css" rel="stylesheet">

	<!-- Loading Stylesheets -->    
	
	<link href="resources/applicant/dashboard/css/responsive.css" rel="stylesheet">
	<link href="resources/applicant/dashboard/css/archon.css" rel="stylesheet">
	<link href="resources/applicant/dashboard/css/prettify.css" rel="stylesheet">
	<link href="resources/applicant/dashboard/css/style.css" rel="stylesheet">
	<!-- Loading Custom Stylesheets -->    
	<link href="resources/applicant/dashboard/css/custom.css" rel="stylesheet">
	
	<script type="text/javascript" src="resources/applicant/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>

	<link rel="shortcut icon" href="images/favicon.ico">


<script type="text/javascript">
    $(document).ready(function(){
    	// Smart Wizard 	
  		$('#wizard').smartWizard();
/*      
      function onFinishCallback(){
        $('#wizard').smartWizard('showMessage','Finish Clicked');
        alert('Finish Clicked');
      }
*/	  
		});
</script>

<script>

var d=new Date();

var current=d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();

$(function(){

$("#today_date").text(current);

});

</script>
<style>
td,th
{
text-align:center;
}
</style>

</head>
<body>		
<div>
  				<div class="row">
				<label for="Branch" class="col-lg-3 control-label">Branch</label>
				<div class="col-lg-11">
				<form>
					<select name="branch" id="branch" class="form-control">
						<option value="0">---Branch---</option>
						<option value="CE">Computer Engineering</option>
						<option value="EXTC">Electronics and Telecommunication</option>
						<option value="IT">Information Technology</option>
						<option value="PPT">Printing and Packaging Technology</option>
						<option value="BT">Biotechnology</option>
						<option value="ME">Mechanical Engineering</option>
					</select>
					</form>
				</div>
				</div>
		    <!--jquery refer zillion screenshots
				<label for="" class="col-lg-3 control-label">Student Merit List for  </label> 
			-->
			<div class="row">
								<table class="table">
									<thead>
										<tr>
											<th >Sr. No</th>
											<th>Applicant ID</th>
											<th>Name of the Applicant</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="student" items="${Users}">
									<tr>
															<td><c:out value="${student.getId()}"></c:out></td>
															<td><c:out value="${student.getId()}"></c:out></td>
															<td><c:out value="${student.getMeritListFeMeritScore()}"></c:out></td>
									</tr>
									</c:forEach>
									</tbody>
								</table>							
			</div>
			
			
			
			
			<input type="hidden" name="user_sess" id="user_sess" value="${userID}" />
					
  		
</div>		
   <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>		
</body>
</html>
