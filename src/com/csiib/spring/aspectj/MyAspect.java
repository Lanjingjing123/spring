package com.csiib.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @author apple
 * 
 */
@Component
@Aspect
public class MyAspect {
	//声明公共切入点
	@Pointcut("execution(* com.csiib.spring.aspectj.*.*(..))")
	private void pointCut() {
	}
	
	/**
	 * 前置通知（当前切入点有效）
	 * @param joinPoint
	 */
	
//	@Before("execution(* com.csiib.spring.aspectj.*.*(..))")
	public void before(JoinPoint joinPoint) {
		
		System.out.println("before method! 开启事物 前置通知");
	}
	
	/**
	 * 最终通知
	 * @param joinPoint
	 */
	@After(value="pointCut")
	public void after(JoinPoint joinPoint) {
		System.out.println("after method! 提交事务"+joinPoint.getKind());
	}
	/**
	 * 后置通知
	 * @param joinPoint
	 * @param ret
	 */
	
//	@AfterReturning(value="pointCut()",returning="ret")
	public void afterReturning(JoinPoint joinPoint,Object ret) {
		System.out.println("后置通知！"+joinPoint.getSignature().getName()+"--->"+ret);
	}
	/**
	 * 环绕通知
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
//	@Around(value="execution(* com.csiib.spring.aspectj.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("前");
		Object object  = joinPoint.proceed();
		System.out.println("后");
		return object;
	}
	
//	@AfterThrowing(value="pointCut()",throwing="e")
	public void afterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("抛出异常通知："+e.getMessage());
	}
}
