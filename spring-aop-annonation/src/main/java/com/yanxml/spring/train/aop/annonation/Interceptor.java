package com.yanxml.spring.train.aop.annonation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Interceptor {
	//@Pointcut("excution (* com.us.demo.UserManagerImpl.*(..))")
	@Pointcut("execution (* com.us.demo.UserManagerImpl.*(..))")
	private void anyMethod(){
		//定义切入点		
	}
	//异常时下方的问题
/*	
	@Before("anyMethod() && args(name)") 
	public void doBefore(){
		System.out.println("--执行前置通知--");
	}*/
	@Before("anyMethod()")
	public void doBefore(){
		System.out.println("--执行前置通知--");
	}
	
	@AfterReturning("anyMethod()")
	public void doAfterReturning(){
		System.out.println("--执行后置通知--");
	}
	
	@After("anyMethod()")
	public void doAfter(){
		System.out.println("--执行最终通知--");
	}
	
	@AfterThrowing("anyMethod()")
	public void doAfterThrowing(){
		System.out.println("执行意外通知");
	}
	
	@Around("anyMethod()")
	public Object doAround(ProceedingJoinPoint pjb) throws Throwable{
		System.out.println("--前置判断方法--");
		Object object=pjb.proceed();//该方法必须被执行
		System.out.println("--退出判断方法--");
		return object;
	}

}
