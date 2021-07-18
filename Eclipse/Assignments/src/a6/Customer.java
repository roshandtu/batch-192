package a6;

public class Customer extends Bank {

	@Override
	public void openAccount(int accno, String name, String address, int initAmt) {
		this.accno = accno;
		this.name = name;
		this.address = address;
		super.setBalance(initAmt);
		System.out.println("Account Created successfully");
	}

	@Override
	public void deposit(int amt) {
		super.setBalance(super.getBalance() + amt);
		System.out.println(amt + " credited. Available balance is " + super.getBalance());
	}

	@Override
	public void withdraw(int amt) {
		if(super.getBalance() < amt) {
			System.out.println("Insufficient Balance");
		}
		else {
			super.setBalance(super.getBalance() - amt);
			System.out.println(amt + " debited. Available balance is " + super.getBalance());
		}
	}

	@Override
	public void displayCustomerDetails() {
		System.out.println("A/C No.: " + this.accno);
		System.out.println(this.name);
		System.out.println(this.address);
		System.out.println("Balance: " + super.getBalance());
	}

}
