package day10java.filesex;

import java.io.*;

public class FileCopy {
	public static void main(String[] args) throws Exception {
		FileInputStream fin = new FileInputStream("Sample.txt");
		FileOutputStream fout = new FileOutputStream("Sample2.txt");
		
		int ch;
		
		while((ch = fin.read()) != -1) {
			fout.write(ch);
		}
		
		System.out.println("Done");
		
		fin.close();
		fout.close();
	}
}
