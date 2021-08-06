//setter Injection   
public class Student 
{  
	private String name, address;
	private int rollno;
	private float mark;
	
	public Student() {
		
	}
	
	public Student(int rn, String n, String ad, float m) {
		this.rollno = rn;
		this.name = n;
		this.address = ad;
		this.mark = m;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public void setName(String name) {  
		this.name = name;  
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}  
	

	public void display(){  
		System.out.println("Roll#: " + rollno + "\nName: " + name + "\nAddress" + address + "\nMarks: " + mark);  
	}  

}  