package com.yanxml.spring.train.simple.ioc.dao.impl;

import com.yanxml.spring.train.simple.ioc.dao.UserDao;

public class UserDao4MysqlImpl implements UserDao{
	public void show(){
		System.out.println("Mysql DAO!");
	}

}
