public class Employee {  
	private int id;  
	private String name, place;  
	private float salary;
	Bank bank;
	//has a relationship
	
	public Employee() 
	{
		System.out.println("default constructor");
	}  

	public Employee(int id, String name, String place, float sal, Bank bank) 
	{  
		this.id = id;  
		this.name = name;
		this.place = place;
		this.bank = bank;
		this.salary = sal;
	}  
	void show()
	{  
		System.out.println(id+" "+name + " " + place + " " + salary);  
		System.out.println(bank.toStr());
	}
}  