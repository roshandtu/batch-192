package a2;

public class Driver {
	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "Roosafeed", "ASE", 37000, "CSE", 1, "CSE Block");
		Employee emp2 = new Employee(2, "Akhil", "IT", 30000, "CSE", 1, "CSE Block");
		
		emp1.print();
		System.out.println("-------------------");
		emp2.print();
	}
}
