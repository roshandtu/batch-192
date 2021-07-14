package test;

import java.util.Iterator;
import java.util.Scanner;

public class TestService {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Vehicle[] va = new Vehicle[1];
		
		for (int i = 0; i < va.length; i++) {
			System.out.println("Enter 1 to add car or 2 to add a bike for service: ");
			int value = in.nextInt();
			
			switch(value){
				case 1:
					System.out.println("Enter car name, Color, Speed and gear type: ");
					Car c = new Car(in.next(), in.next(), in.nextFloat(), in.next());
					va[i] = c;
					break;
				case 2:
					System.out.println("Enter Bike name, color, speed, gearNumber: ");
					Bike b = new Bike(in.next(), in.next(), in.nextFloat(), in.nextInt());
					va[i] = b; 
					break;
			}
			
		}
		
		for (int i = 0; i < va.length; i++) {
			va[i].print();
		}
		
	}
}
