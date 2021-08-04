package co.vinod.mait.programs;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.vinod.mait.entity.Person;
import co.vinod.mait.util.HibernateUtil;
import co.vinod.mait.util.KeyboardUtil;

public class P02_AddNewPerson {

	public static void main(String[] args) {

		int id;
		String fname, lname, phone, email;

		id = KeyboardUtil.getInt("Enter id: ");
		fname = KeyboardUtil.getString("Enter firstname: ");
		lname = KeyboardUtil.getString("Enter lastname: ");
		phone = KeyboardUtil.getString("Enter phone: ");
		email = KeyboardUtil.getString("Enter email: ");

		Person p1 = new Person(id, fname, lname, phone, email);
		
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(p1);
			tx.commit();
			System.out.println("Data saved to db.");
		} catch (HibernateException e) {
			tx.rollback();
			System.out.println("There was an error while trying to save data.");
			System.out.println(e.getMessage());
		}
		
		session.close();
		

	}
}









