package a2;

public class Department {
	protected int deptno;
	protected String deptname, loc;

	public void print() {
		System.out.println("Department: (" + this.deptno + ") " + this.deptname);
		System.out.println("Location: " + this.loc);
	}
}
