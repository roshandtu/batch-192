package day6java;

import java.lang.*;
import java.util.*;

abstract class Bank1 {
	protected int balance = 0;
	protected String name;
	abstract void openAccount();
	abstract void deposit(int amount);	
	abstract void withdraw(int amount);
}

public class Bank extends Bank1 {
	@Override
	void deposit(int amount) {
		this.balance += amount;
		System.out.println("Deposited INR" + amount);
	}
	
	@Override
	void withdraw(int amount) {
		if(amount > this.balance) {
			System.out.println("Not enough funds");
		}
		else {
			this.balance -= amount;
			System.out.println(amount + " deducted from your account");
		}
	}
	
	@Override
	void openAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name: ");
		this.name = sc.next();
		System.out.println("New account created in the name of " + this.name);
	}
	
	int getBalance() {
		return this.balance;
	}
}
