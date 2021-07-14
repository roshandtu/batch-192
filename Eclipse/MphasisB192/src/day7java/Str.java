package day7java;

import java.lang.String;

public class Str {
	public static void main(String[] args) {
		String s1 = "apple";
		String s2 = "apple";			//since the values are same, only one block of memory 
										//will be created to store apple and s1 and s2 will
										//point to it
		
		String s3 = new String("apple");//new keyword will force java to create new a new memory 
		String s4 = new String("apple");//block
		
		if(s1 == s2)
			System.out.println("1 - t");
		else
			System.out.println("1 - f");
		
		if(s1 == s3)
			System.out.println("2 - t");
		else
			System.out.println("2 - f");
		
		if(s3 == s4)
			System.out.println("3 - t");
		else
			System.out.println("3 - f");
		
		if(s3.equals(s4))
			System.out.println("4 - t");
		else
			System.out.println("4 - f");
		
		
		StringBuffer s5 = new StringBuffer("hello");
		StringBuffer s6 = new StringBuffer("hello");
		
		if(s5.toString().equals(s6.toString()))
			System.out.println("5 - t");
		else
			System.out.println("5 - f");
	}

}
