package com.yanxml.spring.train.aop.annonation;

public class UserManagerImpl implements UserManager{

	public void addUser(String userName, String passWord) {
		// TODO Auto-generated method stub
		System.out.println("add ");
	}

	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		System.out.println("delete ");
	}

	public void modifyUser(int userId, String userName, String passWord) {
		// TODO Auto-generated method stub
		System.out.println("modify ");
	}

	public void findUser(int userId) {
		// TODO Auto-generated method stub
		System.out.println("find ");
	}
	

}
