package a8;

import java.util.*;

public class Ticket {
	protected String name;
	

	void getDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name: ");
		this.name = sc.next();
	}
	
	void print() {
		System.out.println("Name: " + name);
	}
	
	public String getType() {
		return "Ticket";
	}
}
