<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form method="post" action="loginCtrl">
		<table>
			<tr>
				<td>Empno/ Email
				<td><input type="text" name="uname" />
			</tr>
			<tr>
				<td>Password
				<td><input type="password" name="pass" />
			</tr>
			<tr>
				<td>
				<td><input type="submit" name="loginB" value="Login" />
			</tr>
		</table>
	</form>
</body>
</html>