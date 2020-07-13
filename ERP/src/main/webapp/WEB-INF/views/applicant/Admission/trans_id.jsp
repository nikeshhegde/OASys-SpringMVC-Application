<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transaction ID Page</title>
<link href="/resources/applicant/Dashboard/form-wizard/css/demo_style.css" rel="stylesheet" type="text/css">

<link href="/resources/applicant/Dashboard/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/resources/applicant/Dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/resources/applicant/Dashboard/form-wizard/js/jquery.smartWizard.js"></script>


<link href="/resources/applicant/Dashboard/css/bootstrap.css" rel="stylesheet">
<link href="/resources/applicant/Dashboard/css/archon.css" rel="stylesheet">
<link href="/resources/applicant/Dashboard/css/responsive.css" rel="stylesheet">
<link href="/resources/applicant/Dashboard/login/css/style.css" rel="stylesheet">
<link href="/resources/applicant/Dashboard/css/style.css" rel="stylesheet">
<link href="/resources/applicant/Dashboard/css/custom.css" rel="stylesheet">
<style>		
			.button_example{
			width:110px;
border:3px solid #25729a; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #3093c7; background-image: -webkit-gradient(linear, left top, left bottom, from(#3093c7), to(#1c5a85));
 background-image: -webkit-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -moz-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -ms-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -o-linear-gradient(top, #3093c7, #1c5a85);
 background-image: linear-gradient(to bottom, #3093c7, #1c5a85);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#3093c7, endColorstr=#1c5a85);
}

.button_example:hover{
width:110px;
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
	<script>
		$(document).ready(function(){
			$("#DD").hide();
			$("#NEFT").hide();
		$('#paymentLogType').change(function() {  
			   // assign the value to a variable, so you can test to see if it is working
			    var selectVal = $('#paymentLogType :selected').val();
			    
			   	if(selectVal=="DD")
			   		{
			   		$("#NEFT").hide();
			   		$("#DD").show();

			   		}
			   	else
			   		{
			   		$("#DD").hide();
			   		$("#NEFT").show();
			   		
			   		}	
			});
		
		});

		</script>

</head>
<body>
			<h3 class="page-header">Payment</h3>
			
			<table class="table table-striped">			
			<tr><th colspan="2" style="text-align:center;">Personal Details</th></tr>
			<tr><td>Surname</td><td>${userModel.admissionUserSurName}</td></tr>
			<tr><td>Name</td><td>${userModel.admissionUserFname}</td></tr>
			<tr><td>Father's name</td><td>${userModel.admissionUserFatherName}</td></tr>
			<tr><td>Mother's name</td><td>${userModel.admissionUserMotherName}</td></tr>
			<tr><td>Branch</td><td>${userModel.getAdmissionUserBranch()}</td></tr>
			<tr><td>Year</td><td><c:out value="${userModel.getAdmissionUserCurrentSemester()/2+1}" /></td></tr>			
			</table>
			
			<b>Given below are the payment details of the transaction to be made</b><br/>
			<b>Please Make the transaction online at your Bank's online site and Enter the Transaction Id provided</b>	
			<!--div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">
				Name
				</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserFname" id="admission_user_name"  placeholder="Username" value='<c:out value="${userModel.admissionUserFname}"/>'>
					<label for="admission_user_name" id="admission_user_name-error" class="text-danger"></label>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Father's Name</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserFatherName" id="admission_user_father_name" value='<c:out value="${userModel.admissionUserFatherName}"/>' placeholder="Father's name">
					<label for="admission_user_father_name" id="admission_user_father_name-error" class="text-danger"></label>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Mother's Name</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserMotherName" id="admission_user_mother_name" value='<c:out value="${userModel.admissionUserMotherName}"/>' placeholder="Mother's name">
					<label for="admission_user_mother_name" id="admission_user_mother_name-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Branch</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserBranch" id="admission_user_branch" value='<c:out value="${userModel.admissionUserBranch}"/>' placeholder="Branch" readonly>
					<label for="admission_user_branch" id="admission_user_branch-error" class="text-danger"></label>	
				</div>
			</div>		
			
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Year</label>
				<div class="col-lg-11">
					<input type="text" class="form-control" name="admissionUserCurrentSemester" id="admission_user_current_semester" value='<c:out value="${(userModel.admissionUserCurrentSemester+2)/2}"/>' placeholder="Current Semester" readonly>
					<label for="admission_user_current_semester" id="admission_user_current_semester-error" class="text-danger"></label>
				</div>
			</div-->
			

				

			<table class="table table-striped">
			<tr><th colspan="2" style="text-align:center;">Payment details</th></tr>
			<tr><td>Amount to be paid</td><td>${Amount}</td></tr>
			<tr><td>Bank name:</td><td> ${bankDetail.getBankName()} </td></tr>
			<tr><td>Bank branch:</td><td> ${bankDetail.getBankBranch()} </td></tr>
			<tr><td>City:</td><td> ${bankDetail.getBankCity()} </td></tr>
			<tr><td>Account Number:</td><td> ${bankDetail.getAccountNumber()} </td></tr>
			<tr><td>Account type:</td><td> ${bankDetail.getAccountType()} </td></tr>
			<tr><td>IFSC Number:</td><td>${bankDetail.getIFSCNumber()}</td></tr>
			<tr><td>Account Holder Name</td><td>${bankDetail.getAccountHolder()}</td></tr>
			
			</table>	
			<form action="trans_id2" method="get">		
				<div class="form-group">
					<select name="paymentLogType" id="paymentLogType">
					<option name="DD" value="">Choose payment method</option>
					<option name="DD" value="DD">Demand Draft</option>
					<option name="NEFT" value="NEFT">NEFT</option>
					</select>
					
					<div id="NEFT">
						<label for="paymentLogTransactionId" class="col-lg-2 control-label">
							Transaction Id
						</label>
						<div class="col-lg-11">
							<input type="text" class="form-control" name="admissionUserTransactionId" id="admission_trans_id" placeholder="Enter your Transaction Id here">
							<label for="admission_trans_id" id="admission_trans_id-error" class="text-danger"></label>  
						</div>
					</div>
									
					<div id="DD">
						<div class="col-lg-11">
							<input type="date" class="form-control" name="drawnDate" id="drawnDate" >
							<label for="admission_trans_id" id="admission_trans_id-error" class="text-danger"></label>  
						</div>
						<div class="col-lg-11">
							<input type="text" class="form-control" name="drawnName" id="drawnName" >
							<label for="admission_trans_id" id="admission_trans_id-error" class="text-danger"></label>  
						</div>
						<div class="col-lg-11">
							<input type="text" class="form-control" name="ddPayable" id="ddPayable" >
							<label for="admission_trans_id" id="admission_trans_id-error" class="text-danger"></label>  
						</div>
						<div class="col-lg-11">
							<input type="text" class="form-control" name="ddAmount" id="ddAmount" >
							<label for="admission_trans_id" id="admission_trans_id-error" class="text-danger"></label>  
						</div>
						<div class="col-lg-11">
							<input type="text" class="form-control" name="applicantBank" id="applicantBank" >
							<label for="admission_trans_id" id="admission_trans_id-error" class="text-danger"></label>  
						</div>
						<div class="col-lg-11">
							<input type="text" class="form-control" name="applicantBranch" id="applicantBranch" >
							<label for="admission_trans_id" id="admission_trans_id-error" class="text-danger"></label>  
						</div>
						<div class="col-lg-11">
							<input type="text" class="form-control" name="ddNumber" id="ddNumber" >
							<label for="admission_trans_id" id="admission_trans_id-error" class="text-danger"></label>  
						</div>
						<div class="col-lg-11">
							<input type="text" class="form-control" name="ddMicrCode" id="ddMicrCode" >
							<label for="admission_trans_id" id="admission_trans_id-error" class="text-danger"></label>  
						</div>
					</div>
					
					<div class="button-container row">
						<div class="col-lg-11">
							<div class="col-lg-4 col-lg-offset-2">
								<div class="col-lg-offset-1">
									<input class="button_example" align="center" type="submit" name="Submit" id="Submit"></input>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				</form>			
			
	</body>	
</html>		