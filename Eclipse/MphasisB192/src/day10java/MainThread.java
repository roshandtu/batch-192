package day10java;

import java.lang.*;

public class MainThread {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();
		
		System.out.println(Thread.currentThread().getName());
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("T1 alive? " + t1.isAlive());
		System.out.println("T2 alive? " + t2.isAlive());
		System.out.println("T3 alive? " + t3.isAlive());
		
		try {
//			wait till t1 is dead
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("T1 alive? " + t1.isAlive());
	}
}
