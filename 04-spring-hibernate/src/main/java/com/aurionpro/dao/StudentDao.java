package com.aurionpro.dao;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentDao {
	List<Student> findAll = null;

	Student save(Student student);

	Student findById(int id);

	List<Student> findAll();

	List<Student> findFirstName(String firstName);

	List<Student> findByEmail(String email);



	void update(Student student);

	

	void detelteStudent(int id);

	void deleteAll();




}
