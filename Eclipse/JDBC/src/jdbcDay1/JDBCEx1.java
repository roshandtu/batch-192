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
import java.util.*;

public class JDBCEx1 {
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//loading the driver
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","mphasis","1234");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Employee ID: ");
		int id = sc.nextInt();
		System.out.print("New Salary: ");
		int sal = sc.nextInt();
				
		PreparedStatement st = con.prepareStatement("UPDATE employees SET salary=? WHERE empno=?");
		st.setInt(1, sal);
		st.setInt(2, id);
		
		if(!st.execute()) {
			if(st.getUpdateCount() > 0) {
				System.out.println("successfully updated");
			}
		}
		
		
	}    
}
