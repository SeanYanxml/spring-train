package com.yanxml.spring.train.bean.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yanxml.spring.train.bean.config.beans.PersonBean;


public class TestClass {
	
	@Test
	public  void testMethod() throws Exception{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonBean personBean1 =(PersonBean) ctx.getBean("userBean");
		PersonBean personBean2=(PersonBean) ctx.getBean("userBean");
		//personBean1.show();
		System.out.print(personBean1==personBean2);
		//personBean.show();
	}
	
/*	@Test
	public void testMethod() throws Exception{
		//读取配置文件
		MyClassPathXmlApplicationContext ctx=new MyClassPathXmlApplicationContext("applicationContext.xml");
		//获取Bean实例
		UserBean bean=(UserBean) ctx.getBean("userBean");
		//调用方法;
		bean.show();
	}
*/
}
