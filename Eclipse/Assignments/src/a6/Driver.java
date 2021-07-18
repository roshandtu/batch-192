package a6;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Customer c = new Customer();
		Scanner sc = new Scanner(System.in);
		String n, a;
		int i;
		
		System.out.print("Name: ");
		n = sc.nextLine();
		System.out.print("Address: ");
		a = sc.nextLine();
		System.out.print("Initial deposit: ");
		i = sc.nextInt();
		
		c.openAccount(1001, n, a, i);
		
		int o;
		while(true) {
			System.out.println("0: Quit\n1:Deposit | 2:Withdraw | 3:Account details");
			System.out.print("Choice: ");
			o = sc.nextInt();
			
			if(o == 0) {
				break;
			}
			
			switch(o) {
				case 1: System.out.print("Deposit amount: ");
					i = sc.nextInt();
					c.deposit(i);
					break;
				case 2: System.out.print("Withdraw amount: ");
					i = sc.nextInt();
					c.withdraw(i);
					break;
				case 3: c.displayCustomerDetails();
			}
			
			System.out.println("---------------------");
			
		}
	}
}
