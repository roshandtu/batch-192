//Assignment 2 - Spring MVC
/* 
create table empregistration.
create a registration page .after registration it should redirect to login page.
if login is success then display success page else display failure page
*/


package assg1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVController {
	
	@RequestMapping("/register")
	public ModelAndView registerPage() {
		System.out.println("/register");
		return new ModelAndView("assg1_register");
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		System.out.println("/register");
		return new ModelAndView("assg1_login");
	}
	
	@RequestMapping("/registerCtrl")
	public ModelAndView registerControl(HttpServletRequest request,HttpServletResponse res) throws IOException {
		System.out.println("/registerCtrl");
		
		res.setContentType("text/html");
		String empno = request.getParameter("empno"),
				name = request.getParameter("name"),
				pwd = request.getParameter("password"),
				mob = request.getParameter("mob"),
				sal = request.getParameter("salary"),
				dept = request.getParameter("dept"),
				email = request.getParameter("email");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MPHASIS","1234");
			PreparedStatement st = null;
			
			st = con.prepareStatement("INSERT INTO  employees VALUES (?,?,?,?,?, emp_desig(?),?,?)");
			//EMPNO	NAME	MOB	SALARY	DEPT	DESIG	EMAIL	PASSWORD
			
			st.setInt(1, Integer.parseInt(empno));
			st.setString(2, name);
			st.setString(3,	mob);
			st.setInt(4, Integer.parseInt(sal));
			st.setInt(5, Integer.parseInt(dept));
			st.setInt(6, Integer.parseInt(sal));
			st.setString(7, email);
			st.setString(8, pwd);
			
			if(!st.execute()) {
				if(st.getUpdateCount() > 0) {
					return new ModelAndView("redirect:/login");
				}
			}
			else {
				return new ModelAndView("errorpage", "message", "Could not register");  
			}
		}
		catch(Exception e) {
			e.printStackTrace();	
			return new ModelAndView("errorpage", "message", e);  
		}
		
		return new ModelAndView("assg1_register");
	}
	
	@RequestMapping("/loginCtrl")
	public ModelAndView loginControl(HttpServletRequest request,HttpServletResponse res) throws IOException {
		System.out.println("/loginCtrl");
		
		res.setContentType("text/html");
		String uname = request.getParameter("uname"),
				pass = request.getParameter("pass");
		int empno = 0;
		
		try {
			empno = Integer.parseInt(uname);
		}
		catch (NumberFormatException e) {
			empno = 0;
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MPHASIS","1234");
			PreparedStatement st = null;
			
			st = con.prepareStatement("SELECT * FROM employees WHERE empno=? OR email=? AND password=?");
			//EMPNO	NAME	MOB	SALARY	DEPT	DESIG	EMAIL	PASSWORD
			
			st.setInt(1, empno);
			st.setString(2, uname);
			st.setString(3,	pass);
			
			if(st.execute()) {
				if(st.getResultSet().next()) {
					return new ModelAndView("successpage", "message", "Logged in successfully"); 
				}
				else {
					return new ModelAndView("errorpage", "message", "Could not login"); 
				}
			}
			else {
				return new ModelAndView("errorpage", "message", "Could not login");  
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("errorpage", "message", e);  
		}
	}
}
