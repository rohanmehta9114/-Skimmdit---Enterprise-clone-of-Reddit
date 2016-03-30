<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="resources/js/validate.js" ></script>
		
<title>Insert title here</title>
</head>
<body>

<%

HttpSession mysession=request.getSession();
if(mysession.getAttribute("usersession")!=null)
{
String user=(String)mysession.getAttribute("usersession");
}
else
{
	response.sendRedirect("register.jsp");
}

%>
</body>
<form name="submitForm" action="submitlink" method="post" onsubmit="return(validate());">
<table>
<tr><td>
Title:<input type="text" name="title" />
</td>
<td id="title1" style="color: red; display: none;"><center>Please enter a proper title!!!</center></td>
</tr>
<tr><td>
Link:<textarea rows="6" cols="50" name="url" id="url"> 
</textarea>
</td>
<td  name="link1" id="link1" style="color: red; display: none;"><center>Please enter a proper Link!!!</center></td></tr>
</table>
<input type="submit" />
</form> 
</html>