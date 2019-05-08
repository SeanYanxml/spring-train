package com.yanxml.spring.train.ioc.theory.dao.impl;

import com.yanxml.spring.train.ioc.theory.dao.UserDao;

public class UserDao4MysqlImpl implements UserDao{
	public void show(){
		System.out.println("Mysql DAO!");
	}

}
