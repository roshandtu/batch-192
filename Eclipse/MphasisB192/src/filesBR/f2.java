package filesBR;

import java.io.*;
class f2
{   
	public static void main(String args[]) throws Exception
	{
		FileReader fr = new FileReader("Sample.txt");//read data in character format
		BufferedReader br = new BufferedReader(fr);
		String name;
		
		
		while((name = br.readLine()) != null)//null is EOF in character stream
		{
			System.out.println(name);
		}
		
		fr.close();
		br.close();
		System.out.println("file copied.....");
	}}
