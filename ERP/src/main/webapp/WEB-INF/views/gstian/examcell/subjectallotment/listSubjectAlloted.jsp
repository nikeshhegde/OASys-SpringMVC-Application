 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Subjects Alloted</title>

<link rel="stylesheet" href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>
<link href='<c:url value="/web-resources/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrap/css/bootstrap-theme.min.css"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrap/css/bootstrap-theme.css.map"/>' rel="stylesheet">
<link href='<c:url value="/web-resources/bootstrap/css/bootstrap.css.map"/>' rel="stylesheet">

<%-- <link rel="stylesheet"
       href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'> --%>
<link rel="stylesheet" 
       href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>
<style type="text/css">
  th {
       text-align: left
  }

</style>
</head>

<body>
   <div style="width: 95%; margin: 0 auto;">
       
        <div id="subjectDialog" style="display: none;">
            <%@ include file="subjectAllotmentForm.jsp"%>
        </div>

        <h1>List Of Subjects Alloted</h1>

        <button class="pure-button pure-button-primary" onclick="addSubject()">
            <i class="fa fa-plus"></i> Allot Subject
         </button>
         <br>
         <table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="3%">S.N</th>
                  <th width="4%">Sub Id</th>
                  <th width="9%">Subject</th>
                  <th width="6%">SubCode</th>
                  <th width="8%">Semester</th>
                  <th width="14%">Branch</th>
                  <th width="4%">Year</th>
                  <th width="6%">Theory Max</th>
                  <th width="7%">Theory Credit</th>
                  <th width="6%">Prac Max</th>
                  <th width="7%">Prac Credits</th>
                  <th width="6%">TermWork</th>
                  <th width="7%">TermWork Credit</th>
                  <th width="6%">IA Max</th>
                  <th width="7%">IA Credit</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${subjectAllotedList}" var="subject" varStatus="loopCounter">
               <tr>
                   <td><c:out value="${loopCounter.count}" /></td>
                   <td><c:out value="${subject.subjectId}" /></td>
                   <td><c:out value="${subject.subject}" /></td>
                   <td><c:out value="${subject.subjectCode}" /></td>
                   <td><c:out value="${subject.semester}" /></td>
                   <td><c:out value="${subject.branch}" /></td>
                   <td><c:out value="${subject.year}" /></td>
                   <td><c:out value="${subject.theoryMax}" /></td>
                   <td><c:out value="${subject.theoryMaxCredit}" /></td>
                   <td><c:out value="${subject.practicalOralMax}" /></td>
                   <td><c:out value="${subject.practicalOralMaxCredit}" /></td>
                   <td><c:out value="${subject.termWorkMax}" /></td>
                   <td><c:out value="${subject.termWorkMaxCredit}" /></td>
                   <td><c:out value="${subject.internalAssessmentMax}" /></td>
                   <td><c:out value="${subject.internalAssessmentMaxCredit}" /></td>
                  

                   <td>
                     <nobr>
                        <button onclick="editAllotment(${subject.subjectId});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit Allotment
                        </button>

                        <a href="delete/${subject.subjectId}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this Allotment?');">
                             <i class="fa fa-times"></i>Delete
                        </a>
                      </nobr>
                   </td>
                </tr>
                </c:forEach>
            </tbody>
         </table>
     </div>

     <!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->
     
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/jquery-1.10.2.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/jquery-ui-1.10.4.custom.js"/>'></script>
   <%--  <script type="text/javascript"
       src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script> --%>
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/js-for-listSubjects.js"/>'></script>
</body>
</html> 