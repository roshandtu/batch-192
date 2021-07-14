package day9java.assg1;
import java.util.*;

public class Book {
	protected int id, qty;
	protected String name, author, publisher;
	
	void getDetails(int slno) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name of the book: ");
		this.name = sc.next();
		System.out.print("Author of the book: ");
		this.author = sc.next();
		System.out.print("Publisher of the book: ");
		this.publisher = sc.next();
		System.out.print("Units available: ");
		this.qty = sc.nextInt();
		this.id = slno;
//		sc.close();
	}
	
	void print() {
		System.out.println("SlNo: " + this.id);
		System.out.println("Name: " + this.name + ", by " + this.author);
		System.out.println("Published by " + this.publisher);
		System.out.println(this.qty + " units available");
	}
	
	
	public static void main(String[] args) {
		Map<Integer, Book> books = new HashMap<Integer, Book>();
		
		Scanner s = new Scanner(System.in);
		int c, k = 0;
		
		while(true) {
			System.out.print("0: Quit, 1: Add book\nChoice: ");
			c = s.nextInt();
			
			if(c == 0) {
				break;
			}
			
			else if(c == 1) {
				Book b = new Book();
				
//				k = (books.keySet().isEmpty()) ? 0 : (Integer) books.keySet().toArray()[books.keySet().toArray().length - 1];
				k = books.keySet().toArray().length;
				
				System.out.println("Sl No.: " + (k + 1));
				b.getDetails(k + 1);
				
				books.put(k, b);
			}
		}
		
		System.out.println("\n");
		
		for(Map.Entry<Integer, Book> en: books.entrySet()) {
			en.getValue().print();
			System.out.println("-------------------------");
		}
	}
	
}
