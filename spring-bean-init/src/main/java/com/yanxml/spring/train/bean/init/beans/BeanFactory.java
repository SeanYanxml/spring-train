package com.yanxml.spring.train.bean.init.beans;

public class BeanFactory {
	
	//静态工厂实例化使用
	public static PersonBean UserBeanService(){
		return new UserBean();
	}
	
	//动态工厂
	public PersonBean getUserBeanService(){
		return new UserBean();
	}

}
