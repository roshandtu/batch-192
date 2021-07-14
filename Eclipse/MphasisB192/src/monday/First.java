package monday;

import java.lang.*;
import java.util.*;

public class First {
	public static void main(String[] args) {
		byte a = 10;
		short b = 20;
		int c = 30;
		long d = 40;
		float e = 50.4f;
		double f = 60.7;
		char g = 'r';
		String h = "Roos";
		boolean i = true;
		
		System.out.println(a + " " + b + " " + c);
		System.out.println(d + " " + e + " " + f);
		System.out.println(g + " " + h + " " + i);
		
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter 2 numbers:");
		int n1 = ob.nextInt();
		int n2 = ob.nextInt();
		int sum = n1 + n2;
		System.out.println(n1 + " + " + n2 + " = " + sum);
		
		System.out.println("Enter 2 double numbers:");
		double f1 = ob.nextDouble();
		double f2 = ob.nextDouble();
		double sumf = f1 + f2;
		System.out.println(f1 + " + " + f2 + " = " + sumf);
		
		ob.close();
	}
}
