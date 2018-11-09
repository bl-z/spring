package com.ss;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookDao {
	
	 @Test   
	public void testBook() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("container.xml");
		Object bean = context.getBean("book2");
		System.out.println(bean);
		
		
	}

}
