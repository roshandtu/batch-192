<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h1>Error</h1>
	<% exception.printStackTrace(response.getWriter());  %>
</body>
</html>