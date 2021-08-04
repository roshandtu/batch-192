package co.vinod.mait.programs;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.vinod.mait.entity.Person;
import co.vinod.mait.util.HibernateUtil;
import co.vinod.mait.util.KeyboardUtil;

public class P03_DeletePerson {

	public static void main(String[] args) {

		int id = KeyboardUtil.getInt("Enter id of the person to delete: ");

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try {
			Person p1 = (Person) session.get(Person.class, id);
			if (p1 == null) {
				System.out.println("No record to delete!");
			} else {
				session.delete(p1);
				session.getTransaction().commit();
				System.out.println("Data deleted successfully!");
			}
		} catch (HibernateException e) {
			System.out.println("Could not delete the data");
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		}

		session.close();

	}
}
