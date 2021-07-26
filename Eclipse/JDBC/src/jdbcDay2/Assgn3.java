//WAP in java using case and switch.
//create a bank table having fields accno,name,balance
//A person can deposit
//A person can withdraw amount.
//A person can close his account.
//Display the final table in oracle.

package jdbcDay2;

import java.sql.*;
import java.util.*;

public class Assgn3 {
	public static String pad(String s, int l) {
		while(s.length() <= l) {
			s = s + " ";
		}
		return s;
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "mphasis", "1234");
		
		
		PreparedStatement newAcc = conn.prepareStatement("INSERT INTO bank VALUES (accnumber.nextval, ?, ?)");
		PreparedStatement up = conn.prepareStatement("UPDATE bank SET bal = ? WHERE accno = ?");
		PreparedStatement del = conn.prepareStatement("DELETE FROM bank WHERE accno = ?");
		PreparedStatement getBal = conn.prepareStatement("SELECT bal FROM bank WHERE accno = ?");
		Statement st = conn.createStatement();
		ResultSet rs;
		
		int c, accno, amt, bal;
		String name;
		
		while(true) {
			System.out.print("\n0:Quit\n1:Create Account, 2:Deposit, 3:Withdraw, 4:Delete Account, 5:Show Balance, 6:List all\nChoice: ");
			c = sc.nextInt();
			sc.nextLine();
			
			if(c == 0) {
				break;
			}
			
			switch(c) {
				case 1: System.out.println("Create New Account");
						System.out.print("Name: ");
						name = sc.nextLine().strip();
						System.out.print("Initial Deposit: ");
						amt = sc.nextInt();
						
						newAcc.setString(1, name);
						newAcc.setInt(2, amt);
						
						if(!newAcc.execute()) {
							if(newAcc.getUpdateCount() > 0) {
								rs = st.executeQuery("SELECT accnumber.currval FROM dual");
								rs.next();
								System.out.println("Account Created. A/C number: " + rs.getString(1));
							}
						}
						break;
						
				case 2: System.out.println("Deposit");
						System.out.print("Account Number: ");
						accno = sc.nextInt();
						
						getBal.setInt(1, accno);
						getBal.execute();
						rs = getBal.getResultSet();
						rs.next();
						bal = rs.getInt(1);
						System.out.println("Avaliable Balance: " + bal);
						System.out.print("Deposit Amount: ");
						amt = sc.nextInt();
						bal += amt;
						
						up.setInt(1, bal);
						up.setInt(2, accno);
						if(!up.execute()) {
							if(up.getUpdateCount() > 0) {
								System.out.println(amt + " credited. Available balance is " + bal);
							}
						}						
						break;
				
				case 3: System.out.println("Withdraw");
						System.out.print("Account Number: ");
						accno = sc.nextInt();
						
						getBal.setInt(1, accno);
						getBal.execute();
						rs = getBal.getResultSet();
						rs.next();
						bal = rs.getInt(1);
						System.out.println("Avaliable Balance: " + bal);
						System.out.print("Withdraw Amount: ");
						amt = sc.nextInt();
						if (amt < bal) {
							bal -= amt;							
							up.setInt(1, bal);
							up.setInt(2, accno);
							if(!up.execute()) {
								if(up.getUpdateCount() > 0) {
									System.out.println(amt + " debited. Available balance is " + bal);
								}
							}
						}
						else {
							System.out.println("Insufficient balance");
						}							
						break;
				
				case 4: System.out.println("Delete An Account");
						System.out.print("Account Number: ");
						accno = sc.nextInt();
						
						del.setInt(1, accno);
						
						if(!del.execute()) {
							if(del.getUpdateCount() > 0) {
								System.out.println("Account deleted");
							}
						}
						break;
						
				case 5: System.out.println("Display Balance");
						System.out.print("Account Number: ");
						accno = sc.nextInt();
						
						getBal.setInt(1, accno);
						
						getBal.setInt(1, accno);
						getBal.execute();
						rs = getBal.getResultSet();
						rs.next();
						bal = rs.getInt(1);
						System.out.println("Balance: " + bal);
						break;
						
				case 6: //list all accounts
						System.out.println(pad("A/C No", 6) + "\t" + pad("Name", 20) + "\t" + "Balance");
						System.out.println("----------------------------------------");
						rs = st.executeQuery("SELECT * FROM bank");
						while(rs.next()) {
							System.out.println(pad(rs.getString(1), 6) + "\t" + pad(rs.getString(2), 20) + "\t" + rs.getString(3));
						}
			}
		}
		
		sc.close();
	}
}
