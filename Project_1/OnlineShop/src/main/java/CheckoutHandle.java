

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.Product;

/**
 * Servlet implementation class CheckoutHandle
 */
@WebServlet("/CheckoutHandle")
public class CheckoutHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("ch-name"),
				addr = request.getParameter("ch-address"),
				pin = request.getParameter("ch-pin"),
				cname = request.getParameter("ch-nameoncard"),
				cnum = request.getParameter("ch-cardno"),
				cmm = request.getParameter("ch-cardexpmonth"),
				cyy = request.getParameter("ch-cardexpyear");
		HttpSession sess = request.getSession(false);
		
		List<Product> plist = (List<Product>) sess.getAttribute("items");
		
		try {		
			
			if(plist != null) {
				int uid = 0;
				if(sess.getAttribute("uid") != null) {
					uid = Integer.parseInt((String) sess.getAttribute("uid"));
				}
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");
				
				PreparedStatement ps = con.prepareStatement("INSERT INTO proj1_checkout VALUES (seq_p1_checkout.nextval, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				ps.setString(1, name);
				ps.setString(2, addr);
				ps.setInt(3, Integer.parseInt(pin));
				ps.setString(4, cnum);
				ps.setString(5, cname);
				ps.setInt(6, Integer.parseInt(cmm));
				ps.setInt(7, Integer.parseInt(cyy));
				ps.setInt(8, uid);
				
				if(!ps.execute()) {
					if(ps.getUpdateCount() > 0) {
						ResultSet rs = con.createStatement().executeQuery("SELECT seq_p1_checkout.currval FROM DUAL");
						rs.next();
						int chid = rs.getInt(1);
						
						PreparedStatement ps2 = con.prepareStatement("INSERT INTO proj1_items VALUES (seq_p1_items.nextval, ?, ?, ?)");
						
						for(Product p : plist) {
							ps2.setInt(1, p.getId());
							ps2.setInt(2, chid);
							ps2.setInt(3, p.getCount());
							
							ps2.execute();
						}						
					}
				}
				
				con.close();
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			response.sendRedirect("index.jsp");
			sess.removeAttribute("items");
		}
	}

}
