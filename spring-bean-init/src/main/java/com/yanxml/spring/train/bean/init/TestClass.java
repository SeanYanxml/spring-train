package com.yanxml.spring.train.bean.init;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yanxml.spring.train.bean.init.beans.PersonBean;

public class TestClass {
	@Test
	public void testMethod() throws Exception{
		//读取配置文件
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取Bean实例
		//三种加载Bean的方式都可以 进行Bean的配置
		PersonBean personBean1=(PersonBean) ctx.getBean("userBean1");
		PersonBean personBean2=(PersonBean) ctx.getBean("userBean2");
		PersonBean personBean3=(PersonBean) ctx.getBean("userBean3");
		//调用实例方法
		
		personBean1.show();
		personBean2.show();
		personBean3.show();


	}

}
