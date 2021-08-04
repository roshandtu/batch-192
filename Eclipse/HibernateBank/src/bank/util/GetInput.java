package bank.util;

import java.util.Scanner;

public class GetInput {
		
	public static int getInt(String msg) {
		System.out.print(msg + ": ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
//		sc.close();
		return i;		
	}
	
	public static String getString(String msg) {
		System.out.print(msg + ": ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
//		sc.close();
		return s;	
	}
	
	public static float getFloat(String msg) {
		System.out.print(msg + ": ");
		Scanner sc = new Scanner(System.in);
		float f = sc.nextFloat();
//		sc.close();
		return f;	
	}
}
