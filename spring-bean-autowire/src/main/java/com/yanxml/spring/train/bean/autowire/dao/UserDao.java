package com.yanxml.spring.train.bean.autowire.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements PersonDao{
	public void show(){
		System.out.println("User Dao!");
	}

}
