<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Registration for Alumnus</title>
		<script type="text/javascript" src="/resources/gstian/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
		<style>		
			.button_example{
border:3px solid #25729a; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #3093c7; background: -webkit-gradient(linear, left top, left bottom, from(#3093c7), to(#1c5a85));
 background: -webkit-linear-gradient(top, #3093c7, #1c5a85);
 background: -moz-linear-gradient(top, #3093c7, #1c5a85);
 background: -ms-linear-gradient(top, #3093c7, #1c5a85);
 background: -o-linear-gradient(top, #3093c7, #1c5a85);
 background: linear-gradient(to bottom, #3093c7, #1c5a85);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#3093c7, endColorstr=#1c5a85);
}

.button_example:hover{
 border:3px solid #1c5675;
 background-color: #26759e; background: -webkit-gradient(linear, left top, left bottom, from(#26759e), to(#133d5b));
 background: -webkit-linear-gradient(top, #26759e, #133d5b);
 background: -moz-linear-gradient(top, #26759e, #133d5b);
 background: -ms-linear-gradient(top, #26759e, #133d5b);
 background: -o-linear-gradient(top, #26759e, #133d5b);
 background: linear-gradient(to bottom, #26759e, #133d5b);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#26759e, endColorstr=#133d5b);
}
</style>
        <link rel="stylesheet" type="text/css" href="/resources/applicant/login/css/reg_css.css" />
        <link rel="stylesheet" type="text/css" href="/resources/gstian/login/css/style.css" />
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
		
	</head>
	<body>
		<h1>${message}</h1>
        <form class="reg" method="post" action="add-alumni">
			<table height=580 width=500 >
				<tr>
				<td colspan=2 align="center">
				<img class="img_reg" src="/resources/applicant/login/image/logo2.png"/>
				</td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><input type="text" name="alumniSurname" id="user_sur_name" placeholder="Surname" required oninvalid="setCustomValidity('Please enter your Surname')" oninput="setCustomValidity('')" /></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="alumniFname" id="user_fname" placeholder="First Name" required oninvalid="setCustomValidity('Please enter your First Name')" oninput="setCustomValidity('')"></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				
				<tr>
					<td>Father's Name</td>
					<td><input type="text" name="alumniFatherName" id="user_father_name" placeholder="Father's Name" required oninvalid="setCustomValidity('Please enter your Father's name')" oninput="setCustomValidity('')"/></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				
				<tr>
					<td>Email Address</td>
					<td><input type="email" name="alumniEmail" id="user_email" placeholder="Email" required /></td>
				</tr>
				
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="alumniContactNumber" id="user_father_name" placeholder="Mobile Number" required oninvalid="setCustomValidity('Please enter your Mobile number')" oninput="setCustomValidity('')"/></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				
				<tr>
					<td>Year of passing</td>
					<td><input type="text" name="alumniYearOfPassing" id="user_father_name" placeholder="Year of passing" required oninvalid="setCustomValidity('Please enter your Year of passing')" oninput="setCustomValidity('')"/></td>
					<!--<td><input type="text"  name="lname" id="lname" placeholder="Last Name"></td>-->
				</tr>
				
				
				<tr>
					<td>Password</td>
					<td><input type="password" title="Password must contain at least 8 characters, including UPPER/lowercase and numbers"
						onchange="this.setCustomValidity(this.validity.patternMismatch ? this.title : '')"
						placeholder="Password (Atleast 7 characters)"
						required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="alumniPassword" id="passwords" required></td>
						</tr>
						<tr>
						<td>Confirm Password</td>
					<td><input type="password" title="Please enter the same Password as above"
						onchange="this.setCustomValidity(this.validity.patternMismatch ? this.title : '')"
						placeholder="Confirm Password"
						required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="confirmPassword" id="confirmPassword" required></td>
				</tr>				
				<tr id=branch_select>
				<td>
				Branch
				</td>
				<td>
				<select name="alumniDepartment">
					<option value="">Choose Branch..</option>
					<option value="CE">Computer Engineering</option>
					<option value="EXTC">Electronics and Telecommunication</option>
					<option value="IT">Information Technology</option>
					<option value="PPT">Printing and Packaging Technology</option>
					<option value="MECH">Mechanical Engineering</option>
					<option value="BT">BioTechnology</option>
				</select>
				</td>
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