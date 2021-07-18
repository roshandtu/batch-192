package a7;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Person p = new Person();
		
		Scanner sc = new Scanner(System.in);
		String n, d, l, a;
		int en, dn;
		
		System.out.print("Employee No.: ");
		en = sc.nextInt();
		sc.nextLine(); //take out the extra \n
		System.out.print("Name: ");
		n = sc.nextLine();
		System.out.print("Address: ");
		a = sc.nextLine();
		
		System.out.print("Department No.: ");
		dn = sc.nextInt();
		sc.nextLine(); //take out the extra \n
		System.out.print("Department: ");
		d = sc.nextLine();
		System.out.print("Department Location: ");
		l = sc.nextLine();
		
		p.inputEmpDetails(en, n, a);
		p.inputDepDetails(dn, d, l);
		
		p.dispEmpDetails();
		System.out.println("");
		p.dispDepDetails();
		
	}
}
