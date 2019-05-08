package com.yanxml.spring.train.proxy.statics;

public class UserManagerImplProxy implements UserManager{
	
	public UserManager userManager;

	//构造函数
	public UserManagerImplProxy() {
		// TODO Auto-generated constructor stub
	}
	
	public UserManagerImplProxy(UserManager userManager){
		this.userManager=userManager;
	}
	
	//Check函数
	public void checkSecurity(){
		System.out.println("-UserManagerImpl.checkSecurity()-");
	}
	public void addUser(String userName, String passWord) {
		// TODO Auto-generated method stub
		checkSecurity();
		userManager.addUser(userName, passWord);
	}

	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		checkSecurity();
		userManager.deleteUser(userId);
	}

	public void modifyUser(int userId, String userName, String passWord) {
		// TODO Auto-generated method stub
		checkSecurity();
		userManager.modifyUser(userId, userName, passWord);
	}

	public void findUser(int userId) {
		// TODO Auto-generated method stub
		checkSecurity();
		userManager.findUser(userId);
	}
	

}
