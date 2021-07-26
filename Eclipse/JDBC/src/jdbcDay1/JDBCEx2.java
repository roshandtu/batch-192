package jdbcDay1;

import java.sql.*;
import java.util.*;

public class JDBCEx2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Mobile number: ");
		long mob = sc.nextLong();
		System.out.print("Salary: ");
		int sal = sc.nextInt();
		System.out.print("Department number: ");
		int dept = sc.nextInt();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//loading the driver
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");
		
		PreparedStatement st = con.prepareStatement("begin ins_emps(?, ?, ?, ?); end;");
//		CallableStatement st = con.prepareCall("{call ins_emps(?, ?, ?, ?)}");
//		"begin ins_emps('Nima', 9650880011, 25000, 2); end;"
		
		st.setString(1, name);
		st.setLong(2, mob);
		st.setInt(3, sal);
		st.setInt(4, dept);
		
		st.execute();
		
		System.out.println("Successfully added");
	}

}
