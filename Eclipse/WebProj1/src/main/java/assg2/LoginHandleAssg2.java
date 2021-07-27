package assg2;

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
 * Servlet implementation class LoginHandleAssg2
 */
@WebServlet("/assg2/LoginHandleAssg2")
public class LoginHandleAssg2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandleAssg2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String a = req.getParameter("a2"),
				name, mob, salary, dept, email, pass;
		
		PrintWriter pw = res.getWriter();		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "mphasis", "1234");
				
				if(a.equals("Login")) {
					PreparedStatement st = conn.prepareStatement("SELECT name FROM employees WHERE LOWER(name)=LOWER(?) AND password=?");
					name = req.getParameter("uname");
					pass = req.getParameter("pass");
					
					st.setString(1, name);
					st.setString(2, pass);
					
					ResultSet rs = st.executeQuery();
					
					if(rs.next()) {
						res.sendRedirect("success.html?m=" + rs.getString("name"));
					}
					else {
						res.sendRedirect("error.html");
					}
				}
				
				else if(a.equals("Register")) {
					name = req.getParameter("name");
					mob = req.getParameter("mob");
					salary = req.getParameter("sal");
					dept = req.getParameter("dept");
					email = req.getParameter("email");
					pass = req.getParameter("pass");
					
					PreparedStatement st = conn.prepareStatement("INSERT INTO employees VALUES(new_emp_no(), ?, ?, ?, ?, emp_desig(?), ?, ?)");
					
					st.setString(1, name);
					st.setLong(2, Long.parseLong(mob));
					st.setInt(3, Integer.parseInt(salary));
					st.setInt(4, Integer.parseInt(dept));
					st.setInt(5, Integer.parseInt(salary));
					st.setString(6, email);
					st.setString(7, pass);
					
					if(!st.execute()) {
						if(st.getUpdateCount() > 0) {
							System.out.println("Success");
							res.sendRedirect("login.html");
						}
						else {
							System.out.println("Error");
							pw.println("Not inserted");
						}
					}
					
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
