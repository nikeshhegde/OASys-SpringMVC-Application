<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Change Password</title>
        <meta name="description" content="Custom Login Form Styling with CSS3" />
        <meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="resources/applicant/login/css/style.css" />
		<script src="resources/applicant/login/js/modernizr.custom.63321.js"></script>
		<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->

<style>
	.text-danger
		{
		color:#ff0000;
		}
</style>		
</head>
<body>
 
          <div class="back">
        <img class="img1" src="resources/applicant/login/image/logo2.png" />
       
        
        <div class="container" style="float:left;" >
        <h3>Login</h3>
           <section class="main">
			<form class="form-1" action="changePasswordAction" method="POST">
					<p class="field">
						<input type="password"  name="oldPassword" placeholder="Please Enter Old Password">
						<i class="icon-user icon-large"></i>
					</p>
						<p class="field">
							<input type="password" name="newPassword" placeholder="Please Enter a New password">
							<i class="icon-lock icon-large"></i>
					</p>
					<p class="field">
							<input type="password" name="newPasswordConfirm" placeholder="Please re-Enter the Password">
							<i class="icon-lock icon-large"></i>
					</p>
					<p class="submit">
						<button type="submit" name="submit"><i class="icon-arrow-right icon-large"></i></button>
					</p>
					
				</form>
			</section>
       
        </div>
        </div>


</body>
</html>



		
	