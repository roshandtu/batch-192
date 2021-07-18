package a2;

public class Employee extends Department {
	protected int empno,
		salary;
	protected String name, 
		designation;
	
	public Employee(int eno, String n, String des, int sal, String dep, int dno, String loc) {
		this.name = n;
		this.salary = sal;
		this.empno = eno;
		this.designation = des;
		super.deptname = dep;
		super.deptno = dno;
		super.loc = loc;
	}
	
	public void print() {
		System.out.println(this.empno + " : " + this.name);
		System.out.println(this.designation + ". Salary: " + salary);
		System.out.println("Department: ");
		super.print();
	}
}
