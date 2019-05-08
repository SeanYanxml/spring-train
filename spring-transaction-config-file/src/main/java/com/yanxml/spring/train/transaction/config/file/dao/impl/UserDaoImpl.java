package com.yanxml.spring.train.transaction.config.file.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yanxml.spring.train.transaction.config.file.dao.UserDao;
import com.yanxml.spring.train.transaction.config.file.model.User;


/**
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	//private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public void save(User user) {
		jdbcTemplate.update(" insert into users(username) values(?) ",new Object[]{user.getUsername()}
		,new int[]{java.sql.Types.VARCHAR});
		//后方为何要用 new Int？
		//后一个参数表示的为数据的类型
		
	}
	public void update(User user) {
		//update method
		jdbcTemplate.update(" update users set username=? where id=?  ",new Object[]{user.getUsername(),user.getId()}
		, new int[]{java.sql.Types.VARCHAR,java.sql.Types.INTEGER});
	}
	
	public User getUser(int id) {
		//get User method
		//因为需要return 所以需要使用RowWapper 进行处理
		
		return (User)jdbcTemplate.queryForObject(" select * from users where id=? ", new Object[]{id}, new int[]{java.sql.Types.INTEGER}, new UserRowMapper());
		
	}
	public void delete(int id) {
		//delete method
		jdbcTemplate.update(" delete from users where id=? ",new Object[]{id},new int[]{java.sql.Types.INTEGER});
	    //error test
		jdbcTemplate.update(" delete from users where id =100 ; ");
	}
	
	public List<User> getAllUsers() {
		//get all users method
		
		return (List<User>)jdbcTemplate.query("select * from users ", new UserRowMapper());
	}
	

}
