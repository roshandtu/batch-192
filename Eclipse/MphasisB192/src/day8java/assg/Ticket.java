package day8java.assg;

import java.util.*;

public class Ticket {
	protected String name;
	
//	String getName() {
//		return this.name;
//	}
//	
//	void setName(String n) {
//		this.name = n;
//	}
	
	void getDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name: ");
		this.name = sc.next();
//		sc.close();
	}
	
	void print() {
		System.out.println("Name: " + name);
	}
}
