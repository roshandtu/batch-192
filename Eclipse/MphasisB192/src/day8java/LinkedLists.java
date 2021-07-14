package day8java;
import java.util.*;

public class LinkedLists {
	public static void main(String[] args) {
		LinkedList<Object> ll = new LinkedList<Object>();
		LinkedList<Object> ll2 = new LinkedList<Object>();
		
		ll.add(100);
		ll.add("apple");
		ll.add("Apple");
		ll.add(100);
		ll.add(20);
		
		System.out.println(ll);
		
		ll.addFirst("First");
		ll.addLast("Last");
		
		System.out.println(ll);
		
		ll2.add(1020);
		ll2.add("ball");
		ll2.add("Ball");
		ll2.add(1200);
		ll2.add(220);
		
		ll.remove();				//removes first element
		ll.remove(3);
		
		System.out.println(ll);
		
		ll.addAll(0, ll2);
		
		System.out.println(ll);
	}
}
