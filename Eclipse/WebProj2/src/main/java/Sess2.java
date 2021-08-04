

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sess2
 */
@WebServlet("/Sess2")
public class Sess2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sess2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		
		String h = req.getParameter("hobby"),
				e = req.getParameter("email"),
				b = req.getParameter("a2");
		
		HttpSession s = req.getSession(false);	//continue session
		
		String u = (String) s.getAttribute("uname");
		
		res.setContentType("text/html");
		pw.println("Username: " + u);
		pw.println("<br>Email Id: " + e);
		pw.println("<br>Hobby: " + h);
		
		req.getRequestDispatcher("logout1.html").include(req, res);
		
		if(b != null && b.equals("logout")) {
			s.invalidate();
			res.sendRedirect("login1.html");
		}
		
	}

}
