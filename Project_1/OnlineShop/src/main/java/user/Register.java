package user;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("userName");
		String p = request.getParameter("userPass");
		String e = request.getParameter("userEmail");
		String c = request.getParameter("userCountry");

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");
			PreparedStatement ps = con.prepareStatement("insert into proj1_users values(seq_p1_users.nextval, ?,?,?,?)");
			ps.setString(1, n);
			ps.setString(3, p);
			ps.setString(2, e);
			ps.setString(4, c);

			if(!ps.execute()) {
				con.close();
				if(ps.getUpdateCount() > 0) {
					response.sendRedirect("login.html");
				}
				else {
					response.sendRedirect("register.html");
				}
			}
			else {
				con.close();
				response.sendRedirect("register.html");
			}

		}
		catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}
