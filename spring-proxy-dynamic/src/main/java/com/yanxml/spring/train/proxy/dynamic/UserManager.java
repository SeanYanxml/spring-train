package com.yanxml.spring.train.proxy.dynamic;

public interface UserManager {
	public void addUser(String userName,String passWord);
	public void deleteUser(int userId);
	public void modifyUser(int userId,String userName,String passWord);
	public void findUser(int userId);
}
