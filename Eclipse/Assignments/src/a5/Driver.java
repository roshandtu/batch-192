package a5;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Student s = new Student();
		Scanner sc = new Scanner(System.in);
		
		String temp;
		int tempint;
		
		System.out.print("Rollno: ");
		tempint = sc.nextInt();
		s.setRollNo(tempint);

		//Catch the extra line break		
		sc.nextLine();
		
		System.out.print("Name: ");
		temp = sc.nextLine();
		s.setName(temp);
		
		System.out.print("Address: ");
		temp = sc.nextLine();
		s.setAddress(temp);
		
		System.out.print("School: ");
		temp = sc.nextLine();
		s.setSchoolName(temp);
		
		System.out.print("School Location: ");
		temp = sc.nextLine();
		s.setLoc(temp);
		
		System.out.print("Board: ");
		temp = sc.nextLine();
		s.setBoard(temp);
		
		System.out.println("------------------");
		
		System.out.println(s.getRollNo() + " - " + s.getName());
		System.out.println(s.getAddress());
		System.out.println("School: " + s.getSchoolName() + ", " + s.getLoc());
		System.out.println("Board: " + s.getBoard());
		
		
	}
	
}
