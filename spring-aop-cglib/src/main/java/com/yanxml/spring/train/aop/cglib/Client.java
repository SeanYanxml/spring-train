package com.yanxml.spring.train.aop.cglib;

public class Client {
	public static void main(String []args){
		CGlibProxyFactory cGlibProxyFactory=new CGlibProxyFactory();
		//创建代理对象
		UserManager userManager=(UserManager) cGlibProxyFactory.newProxy(new UserManagerImpl() );
		userManager.addUser("testUser", "testPassword");
	}

}
