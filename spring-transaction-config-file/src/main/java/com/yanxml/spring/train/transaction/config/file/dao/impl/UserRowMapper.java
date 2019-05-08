package com.yanxml.spring.train.transaction.config.file.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yanxml.spring.train.transaction.config.file.model.User;



public class UserRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setUsername(rs.getString("username"));
		user.setId(rs.getInt("id"));
		return user;
	}
	

}
