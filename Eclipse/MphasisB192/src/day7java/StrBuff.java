package day7java;

public class StrBuff {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("hello");
		
		System.out.println(s1);
		System.out.println("capacity: " + s1.capacity() + ", len: " + s1.length());
		System.out.println(s1.append(" world"));
		System.out.println("capacity: " + s1.capacity() + ", len: " + s1.length());
		System.out.println(s1.insert(6, "1my "));
		System.out.println("capacity: " + s1.capacity() + ", len: " + s1.length());
		System.out.println(s1.delete(6, 7));
		System.out.println("ind 6: " + s1.charAt(4));
		System.out.println("ind 9: " + s1.charAt(9));
		System.out.println(s1.replace(6, 9, ""));
		System.out.println(s1.append(" "));
		System.out.println(s1.append(s1.reverse()));
		System.out.println("capacity: " + s1.capacity() + ", len: " + s1.length());
		System.out.println(s1.reverse().substring(0, 12));
		System.out.println("capacity: " + s1.capacity() + ", len: " + s1.length());
		s1.setLength(5);
		s1.setCharAt(0, 'H');
		System.out.println(s1);
		System.out.println("capacity: " + s1.capacity() + ", len: " + s1.length());
//		System.out.println();
	}
}
