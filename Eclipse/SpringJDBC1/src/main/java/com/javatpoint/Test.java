package com.javatpoint;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");
		
//		int status = dao.saveEmployee(new Employee(105,"Roosafeed",35000));
//		System.out.println(status);

//			int status1 = dao.updateEmployee(new Employee(105,"Sonoo",15000));
//			System.out.println(status1);


//		Employee e = new Employee();
//		e.setId(105);
//		int status = dao.deleteEmployee(e);
//		System.out.println(status);
		
//		boolean b = dao.saveEmployeeByPreparedStatement(new Employee(106, "Akhil", 35000));
//		System.out.println(b);
	
		List<Employee> list = dao.getAllEmployees();

		for(Employee e2:list)
			System.out.println(e2.toString());
		
		System.out.println("------------------------");
		
		List<Employee> list2 = dao.getAllEmployeesRowMapper();

		for(Employee e:list2)
			System.out.println(e);
		
	}

}
