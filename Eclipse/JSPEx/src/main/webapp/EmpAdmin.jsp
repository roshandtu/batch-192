<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<style>
    .hidden {
        display: none;
    }
    input, select {
        margin: 5px 0;
        font-size: 1.2em;
        padding: 5px;
    }
    #formData {
        display: flex;
        flex-direction: row;
        width: 80%;
        min-width: 400px;
        flex-wrap: wrap;
    }

    p {
        width: 20%;
        margin: auto 0;
    }

    input[type='text'], input[type='number'] {
        width: 75%;
    }

</style>
</head>
<body>
	<form action="EmpAdmin.jsp" method="post">
        <select name="type" id="type" onchange="updateForm(this.value)">
            <option value="null">---Select---</option>
            <option value="selectall">View Employee Details</option>
            <option value="insert">Add New Employee</option>
            <option value="update">Modify Employee Data</option>
            <option value="delete">Remove An Employee</option>
        </select>
        <div id="formData"></div>
        <input type="submit" value="Submit" disabled />
    </form>


    <div class="hidden" id="insertData">
        <p>Name</p>
        <input type="text" name="name" placeholder="Employee Name" /> <br>
        <p>Email</p>
        <input type="text" name="email" placeholder="Email ID" /> <br>
        <p>Mobile Number</p>
        <input type="number" name="mob" placeholder="Mobile Number" /> <br>
        <p>Salary</p>
        <input type="number" name="sal" placeholder="Salary" /> <br>
        <p>Department Number</p>
        <input type="number" name="dept" placeholder="Department Number" /> <br>
    </div>

    <div class="hidden" id="updateData">
        <p>Employee Number</p>
        <input type="number" name="empno" placeholder="Employee Number" /> <br>
        <p>Name</p>
        <input type="text" name="name" placeholder="Employee Name" /> <br>
        <p>Email</p>
        <input type="text" name="email" placeholder="Email ID" /> <br>
        <p>Mobile Number</p>
        <input type="number" name="mob" placeholder="Mobile Number" /> <br>
        <p>Salary</p>
        <input type="number" name="sal" placeholder="Salary" /> <br>
        <p>Department Number</p>
        <input type="number" name="dept" placeholder="Department Number" /> <br>
    </div>

    <div class="hidden" id="deleteData">
        <p>Employee Number</p>
        <input type="number" name="empno" placeholder="Employee Number" /> <br>
    </div>

    <div class="hidden" id="selectallData">
        <p>Name</p>
        <input type="text" name="name" placeholder="Employee Name (Optional)" /> <br>
    </div>
	

	<%
		String but = request.getParameter("type");
		String name, mob, salary, dept, email, eno;
		if(but != null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "mphasis", "1234");
			PreparedStatement st;
			
			if(but.equals("insert")) {
				try {
					name = request.getParameter("name");
					mob = request.getParameter("mob");
					salary = request.getParameter("sal");
					dept = request.getParameter("dept");
					email = request.getParameter("email");
					
					st = conn.prepareStatement("INSERT INTO employees VALUES(new_emp_no(), ?, ?, ?, ?, emp_desig(?), ?, LOWER(?))");
//					name, mob, salary, dept, salary
					
					st.setString(1, name);
					st.setLong(2, Long.parseLong(mob));
					st.setInt(3, Integer.parseInt(salary));
					st.setInt(4, Integer.parseInt(dept));
					st.setInt(5, Integer.parseInt(salary));
					st.setString(6, email);
					st.setString(7, name);
					
					if(!st.execute()) {
						if(st.getUpdateCount() > 0) {
							System.out.println("Success");
							out.println("Inserted successfully <br />");
						}
						else {
							System.out.println("Error");
							out.println("Not inserted <br />");
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
			else if(but.equals("selectall")) {
				try {
					name = request.getParameter("name");
					
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
				catch (Exception e)
				{
					e.printStackTrace();
				}			
			}
			
			else if(but.equals("update")) {
				try {
					eno = request.getParameter("empno");
					name = request.getParameter("name");
					mob = request.getParameter("mob");
					salary = request.getParameter("sal");
					dept = request.getParameter("dept");
					email = request.getParameter("email");
					
					st = conn.prepareStatement("UPDATE employees SET name=?, mob=?, salary=?, dept=?, desig=emp_desig(?), email=? WHERE empno=?");
//					name, mob, salary, dept, salary
					
					st.setString(1, name);
					st.setLong(2, Long.parseLong(mob));
					st.setInt(3, Integer.parseInt(salary));
					st.setInt(4, Integer.parseInt(dept));
					st.setInt(5, Integer.parseInt(salary));
					st.setString(6, email);
					st.setInt(7, Integer.parseInt(eno));
					
					if(!st.execute()) {
						if(st.getUpdateCount() > 0) {
							System.out.println("Success");
							out.println("Updated successfully <br />");
						}
						else {
							System.out.println("Error");
							out.println("Not updated <br />");
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}			
			}
			
			else if(but.equals("delete")) {
				try {
					eno = request.getParameter("empno");
					
					st = conn.prepareStatement("DELETE employees WHERE empno=?");
//					name, mob, salary, dept, salary
					
					st.setInt(1, Integer.parseInt(eno));
					
					if(!st.execute()) {
						if(st.getUpdateCount() > 0) {
							System.out.println("Success");
							out.println("Deleted successfully <br />");
						}
						else {
							System.out.println("Error");
							out.println("Not deleted <br />");
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}			
			}
		}
		
	%>
</body>

<script>
    
    function updateForm(val) {
        var bd = document.getElementById("formData");
        var sb = document.querySelector("input[type='submit'");
            
        if(val == "null") {
            bd.innerHTML = "";
        }
        else {
            var fd = document.getElementById(val + "Data");
            bd.innerHTML = fd.innerHTML;
        }      
        
        sb.disabled = false;
        switch(val) {
            case "insert" : sb.value = "Insert"; break;
            case "delete" : sb.value = "Delete"; break;
            case "update" : sb.value = "Update"; break;
            case "selectall" : sb.value = "View Details"; break;
            default: sb.value = "Select an action";
                    sb.disabled = true;
        }        
    }
</script>

</html>