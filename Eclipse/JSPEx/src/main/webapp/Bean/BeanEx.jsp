<jsp:useBean id="sr" class="beans.BookDet"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beans</title>
</head>
<body>
	<form action="BeanEx.jsp">
		<select name="pub">
			<option value="pub1"> Pub1 </option>
			<option value="pub2"> Pub2 </option>
			<option value="pub3"> Pub3 </option>
			<option value="pub4"> Pub4 </option>
		</select> <br>
		<input type="submit" name="submit" value="Get Price" />
	</form>
	<br> <br>
	
	<%
		String pu = request.getParameter("pub");
	
		if(pu != null) {
			%>
			<jsp:setProperty property="pub" name="sr"/>
			<jsp:getProperty property="price" name="sr"/>
			<%
		}
	%>	
</body>
</html>