package jdbcDay2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Assgn2 {
	public static String pad(String s, int l) {
		while(s.length() <= l) {
			s = s + " ";
		}
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//loading the driver
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");
		
		int c;
		PreparedStatement ins = con.prepareStatement("begin ins_emps(?, ?, ?, ?); end;");
		PreparedStatement upsal = con.prepareStatement("UPDATE employees SET salary = ? WHERE empno = ?");
		PreparedStatement upmob = con.prepareStatement("UPDATE employees SET mob = ? WHERE empno = ?");
		PreparedStatement del = con.prepareStatement("DELETE FROM employees WHERE empno = ?");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM employees ORDER BY empno");
		
		String name;
		int sal, dept, eno;
		long mob;
		while(true) {
			System.out.print("0: Quit\n1:Insert, 2:Update Salary, 3:Update Mobile, 4:Delete, 5: List All\nChoice: ");
			c = sc.nextInt();
			sc.nextLine();
			
			if (c == 0) {
				break;
			}
			
			switch(c) {
				case 1: System.out.println("Insert");
						System.out.print("Name: ");
						name = sc.nextLine();
						name = name.strip();
						System.out.print("Mobile Number: ");
						mob = sc.nextLong();
						System.out.print("Salary: ");
						sal = sc.nextInt();
						System.out.print("Dept Number: ");
						dept = sc.nextInt();
						
						ins.setString(1, name);
						ins.setLong(2, mob);
						ins.setInt(3, sal);
						ins.setInt(4, dept);
						ins.execute();
						System.out.println("Added\n");
						break;
						
						
				case 2: System.out.println("Update Salary");
						System.out.print("Employee Number: ");
						eno = sc.nextInt();
						System.out.print("New Salary: ");
						sal = sc.nextInt();
				
						upsal.setInt(1, sal);
						upsal.setInt(2, eno);
						if(!upsal.execute()) {
							if(upsal.getUpdateCount() > 0) {
								System.out.println("Salary Updated\n");								
							}
						}
						break;
						
				case 3: System.out.println("Update Mobile Number");
						System.out.print("Employee Number: ");
						eno = sc.nextInt();
						System.out.print("New Mobile Number: ");
						mob = sc.nextLong();
				
						upmob.setLong(1, mob);
						upmob.setInt(2, eno);
						if(!upmob.execute()) {
							if(upmob.getUpdateCount() > 0) {
								System.out.println("Mobile Number Updated\n");								
							}
						}
						break;	
						
				case 4: System.out.println("Delete an employee");
						System.out.print("Employee Number to be deleted: ");
						eno = sc.nextInt();
						
						del.setInt(1, eno);
						if(!del.execute()) {
							if(del.getUpdateCount() > 0) {
								System.out.println("Deleted\n");								
							}
						}
						break;	
						
				case 5: System.out.println("ENo\t" + pad("Name", 20) + "\t" + pad("Mobile No.", 10) + "\t" + pad("Salary", 10) + "\t" + pad("Deignation", 10) + pad("Department", 10));
						while(rs.next()) {
							System.out.println(rs.getInt("empno") + "\t" + pad(rs.getString("name"), 20) + "\t" + pad(rs.getString("mob"), 10) + "\t" + pad(rs.getString("salary"), 10) + "\t" + pad(rs.getString("desig"), 10) + "\t" + pad(rs.getString("dept"), 10));     
						}
						break;
			}
			
			
		}
		
		sc.close();
	}
}
