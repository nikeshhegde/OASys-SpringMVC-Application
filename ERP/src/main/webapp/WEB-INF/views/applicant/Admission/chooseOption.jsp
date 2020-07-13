<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Choose Options</title>
</head>
<body>
	<center>
		<h1>This is Choose Option Page</h1>
	</center>
	<p>Welcome ${name}</p>
	<!--p>Welcome Mr. ${name1}</p-->
	<P>
		<I>&nbsp;&nbsp;&nbsp;&nbsp;
		You can choose any one option to perform Add, Delete,Serach </I>
	</P>
	<c:forEach var="listValue" items="${thelist}">
		<p>${listValue.getAdmissionUserFname()}</p>
	</c:forEach>
<form action="testVal" method="post">
	<center>
		 <a href="<c:url value="addNewStudent"/>">Add Student</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="<c:url value="removeStudent"/>">Remove Student</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="<c:url value="searchStudent"/>">Search Student</a> 
			
			<!-- <a href="error">Load Controller method 1</a><br>
			<a href="error.jsp">Load Controller method 2</a><br> -->
	</center>

<form>
</body>
</html>
