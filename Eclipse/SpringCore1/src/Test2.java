import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test2 {
	public static void main(String[] args) {
		Resource r = new ClassPathResource("hasarelation.xml");
		BeanFactory bf = new XmlBeanFactory(r);
		
		Employee e1 = (Employee) bf.getBean("e1");
		e1.show();
	}
}
