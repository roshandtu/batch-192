package co.vinod.mait.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static Session getSession() {
		// empty configuration object
		Configuration cfg = new Configuration();
		// read the hibernate.cfg.xml
		cfg.configure();
		// obtain a session-factory object
		SessionFactory factory = cfg.buildSessionFactory();
		// get a new session 
		return factory.openSession();
	}

}
