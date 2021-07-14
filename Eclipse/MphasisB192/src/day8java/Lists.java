package day8java;

import java.util.*;

public class Lists {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("Apple");
		al.add("apple");
		al.add("Ball");
		al.add("Edge");
		al.add("Cat");
		al.add("Chrome");
		al.add("Dog");
		al.add("Apple");
		
		System.out.println("ArrayList: " + al);
		
		al.set(3, "Boot");
		al.remove(2);
		
		System.out.println("ArrayList: " + al);
		
		
		ArrayList<Integer> ial = new ArrayList<Integer>();
		
		ial.add(1);
		ial.add(5635);
		ial.add(45);
		ial.add(45);
		ial.add(420);
		ial.add(455);
		ial.add(452);
		ial.add(452);
		
		System.out.println("Int ArrayList: " + ial);
		
		ial.set(3, 69);
		ial.remove(2);
		
		System.out.println("Int ArrayList: " + ial);
		
		Collections.sort(ial);
		
		System.out.println("Int ArrayList Sorted: " + ial);
		
		Iterator<Integer> i = ial.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
