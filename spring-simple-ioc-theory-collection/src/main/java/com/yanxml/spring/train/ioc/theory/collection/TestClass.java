package com.yanxml.spring.train.ioc.theory.collection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yanxml.spring.train.ioc.theory.collection.service.UserService;


public class TestClass {
	@Test
	public void testMethod(){
		ApplicationContext ctx=new  ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) ctx.getBean("userService");
		userService.show();
	}

}
