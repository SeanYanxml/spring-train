package com.yanxml.spring.train.proxy.dynamic.client;

import com.yanxml.spring.train.proxy.dynamic.SecurityHandler;
import com.yanxml.spring.train.proxy.dynamic.UserManager;
import com.yanxml.spring.train.proxy.dynamic.UserManagerImpl;

public class Client {
	public static void main(String []args){
		SecurityHandler handler=new SecurityHandler();
		//使用代理机制 和 反射机制 获取 实例对象 
		//此处为动态代理
		//使用动态代理 开关方便 
		//使用反射机制方法更加具有通用性
		UserManager userManager=(UserManager) handler.newProxy(new UserManagerImpl());
		userManager.addUser("testName", "testPassword");
	}

}
