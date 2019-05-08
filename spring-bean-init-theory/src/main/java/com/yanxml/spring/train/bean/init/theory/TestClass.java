package com.yanxml.spring.train.bean.init.theory;

import org.junit.Test;
import com.yanxml.spring.train.bean.init.theory.beans.PersonBean;
import com.yanxml.spring.train.bean.init.theory.spring.MyClassPathXmlApplicationContext;

public class TestClass {
	
	/*@Test
	public  void testMethod() throws Exception{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonBean personBean =(PersonBean) ctx.getBean("userBean");
		personBean.show();
	}*/
	
	@Test
	public void testMethod() throws Exception{
		//读取配置文件
		MyClassPathXmlApplicationContext ctx=new MyClassPathXmlApplicationContext("applicationContext.xml");
		//获取Bean实例
		PersonBean bean=(PersonBean) ctx.getBean("userBean");
		//调用方法;
		bean.show();
	}

}
