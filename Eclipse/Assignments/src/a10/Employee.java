package a10;

import java.util.*;

public class Employee extends Address {
	protected int empNo;
	protected String name;
	
	protected Bank b = new Bank();
	
	void getDetails(int id) {
		Scanner sc2 = new Scanner(System.in);
		System.out.print("Name: ");
		this.name = sc2.next();
		this.empNo = id;
		super.getAddress();
		b.setAccountDetails(id + 100, this.name, super.retAddr());
	}
	
	void print() {		
		System.out.println("ID: " + this.empNo + " Name: " + this.name);	
		super.printAddr();
		b.printAccNo();
	}
	
	String retName() {
		return this.name;
	}
	
	void deposit() {
		Scanner sc3 = new Scanner(System.in);
		System.out.print("Deposit amount: ");
		int amt = sc3.nextInt();
		b.deposit(amt);
	}
	
	void withdraw() {
		Scanner sc4 = new Scanner(System.in);
		System.out.print("Withdraw amount: ");
		int amt = sc4.nextInt();
		b.withdraw(amt);
	}
}
