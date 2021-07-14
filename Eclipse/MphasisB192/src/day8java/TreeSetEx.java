package day8java;

import java.util.*;

public class TreeSetEx {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("Apple");
		ts.add("apple");
		ts.add("Ball");
		ts.add("Edge");
		ts.add("Cat");
		ts.add("Chrome");
		ts.add("Dog");
		ts.add("Apple");
		
		System.out.println("TreeSet: " + ts);
		
		HashSet<String> hs = new HashSet<String>();

		hs.add("Apple");
		hs.add("apple");
		hs.add("Ball");
		hs.add("Edge");
		hs.add("Cat");
		hs.add("Chrome");
		hs.add("Dog");
		hs.add("Apple");

		System.out.println("HashSet: " + hs);
		
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();

		lhs.add("Apple");
		lhs.add("apple");
		lhs.add("Ball");
		lhs.add("Edge");
		lhs.add("Cat");
		lhs.add("Chrome");
		lhs.add("Dog");
		lhs.add("Apple");

//		System.out.println("LinkedHashSet: " + lhs);	
		
		for(Object ob:lhs) {
			System.out.println(ob);
		}
		
	}
}
