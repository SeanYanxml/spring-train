package com.yanxml.spring.train.transaction.config.file.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.yanxml.spring.train.transaction.config.file.dao.UserDao;
import com.yanxml.spring.train.transaction.config.file.model.User;


@Transactional
public class UserDaoImplTest {
	UserDao userDao;
	@Before
	public void init(){
		try{
			ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-JDBC.xml"});
			userDao=(UserDao) ctx.getBean("userDao");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//测试UserDao的5个方法
	@Test
	public void testSave(){
		System.out.println("-----------testSave-------");
		for(int i=0;i<5;i++){
			User user=new User();
			user.setUsername("admin"+i);
			userDao.save(user);
		}
	}
	@Test
	public void testUpdate(){
		System.out.println("-----------testUpdate--------");
		User user=userDao.getUser(1);
		user.setUsername("admin110");
		userDao.update(user);
	}
	@Test
	public void testDelete(){
		System.out.println("-----------testDelete--------");
		userDao.delete(4);
	}
	@Test
	public void testGetAllUsers(){
		List<User> users=userDao.getAllUsers();
		System.out.println("-----------testGetAllUsers--------");
		for(User user : users){
			System.out.println("userName: "+user.getUsername());
		}
	}
	@Test
	public void testGetUser(){
		System.out.println("-----------testGetUser--------");
		System.out.println("userName: "+userDao.getUser(1).getUsername());
	}

}
