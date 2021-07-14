package test;

public class Bike extends Vehicle {
	
	int gearNumber;
	
	public Bike() {
		super();
	}

	public Bike(String name, String color, float speed, int gearNumber) {
		super(name, color, speed);
		this.gearNumber = gearNumber;
	}
	
	public void print() {
		super.print();
		System.out.println("Gear Number = " + gearNumber);
	}
	
	public void increaseGear() {
		if(gearNumber < 5) {
			gearNumber++;
			
			speed += 10;
			System.out.println("Gear is shifted = " + gearNumber);
			
		}
		
		else {
			System.out.println("Gear can't be shifted more, it's max!!!");
		}
	}
	
	public void decreaseGear() {
		if(gearNumber > 1) {
			gearNumber--;
			speed -= 10;
			System.out.println("Gear is shifted = " + gearNumber);
		}
		
		else {
			System.out.println("Gear can't be shifted more, its min!!!");
		}
	}
	
	
}