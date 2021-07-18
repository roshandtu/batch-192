package a10;

public class Bank {
	protected int accNo, bal;
	protected String name, addr;
	
	void setAccountDetails(int an, String n, String ad) {
		this.accNo = an;
		this.name = n;
		this.addr = ad;
		this.bal = 0;
	}
	
	void printAccNo() {
		System.out.println("Bank A/C No.: " + this.accNo + " | Balance: " + this.bal);
		System.out.println("Bank Address: " + this.addr);
	}
	
	void deposit(int amt) {
		this.bal += amt;
	}
	
	void withdraw(int amt) {
		if(this.bal < amt) {
			System.out.println("Insufficient balance");
		}
		else {
			this.bal -= amt;
		}
	}
}
