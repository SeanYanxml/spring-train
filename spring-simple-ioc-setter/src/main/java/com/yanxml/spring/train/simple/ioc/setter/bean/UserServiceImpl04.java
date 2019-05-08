package com.yanxml.spring.train.simple.ioc.setter.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl04 implements UserService{
	//使用Spring的默认配置进行装配
	@Autowired
	private PersonDao personDao;
	//使用名字进行装配
	//	@Autowired
	//	@Qualifier("personDao")
	//	private PersonDao personDao;
	public void show(){
		personDao.show();
	}

}
