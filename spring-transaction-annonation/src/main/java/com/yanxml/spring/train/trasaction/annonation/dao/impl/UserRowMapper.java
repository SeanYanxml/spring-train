package com.yanxml.spring.train.trasaction.annonation.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.yanxml.spring.train.trasaction.annonation.model.User;


public class UserRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setUsername(rs.getString("username"));
		user.setId(rs.getInt("id"));
		return user;
	}
	

}
