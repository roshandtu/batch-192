package a8;

public class Crew extends Ticket {
	
	public int price = 0;
	
	@Override
	public String getType() {
		return "crew";
	}
		
	void print() {
		System.out.println("Crew");
		super.print();
		System.out.println("Price: " + this.price);
	}
}
