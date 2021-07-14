package day7java;

import java.util.*;

public class TryCatch1 {
	public static void main(String[] args) {
		try
		{
			try
			{
				Scanner ob=new Scanner(System.in);
				System.out.println("enter 2 nos");
				int a=ob.nextInt();
				int b=ob.nextInt();
				int c=a/b;
				System.out.println("the result is "+c);
			}
			catch(Exception x) //handle all type of error
			{
				System.out.println("the inner error is "+x);
			}
			Scanner ob=new Scanner(System.in);
			System.out.println("enter 1 no");
			int d=ob.nextInt();
		}
		catch(Exception x) //handle all type of error
		{
			System.out.println("the out error is "+x);
		}

		finally
		{
			System.out.println("this is end of the program");
		}

	}
}

