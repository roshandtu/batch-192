package cart;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addCart")
public class addCart extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String pid = request.getParameter("pid");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM proj1_products WHERE id=?");
			if(pid != null) {
				ps.setInt(1, Integer.parseInt(pid));
				
				if(ps.execute()) {
					ResultSet rs = ps.getResultSet();
					if(rs.next()) {
						Product p = new Product();
						p.setId(rs.getInt("id"));
						p.setName(rs.getString("name"));
						p.setPrice(rs.getFloat("price"));
						p.setImage(rs.getString("image"));
						p.setCategory(rs.getString("category"));
						p.setCount(1);
						
						HttpSession sess = request.getSession();
						
						if(sess.getAttribute("items") != null) {
							List<Product> plist = (List<Product>) sess.getAttribute("items");
							boolean f = false;
							
							for(int i = 0; i < plist.size(); i++) {
								if(plist.get(i).getId() == p.getId()) {
									plist.get(i).setCount(plist.get(i).getCount() + p.getCount());
									f = true;
									break;
								}
							}
							
							if(!f) {
								plist.add(p);
							}					
							
							
							sess.setAttribute("items", plist);							
						}
						else {
							List<Product> plist = new ArrayList<Product>();
							plist.add(p);
							sess.setAttribute("items", plist);
						}
					}
				}
				
				con.close();
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {               			
			response.sendRedirect("index.jsp");
			out.close();
		}     


	}
}