package co.vinod.mait.programs;

import org.hibernate.Session;

import co.vinod.mait.entity.Person;
import co.vinod.mait.util.HibernateUtil;
import co.vinod.mait.util.KeyboardUtil;

public class P04_UpdatePersonData {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		int id = KeyboardUtil.getInt("Enter id: ");
		session.beginTransaction();
		Person p1 = (Person) session.get(Person.class, id);

		if (p1 == null) {
			System.out.println("No data found!");
		} else {
			String input;

			input = KeyboardUtil.getString("First name : (" + p1.getFirstName() + ") ");
			if (!input.equals("")) {
				p1.setFirstName(input);
			}

			input = KeyboardUtil.getString("Last name : (" + p1.getLastName() + ") ");
			if (!input.equals("")) {
				p1.setLastName(input);
			}

			input = KeyboardUtil.getString("Phone : (" + p1.getPhone() + ") ");
			if (!input.equals("")) {
				p1.setPhone(input);
			}

			input = KeyboardUtil.getString("Email : (" + p1.getEmail() + ") ");
			if (!input.equals("")) {
				p1.setEmail(input);
			}

			session.getTransaction().commit();
			System.out.println("Data updated back to the db.");

		}

	}
}
