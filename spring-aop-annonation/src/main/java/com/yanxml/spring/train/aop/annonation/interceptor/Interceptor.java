package com.yanxml.spring.train.aop.annonation.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Interceptor
{
	@Pointcut("execution (* com.us.demo.UserManagerImpl.*(..))")
	public void anyMethod()  //���������
	{
		
	}
//	@Before("anyMethod()") //������Ϊ���������
//	public void doBefore()
//	{
//		System.out.println("----------------ִ��ǰ��֪ͨ-----------------");
//	}
	//���в���
	@Before("anyMethod() && args(name)") //��ʾִ���������з���������Ҫ�󷽷��еĲ���ֻ��һ�����������ַ�������
	public void doBefore(String name)
	{
		System.out.println("----------------ִDo Before-----------------");
	}
	
//	@AfterReturning("anyMethod()")
//	public void doAfterReturning()
//	{
//		System.out.println("----------------ִ�к���֪ͨ-----------------");
//	}
	//��ȡ���ؽ��,���ѷ��ؽ����Ϊ��������������
	@AfterReturning(pointcut="anyMethod()",returning="result")
	public void doAfterReturning(String result)
	{
		System.out.println("----------------ִDo After Returning-----------------");
	}
	
	@After("anyMethod()")
	public void doAfter()
	{
		System.out.println("----------------Do After-----------------");
	}
	
//	@AfterThrowing("anyMethod()")
//	public void doAfterThrowing()
//	{
//		System.out.println("----------------ִ������֪ͨ-----------------");
//	}
	//��ȡ�׳������⣬����������Ϊ��������������
	@AfterThrowing(pointcut="anyMethod()",throwing="e")
	public void doAfterThrowing(Exception e)
	{
		System.out.println("----------------ִException Throw----------------");
	}	
	@Around("anyMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("----------------Around Start----------------");
		Object result=pjp.proceed();  //�÷������뱻ִ��
		System.out.println("----------------Around End-----------------");
		return result;
	}
}
