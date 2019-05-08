package com.yanxml.spring.train.quickstart;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yanxml.spring.train.quickstart.beans.PersonBean;


public class TestClass {
	@Test
	public void testMethod() throws Exception{
		//读取配置文件
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取Bean实例
		PersonBean personBean=(PersonBean) ctx.getBean("userBean");
		//调用实例方法
		personBean.show();
	}

}
