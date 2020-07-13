<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Report</title>
	<link href="resources/applicant/Dashboard/form-wizard/css/demo_style.css" rel="stylesheet" type="text/css">

<link href="resources/applicant/Dashboard/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/applicant/Dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="resources/applicant/Dashboard/form-wizard/js/jquery.smartWizard.js"></script>


<link href="resources/applicant/Dashboard/css/bootstrap.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/archon.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/responsive.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/login/css/style.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/style.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/custom.css" rel="stylesheet">
<script src="//datatables.net/download/build/nightly/jquery.dataTables.js?_=c4860a4a5b8636021ae24650f795f55b"></script>
<link href="/resources/applicant/Dashboard/css/dataTables.css" rel="stylesheet">
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
<script>
$(document).ready(function(){
    $('#myTable').dataTable();
    
    var name="${reportCategory}";
    
    /*
   $("#pdf").click(function(){
	   
	   var table=$("table");
	   
	   alert("table id "+table.attr("id"));
	 */ 
	   $("#pdf").click(function(){
		  alert("Here"); 
	   var value=$("select").val();
	   
	   
	   alert(value);
	   alert(name);
	  
	   name=name.replace(" ","-");
	   value=value.replace(" ","-");
	   var content="";
	   content+="<input type='hidden' name="+name+" value="+value+">";
	   content+="<input type='hidden' name='reportCategory' value="+name+">";
	   $("#report").append(content);
	   if(value!="")
		   {
	   		$("#report").submit();
		   }
	   });
	   
});
</script>


<body>
	<div class="row">
		<h1>Select one of the values</h1>
		<div class="col-md-4 col-md-offset-2">
		<form action="report" method="POST">
			<select name="${reportCategory}" class="form-control">
					<option value="">---SELECT FILTER---</option>
				<c:forEach items="${reportValues}" var="reportValue">
					<option value="${reportValue.getParameterValue()}">${reportValue.getParameterValue()}</option>
				</c:forEach>
			</select>
			<input type="hidden" name="reportCategory" value="${reportCategory}">
			<input type="submit" class="form-control" value="Go">
		</form>	
		</div>
		<div class="col-md-4">		
				<a href="#" class="button_example" id="pdf">View PDF</a>
				<form id="report" action="report-pdf" method="POST" target="_blank">
				</form>
		</div>
		<!--div class="col-md-4">
		<a href="#" class="button_example" id="pdf">View PDF</a>
		</div-->
		
	</div>
	<div class="row">
		<div class="col-md-10 col-md-offset-2">
			<table id="myTable">
				<thead>
					<tr>
						<th>
						Id
						</th>
						<th>
						Surname
						</th>
						<th>
						Name
						</th>
						<th>
						Father's Name
						</th>
						<th>
						Mother's Name
						</th>
						<th>
						Gender
						</th>
						<th>
						Email ID
						</th>
						<th>
						Applied Under
						</th>
						<th>
						Permanent Address
						</th>
						<th>
						Current Address
						</th>
						<th>
						Mobile Number
						</th>
						<th>
						LandLine Number
						</th>
						<th>
						Date of Birth
						</th>
						<th>
						Place Of Birth
						</th>
						<th>
						Domicile
						</th>
						<th>
						State
						</th>
						<th>
						Nationality
						</th>
						<th>
						Religion
						</th>
						<th>
						Caste
						</th>
						<th>
						Physically Handicapped
						</th>
						<th>
						Economically backward
						</th>
						<th>
						Mother Tongue
						</th>
						<th>
						Blood group
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${students}" var="student"> 
					<tr>
						<td>
						${student.getId()}
						</td>
						<td>
						${student.getAdmissionUserSurName()}
						</td>
						<td>
						${student.getAdmissionUserFname()}
						</td>
						<td>
						${student.getAdmissionUserFatherName()}
						</td>
						<td>
						${student.getAdmissionUserMotherName()}
						</td>
						<td>
						${student.getAdmissionUserGender()}
						</td>
						<td>
						${student.getAdmissionUserEmail()}
						</td>
						<td>
						${student.getAdmissionUserAppliedUnder()}
						</td>
						<td>
						${student.getAdmissionUserPermanentAddress()}
						</td>
						<td>
						${student.getAdmissionUserCurrentAddress()}
						</td>
						<td>
						${student.getAdmissionUserMobileNumber()}
						</td>
						<td>
						${student.getAdmissionUserLandlineNumber()}
						</td>
						<td>
						${student.getAdmissionUserDateOfBirth()}
						</td>
						<td>
						${student.getAdmissionUserPlaceOfBirth()}
						</td>
						<td>
						${student.getAdmissionUserDomicile()}
						</td>
						<td>
						${student.getAdmissionUserState()}
						</td>
						<td>
						${student.getAdmissionUserNationality()}
						</td>
						<td>
						${student.getAdmissionUserReligion()}
						</td>
						<td>
						${student.getAdmissionUserCaste()}
						</td>
						<td>
						${student.getAdmissionUserPhyHandicapped()}
						</td>
						<td>
						${student.getAdmissionUserEcoBackward()}
						</td>
						<td>
						${student.getAdmissionUserMotherTongue()}
						</td>
						<td>
						${student.getAdmissionUserBloodGroup()} ${student.getAdmissionUserRh()}
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
