package com.yanxml.spring.train.ioc.theory.collection.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;



public class UserServiceImpl/* implements UserService*/{
	/*private UserDao userDao;
	public void show(){
		userDao.show();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}*/
	
	
	/**
	 * Demo 07
	 * Sean Yan
	 * 2016/08/26
	 * */
/*	//Set
	private Set<String> sets=new HashSet<String>();
	public Set<String> getSets() {
		return sets;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}
	
	public Set<String> showSet(){
		return sets;
	}*/
	
	//List
/*	private List<String> lists=new ArrayList<String>();
	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}
	public List<String> showSet(){
		return lists;
	}*/
	
/*	//Property
	private Properties properties=new Properties();

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public Properties showProperties(){
		return properties;
	}*/
	
	//List
	private Map<String, String> maps=new HashMap<String, String>();

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	public Map<String,String> showMaps(){
		return maps;
	}
	
	
}
