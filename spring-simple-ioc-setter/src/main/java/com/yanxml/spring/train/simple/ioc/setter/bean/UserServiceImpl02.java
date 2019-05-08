package com.yanxml.spring.train.simple.ioc.setter.bean;

public class UserServiceImpl02 implements UserService{
	PersonDao personDao;
	String name;
	UserServiceImpl02(){
		
	}
	UserServiceImpl02(PersonDao personDao){
		this.personDao=personDao;
	}
	UserServiceImpl02(PersonDao personDao,String name){
		this.personDao=personDao;
		this.name=name;
	}
	public void show(){
		personDao.show();
		System.out.println("name: "+name);
	}

}
