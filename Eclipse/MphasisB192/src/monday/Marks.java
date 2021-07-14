package monday;

import java.util.*;
import java.lang.*;

public class Marks {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Rollnumbers: ");
		int roll = sc.nextInt();
		
		int m;
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			System.out.print("Mark (sub" + (i + 1) + "): ");
			sc.nextInt();
			m = sc.nextInt();
			sum += m;
		}
		
		int avg = sum / 3;
		
		System.out.println("Total Marks: " + sum);
		System.out.println("Average Marks: " + avg);
		
		if(avg > 75) {
			System.out.println("First Division");
		}
		else if(avg > 60) {
			System.out.println("Second Division");
		}
		else if(avg > 45) {
			System.out.println("Third Division");
		}		
		else {
			System.out.println("Fail");
		}
	}
}
