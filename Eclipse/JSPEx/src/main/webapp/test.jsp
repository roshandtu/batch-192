<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
<%!
	int a = 1, b =2;
	//dssd
%>

<%-- this is jsp comments--%>

<%
	a = (request.getParameter("a") != null) ? Integer.parseInt(request.getParameter("a")) : a;
%>

<%= a * b %>


</body>
</html>