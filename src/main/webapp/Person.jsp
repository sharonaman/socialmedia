<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="BEAN.Variable"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>ID</th>
<th>NAME</th>
<th>PASSWORD</th>

</tr>
<%
	ArrayList<Variable> person=(ArrayList<Variable>) session.getAttribute("person");
for(Variable data:person)
{
	%>
	<tr>
	<th><%= data.getId() %></th>
	<th><%= data.getName() %></th>
	<th><%= data.getPassword()%></th>
	
	<form action="Controller" method="post">
	<input type="hidden" name="id" value=<%= data.getId()%>>
	</form>
	
	</th>
	</tr>
	
	
<%	
}

%>
</table>
</body>
</html>