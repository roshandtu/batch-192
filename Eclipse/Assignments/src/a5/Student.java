package a5;

public class Student extends School {
	private int rollno;
	private String name, address;
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public int getRollNo() {
		return this.rollno;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setRollNo(int rollno) {
		this.rollno = rollno;
	}
}
