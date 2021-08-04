import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class Logic {
 
    public static void main(String[] args)
    {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        
        
        Session session = factory.openSession();       
 
            Query qry = session.createQuery("delete from Product p where p.productId=?");
            qry.setParameter(0,2);
            int res = qry.executeUpdate();
 
            System.out.println("Command successfully executed....");
            System.out.println("Numer of records effected due to delete query"+res);
 
        session.close();
        factory.close();
    }
 
}

//create table product(pid number,pname varchar2(30),price number);