package com.yanxml.spring.train.bean.common.setter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yanxml.spring.train.bean.common.setter.bean.Bean1;


public class TestClass2 {
	@Test
	public void testMethod(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"applicationCommon.xml","applicationCommon2.xml"});
		//貌似这种方式无法进行加载
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationCommon*.xml");

		//Bean2 bean2=(Bean2) ctx.getBean("bean2");
		Bean1 bean1=(Bean1) ctx.getBean("bean1");
		
		//System.out
		System.out.println("bean2:id "+bean1.getBean2().getId());
		System.out.println("bean2:name "+bean1.getBean2().getName());
		System.out.println("bean2:password "+bean1.getBean2().getPassword());
		System.out.println("bean3:id "+bean1.getBean3().getId());
		System.out.println("bean3:name "+bean1.getBean3().getName());
		System.out.println("bean4:age "+bean1.getBean4().getAge());
	}

}
