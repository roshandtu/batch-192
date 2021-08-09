package com.javatpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@Controller
public class HelloWorldController 
{

	@RequestMapping("/hello")
	public ModelAndView helloWorld(){
		String message1="Hello Spring MVC how r u";
		return new ModelAndView("hellopage","message",message1);//output jsp page is hellopage.jsp
	}
	@RequestMapping("/welcome")
	public ModelAndView welcomeWorld(){
		String message1="Hello Welcome to Spring MVC";
		return new ModelAndView("welcome","message",message1);//output jsp page is wecome.jsp
	}

	@RequestMapping("/hello2")  
	public ModelAndView helloWorld2(HttpServletRequest request,HttpServletResponse res) {  
		int number1=Integer.parseInt(request.getParameter("t1"));
		int number2=Integer.parseInt(request.getParameter("t2"));
		String key=request.getParameter("t3");

		if(key.equals("add"))
		{  
			int message = (number1+ number2);  
			return new ModelAndView("sol", "message", message);  
		}  
		if (key.equals("sub"))
		{  
			int message = ((number1)-(number2));  
			return new ModelAndView("sol", "message", message);  
		}
		if(key.equals("mul"))
		{  
			int message = (number1)*(number2);  
			return new ModelAndView("sol", "message", message);  
		}
		if(key.equals("div"))
		{  
			int message = (number1/number2);  
			return new ModelAndView("sol", "message", message);  
		}
		else{  
			return new ModelAndView("error", "message","Sorry, Entry error");  
		}  
	} 

	@RequestMapping("/loginCtrl")  
	public ModelAndView helloWorld3(HttpServletRequest request,HttpServletResponse res) throws IOException 
	{  
//		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String empno = request.getParameter("empno"),
				name = request.getParameter("name"),
				pwd = request.getParameter("password"),
				mob = request.getParameter("mob"),
				sal = request.getParameter("salary"),
				dept = request.getParameter("dept"),
				email = request.getParameter("email");

		String btn = request.getParameter("bttn");
		String ret = "";
		
		try 
		{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MPHASIS","1234");
			PreparedStatement st = null;

			if(btn.equalsIgnoreCase("Insert")) {
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
						ret = "Inserted";
					}
				}
			}

			else if(btn.equalsIgnoreCase("Update By Empno")) {
				st = con.prepareStatement("UPDATE  employees SET name=?, mob=?, salary=?, dept=?, desig=emp_desig(?), email=?, password=? WHERE empno=?");
				//EMPNO	NAME	MOB	SALARY	DEPT	DESIG	EMAIL	PASSWORD
				
				st.setInt(8, Integer.parseInt(empno));
				st.setString(1, name);
				st.setString(2,	mob);
				st.setInt(3, Integer.parseInt(sal));
				st.setInt(4, Integer.parseInt(dept));
				st.setInt(5, Integer.parseInt(sal));
				st.setString(6, email);
				st.setString(7, pwd);
				
				if(!st.execute()) {
					if(st.getUpdateCount() > 0) {
						ret = "Updated";
					}
				}
			}

			else if(btn.equalsIgnoreCase("Select By Empno")) {
				st = con.prepareStatement("SELECT * FROM employees WHERE empno=?");
				st.setInt(1, Integer.parseInt(empno));
				
				ResultSet rs = null;
				if(st.execute()) {
					rs = st.getResultSet();
					if(rs.next()) {
						ret = "Empno: " + rs.getInt("empno");
						ret += "<br>";
						ret += "Name: " + rs.getString("name");
						ret += "<br>";
						ret += "Password: " + rs.getString("password");
						ret += "<br>";
						ret += "Email: " + rs.getString("email");
						ret += "<br>";
						ret += "Mobile: " + rs.getString("mob");
						ret += "<br>";
						ret += "Department: " + rs.getString("dept");
						ret += "<br>";
						ret += "Salary: " + rs.getString("salary");
						ret += "<br>";
						ret += "Designation: " + rs.getString("desig");
					}
					else {
						ret = "Employee number not found";
					}			
					
				}
				else {
					ret = "Employee number not found";
				}
				
			}

			else if(btn.equalsIgnoreCase("Select All")) {
				st = con.prepareStatement("SELECT * FROM employees ORDER BY empno");
				
				ResultSet rs = null;
				if(st.execute()) {
					rs = st.getResultSet();
					
					ret = "<table border=1><tr>";
					ret += "<th>Empno";
					ret += "<th>Name";
					ret += "<th>Password";
					ret += "<th>Email";
					ret += "<th>Mobile";
					ret += "<th>Department";
					ret += "<th>Salary";
					ret += "<th>Designation</tr>";
					while(rs.next()) {
						ret += "<tr>";						
						
						ret += "<td>" + rs.getString("empno");						
						ret += "<td>" + rs.getString("name");						
						ret += "<td>" + rs.getString("password");						
						ret += "<td>" + rs.getString("email");					
						ret += "<td>" + rs.getString("mob");						
						ret += "<td>" + rs.getString("dept");						
						ret += "<td>" + rs.getString("salary");						
						ret += "<td>" + rs.getString("desig");
						
						ret += "</tr>";
					}
				}
				else {
					ret = "No data found";
				}
			}

			else if(btn.equalsIgnoreCase("Delete By Empno")) {
				st = con.prepareStatement("DELETE FROM employees WHERE empno=?");
				
				st.setInt(1, Integer.parseInt(empno));
				
				if(!st.execute()) {
					if(st.getUpdateCount() > 0) {
						ret = "Deleted";
					}
				}
			}

			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("resultpage", "message", ret);  

	}


}
