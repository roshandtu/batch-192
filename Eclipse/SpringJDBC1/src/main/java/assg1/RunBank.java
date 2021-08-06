package assg1;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RunBank {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		BankDAO dao = (BankDAO) ctx.getBean("bankdao");

		//		List<Bank> all = dao.getAllAccounts();
		//		
		//		for(Bank b : all) {
		//			System.out.println(b.toString());
		//			System.out.println("---");
		//		}

		int accno, c;
		Scanner sc = new Scanner(System.in);
		Bank newB = new Bank();

		while(true) {
			System.out.println("\n0:Quit | 1:Create Account | 2:Deposit | 3:Withdraw | 4:Change Name | 5:A/C Details | 6: All Accounts");
			System.out.print("Option: ");
			c = sc.nextInt();
			if(c == 0) {
				break;
			}

			if(c == 1) {
				System.out.println("Create Account");
				System.out.print("Account Number: ");
				newB.setAccno(sc.nextInt());
				sc.nextLine(); //clear \n
				System.out.print("Name: ");
				newB.setName(sc.nextLine());
				System.out.print("Initial Deposit: ");
				newB.setBal(sc.nextFloat());

				try {
					dao.insertAcc(newB);
					System.out.println("Account created");
				}
				catch(Exception e) {
					System.out.println("Failed");
					System.out.println(e);
				}
			}

			else if(c == 2) {
				System.out.print("Deposit\nAccount Number: ");
				accno = sc.nextInt();
				newB = dao.getAcc(accno);
				System.out.println("Hello, " + newB.getName() + ". Available balance is " + newB.getBal());
				System.out.print("Deposit Amount: ");
				newB.setBal(sc.nextFloat() + newB.getBal());

				try {
					dao.updateAccBal(newB);
					System.out.println("Balance updated");
				}
				catch(Exception e) {
					System.out.println("Failed");
					System.out.println(e);
				}
			}

			else if(c == 3) {
				System.out.print("Withdraw\nAccount Number: ");
				accno = sc.nextInt();
				newB = dao.getAcc(accno);
				System.out.println("Hello, " + newB.getName() + ". Available balance is " + newB.getBal());
				System.out.print("Withdraw Amount: ");

				float amt = sc.nextFloat();
				if(amt > newB.getBal()) {
					System.out.println("Not Enough Funds");
				}
				else {
					try {
						newB.setBal(newB.getBal() + amt);
						dao.updateAccBal(newB);
						System.out.println("Balance updated");
					}
					catch(Exception e) {
						System.out.println("Failed");
						System.out.println(e);
					}
				}				

			}

			else if(c == 4) {
				System.out.print("Update Name\nAccount Number: ");
				accno = sc.nextInt();
				newB = dao.getAcc(accno);
				sc.nextLine();
				System.out.println("Current name: " + newB.getName());				
				System.out.print("New name: ");

				String n = sc.nextLine();
				if(n.equals("") || n == null) {
					System.out.println("Name cannot be blank");
				}
				else {
					try {
						newB.setName(n);
						dao.updateAccName(newB);
						System.out.println("Name updated");
					}
					catch(Exception e) {
						System.out.println("Failed");
						System.out.println(e);
					}
				}				

			}
			
			else if(c == 5) {
				System.out.print("Account Details\nAccount Number: ");
				accno = sc.nextInt();
				newB = dao.getAcc(accno);
				System.out.println(newB.toString());	
			}
			
			else if(c == 6) {
				System.out.println("All Account Details");
				List<Bank> all = dao.getAllAccounts();

				for(Bank b : all) {
					System.out.println(b.toString());
					System.out.println("---");
				}
			}

		}
	}
}
