package test;

public class Car extends Vehicle {
	
	private String gearType;
	
	public Car() {
		super();
	}

	public Car(String name, String color, float speed , String gearType) {
		super(name, color, speed);
		this.gearType = gearType;
		
	}
	
	public String getGearType() {
		return gearType;
	}

	public void setGearType(String gearType) {
		this.gearType = gearType;
	}

	public void print() {
		super.print();
		System.out.println("Gear Type: " + gearType);
	}
	
	public void accelerate() {
		speed += 5;
		System.out.println("Speed is insreased by 5 km/hr = " + speed);
	}
	
	
	
}