package com.csii;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
	public static UserService createProxyBeans() {
		//创建目标类
		final UserService userService = new UserServiceImpl();
		//创建切面类
		final MyAspect myAspect = new MyAspect();
		//创建代理对象
		UserService proxyUser = (UserService) Proxy.newProxyInstance(BeanFactory.class.getClassLoader(),
				userService.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//执行目标方法前（切面，开启事务）
						myAspect.before();
						//执行目标方法
						Object object = method.invoke(userService, args);
						//执行目标方法后（提交事务）
						myAspect.after();
						return object;
						
					}
				});
		return proxyUser;
		
	}
}
