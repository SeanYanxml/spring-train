package com.yanxml.spring.train.bean.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yanxml.spring.train.bean.autowire.service.UserService;


public class TestClass {
	@Test
	public void testMethod(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) ctx.getBean("userService");
		userService.show();
		((ClassPathXmlApplicationContext)ctx).close();
		//((AbstractApplicationContext) ctx).close();
	}

}
