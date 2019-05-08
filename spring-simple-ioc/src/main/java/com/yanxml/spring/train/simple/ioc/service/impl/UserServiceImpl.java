package com.yanxml.spring.train.simple.ioc.service.impl;

import com.yanxml.spring.train.simple.ioc.dao.UserDao;
import com.yanxml.spring.train.simple.ioc.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public void show(){
		userDao.show();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
