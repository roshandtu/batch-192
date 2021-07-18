package a10;

import java.util.*;

public class Address {
	protected String city, state, country;
	
	void getAddress() {		
		Scanner sc1 = new Scanner(System.in);
		System.out.print("City: ");
		this.city = sc1.next();
		System.out.print("State: ");
		this.state = sc1.next();
		System.out.print("Country: ");
		this.country = sc1.next();
	}
	
	void printAddr() {
		System.out.println(this.city + ", " + this.state + ", " + this.country);
	}
	
	String retAddr() {
		return this.city + ", " + this.state + ", " + this.country;
	}
}
