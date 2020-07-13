<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
</head>

<style>
div.ex {
	width: 350px;
	padding: 10px;
	border: 5px solid gray;
	margin: 0px;
}
</style>
<center>
	<h1>Welcome To Home Page</h1>
	<body>
		<P>Current time is : ${serverTime}.</P>
		<P>And My Age will be : ${age }</P>
</center>
<center>
	<div class="ex">
		<center>
           <table>
			<form action="student" method="post">
				<tr>
					<td><spring:message code="home.lable.loginName"/></td>
					<td><input type="text" name="logInUserName"></td>
				</tr>
				</br>
				<tr>
					<td><spring:message code="home.lable.loginPassword"/></td>
					<td><input type="password" name="logInUserPwd"></td>
				</tr>
				</br>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Login"></td>
				</tr>
			</form>
</table>
		</center>
	</div>
</center>

<br></br>
<br></br>
<P>
	<B>Note:</B><I> Currently this application is not spring security enabled. For login use mentioned credentials</I>
	<br></br>
	
	<B>Login Id / Password : </B>
	<br></br>
	<I>shiv / 123456</I>
	<br></br>
	<I>vishnu / 123456</I>
	<br></br>
	<I>brahma / 123456</I>
</P>
</body>
</html>

