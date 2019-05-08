package com.yanxml.spring.train.simple.ioc.setter.bean;

public class UserServiceImpl implements UserService{
	private PersonDao personDao;
	
	
	//Setter 方式进行初始化
	public PersonDao getPersonDao() {
		return personDao;
	}
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}


	//实现方法
	public void show(){
		personDao.show();
	}

}
