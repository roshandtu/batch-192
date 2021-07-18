package a6;

public abstract class Bank {
	private int bal;
	protected int accno;
	protected String name, address;
	
	public abstract void openAccount(int accno, String name, String address, int initAmt);
	public abstract void deposit(int amt);
	public abstract void withdraw(int amt);	
	public abstract void displayCustomerDetails();
	
	public int getBalance() {
		return this.bal;
	}
	
	public void setBalance(int balance) {
		this.bal = balance;
	}
}
