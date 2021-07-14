package monday;

import java.util.*;
import java.lang.*;

public class Greatest {
	public static void main(String[] args) {
		System.out.println("Enter 2 numbers: ");
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		if(n1 > n2) {
			System.out.println("Greatest is " + n1);
		}
		else {
			System.out.println("Greatest is " + n2);
		}
		
//		3 numbers
		System.out.println("Enter 3 numbers: ");
		int n3 = sc.nextInt();
		int n4 = sc.nextInt();
		int n5 = sc.nextInt();
		
		if(n3 > n4 && n3 > n5) {
			System.out.println("Greatest is " + n3);
		}
		else if(n4 > n3 && n4 > n5) {
			System.out.println("Greatest is " + n4);
		}
		else {
			System.out.println("Greatest is " + n5);
		}
		
		sc.close();
	}
}
