<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<script src="/resources/gstian/js/jquery-1.10.2.js"></script>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="/resources/gstian/bootstrap/css/bootstrap.min.css" />
		

		<!-- Optional theme -->
		<link rel="stylesheet" href="/resources/gstian/bootstrap/css/bootstrap-theme.min.css">

        <link rel="stylesheet" href="<c:url value="/resources/2.css"/>"/>
		<!-- Latest compiled and minified JavaScript -->
		<script src="/resources/gstian/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<style>
	#me {
    -webkit-animation: rotation 8s infinite linear;
	}

	@-webkit-keyframes rotation {
    from {-webkit-transform: rotate(0deg);}
    to   {-webkit-transform: rotate(359deg);}
	}



	.logobg{
      background-image: url("/resources/images/sies1.png");
      width:440px;
      height:200px;
	}

	</style>
	<body>
		<c:forEach var="payment" items="${paymentLog}">
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Payment Transaction Id</th>
				<th>Payment Transaction Amount</th>
			</tr>
			<tr>
				<td>${payment.getId()}</td>
				<td>${admUser.getAdmissionUserFname()}</td>
				<td>${payment.getPaymentLogTransactionId()}</td>
				<td>${payment.getPaymentLogAmount()}</td>
			</tr>
		</table>
		</c:forEach>
	</body>
	</html>