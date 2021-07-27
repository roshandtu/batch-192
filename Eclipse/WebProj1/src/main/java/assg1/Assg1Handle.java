package assg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Assg1Handle
 */
@WebServlet("/assg1/Assg1Handle")
public class Assg1Handle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assg1Handle() {
        super();
    }
    
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		
		res.addHeader("Content-type", "text/html");
		System.out.println(req.getMethod() + " - " + req.getRequestURI());
		Connection conn = null;
		PreparedStatement st = null;
		
		String action = req.getParameter("type"),
				eno, name, mob, salary, dept, email;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "mphasis", "1234");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if(action.equals("selectall")) {
			try {
				name = req.getParameter("name");
				
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
					pw.println("<table border=1>");
					pw.println("<tr>");
					pw.println("<th> Employee No.");
					pw.println("<th> Name");
					pw.println("<th> Email");
					pw.println("<th> Mobile No.");
					pw.println("<th> Salary");
					pw.println("<th> Department");
					pw.println("<th> Designation");
					pw.println("</tr>");
					while(rs.next()) {
						pw.println("<tr>");
						pw.println("<td>" + rs.getString("empno"));
						pw.println("<td>" + rs.getString("name"));
						pw.println("<td>" + rs.getString("email"));
						pw.println("<td>" + rs.getString("mob"));
						pw.println("<td>" + rs.getString("salary"));
						pw.println("<td>" + rs.getString("dept"));
						pw.println("<td>" + rs.getString("desig"));
						pw.println("</tr>");
					}
					pw.println("</table>");
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
		
		else if(action.equals("insert")) {
			try {
				name = req.getParameter("name");
				mob = req.getParameter("mob");
				salary = req.getParameter("sal");
				dept = req.getParameter("dept");
				email = req.getParameter("email");
				
				st = conn.prepareStatement("INSERT INTO employees VALUES(new_emp_no(), ?, ?, ?, ?, emp_desig(?), ?)");
//				name, mob, salary, dept, salary
				
				st.setString(1, name);
				st.setLong(2, Long.parseLong(mob));
				st.setInt(3, Integer.parseInt(salary));
				st.setInt(4, Integer.parseInt(dept));
				st.setInt(5, Integer.parseInt(salary));
				st.setString(6, email);
				
				if(!st.execute()) {
					if(st.getUpdateCount() > 0) {
						System.out.println("Success");
						pw.println("Inserted successfully <br />");
					}
					else {
						System.out.println("Error");
						pw.println("Not inserted <br />");
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
		
		else if(action.equals("update")) {
			try {
				eno = req.getParameter("empno");
				name = req.getParameter("name");
				mob = req.getParameter("mob");
				salary = req.getParameter("sal");
				dept = req.getParameter("dept");
				email = req.getParameter("email");
				
				st = conn.prepareStatement("UPDATE employees SET name=?, mob=?, salary=?, dept=?, desig=emp_desig(?), email=? WHERE empno=?");
//				name, mob, salary, dept, salary
				
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
						pw.println("Updated successfully <br />");
					}
					else {
						System.out.println("Error");
						pw.println("Not updated <br />");
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
		
		else if(action.equals("delete")) {
			try {
				eno = req.getParameter("empno");
				
				st = conn.prepareStatement("DELETE employees WHERE empno=?");
//				name, mob, salary, dept, salary
				
				st.setInt(1, Integer.parseInt(eno));
				
				if(!st.execute()) {
					if(st.getUpdateCount() > 0) {
						System.out.println("Success");
						pw.println("Deleted successfully <br />");
					}
					else {
						System.out.println("Error");
						pw.println("Not deleted <br />");
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
	}

	

}
