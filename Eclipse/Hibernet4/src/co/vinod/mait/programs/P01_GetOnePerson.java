package co.vinod.mait.programs;

import org.hibernate.Session;

import co.vinod.mait.entity.Person;
import co.vinod.mait.util.HibernateUtil;

public class P01_GetOnePerson {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();

		int id = 101;
		Person p1 = (Person) session.get(Person.class, id);

		if (p1 == null) {
			System.out.println("No data found!");
		} else {
			System.out.println("Name  = " + p1.getFirstName() + " "
					+ p1.getLastName());
			System.out.println("Phone = " + p1.getPhone());
			System.out.println("Email = " + p1.getEmail());
		}

	}

}
