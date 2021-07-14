package day9java;

import java.util.*;

public class HashMaps {
	public static void main(String[] args) {
		HashMap<Integer, String> hs = new HashMap<>();
		
		hs.put(1, null);
		hs.put(3, "Apple");
		hs.put(2, "");
		hs.put(4, "Ball");
		hs.put(5, "Apple");
		hs.put(8, "Cat");
		hs.put(6, "1233");
		hs.put(7, "...");
		hs.put(8, "Cats");
		
		System.out.println(hs);
		
		System.out.println("Key set: " + hs.keySet());
		System.out.println("Containes key 1: " + hs.containsKey(1));
		System.out.println("Contains value Apple: " + hs.containsValue("Apple") + ", apple: " + hs.containsValue("apple"));
		
	}
}
