 package com.test.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.beans.Student;

public class SpringApp {
	
	private static final Logger logger =LoggerFactory.getLogger(SpringApp.class);

	public static void main(String[] args) {
		// Load your configuration...create Spring container
		// the reference ApplicationContext interface is springContainer
		logger.debug("Main Method Started");
		
		logger.debug("### load applicationContext.xml #####");
		
		ApplicationContext springContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student studentObj=springContainer.getBean("student", Student.class);
		Student studentObj1=springContainer.getBean("student1", Student.class);
		Student studentObj2=springContainer.getBean("student1", Student.class);
		Student studentObj3=springContainer.getBean("student", Student.class);
		
		
		logger.debug("### Student object" + studentObj + "####");

	}

}
 