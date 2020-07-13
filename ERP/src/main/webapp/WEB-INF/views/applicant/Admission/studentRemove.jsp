<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Student Remove</title>
</head>
<body>

	<center>
	
	<br></br>

		<h1>This is Student Remove page</h1>
			
			
			<br></br>	
		<form action="removeStudentRecord" method="post">


			<tr>
				<td><B><spring:message code="student.label.recordId" /></B></td>
				<td><input type=text name=recordId id="recordId" size="10"></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Delete Record" /></td>
			</tr>
	</center>

	</form>
</body>
</html>
