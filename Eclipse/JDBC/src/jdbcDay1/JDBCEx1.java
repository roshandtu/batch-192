//Jdbc :- java database connectivity
//----------------------------------------------
//java program (byte code)<--------------------->Driver<-------------------------->oracle(ASCII code)
//when we are working with jdbc 
//step-1)load the driver
//step-2)create a connection
//step-3)sql statement to be executed
//step-4)execute()

package jdbcDay1;

import java.sql.*;

public class JDBCEx1 {
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//loading the driver
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");
		Statement st = con.createStatement();
//		st.execute("begin ins_emps('Nima', 9650880011, 25000, 2); end;");
		st.execute("update employees set salary = salary - 500 where empno = 104");
		System.out.println("successful");
	}    
}
