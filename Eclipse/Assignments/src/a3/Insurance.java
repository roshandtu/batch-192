package a3;

public class Insurance {
	protected int inno, prem;
	protected String type;
	
	public Insurance(int n, String type, int amt) {
		this.inno = n;
		this.prem = amt;
		this.type = type;
	}
	
	public void print() {
		System.out.println("No.: " + this.inno);
		System.out.println("Type: " + this.type);
		System.out.println("Premium: " + this.prem);
	}
}
