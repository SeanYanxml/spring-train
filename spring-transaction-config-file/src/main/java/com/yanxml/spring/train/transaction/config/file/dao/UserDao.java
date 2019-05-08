package com.yanxml.spring.train.transaction.config.file.dao;

import java.util.List;

import com.yanxml.spring.train.transaction.config.file.model.User;


public interface UserDao {
	public void save(User user);
	public void update(User user);
	public User getUser(int id);
	public void delete(int id);
	public List<User> getAllUsers();

}
