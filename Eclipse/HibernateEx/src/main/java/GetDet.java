

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.Configuration;
import org.hibernate.*;

/**
 * Servlet implementation class GetDet
 */
@WebServlet("/GetDet")
public class GetDet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Configuration cfg=new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session ss=sf.openSession();
		mypojo pojo = new mypojo();
		Transaction tx = ss.beginTransaction();
		Query q = ss.createQuery("from mypojo");
		List stud = q.list();
		Iterator it = stud.iterator();
		while(it.hasNext())
		{
			pojo = (mypojo) it.next();
			System.out.println(pojo.getUname());
			
			pw.println("EMPNO: " + pojo.getEmpno());
			pw.println("<br>");
			pw.println("NAME: " + pojo.getUname());
			pw.println("<br>");
			pw.println("EMAIL: " + pojo.getEmail());
			pw.println("<br>");
			pw.println("DESIGNATION: " + pojo.getDesig());
			pw.println("<br>");
			pw.println("MOBILE: " + pojo.getMob());
			pw.println("<br>");
			pw.println("ADDRESS: "  + pojo.getAddr());
			pw.println("<br>");
			pw.println("PASSWORD: " + pojo.getPword());
			
			pw.println("<br>");
			pw.println("<hr>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
