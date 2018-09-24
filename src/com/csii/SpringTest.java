package com.csii;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
//	@Test
//	public void demo() {
//		String classPath = "com/csii/beans.xml";
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(classPath);
//		UserService userService = (UserService) applicationContext.getBean("userServiceId");
//		userService.addUser();
//		userService.deleteUser();
//		userService.updateUser();
//	}
//	/**
//	 * 手动
//	 */
//	@Test
//	public void demo2() {
//		BeanFactory beanFactory = new BeanFactory();
//		UserService userService = beanFactory.createProxyBeans();
//		userService.addUser();
//		userService.deleteUser();
//		userService.updateUser();
//	}
	/**
	 * 半自动aop
	 */
	@Test
	public void demo3() {
		String classPath = "com/csii/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(classPath);
		UserService userService =  (UserService) applicationContext.getBean("proxyUser");
		userService.addUser();
		userService.deleteUser();
		userService.updateUser();
	}
	/**
	 * 全自动aop
	 */
	@Test
	public void demo4() {
		String classPath = "com/csii/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(classPath);
		System.out.println(applicationContext);
		UserService userService =  (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		userService.deleteUser();
		userService.updateUser();
	}
}
