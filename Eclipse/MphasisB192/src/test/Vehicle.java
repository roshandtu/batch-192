package test;

public class Vehicle {
	protected String name;
	protected String color;
	protected float speed;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String name, String color, float speed) {
		this.name = name;
		this.color = color;
		this.speed = speed;
	}
	

	public void print() {
		System.out.println("Name: " + name);
		System.out.println("Color: " + color);
		System.out.println("Speed: " + speed);
	}
	
}