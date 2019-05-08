package com.yanxml.spring.train.user.defined.setter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yanxml.spring.train.user.defined.setter.bean.Bean;

public class TestClass {
	@Test
	public void testMethod(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationEditor.xml"});
		Bean bean=(Bean) ctx.getBean("bean");
		System.out.println(bean.getDate());
	}

}
