package co.vinod.mait.util;

import java.util.Scanner;

@SuppressWarnings("resource")
public class KeyboardUtil {

	public static String getString(String message) {
		System.out.print(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static int getInt(String message) {
		System.out.print(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static double getDouble(String message) {
		System.out.print(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
}
