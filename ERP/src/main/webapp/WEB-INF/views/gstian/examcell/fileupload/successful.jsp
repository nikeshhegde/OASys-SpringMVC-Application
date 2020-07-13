 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Successfully Uploaded</title>

<link rel="stylesheet" href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
       href="resources/gstian/bootstrap/fonts/font-awesome.min.css">
<link rel="stylesheet" 
       href='<c:url value="resources/gstian/css/jquery-ui-1.10.4.custom.css"/>'>
<style type="text/css">
  th {
       text-align: left
  }

</style>
</head>

<body>
   <div style="width: 95%; margin: 0 auto;">
       
        <div id="fileuploadDialog" style="display: none;">
            <%@ include file="uploadForm.jsp"%>
        </div>

        <h1>List of files uploaded</h1>

        <button class="pure-button pure-button-primary" onclick="uploadTheFile()">
            <i class="fa fa-plus"></i> Upload File
         </button>
         <br>
         <table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="10%">S.N</th>
                  <th width="10%">File Id</th>
                  <th width="20%">File Name</th>
                  <th width="40%">File Directory/ Location</th>
                  <th width="20%">Date Created</th>
                  
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${filesUploadList}" var="files" varStatus="loopCounter">
               <tr>
                   <td><c:out value="${loopCounter.count}" /></td>
                   <td><c:out value="${files.fileId}" /></td>
                   <td><c:out value="${files.filename}" /></td>
                   <td><c:out value="${files.location}" /></td>
                   <td><c:out value="${files.dateCreated}" /></td>                 
                   <td>
                     <nobr>
                        <a href="convert/${files.fileId}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to convert csv file to database table?');">
                             <i class="fa fa-times"></i>Convert
                        </a>

                        <a href="deletefile/${files.fileId}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this previously uploaded file?');">
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
       src='<c:url value="resources/gstian/js/jquery-1.10.2.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="resources/gstian/js/jquery-ui-1.10.4.custom.js"/>'></script>
   <%--  <script type="text/javascript"
       src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script> --%>
    <script type="text/javascript"
       src='<c:url value="resources/gstian/js/js-for-listFiles.js"/>'></script>
</body>
</html> 