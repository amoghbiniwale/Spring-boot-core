package com.aurionpro.repository;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentRepository {
	List<Student> findAllStudents();

	Student findById(int id);


	Student saveStudent(Student student);

	void deleteStudentById(int id);

	void deleteAll();
	
}
