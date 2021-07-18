package a10;

import java.util.*;

public class Run {
	public static void main(String[] args) {
		Map<Integer, Employee> emp = new HashMap<Integer, Employee>();

		int c, k = 0;
		Scanner s = new Scanner(System.in);

		while(true) {
			System.out.print("0: Quit, 1: Add Employee\nChoice: ");
			c = s.nextInt();

			if(c == 0) {
				break;
			}

			else if(c == 1) {
				Employee e = new Employee();

				k = emp.keySet().toArray().length;

				System.out.println("Emp No.: " + (k + 1));

				e.getDetails(k+1);

				emp.put(k, e);
			}
		}
		
		System.out.println("\n");
		
		for(Map.Entry<Integer, Employee> en: emp.entrySet()) {
			System.out.print(((Integer) en.getKey() + 1) + " : " + en.getValue().retName() + " | ");
		}
	
		
		while(true) {
			System.out.print("\n0: Quit, 1: Deposit, 2: Withdraw\nChoice: ");
			c = s.nextInt();

			if(c == 0) {
				break;
			}
			
			System.out.print("Enter employee ID: ");
			int id = s.nextInt();
			Employee em = emp.get(id-1);
			
			if(c == 1) {
				em.deposit();
			}
			
			else if(c == 2) {
				em.withdraw();
			}
		}

		System.out.println("\n");

		for(Map.Entry<Integer, Employee> en: emp.entrySet()) {
			en.getValue().print();
			System.out.println("-------------------------");
		}
	}
}
