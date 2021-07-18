package a4;

public class Driver {
	public static void main(String[] args) {
		Car c = new Car("KL07CB9471", "Polo", 'p', 800000);
		Car c2 = new Car("KL07AA045", "800", 'p', 200000);
		
		LuxuryCar cl = new LuxuryCar(c,4);
		LuxuryCar l1 = new LuxuryCar("KL07CF9090", "Car2", 'e', 1000000, true, false, 3);
		
		c2.print();
		System.out.println("---------------------");
		cl.print();
		System.out.println("---------------------");
		l1.print();
		
	}
}
