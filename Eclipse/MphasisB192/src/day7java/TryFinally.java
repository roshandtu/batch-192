package day7java;

import java.util.Scanner;

public class TryFinally {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 2 numbers:");
			int n1 = sc.nextInt(),
					n2 = sc.nextInt();

			System.out.println("Result = " + n1/n2);
			
		}
		finally {
			System.out.println("END" );
		}
	}
}
