package day10java.filesex;

import java.io.*;
import java.util.Scanner;

public class FilesEx1 {
	public static void main(String[] args) {
		
//		String fname = args[0];
		String fname = "Sample.txt";
		File f = new File(fname);
		
		if(f.exists()) {
			System.out.println("Name: " + f.getName());
			System.out.println("Relative Path: " + f.getPath());
			System.out.println("Abs path: " + f.getAbsolutePath());
			System.out.println("Readable: " + f.canRead());
			System.out.println("Writable: " + f.canWrite());
			System.out.println("Exist: " + f.exists());
			System.out.println("File: " + f.isFile());
			System.out.println("Folder: " + f.isDirectory());
			System.out.println("Length: " + f.length());
			
			if(f.canRead()) {
				try {
					Scanner r = new Scanner(f);
					System.out.println("File Contents:\n" + r.nextLine());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}		
		
		else {
			System.out.println("File does not exist");
		}
	}
}
