<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Employee Details</title>
</head>
<body>
	<form action="getEmpDet.jsp" method="post">
		<input type="text" name="name">
		<input type="submit" value="search" name="bttn">
	</form>
	<br> <br>
	<%
	String but = request.getParameter("bttn");
	
	if (but != null) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "mphasis", "1234");
			
			PreparedStatement st = null;
			
			String name = request.getParameter("name");
			
			if(name.equals("")) {
				st = conn.prepareStatement("SELECT * FROM employees ORDER BY empno");	
			}
			
			else {
				st = conn.prepareStatement("SELECT * FROM employees WHERE LOWER(name) LIKE LOWER('%' || ? || '%') ORDER BY empno");
				
				st.setString(1, name);
			}
			
			ResultSet rs;
			
			if(st.execute()) {
				rs = st.getResultSet();
				out.println("<table border=1>");
				out.println("<tr>");
				out.println("<th> Employee No.");
				out.println("<th> Name");
				out.println("<th> Email");
				out.println("<th> Mobile No.");
				out.println("<th> Salary");
				out.println("<th> Department");
				out.println("<th> Designation");
				out.println("</tr>");
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>" + rs.getString("empno"));
					out.println("<td>" + rs.getString("name"));
					out.println("<td>" + rs.getString("email"));
					out.println("<td>" + rs.getString("mob"));
					out.println("<td>" + rs.getString("salary"));
					out.println("<td>" + rs.getString("dept"));
					out.println("<td>" + rs.getString("desig"));
					out.println("</tr>");
				}
				out.println("</table>");
			}
		}
		catch (Exception e) {
			out.println("Error: " + e);
		}
	}		
		
	%>
</body>
</html>