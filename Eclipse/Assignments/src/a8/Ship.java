package a8;

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
		
		int child = 0,
			adult = 0,
			crew = 0;
		
		System.out.println("---------------------");
				
		for(Ticket t:tic) {
			t.print();
			System.out.println("---------------------");
			if(t.getType().equals("crew"))
				crew++;
			else if(t.getType().equals("adult"))
				adult++;
			else if(t.getType().equals("child"))
				child++;
		}
		
		System.out.println("Total number of each tickets:");
		System.out.println("Crews: " + crew);
		System.out.println("Adults (age > 10): " + adult);
		System.out.println("Children (age <= 10): " + child);
		
		sc.close();
	}
}
