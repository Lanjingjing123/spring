package com.csii;



public class MyAspect {
	public void before() {
		System.out.println("before method! 开启事物");
	}
	
	public void after() {
		System.out.println("after method! 提交事务");
	}

}
