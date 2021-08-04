

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookie
 */
@WebServlet("/GetCookie")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		
		Cookie c[] = req.getCookies();
		
		res.setContentType("text/html");
		
		pw.println("<a href='cookie.html'>Go Back</a><br>");
		
		for(int i = 0; i < c.length; i++) {
			pw.println("<br>");
			pw.println("Cookie Name: " + c[i].getName());
			pw.println("<br>Cookie Value: " + c[i].getValue());
			pw.println("<hr><br>");
		}
		
		
	}

}
