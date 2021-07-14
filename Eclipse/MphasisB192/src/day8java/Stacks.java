package day8java;
import java.util.*;

public class Stacks {
	public static void main(String[] args) {
		Stack<Object> st = new Stack<Object>();
		
		st.push(100);
		st.push(200);
		st.push("Apple");
		st.push(100);
		st.push("apple");
		
		System.out.println(st);
		System.out.println("Pop: " + st.pop());
		System.out.println(st);
		System.out.println("Peek: " + st.peek());
		System.out.println(st);
		System.out.println("index(Apple): " + st.indexOf("Apple"));
		
	}
}
