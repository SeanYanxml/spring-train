package com.yanxml.spring.train.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SecurityHandler implements InvocationHandler{

	//目标对象
	private Object targetObject;
	public Object newProxy(Object targetObject){
		//动态代理
		this.targetObject=targetObject;
		//java.lang.reflect 中
		//使用java的反射机制 进行返回类
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
	}
	public void checkMethod(){
		System.out.println("----Check Method----");
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		// InvocationHandler 中必须的实现方法
		checkMethod();
		Object ret=null;
		try{
			//调用目标对象的真实方法
			ret=method.invoke(this.targetObject, args);
			//ret 接收存在的返回值  若无返回值 则返回null
		}catch(Exception e){
			e.printStackTrace();
		}
		return ret;
	}
	

}
