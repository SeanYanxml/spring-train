package com.yanxml.spring.train.aop.config.file;

import org.aspectj.lang.ProceedingJoinPoint;

public class Interceptor {
	public void doBefore(){
		System.out.println("--执行前置通知--");
	}
	
	public void doAfterReturning(){
		System.out.println("--执行后置通知--");
	}
	
	public void doAfter(){
		System.out.println("--执行最终通知--");
	}
	
	public void doAfterThrowing(){
		System.out.println("--执行意外通知--");
	}
	
	public Object doAround(ProceedingJoinPoint pjb) throws Throwable{
		System.out.println("--进入判断方法--");
		Object result=pjb.proceed();//该方法必须被执行
		System.out.println("--退出判断方法--");
		return result;
	}

}
