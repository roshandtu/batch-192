
public class Bank {
	private int accno;
	private String name;
	private float bal;
	
	public Bank(int accno, String name, float bal) {
		this.accno = accno;
		this.name = name;
		this.bal = bal;
	}
	
	public String toStr() {
		return "A/C #" + this.accno + " - " + this.name + "\nBalance: " + this.bal;
	}
	
}
