package com.yanxml.spring.train.bean.autowire.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.yanxml.spring.train.bean.autowire.dao.PersonDao;

@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService{
	@Autowired
	//自动装载其他Bean的时候需要    配置 @Autowired标签
	PersonDao personDao;
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void show(){
		personDao.show();
	}
	
	//另外 还可以配置初始化 和 结束标签
	@PostConstruct
	public void init(){
		System.out.println("初始化！");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("销毁处理！");
	}

}
