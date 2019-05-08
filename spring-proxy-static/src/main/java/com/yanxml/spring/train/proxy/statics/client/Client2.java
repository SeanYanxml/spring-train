package com.yanxml.spring.train.proxy.statics.client;

import com.yanxml.spring.train.proxy.statics.UserManagerImpl;
import com.yanxml.spring.train.proxy.statics.UserManagerImplProxy;

public class Client2 {
	public static void main(String []args){
		UserManagerImplProxy userManagerImplProxy=new UserManagerImplProxy(new UserManagerImpl());
		userManagerImplProxy.addUser("testName", "testPassword");
	}

}
