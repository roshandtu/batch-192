

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airline.FlightDAO;

/**
 * Servlet implementation class getData
 */
@WebServlet("/getData")
public class getData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String t = request.getParameter("type");		
		if(t != null) {
			Connection con = null;			
			PreparedStatement st = null;
			
			if(t.equals("places")) {
				String qf, qt, ret;
				qf = "SELECT DISTINCT origin FROM flight";
				qt = "SELECT DISTINCT dest FROM flight";
				ret = "{";
				try {
					con = FlightDAO.getConnection();
					ResultSet rs = con.prepareStatement(qf, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
					
					ret = ret + "\"from\": [";
					while (rs.next()) {
						ret = ret + "\"" + rs.getString("origin") + "\"";
						if(!rs.isLast()) {
							ret = ret + ",";
						}
						
					}
					
					rs = con.prepareStatement(qt, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
					
					
					ret = ret + "], \"to\": [";
					while (rs.next()) {
						ret = ret + "\"" + rs.getString("dest") + "\"";
						if(!rs.isLast()) {
							ret = ret + ",";
						}
						
					}
					
					ret = ret + "]}";
					
					rs.close();
					con.close();
					
					response.getWriter().println(ret);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
