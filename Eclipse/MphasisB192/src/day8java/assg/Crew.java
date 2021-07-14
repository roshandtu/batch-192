package day8java.assg;

public class Crew extends Ticket {
	
	public int price = 0;
	
	String getType() {
		return "crew";
	}
	
//	int getPrice() {
//		return this.price;
//	}
	
	void print() {
		System.out.println("Crew");
		super.print();
		System.out.println("Price: " + this.price);
	}
}
