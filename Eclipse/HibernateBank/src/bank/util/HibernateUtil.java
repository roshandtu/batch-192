package bank.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static Session getSess() {
		Configuration config = new Configuration();
		config.configure();
		
		return config.buildSessionFactory().openSession();
	}

}
