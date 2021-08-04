import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.servlet.annotation.*;
@WebServlet("/Login")
public class Login extends HttpServlet
{	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{		
		try
		{	
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			
			String name = req.getParameter("name"),
					pwd = req.getParameter("pwd"),
					desig = req.getParameter("desig"),
					addr = req.getParameter("addr"),
					mob = req.getParameter("mob"),
					email = req.getParameter("email");
			
			
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure().buildSessionFactory();
			Session ss = sf.openSession();
			mypojo pojo=new mypojo();
			
			pojo.setUname(name);
			pojo.setPword(pwd);
			pojo.setDesig(desig);
			pojo.setMob(mob);
			pojo.setAddr(addr);
			pojo.setEmail(email);
			
			Transaction tx = ss.beginTransaction();
			ss.save(pojo);
			tx.commit();
			ss.close();
			res.sendRedirect("login.html");
		}
		catch(Exception ae)
		{		
			ae.printStackTrace();
		}	
	}
}


