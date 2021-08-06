import java.util.Iterator;
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
 
public class Logic {
 
    
    public static void main(String[] args)
    {
 
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
 
Criteria crit = session.createCriteria(Product.class);//Criteria is interface used to build the query
Criterion cn = Restrictions.gt("price",new Double(100));//Criterian is interface used for condition
        crit.add(cn);//added criterion interface object to criteria object
        List l=crit.list();//executed criteria query by calling list() method in criteria
        System.out.println("List total size..._"+l.size());
        Iterator it=l.iterator();
 
        while(it.hasNext())
        {
            Product p=(Product)it.next();//in this case we must typecast into our POJO class type only
            System.out.println(p.getProductId());
            System.out.println(p.getProName());
            System.out.println(p.getPrice());
            System.out.println("-----------------");
        }
 
        session.close();
        factory.close();
    }
 
}








