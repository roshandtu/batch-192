package a3;

public class Driver {
	public static void main(String[] args) {
		Insurance i1 = new Insurance(1, "Health", 3000);
		Bank b1 = new Bank(101, "Roosafeed", 10000, i1);
		
		b1.print();
	}
}
