package monday;

import java.util.*;
import java.lang.*;

public class Arrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 5 nos: ");
		int a[] = new int[5];
		
		for(int i = 0; i < 5; i++) {
			a[i] = sc.nextInt();
		}
		
//		System.out.print("The array contents are: ");
//		
		for(int i = 0; i < 5; i++) {
			System.out.print(a[i] + " ");
			if(a[i] % 2 == 0) {
				System.out.println("- Even");
			}
			else {
				System.out.println("- Odd");
			}
		}
	}
}
