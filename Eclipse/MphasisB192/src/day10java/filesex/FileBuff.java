package day10java.filesex;

import java.io.*;

public class FileBuff {
	public static void main(String[] args) throws Exception {
		FileInputStream fin = new FileInputStream("Sample.txt");
		FileOutputStream fout = new FileOutputStream("BufferSample.txt");
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(fout);


		int ch;

		while((ch = bin.read()) != -1) {
			bout.write(ch);
		}

		System.out.println("Done");
		
		bin.close();
		bout.close();
	}
}
