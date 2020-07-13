<!-- unused page -->
<!-- refer again later-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet"  href='<c:url value="/web-resources/css/chosen.min.css"/>'>
<script src="<c:url value="/webjars/js/lib/chosen.jquery.min.js" />"></script>
<script src="<c:url value="/webjars/js/lib/addcheckbox.js" />"></script>
<link href='<c:url value="/web-resources/dashboard/css/bootstrap.css"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrap/css/bootstrap-theme.min.css"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrap/css/bootstrap-theme.css.map"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrap/css/bootstrap.css.map"/>' rel="stylesheet">
	


<script type="text/javascript">

function doAjaxOnClick() { 
	var branch = $('#dept').val();  
    var semester = $('#sem').val();  
    var year= $('#ddlyear').val();
    

	        $.ajax({
	            contentType : 'application/json; charset=utf-8',
	            type: "GET",
	            url: "fetchktsubjects",
	            dataType : 'json',
	            data : "branch=" + branch + "&semester=" + semester +"&year=" + year, 
	            success : function(response){
	            	
	            	var m=response;
	                var obj = m ;
	                var item=obj;
	                /* var length=item.length; */
	            	
	                $(document).ready(function(){
	                	//$('#rollNumber').val("111A3025");
	                	//$('#year').val(year);
	                	for(var i=0;i<item.length;i++){
	                		appendCheckBoxes(item[i],i);
	                	}

	                	$('#listofsubjects').fadeIn();
	                	
	                });
	            },
	            error : function(){
	                $(this).html("Error!");
	            }
	        });
	
}

</script>
<script>
function appendCheckBoxes(item,i){
	var type="checkbox"
	var element= document.createElement("input") ;
	element.type=type;
	element.id="listOfKtSubject"+(i+1);					//item.subject;
	element.name="listOfKtSubject";
	element.value=item.subjectId;
	
	 
	var add = document.getElementById("list");
	var label1 = document.createElement("label");
	add.appendChild(element);
	/* label1.htmlFor = "listOfKtSubject"+(i+1);
	label1.textContent =item.subject;
	element.appendChild(label1); */
	$("#listOfKtSubject"+(i+1)).after("<label for='checkbox'>"+item.subject+"</label><br>");
	
}

</script>
<script >
             
$(function() {
var noofyears = 3; // Change to whatever you want
var thisYear = (new Date()).getFullYear();
for (var i = 0; i <= noofyears; i++) {
var year = thisYear - i;
$('<option>', { value: year, text: year }).appendTo("#ddlyear");
}
});
</script> 
<script type="text/javascript">
$(function(){
    $(".chozn-select").chosen({width: "15%"});
});
</script>
<title>KT Form</title>
</head>
<body>


<div style=" border-style: solid; border-width: 1px; border-color:#BCBCBC;padding:4px;"> 
<div style="padding-bottom: 10px; background-color: rgb(231, 231, 231);margin-top: -18px;">
<h3 style="text-transform: uppercase; padding-left: 10px; padding-top: 7px;    margin-bottom: 0px;}">Subject Intermediate Table</h3>

</div>

<%-- <form:form commandName="subjectDatesStore" action="submitForm" method="post" id="submitForm">    
 --%><%-- <form  method="post" id="submitForm"> --%>
  	<br>
  	<select id="dept"  class="chozn-select"> <!-- path="branch" --> 
	<option value="">    --- Select Branch ---   </option>
	<option value="1">    Information Technology  </option>
	<option value="2">    Computer Science   </option>
	<option value="3">    Electronics and Telecommunication </option>
	<option value="4">    Biotechnology  </option>
    <option value="5">     Mechanical Engineering  </option>
    </select>
    
    <br>
  	<select id="sem"  class="chozn-select"> <!-- path="semester"  -->
	<option value="">    --- Select Semester ---   </option>
	<option value="1">    Semester-1  </option>
	<option value="2">    Semester-2  </option>
	<option value="3">    Semester-3  </option>
	<option value="4">    Semester-4  </option>
	<option value="5">    Semester-5  </option>
	<option value="6">    Semester-6  </option>
	<option value="7">    Semester-7  </option>
	<option value="8">    Semester-8  </option>
    </select>
    
    <br>


    
<!-- <div> -->
<!--       <select class="chozn-select"  data-placeholder="Select Year" id="ddlyear"></select> -->
<!-- </div> -->


    <input type="button" value="Get List of Subjects" onclick="doAjaxOnClick()">
		
		<div id="listofsubjects" style="display: none"><b>
		<form:form id="listForm" modelAttribute="ktSubjectsList" action="storektdetails" method="post">


<!-- 		<div class="pure-control-group"> -->
<!--               <label for="rollNumber">Roll Number</label> -->
<%--               <form:input id="rollNumber" path="rollNumber" /> --%>
<!--           </div> -->


          
		 <div class="pure-control-group" id="list">
              <label for="listOfKtSubject">Select the subjects of Kt</label>
              <br>
             
          </div>
		<button type="submit" value="submit">Submit</button>
		
		</form:form>
		</b></div>
				
<br>
<%-- </form> --%>
<%-- </form:form> --%>
</div>

</body>
</html>