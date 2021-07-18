package a3;

public class Bank {
	protected int accno, bal;
	protected String name;
	Insurance insur;
	
	public Bank(int ano, String name, int bal, Insurance i) {
		this.accno = ano;
		this.name = name;
		this.bal = bal;
		this.insur = i;
	}
	
	public void print() {
		System.out.println("A/C No.: " + this.accno);
		System.out.println("Name: " + this.name);
		System.out.println("Available balance: " + this.bal);
		System.out.println("Insurance Details: ");
		insur.print();
	}
}
