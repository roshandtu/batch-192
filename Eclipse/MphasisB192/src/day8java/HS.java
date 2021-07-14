package day8java;

import java.util.*;

public class HS {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		
		System.out.println("Empty? " + hs.isEmpty());
		
		hs.add(100);
		hs.add(200);
		hs.add(300);
		hs.add(400);
		hs.add(500);
		hs.add(600);
		hs.add(100);
		
		System.out.println(hs);
		System.out.println("size: " + hs.size());
		System.out.println("Empty? " + hs.isEmpty());
		System.out.println("300? " + hs.contains(300));
		hs.remove(300);
		System.out.println(hs);
		System.out.println("300? " + hs.contains(300));
		
	}
}
