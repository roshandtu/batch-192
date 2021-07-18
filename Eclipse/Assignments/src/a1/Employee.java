package a1;

public class Employee {
	public int empno,
		salary;
	
	public String name,
		designation;
	
	public Employee(int eno, String name, String desig, int salary) {
		this.empno = eno;
		this.name = name;
		this.designation = desig;
		this.salary = salary;
	}
	
	
	public static void main(String[] args) {
		Employee emp = new Employee(1, "Roosafeed", "ASE", 37000);

		System.out.println("Employee No.: " + emp.empno);
		System.out.println("Name: " + emp.name);
		System.out.println("Designation: " + emp.designation);
		System.out.println("Salary: " + emp.salary);
	}
}
