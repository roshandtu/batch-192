package monday;

import java.lang.*;
import java.util.*;

public class Second {
	public static void main(String[] args) {
		System.out.println("Enter 5 intergers:");
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int i = 1;
		int n;

		//		START 1
		//		int n1 = sc.nextInt();
		//		int n2 = sc.nextInt();
		//		int n3 = sc.nextInt();
		//		int n4 = sc.nextInt();
		//		int n5 = sc.nextInt();
		//		
		//		sum = n1 + n2 + n3 + n4 + n5;

		//		START 2		
//		for(; i <= 5; i++) {
//			n = sc.nextInt();
//			sum += n;
//		}

		//		START 3
		while(true) {
			n = sc.nextInt();
			if(n == 0) {
				break;
			}
			sum += n;
			i++;
		}

		float avg = (float) sum / (i-1);

		System.out.println("Sum: " + sum);
		System.out.println("Average: " + avg);

		sc.close();
	}
}
