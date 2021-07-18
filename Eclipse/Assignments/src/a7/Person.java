package a7;

public class Person implements Employee, Department {
	protected int depno, empno;
	protected String name, depName, address, depLoc;

	@Override
	public void inputDepDetails(int depNo, String name, String loc) {
		this.depName = name;
		this.depno = depNo;
		this.depLoc = loc;
	}

	@Override
	public void dispDepDetails() {
		System.out.println(this.depno + " - " + this.depName + ", " + this.depLoc);
	}

	@Override
	public void inputEmpDetails(int empNo, String name, String address) {
		this.empno = empNo;
		this.name = name;
		this.address = address;
	}

	@Override
	public void dispEmpDetails() {
		System.out.println(this.empno + " - " + this.name);
		System.out.println(this.address);
	}

}
