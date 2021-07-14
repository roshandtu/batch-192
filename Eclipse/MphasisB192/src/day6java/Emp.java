package day6java;

import java.lang.*;
import java.util.*;

interface employee {
	int a = 10;
	void getDetails();
	void dispDetails();
}

interface dept {
	void getDeptDetails();
	void dispDeptDetails();
}

public class Emp implements employee, dept {	
	protected int eno, dno;
	protected String name, dname, addr, loc;
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void getDeptDetails() {		
		System.out.print("Dept Number: ");
		dno = sc.nextInt();
		System.out.print("Dept Name: ");
		dname = sc.next();
		System.out.print("Dept Location: ");
		loc = sc.next();
	}

	@Override
	public void dispDeptDetails() {
		System.out.println(dno + " - " + dname + " located at " + loc);		
	}

	@Override
	public void getDetails() {
		System.out.print("Employee Number: ");
		eno = sc.nextInt();
		System.out.print("Name: ");
		name = sc.next();
		System.out.print("Address: ");
		addr = sc.next();
	}

	@Override
	public void dispDetails() {
		System.out.println(eno + " - " + name + ". \nAddress: " + addr);	
	}
	
	public static void main(String[] args) {
		Emp p = new Emp();
		
		System.out.println(a);
		p.getDeptDetails();
		p.dispDeptDetails();
		
		p.getDetails();
		p.dispDetails();
	}

}
