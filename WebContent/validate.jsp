<script type="text/javascript">
<%
		if(request.getAttribute("register")=="success")
		{
		%>
		out.println("<span style='color:red'>User Successfully Register</span> <a id='create-user'>clickhere</a>");
		<%
		}
		if(request.getAttribute("register")=="exist")
		{
		%>
		out.println("<span style='color:red'>User Already Exist</span>");
		<%
		}
		if(request.getAttribute("register")=="authfailed")
		{
		%>
		out.println("<span style='color:red'>User Authentication Failed</span>");
		<%
		}
		if(request.getAttribute("register")=="newuser")
		{
		%>
		out.println("<span style='color:red'>New User Created</span>");
		<%
		}
%>
</script>
