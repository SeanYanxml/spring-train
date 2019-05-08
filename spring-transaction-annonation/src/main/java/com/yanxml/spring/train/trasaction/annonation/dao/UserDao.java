package com.yanxml.spring.train.trasaction.annonation.dao;

import java.util.List;

import com.yanxml.spring.train.trasaction.annonation.model.User;


public interface UserDao {
	public void save(User user);
	public void update(User user);
	public User getUser(int id);
	public void delete(int id);
	public List<User> getAllUsers();

}
