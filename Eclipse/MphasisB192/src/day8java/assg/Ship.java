package day8java.assg;

import java.util.*;

public class Ship {
	public static void main(String[] args) {
		LinkedList<Ticket> tic = new LinkedList<Ticket>();
		Scanner sc = new Scanner(System.in);
		int c;
		

		
		while(true) {
			System.out.println("0: Quit\n1: Add crew\n2: Add Passenger");
			System.out.print("Option: ");
			c = sc.nextInt();		
			
			if (c == 0) {
				break;
			}
			
			switch(c) {
			case 1: 
				Crew cr = new Crew();
				cr.getDetails();
				tic.add(cr);
				break;

			case 2: 
				Passenger p = new Passenger();
				p.getDetails();
				tic.add(p);
				break;

			default: 
				break;
			}
		}
		
		System.out.println("---------------------");
				
		for(Ticket t:tic) {
			t.print();
			System.out.println("---------------------");
		}
		
		sc.close();
	}
}
