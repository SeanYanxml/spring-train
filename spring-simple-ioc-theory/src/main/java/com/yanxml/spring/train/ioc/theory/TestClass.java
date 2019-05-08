package com.yanxml.spring.train.ioc.theory;

import org.junit.Test;
import com.yanxml.spring.train.ioc.theory.core.MyClassPathXmlApplicationContext;
import com.yanxml.spring.train.ioc.theory.service.UserService;

public class TestClass {
/*	@Test
	public void testMethod(){
		ApplicationContext ctx=new  ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) ctx.getBean("userService");
		userService.show();
	}*/
	@Test
	public void testMethod() throws Exception {
		MyClassPathXmlApplicationContext ctx = new MyClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("userService");
		service.show();
	}

}
