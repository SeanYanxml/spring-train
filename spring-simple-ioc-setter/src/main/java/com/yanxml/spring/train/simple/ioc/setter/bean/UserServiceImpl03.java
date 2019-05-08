package com.yanxml.spring.train.simple.ioc.setter.bean;

import javax.annotation.Resource;

public class UserServiceImpl03 {
	//使用Resource 进行装配
	@Resource(name="personDao")
	private PersonDao personDao;
	public void show(){
		personDao.show();
	}
	

}
