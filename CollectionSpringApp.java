 package com.test.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.beans.ReferenceData;

public class CollectionSpringApp {
	
	private static final Logger logger =LoggerFactory.getLogger(CollectionSpringApp.class);

	public static void main(String[] args) {
		// Load your configuration...create Spring container
		// the reference ApplicationContext interface is springContainer
		logger.debug("Main Method Started");
		
		logger.debug("### load applicationContext.xml #####");
		
		ApplicationContext springContainer = new ClassPathXmlApplicationContext("collectionApplicationContext.xml");
		
		ReferenceData referenceObj=springContainer.getBean(ReferenceData.class);
		logger.debug("### referenceData object" + referenceObj  + "####");

	}

}
 