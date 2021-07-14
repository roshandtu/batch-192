//wa.p to enter objects of employee class into an arrayList and display it.
//employee :- empno,name,salary and designation

package day8java;

import java.util.*;

public class Assg1 {
	public static void main(String[] args) {
		ArrayList<Object> emp = new ArrayList<Object>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name: ");
		emp.add(sc.next());
		
		System.out.print("Employee Number: ");
		emp.add(sc.next());
				
		System.out.print("Designation: ");
		emp.add(sc.next());
		
		System.out.print("Salary: ");
		emp.add(sc.next());
		
		System.out.println(emp);
		
		emp.clear();
		System.out.println(emp);
		sc.close();
	}
}
