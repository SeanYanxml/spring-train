package com.yanxml.spring.train.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxyFactory implements MethodInterceptor {
	public Object targetObject;
	public Object newProxy(Object targetObject){
		this.targetObject=targetObject;
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(this.targetObject.getClass());
		enhancer.setCallback(this);
		//返回代理对象
		return enhancer.create();
	}
	public void checkMethod(){
		System.out.println("---check Method----");
	}

	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		checkMethod();
		Object ret=null;
		try{
			//调用目标对象的真实方法  
			ret=method.invoke(this.targetObject, args);
			//ret接受存在的返回值，不存在返回值则为Null  
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ret;
	}
	

}
