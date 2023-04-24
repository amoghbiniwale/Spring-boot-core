package com.aurionpro.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Student;
import com.aurionpro.service.StudentService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Student> findAllStudents() {
		TypedQuery<Student> query = manager.createQuery("select e from Student e", Student.class);
		return query.getResultList();
	}

	@Override
	public Student findById(int id) {
		Student student = manager.find(Student.class, id);
		return student;
	}

	@Override
	public Student saveStudent(Student student) {
		return manager.merge(student);
	}

	@Override
	public void deleteStudentById(int id) {
		Student student = manager.find(Student.class, id);
		manager.remove(student);
	}

	@Override
	public void deleteAll() {
		int rows = manager.createQuery("delete from Student").executeUpdate();
      	System.out.println("Number of rows affected is "+rows);
		
	}

	
	
}
