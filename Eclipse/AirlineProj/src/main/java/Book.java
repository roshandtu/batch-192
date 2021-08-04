

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sb = request.getParameter("search");
		String bk = request.getParameter("fl-book");
		
		if(sb != null) {
			if(sb.equalsIgnoreCase("View All Flights")) {
				response.setContentType("text/html");
				request.getRequestDispatcher("AllFlights.jsp").forward(request, response);
			}
			
			else if(sb.equalsIgnoreCase("Search Flights")) {
				HttpSession sess = request.getSession(true);
				String fl_trip = request.getParameter("trip"),
						fl_pass_count = request.getParameter("passenger-count");
				
				if(fl_pass_count != null && !fl_pass_count.equals("")) {
					sess.setAttribute("pass_count", fl_pass_count);
				}
				
				if(fl_trip != null) {
					if(fl_trip.equals("round")) {
						sess.setAttribute("t_count", "2");
					}
					else {
						sess.setAttribute("t_count", "1");
					}
				}
				response.setContentType("text/html");
				request.getRequestDispatcher("SearchFlights.jsp").forward(request, response);
			}		
			
		}
		
		else if(bk != null) {
			if(bk.equalsIgnoreCase("Book")) {
				response.setContentType("text/html");
				request.getRequestDispatcher("PassengerDet.jsp").forward(request, response);
			}
		}
	}

}
