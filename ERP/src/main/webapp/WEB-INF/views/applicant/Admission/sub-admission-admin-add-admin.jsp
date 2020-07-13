<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Add Admin Page</title>
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
        <link rel="stylesheet" type="text/css" href="resources/applicant/login/css/reg_css.css" />
        <link rel="stylesheet" type="text/css" href="resources/applicant/login/css/style.css" />
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
			   		$("branch_select").hide();
			   		}	
			});
		
		});

		</script>
	</head>
	<body>
        <form class="reg" method="post" action="add-admin-action">
			<table height=580 width=500 >
				<tr>
				<td colspan=2 align="center">
				<img class="img_reg" src="resources/applicant/login/image/logo2.png"/>
				</td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="adminFname" id="user_fname" placeholder="First Name" required oninvalid="setCustomValidity('Please enter your First Name')" oninput="setCustomValidity('')"></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				
								
				<tr>
					<td>Email Address</td>
					<td><input type="email" name="adminEmail" id="user_email" placeholder="Email" required /></td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td><input type="password" title="Password must contain at least 8 characters, including UPPER/lowercase and numbers"
						onchange="this.setCustomValidity(this.validity.patternMismatch ? this.title : '')"
						placeholder="Password (Atleast 7 characters)"
						required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="adminPassword" id="passwords" required></td>
						</tr>
						<tr>
						<td>Confirm Password</td>
					<td><input type="password" title="Please enter the same Password as above"
						onchange="this.setCustomValidity(this.validity.patternMismatch ? this.title : '')"
						placeholder="Confirm Password"
						required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="confirmPassword" id="confirmPassword" required></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="adminMobileNumber" id="user_email" placeholder="Mobile Number" required /></td>
				</tr>				
				<tr>
					<td colspan="2" align="center"><input class="button_example" type="reset" value="Reset">
					<input class="button_example" type="submit" id="registerBtn" name="registerBtn" value="Add">
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>