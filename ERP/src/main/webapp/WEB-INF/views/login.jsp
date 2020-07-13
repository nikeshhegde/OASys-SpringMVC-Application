<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Login - Home</title>
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
 
  
<!-- div class="back" style="margin-top:50px">
        <img class="img1" src='<c:url value="resources/gstian/images/SIES_Logo.png"/>' /><!--<img src="image/usr1.png" width="128" height="128" alt=""/>-->

        <!-- div class="container" style="float:left;" >
        
        <c:if test="${not empty error}">
		<div class="errorblock">
			Login unsuccessful <br /> Cause:
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
        
        
           <section class="main">
		<form id="loginForm" class="form-1" action="<c:url value="/j_spring_security_check"/>" name="f" method="post" >
					<fieldset>
					<p class="field">
					
             			 <input type="text" name="j_username" placeholder="Enter RollNumber"  value=""/>
						 <i class="fa fa-user fa-lg"></i>

					</p>
					
					
					<p class="field">
						
             			 <input type="password" name="j_password" placeholder="Enter password" value=""/>
						 <i class="fa fa-lock fa-lg"></i>

					</p>
					<p class="submit">
						<button type="submit" name="Submit" value="Submit"><i class="fa fa-arrow-right fa-lg"></i></button>
					</p>
					</fieldset>
		</form>		
		 </section>
        </div>
        </div> -->
        
        
          <div class="back">
        <img class="img1" src="resources/applicant/login/image/logo2.png" />
       <!--<img class="profileimg" src="image/usr4.png" />-->
       
         <c:if test="${not empty error}">
		<div class="errorblock">
			<h4 class="text-danger">Login unsuccessful</h4>
			<h4 class="text-danger">Cause:
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</h4>
		</div>
	</c:if>
       
        <div class="container" style="float:left;" >
        <h3>Login</h3>
           <section class="main">
			<form class="form-1" action="<c:url value="/j_spring_security_check"/>" method="POST">
					<p class="field">
						<input type="text"  name="j_username" placeholder="Username or email">
						<i class="icon-user icon-large"></i>
					</p>
						<p class="field">
							<input type="password" name="j_password" placeholder="Password">
							<i class="icon-lock icon-large"></i>
					</p>
					<p class="submit">
						<button type="submit" name="submit"><i class="icon-arrow-right icon-large"></i></button>
					</p>
					
				</form>
				<a href="login/forgotPassword"><h3>Remind my Password..</h3></a>
			</section>
       
        </div>
        </div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

</body>
</html>



		
	