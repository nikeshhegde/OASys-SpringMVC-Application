<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Registration </title>
		<script type="text/javascript" src="resources/applicant/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
		<style>		
			.button_example{
border:3px solid #25729a; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #3093c7; background-image: -webkit-gradient(linear, left top, left bottom, from(#3093c7), to(#1c5a85));
 background-image: -webkit-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -moz-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -ms-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -o-linear-gradient(top, #3093c7, #1c5a85);
 background-image: linear-gradient(to bottom, #3093c7, #1c5a85);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#3093c7, endColorstr=#1c5a85);
}

.button_example:hover{
 border:3px solid #1c5675;
 background-color: #26759e; background-image: -webkit-gradient(linear, left top, left bottom, from(#26759e), to(#133d5b));
 background-image: -webkit-linear-gradient(top, #26759e, #133d5b);
 background-image: -moz-linear-gradient(top, #26759e, #133d5b);
 background-image: -ms-linear-gradient(top, #26759e, #133d5b);
 background-image: -o-linear-gradient(top, #26759e, #133d5b);
 background-image: linear-gradient(to bottom, #26759e, #133d5b);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#26759e, endColorstr=#133d5b);
}
</style>
        <link href="/resources/applicant/welcome/css/reg_css.css" rel="stylesheet"/>
        <link href="/resources/applicant/welcome/css/style.css" rel="stylesheet"/>
        <script src="/resources/gstian/js/jquery-1.10.2.js"></script>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="/resources/gstian/bootstrap/css/bootstrap.min.css" />
		<script src="/resources/gstian/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			window.onload = function () {
			    document.getElementById("passwords").onchange = validatePassword;
			    document.getElementById("confirmPassword").onchange = validatePassword;
			}
			function validatePassword(){
			var pass2=document.getElementById("confirmPassword").value;
			var pass1=document.getElementById("passwords").value;
			if(pass1!=pass2)
			{
			    document.getElementById("confirmPassword").setCustomValidity("Passwords Don't Match");
				return false;
			}
			else
			{
			    document.getElementById("confirmPassword").setCustomValidity('');  
			}
			//empty string means no validation error
			}
		</script>
		
		<script>
		$(document).ready(function(){
			$("#branch_select").hide();
		$('#user_type').change(function() {  
			   // assign the value to a variable, so you can test to see if it is working
			    var selectVal = $('#user_type :selected').val();
			    
			   	if(selectVal=="Diploma")
			   		{
			   		$("#branch_select").show();
			   		}
			   	else
			   		{
			   		$("#branch_select").hide();
			   		}	
			});
		
		});

		</script>
	</head>
	<body>
        <form class="reg" method="post" action="addAdmission">
			<table height=580 width=500 >
				<tr>
				<td colspan=2 align="center">
					<img class="img1" src="/resources/applicant/login/image/logo2.png" />				
				</td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><input type="text" name="admissionUserSurName" id="user_sur_name" placeholder="Surname" required oninvalid="setCustomValidity('Please enter your Surname')" oninput="setCustomValidity('')" /></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="admissionUserFname" id="user_fname" placeholder="First Name" required oninvalid="setCustomValidity('Please enter your First Name')" oninput="setCustomValidity('')"></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				
				<tr>
					<td>Father's Name</td>
					<td><input type="text" name="admissionUserFatherName" id="user_father_name" placeholder="Father's Name" required oninvalid="setCustomValidity('Please enter your Father's name')" oninput="setCustomValidity('')"/></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				
				<tr>
					<td>Mother's Name</td>
					<td><input type="text" name="admissionUserMotherName" id="user_mother_name" placeholder="Mother's Name" required oninvalid="setCustomValidity('Please enter your Mother's Name')" oninput="setCustomValidity('')"/></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				<tr>
					<td>Gender</td>
					<td>	<select name="admissionUserGender" id="user_gender" width="100%">
							
							<option value="Male">Male</option>
							<option value="Female">Female</option>
							<option value="Others">Others</option>
							</select>
					</td>	</tr>
				
				<tr>
					<td>Email Address</td>
					<td><input type="email" name="admissionEmail" id="user_email" placeholder="Email" required /></td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td><input type="password" title="Password must contain at least 8 characters, including UPPER/lowercase and numbers"
						onchange="this.setCustomValidity(this.validity.patternMismatch ? this.title : '')"
						placeholder="Password (Atleast 7 characters)"
						required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="admissionUserPassword" id="passwords" required></td>
						</tr>
						<tr>
						<td>Confirm Password</td>
					<td><input type="password" title="Please enter the same Password as above"
						onchange="this.setCustomValidity(this.validity.patternMismatch ? this.title : '')"
						placeholder="Confirm Password"
						required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="confirmPassword" id="confirmPassword" required></td>
				</tr>				
				<tr>
				<td>Apply for</td>
				<td>
				<select name="admissionUserType" id="user_type" width="100%">
					<option value="">Choose...</option>
					<option value="FirstYearEngineering">First Year Engineering</option>
					<option value="Diploma">Diploma</option>
				</select>
				<!--input type="radio" name="admissionUserType"  value="Diploma">Diploma</input>
				<input type="radio" name="admissionUserType" value="FirstYearEngineering">First Year Engineering</input-->
				</td>
				</tr>
				<tr id="branch_select">
				<td>
				Branch
				</td>
				<td>
				<select name="admissionUserBranch">
				<option value="">Choose Branch..</option>
				<c:forEach items="${branch_dse}" var="dipbranch"  varStatus="status">
					<option value="something">${dipbranch}</option>
				</c:forEach>
				</select>
				</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="button_example" type="reset" value="Reset">
					<input class="button_example" type="submit" id="registerBtn" name="registerBtn" value="Sign up">
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>