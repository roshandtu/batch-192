package day8java;

public class Args {
	public static void main(String args[]) {
		System.out.println("Args:");
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i] + ", ");
		}
		
		try {
			int sum = 0;
			for(int i = 0; i < args.length; i++) {
				sum += Integer.parseInt(args[i]);
			}		
			
			System.out.println("Sum = " + sum);
		}
		catch (Exception e) {
			System.out.println("Error");
		}
	}
}
