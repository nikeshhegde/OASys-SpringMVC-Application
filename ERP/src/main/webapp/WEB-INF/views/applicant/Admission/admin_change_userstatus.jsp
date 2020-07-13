<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Status Page for Admin</title>
<!--link href="form-wizard/css/demo_style.css" rel="stylesheet" type="text/css"-->

<link href="resources/applicant/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css">

<link href="resources/applicant/dashboard/css/bootstrap.css" rel="stylesheet">
<link href="resources/applicant/dashboard/css/archon.css" rel="stylesheet">
<link href="resources/applicant/dashboard/css/responsive.css" rel="stylesheet">
<!-- link href="loginresources/applicant/dashboard/css/style.css" rel="stylesheet"-->
<link href="resources/applicant/dashboard/css/style.css" rel="stylesheet">
<link href="resources/applicant/dashboard/css/custom.css" rel="stylesheet">

<script type="text/javascript">
    $(document).ready(function(){
    	// Smart Wizard 	
  		$('#wizard').smartWizard();
/*      
      function onFinishCallback(){
        $('#wizard').smartWizard('showMessage','Finish Clicked');
        alert('Finish Clicked');
      }
*/	  
		});
</script>

<script>

var d=new Date();

var current=d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();

$(function(){

$("#today_date").text(current);

});

</script>

<style>
td
{
text-align:center;
}

th
{
text-align:center;
}
</style>
</head>
<body>
  				<!--  div class="row">
					<label for="Branch" class="col-lg-3 control-label">Branch</label>
					<div class="col-lg-11">
						<select name="branch" id="branch" class="form-control">
						<option value="0">---Branch---</option>
						<option value="CE">Computer Engineering</option>
						<option value="EXTC">Electronics and Telecommunication</option>
						<option value="IT">Information Technology</option>
						<option value="PPT">Printing and Packaging Technology</option>
						<option value="BT">Biotechnology</option>
						<option value="ME">Mechanical Engineering</option>
						</select>
					</div>
				</div-->
		    <!--jquery refer zillion screenshots
				<label for="" class="col-lg-3 control-label">Student Merit List for  </label> 
			-->
				<div class="row">
				<div>
					<table class="table">
						<thead>
									<tr>
										<th >Sr. No</th>
										<th>Applicant ID</th>
										<th>Name of the Applicant</th>
										<th>Status</th>
										<th>Set As Paid</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach step="2" var="User" items="${Users}">


									<tr>
										<td>${User.getId()}</td>
										<td>${User.getAdmissionUserFname()} </td>
										<td>${User.getAdmissionEmail()}</td>
										<td><span class="status status-success">Approved</span></td>
										<td><form>
										<input type="checkbox" name=""></td>
									</tr>
								</c:forEach>	
									<!-- tr>
										<td>2</td>
										<td>Kyne </td>
										<td>Kynerty@example.com</td>
										<td><span class="status status-primary">Important</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>3</td>
										<td>dude </td>
										<td>dudedeo@example.com</td>
										<td><span class="status status-warning">Suspended</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>4</td>
										<td >Jeju </td>
										<td>jeju@example.com</td>
										<td><span class="status status-danger">Blocked</span></td>
									<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>5</td>
										<td>Jenifer </td>
										<td>jenifer@example.com</td>
										<td><span class="status status-pending">Pending</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>6</td>
										<td>chittu </td>
										<td>chittu@example.com</td>
										<td><span class="status status-warning">Suspended</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
										</tr>
									<tr>
										<td>7</td>
										<td>Mouni </td>
										<td>mouni@example.com</td>
										<td><span class="status status-success">Approved</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>8</td>
										<td>Hari </td>
										<td>hari@example.com</td>
										<td><span class="status status-success">Approved</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>9</td>
										<td>Munna </td>
										<td>munna@example.com</td>
										<td><span class="status status-pending">Pending</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>10</td>
										<td>Uma </td>
										<td>uma@example.com</td>
										<td><span class="status status-pending">Pending</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>11</td>
										<td>Teeti</td>
										<td>teeti@example.com</td>
										<td><span class="status status-danger">Blocked</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>12</td>
										<td>Vijju </td>
										<td>vijjuanu@example.com</td>
										<td><span class="status status-primary">Important</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>13</td>
										<td>Anu </td>
										<td>anu@example.com</td>
										<td><span class="status status-primary">Important</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>14</td>
										<td>Tinku </td>
										<td>tinku@example.com</td>
										<td><span class="status status-danger">Blocked</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>15</td>
										<td>Veeru </td>
										<td>veeru@example.com</td>
										<td><span class="status status-pending">Pending</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>16</td>
										<td>Venkat </td>
										<td>venkat@example.com</td>
										<td><span class="status status-warning">Suspended</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>17</td>
										<td>Honey </td>
										<td>honey@example.com</td>
										<td><span class="status status-success">Approved</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr>
									<tr>
										<td>18</td>
										<td>Hundy </td>
										<td>hundy@example.com</td>
										<td><span class="status status-success">Approved</span></td>
										<td><form>
										<input type="checkbox" name="" ></td>
									</tr-->
								</tbody>
							</table>							
						</div> <!-- /panel body -->
			</div>
   <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>		
</body>
</html>
