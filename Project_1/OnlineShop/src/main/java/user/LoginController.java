
package user;

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
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String un = request.getParameter("uname");
		String pwd = request.getParameter("pass");

		if(!un.equals("") || un != null) {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");
				PreparedStatement ps = con.prepareStatement("SELECT * FROM proj1_users WHERE LOWER(email)=LOWER(?) AND password=?");
				
				ps.setString(1,un);
				ps.setString(2, pwd);
				
				if(ps.execute()) {
					ResultSet rs = ps.getResultSet();
					if(rs.next()) {
						HttpSession sess = request.getSession();
						sess.setAttribute("uname", rs.getString("name"));
						sess.setAttribute("uemail", rs.getString("email"));
						sess.setAttribute("uid", rs.getString("id"));
						
						
						response.sendRedirect("index.jsp");
					}
					else {
						response.sendRedirect("login.html?e=error");
					}
				}
				
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		} 
	}
}