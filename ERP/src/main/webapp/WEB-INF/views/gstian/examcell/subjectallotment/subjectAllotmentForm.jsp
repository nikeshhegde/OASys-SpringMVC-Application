<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:url var="actionUrl" value="save" />

<form:form id="subjectAllotmentForm" commandName="subjectAlloted" method="post"
       action="${actionUrl }" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="subjectId">Year</label>
              <form:input path="year" placeholder="Enter year" />
          </div>
          <div class="pure-control-group">
               <label for="semester">Semester</label>
               <form:input path="semester" placeholder="semester" maxlength="15" />
          </div>
          <div class="pure-control-group">
              <label for="branch">Branch</label>
              <form:input path="branch" placeholder="Enter Branch" maxlength="50" />
          </div>
          <div class="pure-control-group">
              <label for="subject">Subject(s)</label>
              <form:input path="subject" placeholder="Subject Name" />
          </div>
          <div class="pure-control-group">
              <label for="subjectCode">Subject Code</label>
              <form:input path="subjectCode" placeholder="Enter Subject Code" />
          </div>
          <div class="pure-control-group">
              <label for="theoryMax">Theory Maximum Marks</label>
              <form:input path="theoryMax" placeholder="Enter Theory max marks" />
          </div>
          <div class="pure-control-group">
              <label for="practicalOralMax">Practical/Oral Maximum Marks</label>
              <form:input path="practicalOralMax" placeholder="Enter practical/ oral max"  />
          </div>
           <div class="pure-control-group">
              <label for="termWorkMax">TermWork Maximum Marks</label>
              <form:input path="termWorkMax" placeholder="Enter Max term Work marks" />
          </div>
           <div class="pure-control-group">
              <label for="internalAssessmentMax">Internal Assessment Marks</label>
              <form:input path="internalAssessmentMax" placeholder="Enter IA max marks" />
          </div>
          <div class="pure-control-group">
              <label for="theoryMaxCredit">Theory Maximum Credit</label>
              <form:input path="theoryMaxCredit" placeholder="Enter theory max credit" />
          </div>
          <div class="pure-control-group">
              <label for="practicalOralMaxCredit">Practical Maximum Credit</label>
              <form:input path="practicalOralMaxCredit" placeholder="Enter max practical credit" />
          </div>
          <div class="pure-control-group">
              <label for="termWorkMaxCredit">TermWork Maximum Credit</label>
              <form:input path="termWorkMaxCredit" placeholder="Enter term work max credit" />
          </div>
          <div class="pure-control-group">
              <label for="internalAssessmentMaxCredit">InternalAssesment Maximum Credit</label>
              <form:input path="internalAssessmentMaxCredit" placeholder="Enter IA max credits" />
          </div>
			
          <form:input path="subjectId" type="hidden" />
      </fieldset>
</form:form>

</body>
</html>