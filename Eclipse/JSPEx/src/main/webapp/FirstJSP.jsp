<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- --%>    
<%@ page errorPage="FirstError.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
    <form action="FirstJSP.jsp" method="post">
        <input type="text" name="empno" placeholder="Employee Number" />  <br>
        <input type="text" name="name" placeholder="Name" />  <br>
        <input type="text" name="mob" placeholder="Phone Number" /> <br> 
        <input type="text" name="sal" placeholder="Salary" />  <br>
        <input type="text" name="dept" placeholder="Department" /> <br>     
        <input type="submit" value="Submit">  <br>
    </form>

    <div>
        <% 
            String a = request.getParameter("empno"),
            		b = request.getParameter("name"),
            		c = request.getParameter("mob"),
            		d = request.getParameter("sal"),
            		e = request.getParameter("dept");
        
        	int sal = (d == null) ? 0 : Integer.parseInt(d);
        
        	if(a != null) {
        		out.println("<h1>Result</h1>");
        		out.println("Employee Number: " + a);
        		out.println("<br>Employee Name: " + b);
        		out.println("<br>Employee Mobile Number: " + c);
        		out.println("<br>Employee Salary: " + d);
        		out.println("<br>Employee Department: " + e);
        	}
        %>
		
		<jsp:include page="getEmpDet.jsp"></jsp:include>
	</div>
</body>
</html>