<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*"  %>
     
<%

HttpSession mysession=request.getSession();
if(mysession.getAttribute("usersession")!=null)
{
	response.sendRedirect("Profile.jsp");	
}

%>  
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>


  <meta charset="utf-8">
  <title>Welcome to Skimmdit</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="resources/css/style.css">
  <script src="resources/js/popup.js" ></script>
</head>
<body>
 
<div id="dialog-form" title="Create new user">
  <p class="validateTips">All form fields are required.</p>
 
  <form action="register" id="Register" method="post">
    <fieldset>
      <label for="name">Name</label>
      <input type="text" name="userName" id="name" placeholder="User Name" class="text ui-widget-content ui-corner-all">
      <label for="email">Email</label>
      <input type="text" name="email" id="email" placeholder="Email" class="text ui-widget-content ui-corner-all">
      <label for="password">Password</label>
      <input type="password" name="password" id="password" placeholder="xxxxxxx" required class="text ui-widget-content ui-corner-all">
 
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  </form>
</div>
 

<!--  <button id="create-user">Create new user</button>-->
<div style="width:100%;height:15px;border-bottom:1px solid black;background-color:#f0f0f0;"></div>
<div style="width:100%;height:50px;border-bottom:1px solid black;background-color:#8FBBE6;">
<div id="logo" style="padding:15px">
<span style="color:white;font-size:24px;">Skimmdit</span>
</div>
</div>
<form action="Login" method="post">
<div style="width:100%">
<div style="float:right;padding:5px;border:1px solid black">

<div style="float:left;margin-right:10px">
<span style="font-size:18px">User Name:</span><input type="text" name="userName" required width="20px"/>
</div>
<div style="float:left;margin-bottom:10px">
<span style="font-size:18px">Password:</span><input type="password" name="password" required width="20px"/>
</div> 
<div style="clear:left;float:right;border:1px solid black">
<input type="submit" value="login" />
</div>
</div>
</div> 
 </form>
 <a id='create-user'>register your self</a>

  <p>&nbsp</p>
   <p>&nbsp</p>
<div id="div1"></div>
</body>
</html>

<%
		if(request.getAttribute("register")=="success")
		{
		out.println("<span style='color:red'>User Successfully Register</span> <a id='create-user'>clickhere</a>");	
		}
		if(request.getAttribute("register")=="exist")
		{
		out.println("<span style='color:red'>User Already Exist</span>");
		}
		if(request.getAttribute("register")=="authfailed")
		{
		out.println("<span style='color:red'>User Authentication Failed</span>");
		}
		if(request.getAttribute("register")=="newuser")
		{
		out.println("<span style='color:red'>New User Created</span>");
		}
%>
<script>

$.ajax({

url: "sortedlinks", 

success: function(result){

	
        $("#div1").html(result);

    }});
</script>
