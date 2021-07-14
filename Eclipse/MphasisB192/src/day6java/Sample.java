package day6java;

import java.util.*;
import java.lang.*;

public class Sample {
	public static void main(String[] args) {
		Bank ob = new Bank();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Open new account");
		ob.openAccount();
		
		while(true) {
			System.out.println("1: Deposit, 2: Withdraw, 3: Show Balance, 0: Quit");
			
			int a = sc.nextInt();
			if(a == 0) {
				break;
			}
			else if(a == 1) {
				System.out.print("Deposit amount: ");
				int amt = sc.nextInt();
				ob.deposit(amt);
			}
			else if(a == 2) {
				System.out.print("Withdraw amount: ");
				int amt = sc.nextInt();
				ob.withdraw(amt);
			}
			else if(a == 3) {
				System.out.println("Available balance: " + ob.getBalance());
			}
		}
	}
}
