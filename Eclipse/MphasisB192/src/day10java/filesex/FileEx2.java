package day10java.filesex;

import java.io.*;

public class FileEx2 {
	public static void main(String[] args) throws Exception {
		DataInputStream dis = new DataInputStream(System.in);
		FileOutputStream fs = new FileOutputStream("Sample.txt");
		
		int ch;
		System.out.println("Write:");
		while((ch = dis.read()) != '\t') {
			fs.write(ch);			
		}
		
	}
}
