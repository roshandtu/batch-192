

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


@WebServlet("/Second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Second() {
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		String name = req.getParameter("name"),
				mob = req.getParameter("mob"),
				sal = req.getParameter("sal"),
				dept = req.getParameter("dept"),
				sub = req.getParameter("sub"),
				eno = req.getParameter("empno");
		
		res.addHeader("Content-type", "text/html");
		System.out.println(req.getMethod() + " - " + req.getRequestURI());
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "mphasis", "1234");		
						
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
			pw.println("Error <br />");
		}
		
		if (sub.equals("Insert"))
		{
			try {
				PreparedStatement ins = conn.prepareStatement("INSERT INTO employees VALUES(new_emp_no(), ?, ?, ?, ?, emp_desig(?))");
//				name, mob, salary, dept, salary
				
				ins.setString(1, name);
				ins.setLong(2, Long.parseLong(mob));
				ins.setInt(3, Integer.parseInt(sal));
				ins.setInt(4, Integer.parseInt(dept));
				ins.setInt(5, Integer.parseInt(sal));
				
				if(!ins.execute()) {
					if(ins.getUpdateCount() > 0) {
						System.out.println("Success");
						pw.println("Inserted successfully <br />");
					}
					else {
						System.out.println("Error");
						pw.println("Not inserted <br />");
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Insert Error");
				pw.println("Insert Error <br />");
			}
		}
		
		else if (sub.equals("Update"))
		{
			try {
				PreparedStatement ins = conn.prepareStatement("UPDATE employees SET name=?, mob=?, salary=?, dept=?, desig=emp_desig(?) WHERE empno=?");
//				name, mob, salary, dept, salary
				
				ins.setString(1, name);
				ins.setLong(2, Long.parseLong(mob));
				ins.setInt(3, Integer.parseInt(sal));
				ins.setInt(4, Integer.parseInt(dept));
				ins.setInt(5, Integer.parseInt(sal));
				ins.setInt(6, Integer.parseInt(eno));
				
				if(!ins.execute()) {
					if(ins.getUpdateCount() > 0) {
						System.out.println("Success");
						pw.println("Updated successfully <br />");
					}
					else {
						System.out.println("Error");
						pw.println("Not updated <br />");
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Update Error");
				pw.println("Update Error <br />");
			}
		}
		
		else if (sub.equals("Delete"))
		{
			try {
				PreparedStatement ins = conn.prepareStatement("DELETE employees WHERE empno=?");
//				name, mob, salary, dept, salary
				
				ins.setInt(1, Integer.parseInt(eno));
				
				if(!ins.execute()) {
					if(ins.getUpdateCount() > 0) {
						System.out.println("Success");
						pw.println("Deleted successfully <br />");
					}
					else {
						System.out.println("Error");
						pw.println("Not deleted <br />");
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Delete Error");
				pw.println("Delete Error <br />");
			}
		}
		
		else if (sub.equals("View"))
		{
			try {
				PreparedStatement ins = null;
//				name, mob, salary, dept, salary
				
				if(eno.equals("")) {
					pw.println("View all");
					ins = conn.prepareStatement("SELECT * FROM employees");					
				}
				else {
					ins = conn.prepareStatement("SELECT * FROM employees WHERE empno=?");	
					ins.setInt(1, Integer.parseInt(eno));					
				}
				
				if(ins.execute()) {
					ResultSet rs = ins.getResultSet();
					pw.println("<table>");
					pw.println("<tr>");
					pw.println("<th> Employee No.");
					pw.println("<th> Name");
					pw.println("<th> Mobile No.");
					pw.println("<th> Salary");
					pw.println("<th> Department");
					pw.println("<th> Designation");
					pw.println("</tr>");
					while(rs.next()) {
						pw.println("<tr>");
						pw.println("<td>" + rs.getString("empno"));
						pw.println("<td>" + rs.getString("name"));
						pw.println("<td>" + rs.getString("mob"));
						pw.println("<td>" + rs.getString("salary"));
						pw.println("<td>" + rs.getString("dept"));
						pw.println("<td>" + rs.getString("desig"));
						pw.println("</tr>");
					}
					pw.println("</table>");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Select Error");
				pw.println("Select Error <br />");
			}
		}
		
		
		pw.println("<h1>Submitted Details:</h1>");
		pw.println("Name: " + name);
		pw.println("<br />");
		pw.println("Mobile Number: " + mob);
		pw.println("<br />");
		pw.println("Salary: " + sal);
		pw.println("<br />");
		pw.println("Department number: " + dept);
		pw.println("<br />");
		pw.println("Action: " + sub);
		pw.println("<br />");
		
		
	}


}
