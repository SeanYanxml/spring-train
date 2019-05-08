package com.yanxml.spring.train.trasaction.annonation.dao;


import java.util.List;
import com.yanxml.spring.train.trasaction.annonation.model.Students;

public interface StudentsDao {
	public void save(Students students);
	public void update(Students students);
	public Students getStudents(int id);
	public void delete(int id);
	public List<Students> getAllStudents();

}
