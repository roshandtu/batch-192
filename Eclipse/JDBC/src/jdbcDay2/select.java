package jdbcDay2;

import java.sql.*;

public class select {
	public static String pad(String s) {
		int len;
		while((len = s.length()) != 20) {
			s = s + " ";
		}
		return s;
	}

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");//loading the driver
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM employees ORDER BY empno");

		while(rs.next()) {
			System.out.println(rs.getInt("empno") + "\t" + pad(rs.getString("name")) + "\t" + rs.getString("desig"));
		}
	}
}
