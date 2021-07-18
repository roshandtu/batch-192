package a4;

public class LuxuryCar extends Car {
	protected boolean ac = true, 
		stereo = true;
	protected int safetyRating;
	
	public LuxuryCar(Car c, int safety) {
		this.safetyRating = safety;
		this.cname = c.cname;
		this.regno = c.regno;
		this.price = c.price;
		this.type = c.type;
	}
	
	public LuxuryCar(String regno, String cname, char type, int price, boolean ac, boolean stereo, int safety) {
		this.cname = cname;
		this.regno = regno;
		this.type = type;
		this.price = price;
		this.ac = ac;
		this.stereo = stereo;
		this.safetyRating = safety;
	}

	public void print() {
		super.print();
		if(ac) {
			System.out.print("A/C");
		}
		else {
			System.out.print("No A/C");
		}
		System.out.print(" | ");
		if(ac) {
			System.out.print("Stereo");
		}
		else {
			System.out.print("No Stereo");
		}
		System.out.println("\nSafety Rating: " + this.safetyRating);
	}
}
