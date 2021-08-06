

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSess
 */
@WebServlet("/LoginSess")
public class LoginSess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSess() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		PrintWriter pw = res.getWriter();
		
		String u = req.getParameter("uname"),
				p = req.getParameter("pass");
		
		HttpSession s = req.getSession(true);	//create new session
		
		if(u.equals("user") && p.equals("user")) {
			s.setAttribute("uname", u);
			res.sendRedirect("page2.html");
		}
		else {
			res.sendRedirect("login1.html");
		}	
		
	}
	

}



