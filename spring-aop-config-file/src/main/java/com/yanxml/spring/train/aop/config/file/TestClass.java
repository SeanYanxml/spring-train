package com.yanxml.spring.train.aop.config.file;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
	@Test
	public void testMethod(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserManager userManager=(UserManager) ctx.getBean("userManager");
		userManager.addUser("testName", "testPassword");
	}

}
