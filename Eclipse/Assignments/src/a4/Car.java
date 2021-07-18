package a4;

public class Car {
	protected String regno, cname;
	protected char type; //p/d/e
	protected int price;

	public Car(String regno, String cname, char type, int price) {
		this.cname = cname;
		this.regno = regno;
		this.type = type;
		this.price = price;
	}

	public Car() {

	}

	public void print() {
		System.out.println(this.regno);
		System.out.print(this.cname + " (");
		switch(this.type) {
			case 'p': System.out.print("Petrol");
				break;
			case 'd': System.out.print("Diesel");
				break;
			case 'e': System.out.print("Electric");
				break;
			default: System.out.print("Not Specified");
		}
		System.out.println(") \nPrice: INR" + this.price);		
	}
}
