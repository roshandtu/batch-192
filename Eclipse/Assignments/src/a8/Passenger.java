package a8;

import java.util.*;

public class Passenger extends Ticket {
	protected int price = 0;
	protected int age;
	
	@Override
	public String getType() {
		if(age > 10)
			return "adult";
		else
			return "child";
	}
	
	void getDetails() {
		super.getDetails();
		Scanner sc = new Scanner(System.in);
		System.out.print("Age: ");
		this.age = sc.nextInt();
		
		if(age > 10) {
			this.price = 500;
		}
		else {
			this.price = 250;
		}
			
	}
	
	void print() {		
		if(age > 10) {
			System.out.println("Full ticket");
		}
		else {
			System.out.println("Child");
		}
		
		super.print();
		System.out.println("Price: " + this.price);
	}
}
