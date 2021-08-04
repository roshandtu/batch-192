//Hibernate Assignment :-
//create a bank class :- accno,name,balance,phoneno,email
//insert data into the table,updata data,delete data
//Seach data from the database with accno.


package bank.entity;

public class Account {
	private int accno;
	private float bal;
	private String name, mob, email;
	
	public Account() {
		
	}
	
	public Account(int a, float b, String n, String m, String e) {
		this.accno = a;
		this.bal = b;
		this.email = e;
		this.mob = m;
		this.name = n;
	}
	
	public float getBal() {
		return bal;
	}
	public void setBal(float bal) {
		this.bal = bal;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	
	public String toStr() {
		return "A/C #" + this.accno + "\nName: " + this.name + "\nAvailable Balance: " + this.bal 
				+ "\nEmail: " + this.email + " | Mobile#: " + this.mob;
	}
	
	public void deposit(float amt) {
		this.bal += amt;
	}
	
	public void withdraw(float amt) {
		if(amt > this.bal) {
			System.out.println("Insufficient Balance");
		}
		else {
			this.bal -= amt;
		}
	}
}
