import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  

public class Test {  
	public static void main(String[] args) {  
		Resource resource = new ClassPathResource("studSetter.xml");  
		BeanFactory factory = new XmlBeanFactory(resource);  

		System.out.println("Setter");
		Student student = (Student)factory.getBean("stud1");  
		student.display();  

		System.out.println("------");

		Student student1 = (Student)factory.getBean("stud2");  
		student1.display();  

		System.out.println("---------------------------");
		System.out.println("Constructor");
		
		Resource resource2 = new ClassPathResource("studConstruct.xml"); 
		factory = new XmlBeanFactory(resource2);
		
		Student s1 = (Student)factory.getBean("s1");  
		student.display();  

		System.out.println("------");

		Student s2 = (Student)factory.getBean("s2");  
		student1.display();  
	}  
}  


//commons.logging.1.1.1.jar
//springframework.beans-3.0.1.Release-A.jar
//springframework.core-3.0.1.Release-A.jar