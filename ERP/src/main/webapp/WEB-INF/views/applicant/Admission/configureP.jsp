<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
<TITLE>Configuring bank details</TITLE>
</HEAD>
<BODY>
<FORM action="/trans_id3a" method="POST">
<INPUT NAME="amountPaid" TYPE="text" placeholder="Amount Paid" required><br/>
<INPUT NAME="bankName" TYPE="text" placeholder="Bank Name" required><br/>
<INPUT NAME="bankBranch" TYPE="text" placeholder="Bank Branch" required><br/>
<INPUT NAME="bankCity" TYPE="text" placeholder="Bank City" required><br/>
<INPUT NAME="accountNumber" TYPE="text" placeholder="Account Number" required><br/>
<INPUT NAME="accountType" TYPE="text" placeholder="Account Type" required><br/>
<INPUT NAME="IFSCNumber" TYPE="text" placeholder="IFSC Number" required><br/>
<INPUT NAME="accountHolder" TYPE="text" placeholder="Account Holder" required><br/>
<INPUT NAME="appliedUnder" TYPE="text" placeholder="Applied Under Category" required><br/>
<SELECT NAME="semester">
<c:forEach var="i" begin="1" end="8">  
 <OPTION value="${i}">${i}</OPTION>
</c:forEach>   
</SELECT><br/>

<SELECT NAME="role">
<c:forEach items="${UserRoles}" var="personBean">  
 <OPTION value="${personBean}">${personBean}</OPTION>
</c:forEach> 
  
  
</SELECT><br/>

<SELECT NAME="status">
<c:forEach items="${UserStatus}" var="personBean">  
 <OPTION value="${personBean}">${personBean}</OPTION>
</c:forEach> 
 </SELECT><br/>

<INPUT NAME="Submit" TYPE="submit">
</FORM>
</BODY>
</HTML>