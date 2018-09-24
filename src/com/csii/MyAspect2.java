package com.csii;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect2 implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("before--------------------开启事务！");
		//手动执行目标方法
		Object object = mi.proceed();
		System.out.println("after--------------------提交事务");
		return object;
	}

}
