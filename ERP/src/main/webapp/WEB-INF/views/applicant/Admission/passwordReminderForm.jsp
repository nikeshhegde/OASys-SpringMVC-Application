<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SIES GST ERP - Remind Password</title>
 <style>
      			.button_example{
border:3px solid #25729a; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #3093c7; background-image: -webkit-gradient(linear, left top, left bottom, from(#3093c7), to(#1c5a85));
 background-image: -webkit-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -moz-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -ms-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -o-linear-gradient(top, #3093c7, #1c5a85);
 background-image: linear-gradient(to bottom, #3093c7, #1c5a85);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#3093c7, endColorstr=#1c5a85);
 margin-top:20px;
}

.button_example:hover{
 border:3px solid #1c5675;
 background-color: #26759e; background-image: -webkit-gradient(linear, left top, left bottom, from(#26759e), to(#133d5b));
 background-image: -webkit-linear-gradient(top, #26759e, #133d5b);
 background-image: -moz-linear-gradient(top, #26759e, #133d5b);
 background-image: -ms-linear-gradient(top, #26759e, #133d5b);
 background-image: -o-linear-gradient(top, #26759e, #133d5b);
 background-image: linear-gradient(to bottom, #26759e, #133d5b);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#26759e, endColorstr=#133d5b);
}
      
      </style>

</head>
<body>
    <center>
        <h1>Spring MVC - Send e-mail with attachments</h1>
        <form method="post" action="/login/forgotPasswordAction" name="passwordform">
            <table border="0" width="80%">
                <tr>
                    <td>Enter Your Username:</td>
                    <td><input type="text" name="email" size="65" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input class="button_example" type="submit" value="Send E-mail" />
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>