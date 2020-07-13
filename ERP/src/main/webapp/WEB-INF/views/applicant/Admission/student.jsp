<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
	<head>
		<title>Registration </title>
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
        <link rel="stylesheet" type="text/css" href="/resources/mytheme/login/css/reg_css.css" />
        <link rel="stylesheet" type="text/css" href="/resources/mytheme/login/css/style.css" />
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

	<center>
		<h1>Student Details Form</h1>
		<P>
			<I> Please fill all details ...........</I>
		</P>
	</center>
	<form action="addStudent" method="post">

		<table height=580 width=500 >
			<tr>
				<td colspan=2>
					<center>
						<font size=4><b>Student Registration Form</b></font>
					</center>
				</td>
			</tr>

			<tr>
				<td><spring:message code="student.label.firstName"/></td>
				<td><input type=text name=name id="name" size="30" placeholder="First Name" 
				required oninvalid="setCustomValidity('Please enter your First Name')" oninput="setCustomValidity('')"></td>
			</tr>



			<tr>
				<td><spring:message code="student.label.middleName"/></td>
				<td><input type=text name=middleName id="middleName" size="30"></td>
			</tr>


			<tr>
				<td><spring:message code="student.label.surName"/></td>
				<td><input type=text name=surName id="surName" size="30"></td>
			</tr>

			<tr>
				<td><spring:message code="student.label.fatherName"/></td>
				<td><input type="text" name="fatherName" id="fatherName"
					size="30"></td>
			</tr>

			<tr>
				<td><spring:message code="student.label.motherName"/></td>
				<td><input type="text" name="motherName" id="motherName"
					size="30"></td>
			</tr>



			<tr>
				<td colspan="2"><input type="submit" value="create" /></td>
			</tr>

		
		</table>
			</form>



</body>
</html>







<!-- <tr>
<td>Postal Address</td>
<td><input type="text" name="paddress" id="paddress" size="30"></td>
</tr> -->


<!-- <tr>
<td>Personal Address</td>
<td><input type="text" name="personaladdress"
id="personaladdress" size="30"></td>
</tr> -->

<!-- <tr>
<td>Sex</td>
<td><input type="radio" name="sex" value="male" size="10">Male
<input type="radio" name="sex" value="Female" size="10">Female</td>
</tr> -->


<!-- <tr>
<td>City</td>
<td><select name="City">
<option value="-1" selected>select..</option>
<option value="New Delhi">NEW DELHI</option>
<option value="Mumbai">MUMBAI</option>
<option value="Goa">GOA</option>
<option value="Patna">PATNA</option>
</select></td>
</tr>
 -->


<!-- <tr>
<td>Course</td>
<td><select name="Course">
<option value="-1" selected>select..</option>
<option value="B.Tech">B.TECH</option>
<option value="MCA">MCA</option>
<option value="MBA">MBA</option>
<option value="BCA">BCA</option>
</select></td>
</tr>
 -->

<!-- <tr>
<td>District</td>
<td><select name="District">
<option value="-1" selected>select..</option>
<option value="Nalanda">NALANDA</option>
<option value="UP">UP</option>
<option value="Goa">GOA</option>
<option value="Patna">PATNA</option>
</select></td>

</tr>
 -->
<!-- <tr>
<td>State</td>
<td><select Name="State">
<option value="-1" selected>select..</option>
<option value="New Delhi">NEW DELHI</option>
<option value="Mumbai">MUMBAI</option>
<option value="Goa">GOA</option>
<option value="Bihar">BIHAR</option>
</select></td>
</tr> -->


<!-- <tr>
<td>PinCode</td>
<td><input type="text" name="pincode" id="pincode" size="30"></td>

</tr>
 -->

<!-- <tr>
<td>EmailId</td>
<td><input type="text" name="emailid" id="emailid" size="30"></td>
</tr> -->

<!-- <tr>
<td>DOB</td>
<td><input type="text" name="dob" id="dob" size="30"></td>
</tr> -->


<!-- <tr>
<td>MobileNo</td>
<td><input type="text" name="mobileno" id="mobileno" size="30"></td>
</tr> -->

<!-- <tr>
<td><input type="reset"></td>
<td colspan="2"><input type="submit" value="Submit Form" /></td>
</tr> -->




