<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0);%>
</head>
<body>

<div style="float:right">
<h1>Welcome 
<%
String user=null;
HttpSession mysession=request.getSession();
if(mysession.getAttribute("usersession")!=null)
{

user=(String)mysession.getAttribute("usersession");

out.println(user);
	
}
else
{
	response.sendRedirect("register.jsp");
}

%>
 To Your Profile Page</h1>
<%


%>
<a href="submitlink">Submit Link</a>

<a href="logout">Logout</a>

</div>

<div id="div1">
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>

$.ajax({

url: "sortedlinks", 

success: function(result){

	
        $("#div1").html(result);

    }});
</script>
</body>
</html>