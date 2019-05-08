package com.yanxml.spring.train.proxy.statics.client;

import com.yanxml.spring.train.proxy.statics.UserManager;
import com.yanxml.spring.train.proxy.statics.UserManagerImpl;

public class Client {
	public static void main(String []args){
		UserManager userManager=new UserManagerImpl();
		userManager.addUser("testName", "testPassword");
	}

}
