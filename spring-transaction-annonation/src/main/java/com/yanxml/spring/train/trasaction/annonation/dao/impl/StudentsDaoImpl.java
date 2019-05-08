package com.yanxml.spring.train.trasaction.annonation.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yanxml.spring.train.trasaction.annonation.dao.StudentsDao;
import com.yanxml.spring.train.trasaction.annonation.model.Students;


//保证类中方法的事务性
@Transactional
public class StudentsDaoImpl implements StudentsDao{

	//添加数据源
	private DataSource dataSource;
	//有时使用JDBCTemple
	private JdbcTemplate jdbcTemplate;
	//Getter and Setter
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//此方法不使用事务处理
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void save(Students students) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into students values('name','sex',18)");
	}

	public void update(Students students) {
		// TODO Auto-generated method stub
		
	}

	public Students getStudents(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Students> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
