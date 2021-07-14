package day7java;

import java.util.*;

public class ThrowsEx {
	static void getSalary() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter salary: ");
		int sal = sc.nextInt();
		
		sc.close();
		
		if(sal < 15000) {
			throw new Exception("Salary less than 15,000");
		}
		else {
			System.out.println("Approved");
		}
	}
	
	public static void main(String[] args) {
		try {
			getSalary();
		}
		catch(Exception e) {
			e.printStackTrace();
//			System.out.println("Error: " + e);
		}
	}
}
