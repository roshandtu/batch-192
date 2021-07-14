package day8java.assg;

import java.util.*;

public class Passenger extends Ticket {
	protected int price = 0;
	protected int age;
	
	String getType() {
		return "passenger";
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
		
//		sc.close();
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
