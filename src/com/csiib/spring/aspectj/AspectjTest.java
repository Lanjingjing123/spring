package com.csiib.spring.aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectjTest {
	@Test
	public void demo() {
		
		String classPath = "com/csiib/spring/aspectj/beans2.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(classPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
		
	}
}
