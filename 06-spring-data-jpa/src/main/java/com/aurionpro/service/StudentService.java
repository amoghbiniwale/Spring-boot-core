package com.aurionpro.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aurionpro.entity.Student;

public interface StudentService {
	List<Student> findAll();

	Student findById(int id);

	Student save(Student student);

//	Student updateStudent(Student student);

	void deleteById(int id);

	void deleteAll();



	List<Student> saveAll(List<Student> studentList);

	 Page<Student> getStudentPagination(Integer pageNumber, Integer pageSize);
	
	
}
