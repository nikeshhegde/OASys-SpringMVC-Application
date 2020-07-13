<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Files</title></head>
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.min.css"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap-theme.css.map"/>' rel="stylesheet">
<link href='<c:url value="resources/gstian/bootstrap/css/bootstrap.css.map"/>' rel="stylesheet">


	<link rel="shortcut icon" href='<c:url value="resources/gstian/dashboard/images/favicon.ico"/>'>
<body>
 <c:url var="actionUrl" value="fileuploaded" />
 
 <form:form id="fileUploadForm" modelAttribute="uploadFile" enctype="multipart/form-data" method="POST"
       action="${actionUrl }" class="pure-form pure-form-aligned">

<fieldset>
          <legend></legend>
          
           <div class="pure-control-group">
              <label for="filename">File Name</label>
              <form:input path="filename" placeholder="Enter name of ur choice" />
          </div>
          
           <div class="pure-control-group">
              <label for="location">Enter Location/Directory</label>
              <form:input path="location" value="C:\adi\proj\second" placeholder="Enter location where u want to store" />
          </div>
          
          <div class="pure-control-group">
              <label for="file">Upload File</label>
  				 <form:input type="file" path="file" />
  		  </div>
  		  
  		   <form:input path="fileId" type="hidden" />
 
</fieldset>
</form:form>

</body>
</html>