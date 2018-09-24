package com.csiib.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	/**
	 * 前置通知
	 * @param joinPoint
	 */
	public void before(JoinPoint joinPoint) {
		
		System.out.println("before method! 开启事物 前置通知");
	}
	
	/**
	 * 最终通知
	 * @param joinPoint
	 */
	public void after(JoinPoint joinPoint) {
		System.out.println("after method! 提交事务"+joinPoint.getKind());
	}
	/**
	 * 后置通知
	 * @param joinPoint
	 * @param ret
	 */
	public void afterReturning(JoinPoint joinPoint,Object ret) {
		System.out.println("后置通知！"+joinPoint.getSignature().getName()+"--->"+ret);
	}
	/**
	 * 环绕通知
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("前");
		Object object  = joinPoint.proceed();
		System.out.println("后");
		return object;
	}
	
	public void afterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("抛出异常通知："+e.getMessage());
	}
}
