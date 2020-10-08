package btkSpring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICustomerService customerService = 
				context.getBean("service",ICustomerService.class);
		
		/*CustomerManager customerManager = 
				new CustomerManager(context.getBean("database", ICustomerDal.class));
		
		customerManager.add();*/
		
		customerService.add();
	}

}
