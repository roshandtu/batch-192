<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
</head>
<body>
	<form action="registerCtrl" method="post">
		<table>
			<tr>
				<td>Empno:
				<td><input type="text" name="empno" />
			</tr>
			<tr>
				<td>Name:
				<td><input type="text" name="name" />
			</tr>
			<tr>
				<td>Password:
				<td><input type="password" name="password" />
			</tr>
			<tr>
				<td>Mobile:
				<td><input type="number" name="mob" />
			</tr>
			<tr>
				<td>Salary:
				<td><input type="number" name="salary" />
			</tr>
			<tr>
				<td>Department:
				<td><input type="number" name="dept" />
			</tr>
			<tr>
				<td>Email:
				<td><input type="email" name="email" />
			</tr>
			<tr>
				<td><input type="submit" value="Register" name="bttn" />
			</tr>
		</table>
	</form>
</body>
</html>